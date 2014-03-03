package com.jags.javautils;


import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

  public static final String EMPTY_STRING = "";
  public static final String NOT_APPLICABLE = "N/A";
  public static final Charset UTF_8 = Charset.forName("UTF-8");

  private Strings(){}

  /**
   * @param s string to trim
   * @return null if null given, trimmed string otherwise
   */
  public static String trim(final String s){
    return s == null ? s : s.trim();
  }

  public static boolean isBlank(final String s){
    return s == null || s.length() == 0 || s.trim().length() == 0;
  }

  public static boolean isEmpty(final String s){
    return s == null || s.length() == 0;
  }

  public static boolean isAnyBlank(final String... ss) {
    Check.arrayNotNullOrEmpty(ss, "ss");

    for (String s : ss) {
      if (isBlank(s)) {
        return true;
      }
    }

    return false;
  }

  public static String join(final String separator, final String... ss) {
    if( length(separator) == 1 ){
      return join(separator.charAt(0), ss);
    }

    Check.notNull(separator, "separator");
    Check.arrayNotNullOrEmpty(ss, "ss");

    final StringBuilder result = new StringBuilder();
    for (String s : ss) {
      result.append(s).append(separator);
    }

    result.delete(result.length() - separator.length(), result.length());

    return result.toString();
  }

  public static String join(final char separator, final String... ss) {
    Check.arrayNotNullOrEmpty(ss, "ss");

    final StringBuilder result = new StringBuilder();
    for (String s : ss) {
      result.append(s).append(separator);
    }

    result.delete(result.length() - 1, result.length());

    return result.toString();
  }

  public static String concat(final String... ss) {
    Check.arrayNotNullOrEmpty(ss, "ss");

    final StringBuilder result = new StringBuilder();
    for (final String s : ss) {
      result.append(s == null ? EMPTY_STRING : s);
    }

    return result.toString();
  }

  public static int size(final String s){
    return s == null ? 0 : s.length();
  }

  public static int length(final String s){
    return size(s);
  }

  public static String withoutWhitespace(final String input){
    if(isEmpty(input)){
      return input;
    }

    StringBuilder builder = new StringBuilder();
    for(char c : input.toCharArray()){
      if(!Character.isWhitespace(c)){
        builder.append(c);
      }
    }

    return builder.toString();
  }


  public static boolean containsIgnoreCase(final String searched, final String searchedFor){
    Check.notNull(searched, "searched");
    Check.notNull(searchedFor, "searchedFor");

    return Pattern.compile(Pattern.quote(searchedFor), Pattern.CASE_INSENSITIVE).matcher(searched).find();
  }

  public static String reverse(final String toBeReversed){
    Check.notNull(toBeReversed, "toBeReversed");
    return new StringBuilder(toBeReversed).reverse().toString();
  }

  public static StringBuilder removeLast(final StringBuilder stringBuilder, final int charCountToRemove){
    Check.notNull(stringBuilder, "stringBuilder");
    Check.greaterThanOrEqualTo(stringBuilder.length(), charCountToRemove,
        "string builder length", "number of characters to remove");
    final int length = stringBuilder.length();

    return stringBuilder.delete(length - charCountToRemove, length);
  }

  public static <T> String toStringOrEmpty(final T t){
    return t == null ? EMPTY_STRING : toStringNonNull(t);
  }

  private static <T> String toStringNonNull(final T t){
    final String result;
    if(t.getClass().isArray()){
      result = Arrays.deepToString(Cast.to(t, Object[].class));
    } else {
      result = t.toString();
    }
    return result;
  }

  public static <T> String int2String(final int t){
    return String.valueOf(t);
  }

  public static <T> String toStringOr(final T t, final String valueIfNull){
    if(t == null){
      return valueIfNull;
    } else {
      return t.toString();
    }
  }

  public static String stars(final int count){
    return String.valueOf(Char.repeat('*', count));
  }

  public static List<String> regexSubstring(final String data, final String regexPattern) {
    final Pattern pattern = Pattern.compile(regexPattern);
    final Matcher matcher = pattern.matcher(data);
    final List<String> substrings = new LinkedList<String>();

    while (matcher.find()) {
      substrings.add(matcher.group(1));
    }
    return Collections.unmodifiableList(substrings);
  }
}
