/*
 * Weekly
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.weekly.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Preferences
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-05-09T23:24:57.319165-04:00[America/Toronto]")
public class Preferences {
  /**
   * Gets or Sets weekStart
   */
  @JsonAdapter(WeekStartEnum.Adapter.class)
  public enum WeekStartEnum {
    SUN("SUN"),
    
    MON("MON"),
    
    TUE("TUE"),
    
    WED("WED"),
    
    THU("THU"),
    
    FRI("FRI"),
    
    SAT("SAT");

    private String value;

    WeekStartEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static WeekStartEnum fromValue(String text) {
      for (WeekStartEnum b : WeekStartEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<WeekStartEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final WeekStartEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public WeekStartEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return WeekStartEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_WEEK_START = "weekStart";
  @SerializedName(SERIALIZED_NAME_WEEK_START)
  private WeekStartEnum weekStart = null;

  public static final String SERIALIZED_NAME_TIME_ZONE = "timeZone";
  @SerializedName(SERIALIZED_NAME_TIME_ZONE)
  private String timeZone = null;

  public static final String SERIALIZED_NAME_DRAG_TO_NEXT_WEEK = "dragToNextWeek";
  @SerializedName(SERIALIZED_NAME_DRAG_TO_NEXT_WEEK)
  private Boolean dragToNextWeek = null;

  public Preferences weekStart(WeekStartEnum weekStart) {
    this.weekStart = weekStart;
    return this;
  }

   /**
   * Get weekStart
   * @return weekStart
  **/
  @ApiModelProperty(value = "")
  public WeekStartEnum getWeekStart() {
    return weekStart;
  }

  public void setWeekStart(WeekStartEnum weekStart) {
    this.weekStart = weekStart;
  }

  public Preferences timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

   /**
   * Get timeZone
   * @return timeZone
  **/
  @ApiModelProperty(value = "")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public Preferences dragToNextWeek(Boolean dragToNextWeek) {
    this.dragToNextWeek = dragToNextWeek;
    return this;
  }

   /**
   * Get dragToNextWeek
   * @return dragToNextWeek
  **/
  @ApiModelProperty(value = "")
  public Boolean isDragToNextWeek() {
    return dragToNextWeek;
  }

  public void setDragToNextWeek(Boolean dragToNextWeek) {
    this.dragToNextWeek = dragToNextWeek;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Preferences preferences = (Preferences) o;
    return Objects.equals(this.weekStart, preferences.weekStart) &&
        Objects.equals(this.timeZone, preferences.timeZone) &&
        Objects.equals(this.dragToNextWeek, preferences.dragToNextWeek);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weekStart, timeZone, dragToNextWeek);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Preferences {\n");
    
    sb.append("    weekStart: ").append(toIndentedString(weekStart)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    dragToNextWeek: ").append(toIndentedString(dragToNextWeek)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

