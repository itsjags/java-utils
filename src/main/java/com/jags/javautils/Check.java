package com.jags.javautils;

import com.jags.javautils.commons.ApplicationException;
import com.jags.javautils.errors.CommonErrors;

import java.util.Arrays;
import java.util.Collection;

public class Check {
  public static void isTrue(final boolean condition, final String conditionName, final String... detailMessage) {
    if (!condition) {
      final String fullMessage = String.format("condition [%s] must be true, but was false. %n Details[%s]",
          conditionName, Arrays.toString(Arrays2.emptyIfNull(detailMessage, String[].class)));
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void isTrue(final boolean condition, final String conditionName) {
    isTrue(condition, conditionName, Strings.NOT_APPLICABLE);
  }

  public static void greaterThanOrEqualTo(final float value1, final float value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 >= value2)){
      final String fullMessage = String.format("[%s] must be greater than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void isPositive(final int value, final String valueName) {
    isPositive(value, valueName, Strings.NOT_APPLICABLE);
  }

  public static void isPositive(final int value, final String valueName, final String detailMessage) {
    if (value <= 0) {
      final String fullMessage =
          String.format("[%s] must be greater than 0 but was not. %n" + "[%s] had value [%s]. %n" + "Details[%s]", valueName,
              valueName, value, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void greaterThanOrEqualTo(final float value1, final float value2, final String value1Name, final String value2Name){
    greaterThanOrEqualTo(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void greaterThanOrEqualTo(final int value1, final int value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 >= value2)){
      final String fullMessage = String.format("[%s] must be greater than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void greaterThanOrEqualTo(final int value1, final int value2, final String value1Name, final String value2Name){
    greaterThanOrEqualTo(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void greaterThan(final int value1, final int value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 > value2)){
      final String fullMessage = String.format("[%s] must be greater than [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void greaterThan(final long value1, final long value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 > value2)){
      final String fullMessage = String.format("[%s] must be greater than [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void greaterThan(final int value1, final int value2, final String value1Name, final String value2Name){
    greaterThan(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void greaterThan(final long value1, final long value2, final String value1Name, final String value2Name){
    greaterThan(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void lessThanOrEqualTo(final float value1, final float value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 <= value2)){
      final String fullMessage = String.format("[%s] must be less than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void lessThanOrEqualTo(final float value1, final float value2, final String value1Name, final String value2Name){
    lessThanOrEqualTo(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void lessThanOrEqualTo(final double value1, final double value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 <= value2)){
      final String fullMessage = String.format("[%s] must be less than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void lessThanOrEqualTo(final double value1, final double value2, final String value1Name, final String value2Name){
    lessThanOrEqualTo(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void greaterThanOrEqualTo(final double value1, final double value2, final String value1Name,
                                          final String value2Name, final String detailMessage){
    if(!(value1 >= value2)){
      final String fullMessage = String.format("[%s] must be greater than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void greaterThanOrEqualTo(final double value1, final double value2, final String value1Name,
                                          final String value2Name){
    greaterThanOrEqualTo(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void greaterThan(final double value1, final double value2, final String value1Name,
                                 final String value2Name, final String detailMessage){
    if(!(value1 > value2)){
      final String fullMessage = String.format("[%s] must be greater than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void greaterThan(final double value1, final double value2, final String value1Name,
                                 final String value2Name){
    greaterThan(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static void lessThanOrEqualTo(final int value1, final int value2, final String value1Name, final String value2Name, final String detailMessage){
    if(!(value1 <= value2)){
      final String fullMessage = String.format("[%s] must be less than or equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", value1Name, value2Name, value1Name, value1, value2Name, value2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void lessThanOrEqualTo(final int value1, final int value2, final String value1Name, final String value2Name){
    lessThanOrEqualTo(value1, value2, value1Name, value2Name, Strings.NOT_APPLICABLE);
  }

  public static <T> void notSame(final T t1, final T t2, final String t1Name, final String t2Name, final String detailMessage){
    if(t1 == t2){
      final String fullMessage = String.format("[%s] must not be same object as [%s] but was. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", t1Name, t2Name, t1Name, t1, t2Name, t2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static <T> void notSame(final T t1, final T t2, final String t1Name, final String t2Name){
    notSame(t1, t2, t1Name, t2Name, Strings.NOT_APPLICABLE);
  }

  public static <T> void isEqual(final T t1, final T t2, final String t1Name, final String t2Name, final String detailMessage){
    if(!Equals.areEqual(t1, t2)){
      final String fullMessage = String.format("[%s] must be equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", t1Name, t2Name, t1Name, t1, t2Name, t2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static <T> void isEqual(final T t1, final T t2, final String t1Name, final String t2Name){
    isEqual(t1, t2, t1Name, t2Name, Strings.NOT_APPLICABLE);
  }

  public static void isEqual(final int int1, final int int2, final String int1Name, final String int2Name, final String detailMessage){
    if(!Equals.areEqual(int1, int2)){
      final String fullMessage = String.format("[%s] must be equal to [%s] but was not. %n"
          + "[%s] had value [%s] and [%s] had value [%s]. %n"
          + "Details[%s]", int1Name, int2Name, int1Name, int1, int2Name, int2, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static <T> void isEqual(final int int1, final int int2, final String int1Name, final String int2Name){
    isEqual(int1, int2, int1Name, int2Name, Strings.NOT_APPLICABLE);
  }

  public static <T> void notNull(final T t, final String tName, final String detailMessage) {
    if(t == null){
      final String fullMessage = String.format("[%s] must not be null, but was. %n"
          + "Details[%s]", tName, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static <T> void notNull(final T t, final String tName) {
    notNull(t, tName, Strings.NOT_APPLICABLE);
  }

  public static <T> void nonNull(final T[] ts, final String tsName, final String detailMessage) {
    if(Arrays2.anyNull(ts)){
      final String fullMessage = String.format("[%s] must not be null, but was. %n"
          + "Details[%s]", tsName, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static <T> void nonNull(final T[] ts, final String tsName) {
    nonNull(ts, tsName, Strings.NOT_APPLICABLE);
  }

  public static void nonBlank(final String[] ts, final String tsName, final String detailMessage) {
    for (final String t : ts) {
      if (Strings.isBlank(t)) {
        final String fullMessage = String.format("[%s] [%s] must not contain any blanks, but did. %n"
            + "Details[%s]", tsName, Arrays.toString(ts), detailMessage);
        throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
      }
    }
  }

  public static void nonBlank(final String[] ts, final String tsName) {
    nonBlank(ts, tsName, Strings.NOT_APPLICABLE);
  }


  public static void arrayNotNullOrEmpty(final boolean[] array, final String arrayName) {
    if(Arrays2.length(array) == 0){
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, String.format("[%s] array must not be empty, but it was.", arrayName));
    }
  }

  public static void arrayNotNullOrEmpty(final int[] array, final String arrayName) {
    if(Arrays2.length(array) == 0){
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, String.format("[%s] array must not be empty, but it was.", arrayName));
    }
  }

  public static <T> void arrayNotNullOrEmpty(final T[] array, final String arrayName) {
    if(Arrays2.length(array) == 0){
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, String.format("[%s] array must not be empty, but it was.", arrayName));
    }
  }

  public static <T> void notEmpty(final Collection<T> collection, final String collectionName) {
    if(collection.size() <= 0){
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, String.format("[%s] collection must not be empty, but it was.", collectionName));
    }
  }

  public static void isFalse(final boolean condition, final String conditionName, final String detailMessage) {
    if (condition) {
      final String fullMessage = String.format("condition [%s] must be false, but was true. %n Details[%s]", conditionName, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void isFalse(final boolean condition, final String conditionName) {
    isFalse(condition, conditionName, Strings.NOT_APPLICABLE);
  }

  public static void isBetweenInclusive(final float value, final float lower, final float upper, final String valueName, final String lowerName, final String upperName, final String detailMessage) {
    if (value < lower || value > upper) {
      final String fullMessage = String.format("value [%s][%f] must be between [%s][%f] and [%s][%f] inclusive, but was not. %n Details[%s]",
          valueName, value, lowerName, lower, upperName, upper, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void isBetweenInclusive(final float value, final float lower, final float upper, final String valueName, final String lowerName, final String upperName) {
    isBetweenInclusive(value, lower, upper, valueName, lowerName, upperName, Strings.NOT_APPLICABLE);
  }

  public static void isBetweenInclusive(final double value, final double lower, final double upper, final String valueName, final String lowerName, final String upperName, final String detailMessage) {
    if (value < lower || value > upper) {
      final String fullMessage = String.format("value [%s][%f] must be between [%s][%f] and [%s][%f] inclusive, but was not. %n Details[%s]",
          valueName, value, lowerName, lower, upperName, upper, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);
    }
  }

  public static void isBetweenInclusive(final double value, final double lower, final double upper, final String valueName, final String lowerName, final String upperName) {
    isBetweenInclusive(value, lower, upper, valueName, lowerName, upperName, Strings.NOT_APPLICABLE);
  }

  public static void notBlank(final String s, final String sName, final String detailMessage) {
    if (Strings.isBlank(s)) {
      final String fullMessage = String.format("[%s][%s] must not be blank, but was. %n Details[%s]",
          sName, s, detailMessage);
      throw ApplicationException.create(CommonErrors.VALIDATION_ERROR, fullMessage);

    }
  }

  public static void notBlank(final String s, final String sName) {
    notBlank(s, sName, Strings.NOT_APPLICABLE);
  }
}
