package org.weekly.api.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.weekly.api.CalendarApi;
import org.weekly.api.TasksApi;
import org.weekly.model.Task;
import org.weekly.model.User;
import org.weekly.model.Week;
import org.weekly.store.ModelCreateUpdate;
import org.weekly.store.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Weekly
 *
 * <p>No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 */
@Controller
public class TasksApiServiceImpl implements TasksApi {

    @Autowired
    private CalendarApi calendarApi;

    @Autowired
    private UserRepository userRepository;

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Task> createTasks(@NotNull Integer weekNo, @NotNull Integer weekYear, @Valid List<Task> tasks) {
        Week week = getWeek(weekNo, weekYear);
        User user = userRepository.getOrInsertCurrentUser();
        tasks.stream().forEach(t -> {
            ModelCreateUpdate.initTask(t);
            t.weekNo(week.getWeekNo());
            t.weekYear(week.getYear());
            user.addTasksItem(t);
        });
        User persisted = userRepository.save(user);
        return persisted.getTasks();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<String> deleteTask(@Valid List<String> taskIds) {
        User user = userRepository.getOrInsertCurrentUser();
        List<Task> allTasks = Lists.newLinkedList(user.getTasks());
        List<Task> filteredTasks =
                user.getTasks().stream().filter(t -> ! taskIds.contains(t.getId())).collect(Collectors.toList());
        userRepository.save(user.tasks(filteredTasks));
        allTasks.removeAll(filteredTasks);
        return List.copyOf(allTasks.stream().map(t -> t.getId()).collect(Collectors.toList()));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Task> getTasks(Integer weekNo, Integer weekYear) {
        Week w = getWeek(weekNo, weekYear);
        User user = userRepository.getOrInsertCurrentUser();
        List<Task> ts = userRepository.getAllTasks(user.getId(), w.getYear(), w.getWeekNo());
        return userRepository.getAllTasks(user.getId(), w.getYear(), w.getWeekNo());
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Task> updateTask(@Valid List<Task> tasks) {
        User user = userRepository.getOrInsertCurrentUser();
        Set<String> newTaskIds = tasks.stream().map(t -> t.getId()).collect(Collectors.toSet());
        user.getTasks().stream().filter(t -> !newTaskIds.contains(t.getId()));
        tasks.forEach(t -> user.addTasksItem(ModelCreateUpdate.updateTask(t)));
        userRepository.save(user);
        return tasks;
    }

    private Week getWeek(Integer weekNo, Integer weekYear) {
        if (weekNo != null && weekYear != null)
            return calendarApi.getWeekOf(weekNo, weekYear);
        else
            throw new IllegalArgumentException("No parameters to fetch a week.");
    }
}
