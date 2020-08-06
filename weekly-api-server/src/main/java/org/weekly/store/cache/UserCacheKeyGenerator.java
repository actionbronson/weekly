package org.weekly.store.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.weekly.security.WeeklyUserFactory;

import java.lang.reflect.Method;

@Component("UserCacheKeyGenerator")
public class UserCacheKeyGenerator implements KeyGenerator {
    @Autowired
    private WeeklyUserFactory weeklyUserFactory;

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return weeklyUserFactory.current().getId().toString();
    }
}
