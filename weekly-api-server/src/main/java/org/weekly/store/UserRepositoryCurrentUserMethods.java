package org.weekly.store;

import org.weekly.model.User;

public interface UserRepositoryCurrentUserMethods {
    User getOrInsertCurrentUser(User user);
    User getOrInsertCurrentUser();
}

