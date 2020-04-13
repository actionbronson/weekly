# CalendarApi

All URIs are relative to *http://localhost/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCurrentWeek**](CalendarApi.md#getCurrentWeek) | **GET** /week | Get current week based on a timezone
[**getNextWeek**](CalendarApi.md#getNextWeek) | **GET** /week/next | Get next week.
[**getPreviousWeek**](CalendarApi.md#getPreviousWeek) | **GET** /week/previous | Get previous week.


<a name="getCurrentWeek"></a>
# **getCurrentWeek**
> Week getCurrentWeek(tz, weekStart)

Get current week based on a timezone

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiException;
//import org.weekly.api.CalendarApi;


CalendarApi apiInstance = new CalendarApi();
String tz = "tz_example"; // String | the timezone
String weekStart = "weekStart_example"; // String | Day of the week to start week on.
try {
    Week result = apiInstance.getCurrentWeek(tz, weekStart);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CalendarApi#getCurrentWeek");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tz** | **String**| the timezone |
 **weekStart** | **String**| Day of the week to start week on. | [enum: SUN, MON, TUE, WED, THU, FRI, SAT]

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNextWeek"></a>
# **getNextWeek**
> Week getNextWeek(year, weekEnd)

Get next week.

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiException;
//import org.weekly.api.CalendarApi;


CalendarApi apiInstance = new CalendarApi();
Integer year = 56; // Integer | The year of the week number.
Integer weekEnd = 56; // Integer | Day of the year of the last day of the current week.
try {
    Week result = apiInstance.getNextWeek(year, weekEnd);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CalendarApi#getNextWeek");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **year** | **Integer**| The year of the week number. |
 **weekEnd** | **Integer**| Day of the year of the last day of the current week. |

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPreviousWeek"></a>
# **getPreviousWeek**
> Week getPreviousWeek(year, weekStart)

Get previous week.

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiException;
//import org.weekly.api.CalendarApi;


CalendarApi apiInstance = new CalendarApi();
Integer year = 56; // Integer | The year of the week number.
Integer weekStart = 56; // Integer | Day of the year of the first day of the current week.
try {
    Week result = apiInstance.getPreviousWeek(year, weekStart);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CalendarApi#getPreviousWeek");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **year** | **Integer**| The year of the week number. |
 **weekStart** | **Integer**| Day of the year of the first day of the current week. |

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

