package org.weekly.store;

import org.weekly.model.Task;
import org.weekly.model.UserId;

import java.util.List;

public interface UserRepositoryTaskMethods {
    List<Task> getAllTasks(UserId userId);

    List<Task> getAllTasks(UserId userId, int weekYear, int weekNo);
}
