package org.planit.model;

import java.math.BigDecimal;
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
  private BigDecimal start = null;

  @ApiModelProperty(value = "")
  private String startLabel = null;

  @ApiModelProperty(value = "")
  @Valid
  private BigDecimal end = null;

  @ApiModelProperty(value = "")
  private String endLabel = null;
 /**
   * Get start
   * @return start
  **/
  @JsonProperty("start")
  public BigDecimal getStart() {
    return start;
  }

  public void setStart(BigDecimal start) {
    this.start = start;
  }

  public Week start(BigDecimal start) {
    this.start = start;
    return this;
  }

 /**
   * Get startLabel
   * @return startLabel
  **/
  @JsonProperty("startLabel")
  public String getStartLabel() {
    return startLabel;
  }

  public void setStartLabel(String startLabel) {
    this.startLabel = startLabel;
  }

  public Week startLabel(String startLabel) {
    this.startLabel = startLabel;
    return this;
  }

 /**
   * Get end
   * @return end
  **/
  @JsonProperty("end")
  public BigDecimal getEnd() {
    return end;
  }

  public void setEnd(BigDecimal end) {
    this.end = end;
  }

  public Week end(BigDecimal end) {
    this.end = end;
    return this;
  }

 /**
   * Get endLabel
   * @return endLabel
  **/
  @JsonProperty("endLabel")
  public String getEndLabel() {
    return endLabel;
  }

  public void setEndLabel(String endLabel) {
    this.endLabel = endLabel;
  }

  public Week endLabel(String endLabel) {
    this.endLabel = endLabel;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Week {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    startLabel: ").append(toIndentedString(startLabel)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
    sb.append("    endLabel: ").append(toIndentedString(endLabel)).append("\n");
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

