package org.weekly.store;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.weekly.model.User;
import org.weekly.model.UserId;

@Repository
public interface UserRepository extends MongoRepository<User, UserId>, TaskRepository {
}