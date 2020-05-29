package org.weekly.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.weekly.model.Task;
import org.weekly.model.User;
import org.weekly.model.UserId;

import java.util.List;

public class UserRepositoryImpl implements TaskRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Task> getAllTasks(UserId userId, Sort sort) {
        MatchOperation matchStage = Aggregation.match(Criteria.where("id").is(userId));
        UnwindOperation unwindStage = Aggregation.unwind("tasks");
        SortOperation sortStage = Aggregation.sort(sort);
        ReplaceRootOperation replaceRootStage = Aggregation.replaceRoot().withValueOf("tasks");

        TypedAggregation<User> aggregation = Aggregation.newAggregation(User.class, matchStage, unwindStage, replaceRootStage, sortStage);

        try {
            AggregationResults<Task> results = mongoTemplate.aggregate(aggregation, User.class, Task.class);
            return results.getMappedResults();
        }
        catch (Throwable t) {
            logger.error("Could not obtain the AggregationResults", t);
            throw t;
        }
    }
}
