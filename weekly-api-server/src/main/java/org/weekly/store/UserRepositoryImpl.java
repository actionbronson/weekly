package org.weekly.store;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.weekly.model.Task;
import org.weekly.model.User;
import org.weekly.model.UserId;
import org.weekly.security.WeeklyUserFactory;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Repository
@Component
public class UserRepositoryImpl implements UserRepositoryTaskMethods, UserRepositoryCurrentUserMethods {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
    private static final Sort DEFAULT_TASK_SORT = Sort.by(Sort.Order.asc("weekNo"), Sort.Order.asc("weekNo"));

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WeeklyUserFactory weeklyUserFactory;

    public List<Task> getAllTasks(UserId userId) {
        List<AggregationOperation> operations = getAllTasksAggregation(userId);
        operations.add(Aggregation.sort(DEFAULT_TASK_SORT));
        return getTasks(operations);
    }

    public List<Task> getAllTasks(UserId userId, int weekYear, int weekNo) {
        List<AggregationOperation> operations = getAllTasksAggregation(userId);
        operations.add(Aggregation.match(
                Criteria.where("weekNo").is(weekNo).and("weekYear").is(weekYear)
        ));
        operations.add(Aggregation.sort(DEFAULT_TASK_SORT));
        return getTasks(operations);
    }

    private List<AggregationOperation> getAllTasksAggregation(UserId userId) {
        MatchOperation matchStage = Aggregation.match(Criteria.where("id").is(userId));
        UnwindOperation unwindStage = Aggregation.unwind("tasks");
        ReplaceRootOperation replaceRootStage = Aggregation.replaceRoot().withValueOf("tasks");
        return Lists.newArrayList(matchStage, unwindStage, replaceRootStage);
    }

    private List<Task> getTasks(List<AggregationOperation> operations) {
        TypedAggregation<User> aggregation = Aggregation.newAggregation(User.class, operations);
        try {
            AggregationResults<Task> results = mongoTemplate.aggregate(aggregation, User.class, Task.class);
            return results.getMappedResults();
        }
        catch (Throwable t) {
            LOGGER.error("Could not obtain the AggregationResults", t);
            throw t;
        }
    }

    @Override
    public User getOrInsertCurrentUser() {
        return getOrInsertCurrentUser(weeklyUserFactory.current());
    }

    @Override
    public synchronized User getOrInsertCurrentUser(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class))
                .orElseGet(() -> {
                    LOGGER.warn(format("Could not find user: %s", user.getId().toString()));
                    return mongoTemplate.insert(user.tasks(Lists.newArrayList()));
                });
    }
}
