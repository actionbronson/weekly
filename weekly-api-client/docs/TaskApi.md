# TaskApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createTask**](TaskApi.md#createTask) | **POST** /week/{weekYear}/{weekNo}/tasks | Create a task.


<a name="createTask"></a>
# **createTask**
> Task createTask(weekNo, weekYear)

Create a task.

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiException;
//import org.weekly.api.TaskApi;


TaskApi apiInstance = new TaskApi();
Integer weekNo = 56; // Integer | ISO 8601 relative week (number).
Integer weekYear = 56; // Integer | ISO 8601 relative week (year).
try {
    Task result = apiInstance.createTask(weekNo, weekYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskApi#createTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **weekNo** | **Integer**| ISO 8601 relative week (number). |
 **weekYear** | **Integer**| ISO 8601 relative week (year). |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

