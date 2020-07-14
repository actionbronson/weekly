/**
 * Weekly
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
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
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.weekly.api;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.ComponentScan;
import org.weekly.api.impl.CalendarApiServiceImpl;
import org.weekly.api.impl.TasksApiServiceImpl;
import org.weekly.model.Task;
import org.weekly.model.User;
import org.weekly.model.UserId;
import org.weekly.security.WeeklyUserFactory;
import org.weekly.store.UserRepository;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


/**
 * Weekly
 *
 * <p>No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * API tests for TasksApi 
 */
@RunWith(MockitoJUnitRunner.class)
@ComponentScan(basePackages = "org.weekly.api")
public class TasksApiTest {

    @Mock
    private CalendarApiServiceImpl calendarApi;

    @Mock
    private WeeklyUserFactory weeklyUserFactory;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TasksApiServiceImpl api;

    private User testUser = createTestUser();

    @Before
    public void setup() {
        //ReflectionTestUtils.setField(api, "logger", LoggerFactory.getLogger(CalendarApiServiceImpl.class));
        //User u = createTestUser();
        when(calendarApi.getWeekOf(anyInt(), anyInt())).thenCallRealMethod();
        when(userRepository.getOrInsertCurrentUser()).thenReturn(testUser);
    }

    @Test
    public void getTasksTest() {
        // given
        when(userRepository.getAllTasks(any(), anyInt(), anyInt()))
            .thenReturn(List.of(testUser.getTasks().get(1)));

        // when
        List<Task> tasks = api.getTasks(5,2020);

        // then
        Assert.assertTrue(tasks.size() == 1);
        Assert.assertEquals("jkl-mno-pqr", tasks.stream().findFirst().map(t -> t.getId()).orElseThrow());
    }

    @Test
    public void deleteTasksTest() {
        // given

        // when
        List<String> deleted = api.deleteTask(List.of("jkl-mno-pqr"));

        // then
        Assert.assertTrue(deleted.size() == 1);
        Assert.assertEquals(deleted, List.of("jkl-mno-pqr"));
    }

    @Test
    public void postTasksTest() {
        // given
        when(userRepository.save(any(User.class))).thenAnswer(a -> a.getArgument(0));

        // when
        List<Task> created = api.createTasks(6, 2020, List.of(
            new Task()
                .id("stu-vwx-yza")
                .contents("Do stuff")
                .summary("Get it done!")
        ));

        // then
        Assert.assertTrue(created.size() == 3);
    }

    private User createTestUser() {
        return new User()
                .id(new UserId().email("me@me.com").provider("facebook"))
                .tasks(createTestTasks())
                .firstName("Roger")
                .lastName("Waters");
    }

    private List<Task> createTestTasks() {
        return Lists.newArrayList(
                new Task()
                        .id("abc-def-ghi")
                        .weekNo(1).weekYear(2020)
                        .contents("Do stuff")
                        .summary("Get it done!"),
                new Task()
                        .id("jkl-mno-pqr")
                        .weekNo(5).weekYear(2020)
                        .contents("Do more stuff")
                        .summary("Get it done already!")
        );
    }

}
