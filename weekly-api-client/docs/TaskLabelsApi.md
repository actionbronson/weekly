# TaskLabelsApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTaskLabels**](TaskLabelsApi.md#getTaskLabels) | **GET** /task/labels | Get all task labels.


<a name="getTaskLabels"></a>
# **getTaskLabels**
> TaskLabel getTaskLabels()

Get all task labels.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.TaskLabelsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    TaskLabelsApi apiInstance = new TaskLabelsApi(defaultClient);
    try {
      TaskLabel result = apiInstance.getTaskLabels();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskLabelsApi#getTaskLabels");
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

[**TaskLabel**](TaskLabel.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | . |  -  |

