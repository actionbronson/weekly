package org.weekly.model;

import org.weekly.model.Day;
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

public class Week  {
  
  @ApiModelProperty(value = "")
  @Valid
  private Day start = null;

  @ApiModelProperty(value = "")
  @Valid
  private Day end = null;
 /**
   * Get start
   * @return start
  **/
  @JsonProperty("start")
  public Day getStart() {
    return start;
  }

  public void setStart(Day start) {
    this.start = start;
  }

  public Week start(Day start) {
    this.start = start;
    return this;
  }

 /**
   * Get end
   * @return end
  **/
  @JsonProperty("end")
  public Day getEnd() {
    return end;
  }

  public void setEnd(Day end) {
    this.end = end;
  }

  public Week end(Day end) {
    this.end = end;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Week {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

