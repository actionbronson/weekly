package org.weekly.store;

import org.weekly.model.Task;
import org.weekly.model.User;

import java.time.OffsetDateTime;

public class BasicObjectUpdater {
    // Because inheritance doesnt seem to work with openapi ...

    public static User update(User u) {
        u.setUpdateTs(OffsetDateTime.now());
        if (u.getCreationTs() == null) {
            u.setCreationTs(u.getUpdateTs());
        }
        return u;
    }

    public static Task update(Task t) {
        t.setUpdateTs(OffsetDateTime.now());
        if (t.getCreationTs() == null) {
            t.setCreationTs(t.getUpdateTs());
        }
        return t;
    }
}
