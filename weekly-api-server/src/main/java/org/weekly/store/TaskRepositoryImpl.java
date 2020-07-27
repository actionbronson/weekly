package org.weekly.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.weekly.model.Task;
import org.weekly.model.TaskId;
import org.weekly.model.UserId;

import java.util.List;

@Repository
@Component
public class TaskRepositoryImpl implements TaskRepositoryMethods {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRepositoryImpl.class);
    private static final Sort DEFAULT_TASK_SORT = Sort.by(Sort.Order.asc("weekYear"), Sort.Order.asc("weekNo"));

    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable(value = "tasks", key = "#userId.toString()")
    public List<Task> getAllTasks(UserId userId) {
        CriteriaDefinition criteria = Criteria.where("id.userId").is(userId);
        return mongoTemplate.find(Query.query(criteria).with(DEFAULT_TASK_SORT), Task.class);
    }

    @Override
    public List<Task> getAllTasks(UserId userId, int weekYear) {
        CriteriaDefinition criteria =
            Criteria.where("id.userId").is(userId).and("weekYear").is(weekYear);
        return mongoTemplate.find(Query.query(criteria).with(DEFAULT_TASK_SORT), Task.class);
    }

    @Cacheable(value = "tasks-week-year", key = "(#userId.toString()).concat(#weekYear).concat(#weekNo)")
    public List<Task> getAllTasks(UserId userId, int weekYear, int weekNo) {
        CriteriaDefinition criteria =
            Criteria
                .where("id.userId").is(userId)
                .and("weekYear").is(weekYear)
                .and("weekNo").is(weekNo);
        return mongoTemplate.find(Query.query(criteria).with(DEFAULT_TASK_SORT), Task.class);
    }

    @Override
    public Task getTask(UserId userId, String taskId) {
        TaskId id = new TaskId().userId(userId).taskId(taskId);
        return mongoTemplate.findById(id, Task.class);
    }
//
//    @Override
//    @Cacheable(value = "labels", key = "#userId")
//    public List<TaskLabel> getTaskLabels(UserId userId) {
//        return getUserTaskLabels(getAllLabelsAggregation(userId));
//    }
//
//    @Override
//    @Cacheable(value = "priorities", key = "#userId")
//    public List<TaskPriority> getTaskPriorities(UserId userId) {
//        return getUserTaskPriorities(getAllPrioritiesAggregation(userId));
//    }
//
//    private List<AggregationOperation> getUserListPropertyAggregation(UserId userId, String property, Optional<Sort> sortBy) {
//        List<AggregationOperation> operations = Lists.newArrayListWithCapacity(4);
//        operations.add(Aggregation.match(Criteria.where("id.userId").is(userId)));
//        operations.add(Aggregation.unwind(property));
//        operations.add(Aggregation.replaceRoot().withValueOf(property));
//        sortBy.ifPresent(sort -> operations.add(Aggregation.sort(sort)));
//        return operations;
//    }

//    private List<AggregationOperation> getAllTasksAggregation(UserId userId) {
//        //return getUserListPropertyAggregation(userId, "tasks", Optional.of(DEFAULT_TASK_SORT));
//    }

//    private List<AggregationOperation> getAllLabelsAggregation(UserId userId) {
//        return getUserListPropertyAggregation(userId, "labels", Optional.of(DEFAULT_LABEL_SORT));
//    }
//
//    private List<AggregationOperation> getAllStateAggregation(UserId userId) {
//        return getUserListPropertyAggregation(userId, "states", Optional.of(DEFAULT_LABEL_SORT));
//    }
//
//    private List<AggregationOperation> getAllPrioritiesAggregation(UserId userId) {
//        return getUserListPropertyAggregation(userId, "priorities", Optional.of(DEFAULT_PRIORITY_SORT));
//    }

//    private <T> List<T> getUserPropertyList(List<AggregationOperation> operations, Class<T> propertyClass) {
//        TypedAggregation<User> aggregation = Aggregation.newAggregation(User.class, operations);
//        try {
//            AggregationResults<T> results = mongoTemplate.aggregate(aggregation, User.class, propertyClass);
//            return results.getMappedResults();
//        }
//        catch (Throwable t) {
//            LOGGER.error("Could not obtain the AggregationResults", t);
//            throw t;
//        }
//    }

//    private List<Task> getUserTasks(List<AggregationOperation> operations) {
//        return getUserPropertyList(operations, Task.class);
//    }
//
//    private List<TaskLabel> getUserTaskLabels(List<AggregationOperation> operations) {
//        return getUserPropertyList(operations, TaskLabel.class);
//    }
//
//    private List<TaskState> getUserTaskStates(List<AggregationOperation> operations) {
//        return getUserPropertyList(operations, TaskState.class);
//    }
//
//    private List<TaskPriority> getUserTaskPriorities(List<AggregationOperation> operations) {
//        return getUserPropertyList(operations, TaskPriority.class);
//    }
}