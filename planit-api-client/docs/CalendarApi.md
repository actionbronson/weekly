# CalendarApi

All URIs are relative to *http://localhost/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCurrentWeek**](CalendarApi.md#getCurrentWeek) | **GET** /week/current | Get current week based on a timezone


<a name="getCurrentWeek"></a>
# **getCurrentWeek**
> Week getCurrentWeek()

Get current week based on a timezone

### Example
```java
// Import classes:
//import org.planit.invoker.ApiException;
//import org.planit.api.CalendarApi;


CalendarApi apiInstance = new CalendarApi();
try {
    Week result = apiInstance.getCurrentWeek();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CalendarApi#getCurrentWeek");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

