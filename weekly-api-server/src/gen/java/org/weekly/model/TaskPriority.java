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

public class TaskPriority  {
  
  @ApiModelProperty(value = "")
  private String name = null;

  @ApiModelProperty(value = "")
  private Integer level = null;
 /**
   * Get name
   * @return name
  **/
  @JsonProperty("name")
 @Size(min=3,max=32)  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TaskPriority name(String name) {
    this.name = name;
    return this;
  }

 /**
   * Get level
   * @return level
  **/
  @JsonProperty("level")
  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public TaskPriority level(Integer level) {
    this.level = level;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskPriority {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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

