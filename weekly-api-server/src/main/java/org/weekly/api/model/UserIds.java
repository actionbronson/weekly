package org.weekly.api.model;

import org.weekly.model.UserId;

import java.util.Objects;

public class UserIds {
    public static boolean equals(UserId t1, UserId t2) {
        if (t1 == null || t2 == null)
            return false;
        else
            return Objects.equals(t1.getProvider(), t2.getProvider()) &&
                    Objects.equals(t1.getEmail(), t2.getEmail());
    }
}
