/*
 * Weekly
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.weekly.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * BasicObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-08-06T16:30:12.704730-04:00[America/Toronto]")
public class BasicObject {
  public static final String SERIALIZED_NAME_UPDATE_TS = "updateTs";
  @SerializedName(SERIALIZED_NAME_UPDATE_TS)
  private OffsetDateTime updateTs;

  public static final String SERIALIZED_NAME_CREATION_TS = "creationTs";
  @SerializedName(SERIALIZED_NAME_CREATION_TS)
  private OffsetDateTime creationTs;

  public static final String SERIALIZED_NAME_TYPE_OF = "typeOf";
  @SerializedName(SERIALIZED_NAME_TYPE_OF)
  private String typeOf;


  public BasicObject updateTs(OffsetDateTime updateTs) {
    
    this.updateTs = updateTs;
    return this;
  }

   /**
   * Get updateTs
   * @return updateTs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getUpdateTs() {
    return updateTs;
  }


  public void setUpdateTs(OffsetDateTime updateTs) {
    this.updateTs = updateTs;
  }


  public BasicObject creationTs(OffsetDateTime creationTs) {
    
    this.creationTs = creationTs;
    return this;
  }

   /**
   * Get creationTs
   * @return creationTs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OffsetDateTime getCreationTs() {
    return creationTs;
  }


  public void setCreationTs(OffsetDateTime creationTs) {
    this.creationTs = creationTs;
  }


  public BasicObject typeOf(String typeOf) {
    
    this.typeOf = typeOf;
    return this;
  }

   /**
   * Get typeOf
   * @return typeOf
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTypeOf() {
    return typeOf;
  }


  public void setTypeOf(String typeOf) {
    this.typeOf = typeOf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicObject basicObject = (BasicObject) o;
    return Objects.equals(this.updateTs, basicObject.updateTs) &&
        Objects.equals(this.creationTs, basicObject.creationTs) &&
        Objects.equals(this.typeOf, basicObject.typeOf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateTs, creationTs, typeOf);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

