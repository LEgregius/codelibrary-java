package io.swagger.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Reason {
  @SerializedName("code")
  private String code = null;

  @SerializedName("message")
  private String message = null;

  public String getCode() {
    return code;
  }

  public Reason setCode(String code) {
    this.code = code;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public Reason setMessage(String message) {
    this.message = message;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Reason reason = (Reason) o;
    return Objects.equals(code, reason.code) &&
        Objects.equals(message, reason.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reason {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
