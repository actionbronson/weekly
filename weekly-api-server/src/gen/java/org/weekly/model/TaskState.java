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

public class TaskState  {
  
@XmlType(name="ValueEnum")
@XmlEnum(String.class)
public enum ValueEnum {

@XmlEnumValue("TODO") TODO(String.valueOf("TODO")), @XmlEnumValue("IN_PROGRESS") IN_PROGRESS(String.valueOf("IN_PROGRESS")), @XmlEnumValue("DONE") DONE(String.valueOf("DONE"));


    private String value;

    ValueEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ValueEnum fromValue(String value) {
        for (ValueEnum b : ValueEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  @ApiModelProperty(value = "")
  private ValueEnum value;
 /**
   * Get value
   * @return value
  **/
  @JsonProperty("value")
  public String getValue() {
    if (value == null) {
      return null;
    }
    return value.value();
  }

  public void setValue(ValueEnum value) {
    this.value = value;
  }

  public TaskState value(ValueEnum value) {
    this.value = value;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskState {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

