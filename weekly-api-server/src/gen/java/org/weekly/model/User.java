package org.weekly.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.weekly.model.BasicObject;
import org.weekly.model.Preferences;
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

public class User extends BasicObject {
  
  @ApiModelProperty(required = true, value = "")
  @Valid
  private UserId id = null;

  @ApiModelProperty(value = "")
  private String name = null;

  @ApiModelProperty(value = "")
  private String firstName = null;

  @ApiModelProperty(value = "")
  private String lastName = null;

  @ApiModelProperty(value = "")
  private String picture = null;

  @ApiModelProperty(value = "")
  private String alias = null;

  @ApiModelProperty(value = "")
  @Valid
  private Preferences preferences = null;

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
   * Get firstName
   * @return firstName
  **/
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

 /**
   * Get lastName
   * @return lastName
  **/
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

 /**
   * Get picture
   * @return picture
  **/
  @JsonProperty("picture")
  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public User picture(String picture) {
    this.picture = picture;
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
  public Preferences getPreferences() {
    return preferences;
  }

  public void setPreferences(Preferences preferences) {
    this.preferences = preferences;
  }

  public User preferences(Preferences preferences) {
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
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
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

