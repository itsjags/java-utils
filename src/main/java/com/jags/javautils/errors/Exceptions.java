package com.jags.javautils.errors;

public class Exceptions {

  @SuppressWarnings("unchecked")
  public static <T> T extractCause(final Class<T> clazz, final Throwable throwable) {
    Throwable cause = throwable;
    T applicationException = null;

    while(cause != null) {
      if(clazz.isInstance(cause)) {
        applicationException = (T) cause;
        break;
      }

      cause = cause.getCause();
    }

    return applicationException;
  }

  public static void throwUnsupportedOperation(final String message, final Throwable cause){
    throw new UnsupportedOperationException(message, cause);
  }

  public static void throwUnsupportedOperation(final String message){
    throw new UnsupportedOperationException(message);
  }

  public static void throwUnsupportedOperation(){
    throw new UnsupportedOperationException();
  }

  public static UnsupportedOperationException unsupportedOperation(){
    return new UnsupportedOperationException();
  }
}
