package org.weekly.model;

import java.util.ArrayList;
import java.util.List;
import org.weekly.model.Day;
import org.weekly.model.Task;
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
  private Integer year = null;

  @ApiModelProperty(value = "")
  private Integer weekNo = null;

  @ApiModelProperty(value = "")
  @Valid
  private Day start = null;

  @ApiModelProperty(value = "")
  @Valid
  private Day end = null;

  @ApiModelProperty(value = "")
  @Valid
  private List<Task> tasks = null;
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

  public Week year(Integer year) {
    this.year = year;
    return this;
  }

 /**
   * Get weekNo
   * @return weekNo
  **/
  @JsonProperty("weekNo")
  public Integer getWeekNo() {
    return weekNo;
  }

  public void setWeekNo(Integer weekNo) {
    this.weekNo = weekNo;
  }

  public Week weekNo(Integer weekNo) {
    this.weekNo = weekNo;
    return this;
  }

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

  public Week tasks(List<Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public Week addTasksItem(Task tasksItem) {
    this.tasks.add(tasksItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Week {\n");
    
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    weekNo: ").append(toIndentedString(weekNo)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

