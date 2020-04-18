package org.weekly.model;

import org.weekly.model.TaskLabel;
import org.weekly.model.TaskPriority;
import org.weekly.model.TaskState;
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


public class Task  {
  
  @ApiModelProperty(value = "")
  @Valid
  private TaskLabel label = null;

  @ApiModelProperty(value = "")
  @Valid
  private TaskPriority priority = null;

  @ApiModelProperty(value = "")
  private String summary = null;

  @ApiModelProperty(value = "")
  private String contents = null;

  @ApiModelProperty(value = "")
  @Valid
  private TaskState state = null;
 /**
   * Get label
   * @return label
  **/
  @JsonProperty("label")
  public TaskLabel getLabel() {
    return label;
  }

  public void setLabel(TaskLabel label) {
    this.label = label;
  }

  public Task label(TaskLabel label) {
    this.label = label;
    return this;
  }

 /**
   * Get priority
   * @return priority
  **/
  @JsonProperty("priority")
  public TaskPriority getPriority() {
    return priority;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public Task priority(TaskPriority priority) {
    this.priority = priority;
    return this;
  }

 /**
   * Get summary
   * @return summary
  **/
  @JsonProperty("summary")
 @Size(min=3,max=128)  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Task summary(String summary) {
    this.summary = summary;
    return this;
  }

 /**
   * Get contents
   * @return contents
  **/
  @JsonProperty("contents")
 @Size(max=65536)  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public Task contents(String contents) {
    this.contents = contents;
    return this;
  }

 /**
   * Get state
   * @return state
  **/
  @JsonProperty("state")
  public TaskState getState() {
    return state;
  }

  public void setState(TaskState state) {
    this.state = state;
  }

  public Task state(TaskState state) {
    this.state = state;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    contents: ").append(toIndentedString(contents)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

