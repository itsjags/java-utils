package com.jags.javautils.commons;

import com.jags.javautils.Check;
import com.jags.javautils.errors.ErrorType;

import static java.lang.String.format;

/**
 * Note: The static consturctors are intentionally restricted to the combinations of arguments available here, i.e.
 * either: errorType, message, throwable
 * or: errorType, message
 *
 * the first is for wrapping exceptions,
 * and second is for instantiating a new application exception
 */
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private final ErrorType errorType;

  private ApplicationException(final ErrorType errorType, final String msg, final Throwable cause){
    super(format("error code[%s - %s], message[%s]", errorType.getCode(), errorType.getDescription(), msg), cause);
    this.errorType = errorType;
  }

  private ApplicationException(final ErrorType errorType, final String msg){
    super(format("error code[%s - %s], message[%s]", errorType.getCode(), errorType.getDescription(), msg));
    this.errorType = errorType;
  }

  public static <T extends Enum<T> & ErrorType> ApplicationException create(final T errorType, final String message, final Throwable cause){
    Check.notNull(errorType, "errorType");
    Check.notBlank(message, "message");
    Check.notNull(cause, "cause");

    return new ApplicationException(errorType, message, cause);
  }

  public static <T extends Enum<T> & ErrorType> ApplicationException create(final T errorType, final String message){
    Check.notNull(errorType, "errorType");
    Check.notNull(message, "message");

    return new ApplicationException(errorType, message);
  }

  public ErrorType getErrorType() {
    return errorType;
  }
}
