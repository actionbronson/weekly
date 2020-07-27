# TaskPrioritiesApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTaskPriorities**](TaskPrioritiesApi.md#getTaskPriorities) | **GET** /task/priorities | Get all task priorities.


<a name="getTaskPriorities"></a>
# **getTaskPriorities**
> TaskPriority getTaskPriorities()

Get all task priorities.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TaskPrioritiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TaskPrioritiesApi apiInstance = new TaskPrioritiesApi(defaultClient);
    try {
      TaskPriority result = apiInstance.getTaskPriorities();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskPrioritiesApi#getTaskPriorities");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**TaskPriority**](TaskPriority.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

