package org.weekly.store;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.weekly.model.Task;
import org.weekly.model.TaskId;
import org.weekly.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface TaskRepository extends MongoRepository<Task, TaskId>, TaskRepositoryMethods {

    @Caching(evict = {
        @CacheEvict(value = "tasks", key = "#user.id"),
    })
    default Task createTaskWithBaseUpdate(User user, Task task) {
        return createTasksWithBaseUpdate(user, Collections.singleton(task)).get(0);
    }

    @Caching(evict = {
            @CacheEvict(value = "tasks", key = "#user.id"),
    })
    default List<Task> createTasksWithBaseUpdate(User user, Collection<Task> tasks) {
        List<Task> tasksIterator = tasks.stream()
            .map(t -> BasicObjectUpdater.update(t.id(createTaskId(user))))
            .collect(Collectors.toList());
        return saveAll(tasksIterator);
    }

    @Caching(evict = {
            @CacheEvict(value = "tasks", key = "#user.id"),
    })
    default Task updateTaskWithBaseUpdate(User user, Task task) {
        return updateTasksWithBaseUpdate(user, Collections.singleton(task)).get(0);
    }

    @Caching(evict = {
            @CacheEvict(value = "tasks", key = "#user.id"),
    })
    default List<Task> updateTasksWithBaseUpdate(User user, Collection<Task> tasks) {
        List<Task> tasksIterator = tasks.stream()
                .map(t -> BasicObjectUpdater.update(t))
                .collect(Collectors.toList());
        return saveAll(tasksIterator);
    }

    private TaskId createTaskId(User user) {
        return new TaskId().taskId(UUID.randomUUID().toString()).userId(user.getId());
    }
}
