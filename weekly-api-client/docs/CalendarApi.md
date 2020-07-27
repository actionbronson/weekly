# CalendarApi

All URIs are relative to *https://localhost:8443/api/rest/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCurrentWeek**](CalendarApi.md#getCurrentWeek) | **GET** /week | Get current week based on a timezone
[**getNextWeek**](CalendarApi.md#getNextWeek) | **GET** /week/next | Get next week.
[**getPreviousWeek**](CalendarApi.md#getPreviousWeek) | **GET** /week/previous | Get previous week.
[**getWeekOf**](CalendarApi.md#getWeekOf) | **GET** /week/{weekYear}/{weekNo} | Get current week based on a timezone


<a name="getCurrentWeek"></a>
# **getCurrentWeek**
> Week getCurrentWeek(tz)

Get current week based on a timezone

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    String tz = "tz_example"; // String | the timezone
    try {
      Week result = apiInstance.getCurrentWeek(tz);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#getCurrentWeek");
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
 **tz** | **String**| the timezone |

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The current week |  -  |

<a name="getNextWeek"></a>
# **getNextWeek**
> Week getNextWeek(weekNo, weekYear)

Get next week.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    Integer weekNo = 56; // Integer | ISO 8601 relative week (number).
    Integer weekYear = 56; // Integer | ISO 8601 relative week (year).
    try {
      Week result = apiInstance.getNextWeek(weekNo, weekYear);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#getNextWeek");
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
 **weekNo** | **Integer**| ISO 8601 relative week (number). |
 **weekYear** | **Integer**| ISO 8601 relative week (year). |

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The next week |  -  |

<a name="getPreviousWeek"></a>
# **getPreviousWeek**
> Week getPreviousWeek(weekNo, weekYear)

Get previous week.

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    Integer weekNo = 56; // Integer | ISO 8601 relative week (number).
    Integer weekYear = 56; // Integer | ISO 8601 relative week (year).
    try {
      Week result = apiInstance.getPreviousWeek(weekNo, weekYear);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#getPreviousWeek");
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
 **weekNo** | **Integer**| ISO 8601 relative week (number). |
 **weekYear** | **Integer**| ISO 8601 relative week (year). |

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The previous week |  -  |

<a name="getWeekOf"></a>
# **getWeekOf**
> Week getWeekOf(weekNo, weekYear)

Get current week based on a timezone

### Example
```java
// Import classes:
import org.weekly.invoker.ApiClient;
import org.weekly.invoker.ApiException;
import org.weekly.invoker.Configuration;
import org.weekly.invoker.models.*;
import org.weekly.api.CalendarApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8443/api/rest/v1");

    CalendarApi apiInstance = new CalendarApi(defaultClient);
    Integer weekNo = 56; // Integer | ISO 8601 relative week (number).
    Integer weekYear = 56; // Integer | ISO 8601 relative week (year).
    try {
      Week result = apiInstance.getWeekOf(weekNo, weekYear);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarApi#getWeekOf");
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
 **weekNo** | **Integer**| ISO 8601 relative week (number). |
 **weekYear** | **Integer**| ISO 8601 relative week (year). |

### Return type

[**Week**](Week.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The week |  -  |

