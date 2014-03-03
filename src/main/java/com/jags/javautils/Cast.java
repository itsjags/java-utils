package com.jags.javautils;

/**
 * TODO: Maybe change this to allow the following usage: Cast.to(class).from(object).cast(); (Use static import on to).
 * Might be useful for casting multiple objects for instance.
 */

public class Cast {
  private Cast(){}

  @SuppressWarnings("unchecked")
  public static <I, O> O to(final I input, Class<O> outputClass){
    return (O) input;
  }
}