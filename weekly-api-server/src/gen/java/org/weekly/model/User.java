package org.weekly.model;

import java.util.ArrayList;
import java.util.List;
import org.weekly.model.Task;
import org.weekly.model.UserId;
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

public class User  {
  
  @ApiModelProperty(required = true, value = "")
  @Valid
  private UserId id = null;

  @ApiModelProperty(value = "")
  private String name = null;

  @ApiModelProperty(value = "")
  private String alias = null;

  @ApiModelProperty(value = "")
  private Object preferences = null;

  @ApiModelProperty(value = "")
  @Valid
  private List<Task> tasks = null;
 /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
    @org.springframework.data.annotation.Id
  @NotNull
  public UserId getId() {
    return id;
  }

  public void setId(UserId id) {
    this.id = id;
  }

  public User id(UserId id) {
    this.id = id;
    return this;
  }

 /**
   * Get name
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

 /**
   * Get alias
   * @return alias
  **/
  @JsonProperty("alias")
  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public User alias(String alias) {
    this.alias = alias;
    return this;
  }

 /**
   * Get preferences
   * @return preferences
  **/
  @JsonProperty("preferences")
  public Object getPreferences() {
    return preferences;
  }

  public void setPreferences(Object preferences) {
    this.preferences = preferences;
  }

  public User preferences(Object preferences) {
    this.preferences = preferences;
    return this;
  }

 /**
   * Get tasks
   * @return tasks
  **/
  @JsonProperty("tasks")
  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public User tasks(List<Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public User addTasksItem(Task tasksItem) {
    this.tasks.add(tasksItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    preferences: ").append(toIndentedString(preferences)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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

