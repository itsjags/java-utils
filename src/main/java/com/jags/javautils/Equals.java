package com.jags.javautils;

import java.util.Arrays;

public final class Equals {

  static public boolean areEqual(boolean aThis, boolean aThat) {
    return aThis == aThat;
  }

  static public boolean areEqual(int aThis, int aThat) {
    return aThis == aThat;
  }

  static public boolean areEqual(char aThis, char aThat) {
    return aThis == aThat;
  }

  static public boolean areEqual(short aThis, short aThat) {
    return aThis == aThat;
  }

  static public boolean areEqual(byte aThis, byte aThat) {
    return aThis == aThat;
  }

  static public boolean areEqual(long aThis, long aThat) {
    return aThis == aThat;
  }

  static public boolean areEqual(float aThis, float aThat) {
    return Float.floatToIntBits(aThis) == Float.floatToIntBits(aThat);
  }

  static public boolean areEqual(double aThis, double aThat) {
    return Double.doubleToLongBits(aThis) == Double.doubleToLongBits(aThat);
  }

  static public boolean areEqual(double aThis, double aThat, double target, int ulps){
    boolean result = false;
    if (Double.compare(aThis, aThat) == 0 || Math.abs(aThis - aThat) <= (Math.ulp(target) * ulps)) {
      result = true;
    }
    return result;
  }

  static public boolean areEqual(float aThis, float aThat, float target, int ulps) {
    boolean result = false;
    if (Float.compare(aThis, aThat) == 0 || Math.abs(aThis - aThat) <= (Math.ulp(target) * ulps)) {
      result = true;
    }
    return result;
  }

  /**
   * Possibly-null object field.
   *
   * Includes type-safe enumerations and collections, but does not include
   * arrays
   */
  static public <T> boolean areEqual(T aThis, T aThat) {
    return aThis == null ? aThat == null : aThis.equals(aThat);
  }

  static public <T>  boolean areArraysEqual(T[] t1, T[] t2){
    return Arrays.equals(t1, t2);
  }

  public static <T> boolean allEqual(T...ts){

    Check.notNull(ts, "ts", "cannot check if all items are equal if the array is null");
    Check.greaterThan(ts.length, 1, "ts", "Zero", "cannot check if all items are equal if the array is empty or has 1 item");

    T t0 = ts[0];

    boolean result = true;

    for(T t : ts){
      if(!areEqual(t,t0)){
        result = false;
        break;
      }
    }

    return result;
  }
}