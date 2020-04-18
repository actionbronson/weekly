package org.weekly.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.weekly.model.Task;
import org.weekly.model.User;
import org.weekly.model.Week;

import java.util.Collection;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Collection<Task> getTasks(User user, Week week) {
        return null;
    }
}
