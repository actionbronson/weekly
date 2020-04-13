# openapi-java-client

PlanIt
- API version: 1.0.0
  - Build date: 2020-04-13T16:18:41.063880-04:00[America/Toronto]

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.weekly.invoker.*;
import org.weekly.invoker.auth.*;
import org.weekly.model.*;
import org.weekly.api.CalendarApi;

import java.io.File;
import java.util.*;

public class CalendarApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CalendarApi* | [**getCurrentWeek**](docs/CalendarApi.md#getCurrentWeek) | **GET** /week | Get current week based on a timezone
*CalendarApi* | [**getNextWeek**](docs/CalendarApi.md#getNextWeek) | **GET** /week/next | Get next week.
*CalendarApi* | [**getPreviousWeek**](docs/CalendarApi.md#getPreviousWeek) | **GET** /week/previous | Get previous week.


## Documentation for Models

 - [Day](docs/Day.md)
 - [Preferences](docs/Preferences.md)
 - [User](docs/User.md)
 - [Week](docs/Week.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


