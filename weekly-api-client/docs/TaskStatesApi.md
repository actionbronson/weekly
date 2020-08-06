# TaskStatesApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTaskStates**](TaskStatesApi.md#getTaskStates) | **GET** /task/states | Get all task states.


<a name="getTaskStates"></a>
# **getTaskStates**
> TaskState getTaskStates()

Get all task states.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TaskStatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TaskStatesApi apiInstance = new TaskStatesApi(defaultClient);
    try {
      TaskState result = apiInstance.getTaskStates();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskStatesApi#getTaskStates");
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

[**TaskState**](TaskState.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

