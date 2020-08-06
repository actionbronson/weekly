package org.weekly.model;

import java.time.OffsetDateTime;
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

public class BasicObject  {
  
  @ApiModelProperty(value = "")
  private OffsetDateTime updateTs;

  @ApiModelProperty(value = "")
  private OffsetDateTime creationTs;

  @ApiModelProperty(value = "")
  private String typeOf;
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

  public BasicObject updateTs(OffsetDateTime updateTs) {
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

  public BasicObject creationTs(OffsetDateTime creationTs) {
    this.creationTs = creationTs;
    return this;
  }

 /**
   * Get typeOf
   * @return typeOf
  **/
  @JsonProperty("typeOf")
  public String getTypeOf() {
    return typeOf;
  }

  public void setTypeOf(String typeOf) {
    this.typeOf = typeOf;
  }

  public BasicObject typeOf(String typeOf) {
    this.typeOf = typeOf;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicObject {\n");
    
    sb.append("    updateTs: ").append(toIndentedString(updateTs)).append("\n");
    sb.append("    creationTs: ").append(toIndentedString(creationTs)).append("\n");
    sb.append("    typeOf: ").append(toIndentedString(typeOf)).append("\n");
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

