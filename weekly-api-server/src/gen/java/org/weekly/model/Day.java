package org.weekly.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Day  {
  
  @ApiModelProperty(value = "")
  private Integer dayOfYear = null;

  @ApiModelProperty(value = "")
  private Integer year = null;
 /**
   * Get dayOfYear
   * @return dayOfYear
  **/
  @JsonProperty("dayOfYear")
  public Integer getDayOfYear() {
    return dayOfYear;
  }

  public void setDayOfYear(Integer dayOfYear) {
    this.dayOfYear = dayOfYear;
  }

  public Day dayOfYear(Integer dayOfYear) {
    this.dayOfYear = dayOfYear;
    return this;
  }

 /**
   * Get year
   * @return year
  **/
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Day year(Integer year) {
    this.year = year;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Day {\n");
    
    sb.append("    dayOfYear: ").append(toIndentedString(dayOfYear)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

