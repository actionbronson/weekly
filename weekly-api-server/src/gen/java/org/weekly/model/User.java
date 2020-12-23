package org.weekly.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.weekly.model.Preferences;
import org.weekly.model.TaskLabel;
import org.weekly.model.TaskPriority;
import org.weekly.model.TaskState;
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
  
  @ApiModelProperty(value = "")
  @Valid
  private UserId id;

  @ApiModelProperty(value = "")
  private OffsetDateTime updateTs;

  @ApiModelProperty(value = "")
  private OffsetDateTime creationTs;

  @ApiModelProperty(value = "")
  private String name;

  @ApiModelProperty(value = "")
  private String firstName;

  @ApiModelProperty(value = "")
  private String lastName;

  @ApiModelProperty(value = "")
  private String picture;

  @ApiModelProperty(value = "")
  private String alias;

  @ApiModelProperty(value = "")
  @Valid
  private List<TaskLabel> labels = null;

  @ApiModelProperty(value = "")
  @Valid
  private List<TaskPriority> priorities = null;

  @ApiModelProperty(value = "")
  @Valid
  private List<TaskState> states = null;

  @ApiModelProperty(value = "")
  @Valid
  private Preferences preferences;
 /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
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
   * Get updateTs
   * @return updateTs
  **/
  @JsonProperty("updateTs")
  public OffsetDateTime getUpdateTs() {
    return updateTs;
  }

  public void setUpdateTs(OffsetDateTime updateTs) {
    this.updateTs = updateTs;
  }

  public User updateTs(OffsetDateTime updateTs) {
    this.updateTs = updateTs;
    return this;
  }

 /**
   * Get creationTs
   * @return creationTs
  **/
  @JsonProperty("creationTs")
  public OffsetDateTime getCreationTs() {
    return creationTs;
  }

  public void setCreationTs(OffsetDateTime creationTs) {
    this.creationTs = creationTs;
  }

  public User creationTs(OffsetDateTime creationTs) {
    this.creationTs = creationTs;
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
   * Get labels
   * @return labels
  **/
  @JsonProperty("labels")
  public List<TaskLabel> getLabels() {
    return labels;
  }

  public void setLabels(List<TaskLabel> labels) {
    this.labels = labels;
  }

  public User labels(List<TaskLabel> labels) {
    this.labels = labels;
    return this;
  }

  public User addLabelsItem(TaskLabel labelsItem) {
    this.labels.add(labelsItem);
    return this;
  }

 /**
   * Get priorities
   * @return priorities
  **/
  @JsonProperty("priorities")
  public List<TaskPriority> getPriorities() {
    return priorities;
  }

  public void setPriorities(List<TaskPriority> priorities) {
    this.priorities = priorities;
  }

  public User priorities(List<TaskPriority> priorities) {
    this.priorities = priorities;
    return this;
  }

  public User addPrioritiesItem(TaskPriority prioritiesItem) {
    this.priorities.add(prioritiesItem);
    return this;
  }

 /**
   * Get states
   * @return states
  **/
  @JsonProperty("states")
  public List<TaskState> getStates() {
    return states;
  }

  public void setStates(List<TaskState> states) {
    this.states = states;
  }

  public User states(List<TaskState> states) {
    this.states = states;
    return this;
  }

  public User addStatesItem(TaskState statesItem) {
    this.states.add(statesItem);
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


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    updateTs: ").append(toIndentedString(updateTs)).append("\n");
    sb.append("    creationTs: ").append(toIndentedString(creationTs)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    priorities: ").append(toIndentedString(priorities)).append("\n");
    sb.append("    states: ").append(toIndentedString(states)).append("\n");
    sb.append("    preferences: ").append(toIndentedString(preferences)).append("\n");
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

