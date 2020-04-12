package org.planit.model;

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
  
@XmlType(name="WeekStartEnum")
@XmlEnum(String.class)
public enum WeekStartEnum {

@XmlEnumValue("SUN") SUN(String.valueOf("SUN")), @XmlEnumValue("MON") MON(String.valueOf("MON")), @XmlEnumValue("TUE") TUE(String.valueOf("TUE")), @XmlEnumValue("WED") WED(String.valueOf("WED")), @XmlEnumValue("THU") THU(String.valueOf("THU")), @XmlEnumValue("FRI") FRI(String.valueOf("FRI")), @XmlEnumValue("SAT") SAT(String.valueOf("SAT"));


    private String value;

    WeekStartEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static WeekStartEnum fromValue(String v) {
        for (WeekStartEnum b : WeekStartEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  @ApiModelProperty(value = "")
  private WeekStartEnum weekStart = null;

  @ApiModelProperty(value = "")
  private String timeZone = null;

  @ApiModelProperty(value = "")
  private Boolean dragToNextWeek = null;
 /**
   * Get weekStart
   * @return weekStart
  **/
  @JsonProperty("weekStart")
  public String getWeekStart() {
    if (weekStart == null) {
      return null;
    }
    return weekStart.value();
  }

  public void setWeekStart(WeekStartEnum weekStart) {
    this.weekStart = weekStart;
  }

  public Preferences weekStart(WeekStartEnum weekStart) {
    this.weekStart = weekStart;
    return this;
  }

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
    
    sb.append("    weekStart: ").append(toIndentedString(weekStart)).append("\n");
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

