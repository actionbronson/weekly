# TasksApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTasks**](TasksApi.md#createTasks) | **POST** /tasks | Create tasks.
[**decrementTaskPriority**](TasksApi.md#decrementTaskPriority) | **PUT** /task/{id}/priority/decrement | Decrement a task priority.
[**deleteTasks**](TasksApi.md#deleteTasks) | **DELETE** /tasks | Delete a task.
[**getIndividualTask**](TasksApi.md#getIndividualTask) | **GET** /task/{id} | Get task.
[**getTasks**](TasksApi.md#getTasks) | **GET** /tasks | Get tasks for a week.
[**incrementTaskPriority**](TasksApi.md#incrementTaskPriority) | **PUT** /task/{id}/priority/increment | Increment a task priority.
[**updateTaskById**](TasksApi.md#updateTaskById) | **PUT** /task/{id} | Update a task.
[**updateTaskLabel**](TasksApi.md#updateTaskLabel) | **PUT** /task/{id}/label | Update a task label.
[**updateTaskState**](TasksApi.md#updateTaskState) | **PUT** /task/{id}/state | Update a task state.
[**updateTasks**](TasksApi.md#updateTasks) | **PUT** /tasks | Update a tasks.


<a name="createTasks"></a>
# **createTasks**
> List&lt;Task&gt; createTasks(weekNo, weekYear, task)

Create tasks.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    Integer weekNo = 56; // Integer | ISO 8601 relative week (number).  Defaults to current weekNo.
    Integer weekYear = 56; // Integer | ISO 8601 relative week (year).  Defaults to current weekYear.
    List<Task> task = Arrays.asList(null); // List<Task> | The task(s) you wish to create
    try {
      List<Task> result = apiInstance.createTasks(weekNo, weekYear, task);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#createTasks");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **weekNo** | **Integer**| ISO 8601 relative week (number).  Defaults to current weekNo. |
 **weekYear** | **Integer**| ISO 8601 relative week (year).  Defaults to current weekYear. |
 **task** | [**List&lt;Task&gt;**](Task.md)| The task(s) you wish to create |

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Created task(s). |  -  |

<a name="decrementTaskPriority"></a>
# **decrementTaskPriority**
> Task decrementTaskPriority(id)

Decrement a task priority.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String id = "id_example"; // String | the task id
    try {
      Task result = apiInstance.decrementTaskPriority(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#decrementTaskPriority");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| the task id |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="deleteTasks"></a>
# **deleteTasks**
> deleteTasks(requestBody)

Delete a task.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    List<String> requestBody = Arrays.asList(); // List<String> | The task(s) you wish to update
    try {
      apiInstance.deleteTasks(requestBody);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#deleteTasks");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestBody** | [**List&lt;String&gt;**](String.md)| The task(s) you wish to update | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Task are deleted. |  -  |

<a name="getIndividualTask"></a>
# **getIndividualTask**
> Task getIndividualTask(id)

Get task.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String id = "id_example"; // String | the task id
    try {
      Task result = apiInstance.getIndividualTask(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#getIndividualTask");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| the task id |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="getTasks"></a>
# **getTasks**
> List&lt;Task&gt; getTasks(weekNo, weekYear)

Get tasks for a week.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    Integer weekNo = 56; // Integer | ISO 8601 relative week (number).  Defaults to current weekNo.
    Integer weekYear = 56; // Integer | ISO 8601 relative week (year).  Defaults to current weekYear.
    try {
      List<Task> result = apiInstance.getTasks(weekNo, weekYear);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#getTasks");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **weekNo** | **Integer**| ISO 8601 relative week (number).  Defaults to current weekNo. | [optional]
 **weekYear** | **Integer**| ISO 8601 relative week (year).  Defaults to current weekYear. | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="incrementTaskPriority"></a>
# **incrementTaskPriority**
> Task incrementTaskPriority(id)

Increment a task priority.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String id = "id_example"; // String | the task id
    try {
      Task result = apiInstance.incrementTaskPriority(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#incrementTaskPriority");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| the task id |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="updateTaskById"></a>
# **updateTaskById**
> Task updateTaskById(id, task)

Update a task.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String id = "id_example"; // String | the task id
    Task task = new Task(); // Task | The task to update
    try {
      Task result = apiInstance.updateTaskById(id, task);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#updateTaskById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| the task id |
 **task** | [**Task**](Task.md)| The task to update |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="updateTaskLabel"></a>
# **updateTaskLabel**
> Task updateTaskLabel(id, label)

Update a task label.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String id = "id_example"; // String | the task id
    String label = "label_example"; // String | the task label
    try {
      Task result = apiInstance.updateTaskLabel(id, label);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#updateTaskLabel");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| the task id |
 **label** | **String**| the task label |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="updateTaskState"></a>
# **updateTaskState**
> Task updateTaskState(id, state)

Update a task state.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String id = "id_example"; // String | the task id
    String state = "state_example"; // String | the task state
    try {
      Task result = apiInstance.updateTaskState(id, state);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#updateTaskState");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| the task id |
 **state** | **String**| the task state |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

<a name="updateTasks"></a>
# **updateTasks**
> List&lt;Task&gt; updateTasks(task)

Update a tasks.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TasksApi apiInstance = new TasksApi(defaultClient);
    List<Task> task = Arrays.asList(null); // List<Task> | The tasks you wish to update
    try {
      List<Task> result = apiInstance.updateTasks(task);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#updateTasks");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **task** | [**List&lt;Task&gt;**](Task.md)| The tasks you wish to update |

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updated tasks. |  -  |

