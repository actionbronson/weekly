package org.weekly.store;

import org.springframework.data.domain.Sort;
import org.weekly.model.Task;
import org.weekly.model.UserId;

import java.util.List;

public interface TaskRepository {
    //@Query(value = "{'id': ?0}", fields = "{'tasks': 1, 'id': 0}")
    List<Task> getAllTasks(UserId userId, Sort sort);
}
