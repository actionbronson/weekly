# CalendarApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCurrentWeek**](CalendarApi.md#getCurrentWeek) | **GET** /week | Get current week based on a timezone
[**getNextWeek**](CalendarApi.md#getNextWeek) | **GET** /week/next | Get next week.
[**getPreviousWeek**](CalendarApi.md#getPreviousWeek) | **GET** /week/previous | Get previous week.


<a name="getCurrentWeek"></a>
# **getCurrentWeek**
> Week getCurrentWeek(tz)

Get current week based on a timezone

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiClient;
//import org.weekly.invoker.ApiException;
//import org.weekly.invoker.Configuration;
//import org.weekly.invoker.auth.*;
//import org.weekly.api.CalendarApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oAuthFacebook
OAuth oAuthFacebook = (OAuth) defaultClient.getAuthentication("oAuthFacebook");
oAuthFacebook.setAccessToken("YOUR ACCESS TOKEN");

CalendarApi apiInstance = new CalendarApi();
String tz = "tz_example"; // String | the timezone
try {
    Week result = apiInstance.getCurrentWeek(tz);
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

### Return type

[**Week**](Week.md)

### Authorization

[oAuthFacebook](../README.md#oAuthFacebook)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNextWeek"></a>
# **getNextWeek**
> Week getNextWeek(weekNo, weekYear)

Get next week.

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiClient;
//import org.weekly.invoker.ApiException;
//import org.weekly.invoker.Configuration;
//import org.weekly.invoker.auth.*;
//import org.weekly.api.CalendarApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oAuthFacebook
OAuth oAuthFacebook = (OAuth) defaultClient.getAuthentication("oAuthFacebook");
oAuthFacebook.setAccessToken("YOUR ACCESS TOKEN");

CalendarApi apiInstance = new CalendarApi();
Integer weekNo = 56; // Integer | ISO 8601 relative week (number).
Integer weekYear = 56; // Integer | ISO 8601 relative week (year).
try {
    Week result = apiInstance.getNextWeek(weekNo, weekYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CalendarApi#getNextWeek");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **weekNo** | **Integer**| ISO 8601 relative week (number). |
 **weekYear** | **Integer**| ISO 8601 relative week (year). |

### Return type

[**Week**](Week.md)

### Authorization

[oAuthFacebook](../README.md#oAuthFacebook)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPreviousWeek"></a>
# **getPreviousWeek**
> Week getPreviousWeek(weekNo, weekYear)

Get previous week.

### Example
```java
// Import classes:
//import org.weekly.invoker.ApiClient;
//import org.weekly.invoker.ApiException;
//import org.weekly.invoker.Configuration;
//import org.weekly.invoker.auth.*;
//import org.weekly.api.CalendarApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oAuthFacebook
OAuth oAuthFacebook = (OAuth) defaultClient.getAuthentication("oAuthFacebook");
oAuthFacebook.setAccessToken("YOUR ACCESS TOKEN");

CalendarApi apiInstance = new CalendarApi();
Integer weekNo = 56; // Integer | ISO 8601 relative week (number).
Integer weekYear = 56; // Integer | ISO 8601 relative week (year).
try {
    Week result = apiInstance.getPreviousWeek(weekNo, weekYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CalendarApi#getPreviousWeek");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **weekNo** | **Integer**| ISO 8601 relative week (number). |
 **weekYear** | **Integer**| ISO 8601 relative week (year). |

### Return type

[**Week**](Week.md)

### Authorization

[oAuthFacebook](../README.md#oAuthFacebook)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

