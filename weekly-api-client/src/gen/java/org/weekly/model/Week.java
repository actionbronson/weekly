/*
 * Weekly
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
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
import org.weekly.model.Day;

/**
 * Week
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-06T16:30:12.704730-04:00[America/Toronto]")
public class Week {
  public static final String SERIALIZED_NAME_YEAR = "year";
  @SerializedName(SERIALIZED_NAME_YEAR)
  private Integer year;

  public static final String SERIALIZED_NAME_WEEK_NO = "weekNo";
  @SerializedName(SERIALIZED_NAME_WEEK_NO)
  private Integer weekNo;

  public static final String SERIALIZED_NAME_START = "start";
  @SerializedName(SERIALIZED_NAME_START)
  private Day start;

  public static final String SERIALIZED_NAME_END = "end";
  @SerializedName(SERIALIZED_NAME_END)
  private Day end;


  public Week year(Integer year) {
    
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getYear() {
    return year;
  }


  public void setYear(Integer year) {
    this.year = year;
  }


  public Week weekNo(Integer weekNo) {
    
    this.weekNo = weekNo;
    return this;
  }

   /**
   * Get weekNo
   * @return weekNo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getWeekNo() {
    return weekNo;
  }


  public void setWeekNo(Integer weekNo) {
    this.weekNo = weekNo;
  }


  public Week start(Day start) {
    
    this.start = start;
    return this;
  }

   /**
   * Get start
   * @return start
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Day getStart() {
    return start;
  }


  public void setStart(Day start) {
    this.start = start;
  }


  public Week end(Day end) {
    
    this.end = end;
    return this;
  }

   /**
   * Get end
   * @return end
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Day getEnd() {
    return end;
  }


  public void setEnd(Day end) {
    this.end = end;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Week week = (Week) o;
    return Objects.equals(this.year, week.year) &&
        Objects.equals(this.weekNo, week.weekNo) &&
        Objects.equals(this.start, week.start) &&
        Objects.equals(this.end, week.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, weekNo, start, end);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Week {\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    weekNo: ").append(toIndentedString(weekNo)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

