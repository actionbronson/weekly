package org.weekly.api.model;

import org.weekly.model.TaskId;

import java.util.Objects;

public class TaskIds {
    public static boolean equals(TaskId t1, TaskId t2) {
        if (t1 == null || t2 == null)
            return false;
        else
            return Objects.equals(t1.getTaskId(), t2.getTaskId()) &&
                UserIds.equals(t1.getUserId(), t2.getUserId());
    }
}
