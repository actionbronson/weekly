package org.weekly.store;

import org.weekly.model.Task;
import org.weekly.model.UserId;

import java.util.List;

public interface TaskRepositoryMethods {
    List<Task> getAllTasks(UserId userId);

    List<Task> getAllTasks(UserId userId, int weekYear);

    List<Task> getAllTasks(UserId userId, int weekYear, int weekNo);

    Task getTask(UserId userId, String taskId);

//    List<TaskLabel> getTaskLabels(UserId userId);
//
//    List<TaskPriority> getTaskPriorities(UserId userId);
//
//    default TaskLabel getTaskLabel(UserId userId, String label) {
//        return getTaskLabels(userId)
//            .stream().filter(tl -> tl.getName().equals(label))
//            .findFirst()
//            .orElseThrow(() -> new NoSuchElementException(format("No TaskLabel found with name: '%s'", label)));
//    }
//
//    default TaskPriority getTaskPriority(UserId userId, String priority) {
//        return getTaskPriorities(userId).stream()
//            .filter(p -> p.getName().equals(priority))
//            .findFirst()
//            .orElseThrow(() -> new NoSuchElementException(format("No TaskState found with priority: '%s'", priority)));
//    }
//
//    default TaskPriority getTaskPriority(UserId userId, int priorityLevel) {
//        return getTaskPriorities(userId).stream()
//            .filter(p -> p.getLevel().equals(priorityLevel))
//            .findFirst()
//            .orElseThrow(() ->
//                new NoSuchElementException(format("No TaskState found with priority-level: %d", priorityLevel)));
//    }
//
//    default TaskPriority nextPriority(UserId userId, TaskPriority priority) {
//        List<TaskPriority> sortedPriorities = getTaskPriorities(userId);
//        int indexOf = sortedPriorities.indexOf(priority);
//        Optional<TaskPriority> nextPriority = io.vavr.control.Try.of(() -> sortedPriorities.get(indexOf+1)).toJavaOptional();
//        return nextPriority
//            .orElseThrow(() ->
//                new NoSuchElementException(format("No next priority to priority: '%s'", priority.getName())));
//    }
//
//    default TaskPriority previousPriority(UserId userId, TaskPriority priority) {
//        List<TaskPriority> sortedPriorities = getTaskPriorities(userId);
//        int indexOf = sortedPriorities.indexOf(priority);
//        Optional<TaskPriority> prevPriority = io.vavr.control.Try.of(() -> sortedPriorities.get(indexOf-1)).toJavaOptional();
//        return prevPriority
//            .orElseThrow(() ->
//                new NoSuchElementException(format("No previous priority to priority: '%s'", priority.getName())));
//    }
}
