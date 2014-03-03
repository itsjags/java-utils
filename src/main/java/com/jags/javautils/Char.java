package com.jags.javautils;

import java.util.Arrays;

public class Char {
  public static final String NEW_LINE = System.getProperty("line.separator");

  public static char[] repeat(char c, final int n){
    Check.greaterThanOrEqualTo(n, 0, "number of repetitions", "ZERO", "cannot repeat things less times than ZERO");
    final char[] cs = new char[n];
    Arrays.fill(cs, c);
    return cs;
  }

  public static String toString(final char...chars){
    return Arrays2.length(chars) == 0 ? Strings.EMPTY_STRING : String.valueOf(chars);
  }
}
