package org.weekly.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.weekly.model.User;
import org.weekly.security.WeeklyUserFactory;

import java.util.Optional;

import static java.lang.String.format;

@Repository
@Component
public class UserRepositoryImpl implements UserRepositoryCurrentUserMethods {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WeeklyUserFactory weeklyUserFactory;

    @Override
    @Cacheable(value = "users", keyGenerator = "UserCacheKeyGenerator")
    public User getOrInsertCurrentUser() {
        return getOrInsertCurrentUser(weeklyUserFactory.current());
    }

    @Override
    @Cacheable(value = "users", key = "#user.id.toString()")
    public synchronized User getOrInsertCurrentUser(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(user.getId()));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class))
                .orElseGet(() -> {
                    LOGGER.warn(format("Could not find user: %s", user.getId().toString()));
                    return mongoTemplate.insert(user);
                });
    }
}
