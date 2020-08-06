package org.weekly.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.String.format;

public class ListsUtils {
    public static <T> T findBy(List<T> list, Predicate<T> predicate, Supplier<String> errorOf) {
        return list.stream().filter(predicate)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException(format("Could not find '%s' in list.", errorOf.get())));
    }
}
