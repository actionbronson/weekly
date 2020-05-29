/**
 * PlanIt
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.weekly.store;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.weekly.model.Task;
import org.weekly.model.User;
import org.weekly.model.UserId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "org.weekly.store")
@Import(MongoRepositoryTestConfiguration.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    private static final UserId IRINA = new UserId().email("irina@gmail.com").provider("google");
    private static final UserId JOHN = new UserId().email("john@gmail.com").provider("facebook");

    private static final <T> Collector<T, ?, List<T>> createShuffler() {
        return Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new),
                list -> {
                    Collections.shuffle(list);
                    return list;
                }
        );
    }

    private List<Task> createTask(String name) {
        return IntStream.range(4,25)
                .mapToObj(weekNo ->
                    new Task()
                        .weekNo(weekNo)
                        .contents(format("%s to do stuff on week %d", name, weekNo))
                ).collect(createShuffler());
    }

    private Collection<User> createUsers() {
        return List.of(
            new User()
                .id(JOHN)
                .name("John")
                .tasks(createTask("John")),
            new User()
                .id(IRINA)
                .name("Irina")
                .tasks(createTask("Irina"))
        );
    }

    @Before
    public void setUp() {
        repository.insert(createUsers());
    }

    @Test
    public void validate_Irina_Tasks() {
        List<Task> tasks = repository.getAllTasks(IRINA, Sort.by("weekNo").ascending());
        Assert.assertEquals(
            tasks.stream().map(t -> t.getWeekNo()).collect(Collectors.toList()),
            IntStream.range(4,25).boxed().collect(Collectors.toList())
        );
        Assert.assertTrue(tasks.stream().allMatch(t -> t.getContents().contains("Irina")));
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }
}
