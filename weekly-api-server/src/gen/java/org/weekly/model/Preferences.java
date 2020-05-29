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

public class Preferences  {
  
  @ApiModelProperty(value = "")
  private String timeZone = null;

  @ApiModelProperty(value = "")
  private Boolean dragToNextWeek = null;
 /**
   * Get timeZone
   * @return timeZone
  **/
  @JsonProperty("timeZone")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public Preferences timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

 /**
   * Get dragToNextWeek
   * @return dragToNextWeek
  **/
  @JsonProperty("dragToNextWeek")
  public Boolean isDragToNextWeek() {
    return dragToNextWeek;
  }

  public void setDragToNextWeek(Boolean dragToNextWeek) {
    this.dragToNextWeek = dragToNextWeek;
  }

  public Preferences dragToNextWeek(Boolean dragToNextWeek) {
    this.dragToNextWeek = dragToNextWeek;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Preferences {\n");
    
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    dragToNextWeek: ").append(toIndentedString(dragToNextWeek)).append("\n");
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

