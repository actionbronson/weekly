package org.weekly.store;

import org.weekly.model.Task;

public class TaskMerger {

    private Task task;

    private TaskMerger(Task t) {
        task = t;
    }

    public static TaskMerger of(Task base) {
        return new TaskMerger(base);
    }

    public Task with(Task t) {
        task.setState(t.getState());
        task.setLabel(t.getLabel());
        task.setContents(t.getContents());
        task.setPriority(t.getPriority());
        task.setSummary(t.getSummary());
        task.setWeekNo(t.getWeekNo());
        task.setWeekYear(t.getWeekYear());
        return task;
    }
}
