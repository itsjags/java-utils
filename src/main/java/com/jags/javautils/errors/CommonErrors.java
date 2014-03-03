package com.jags.javautils.errors;

import java.util.Collection;
import java.util.Collections;

public enum CommonErrors implements ErrorType {
  VALIDATION_ERROR("common.errors.001", "Validation Error"),
  DATE_ERROR("common.errors.002", "Date Processing Error"),
  IO_ERROR("common.errors.003", "IO Error"),
  URI_SYNTAX_ERROR("common.errors.004", "URI Syntax Error"),
  XML_INVALID("common.errors.005", "XML invalid against a schema"),
  XML_MALFORMED("common.errors.006", "XML is not well-formed"),
  SERIALIZATION_ERROR("common.errors.007", "Serialization Error"),
  DESERIALIZATION_ERROR("common.errors.008", "Deserialization Error"),
  FORMATTING_ERROR("common.errors.009", "Formatting Error"),
  REFLECTION_ERROR("common.errors.010", "Reflection Error"),
  NOT_SUPPORTED_OPERATION_ERROR("common.errors.011", "Not Supported Operation Error"),
  INSTANTIATION_ERROR("common.errors.012", "Instantiation Error"),
  ACCESS_ERROR("common.errors.013","Access Error"),
  ILLEGAL_ARGUMENT_ERROR("common.errors.014","Illegal Argument Error");

  private final String code;
  private final String description;

  private CommonErrors(String code, String description) {
    this.code = code;
    this.description = description;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Collection<ErrorCategory> getCategories() {
    return Collections.<ErrorCategory>emptyList();
  }

}
