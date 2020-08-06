package org.weekly.store;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.weekly.model.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface UserRepository extends MongoRepository<User, UserId>, UserRepositoryCurrentUserMethods {
    @Cacheable(value = "users", key = "#id.toString()")
    Optional<User> findById(UserId id);

    @CacheEvict(value = "users", key = "#u.id.toString()")
    User save(User u);

    @CacheEvict(value = "users", key = "#u.id.toString()")
    default User saveWithBaseUpdate(User u) {
        BasicObjectUpdater.update(u);
        return save(u);
    }

    default List<TaskPriority> getTaskPriorities() {
        User u = getOrInsertCurrentUser();
        return u.getPriorities().stream()
            .sorted(Comparator.comparing(TaskPriority::getLevel))
            .collect(Collectors.toList());
    }

    default List<TaskLabel> getTaskLabels() {
        User u = getOrInsertCurrentUser();
        return u.getLabels().stream()
                .sorted(Comparator.comparing(TaskLabel::getName))
                .collect(Collectors.toList());
    }

    default List<TaskState> getTaskStates() {
        User u = getOrInsertCurrentUser();
        return u.getStates().stream()
                .sorted(Comparator.comparing(TaskState::getValue))
                .collect(Collectors.toList());
    }
}