package org.weekly.store;

import com.google.common.collect.Lists;
import org.weekly.model.Task;
import org.weekly.model.User;

import java.time.OffsetDateTime;
import java.util.UUID;

public class ModelCreateUpdate {
    public static User updateUser(User user) {
        user.setUpdateTs(OffsetDateTime.now());
        return user;
    }

    public static User initUser(User user) {
        user.setCreationTs(OffsetDateTime.now());
        user.setUpdateTs(user.getCreationTs());
        user.setTasks(Lists.newArrayList());
        return user;
    }

    public static Task initTask(Task task) {
        task.setCreationTs(OffsetDateTime.now());
        task.setUpdateTs(task.getCreationTs());
        task.setId(UUID.randomUUID().toString());
        return task;
    }

    public static Task updateTask(Task task) {
        task.setUpdateTs(OffsetDateTime.now());
        return task;
    }
}
