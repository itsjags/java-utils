package com.jags.javautils.errors;

import java.util.Collection;

public interface ErrorType {
  String getCode();
  String getDescription();
  Collection<ErrorCategory> getCategories();
}
