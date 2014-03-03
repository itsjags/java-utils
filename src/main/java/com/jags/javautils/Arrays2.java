package com.jags.javautils;


import java.lang.reflect.Array;
import java.util.Arrays;


public class Arrays2 {
  private Arrays2() {
  }

  public static <T> int length(final T... ts) {
    return ts == null ? 0 : ts.length;
  }

  public static <T> int length(final boolean... booleans) {
    return booleans == null ? 0 : booleans.length;
  }

  public static <T> int length(final int... ints) {
    return ints == null ? 0 : ints.length;
  }

  public static <T> int length(final long... ints) {
    return ints == null ? 0 : ints.length;
  }

  public static <T> int length(final byte... bytes) {
    return bytes == null ? 0 : bytes.length;
  }

  public static <T> int length(final char... chars) {
    return chars == null ? 0 : chars.length;
  }

  public static <T> boolean isEmptyOrNull(final T... ts) {
    return ts == null || length(ts) == 0;
  }

  public static <T> boolean isEmptyOrNull(final long... ts) {
    return ts == null || length(ts) == 0;
  }

  public static boolean[] toPrimitives(final Boolean... wrappers) {
    if (wrappers == null) {
      return null;
    } else if (wrappers.length == 0) {
      return new boolean[0];
    } else {
      final boolean[] primitives = new boolean[wrappers.length];

      for (int i = 0; i < wrappers.length; i++) {
        Check.notNull(wrappers[i], "wrappers[" + i + "]", "cannot convert null to a boolean value");
        primitives[i] = wrappers[i];
      }

      return primitives;
    }
  }

  public static int[] toPrimitives(final Integer... wrappers) {
    if (wrappers == null) {
      return null;
    } else if (wrappers.length == 0) {
      return new int[0];
    } else {
      final int[] primitives = new int[wrappers.length];

      for (int i = 0; i < wrappers.length; i++) {
        primitives[i] = wrappers[i];
      }

      return primitives;
    }
  }

  public static long[] toPrimitives(final Long... wrappers) {
    if (wrappers == null) {
      return null;
    } else if (wrappers.length == 0) {
      return new long[0];
    } else {
      final long[] primitives = new long[wrappers.length];

      for (int i = 0; i < wrappers.length; i++) {
        primitives[i] = wrappers[i];
      }

      return primitives;
    }
  }

  public static byte[] toPrimitives(final Byte... wrappers) {
    if (wrappers == null) {
      return null;
    } else if (wrappers.length == 0) {
      return new byte[0];
    } else {
      final byte[] primitives = new byte[wrappers.length];

      for (int i = 0; i < wrappers.length; i++) {
        primitives[i] = wrappers[i];
      }

      return primitives;
    }
  }

  public static char[] toPrimitives(final Character... wrappers) {
    if (wrappers == null) {
      return null;
    } else if (wrappers.length == 0) {
      return new char[0];
    } else {
      final char[] primitives = new char[wrappers.length];

      for (int i = 0; i < wrappers.length; i++) {
        primitives[i] = wrappers[i];
      }

      return primitives;
    }
  }

  public static <T> boolean anyNull(final T... ts) {
    Check.notNull(ts, "ts", "cannot tell if any is null in a null array");
    Check.greaterThan(ts.length, 0, "ts.length", "Zero", "cannot tell if any is null in an empty array");

    boolean result = false;
    for (final T t : ts) {
      if (t == null) {
        result = true;
        break;
      }
    }
    return result;
  }

  /**
   * @deprecated Use Arrays2#arrayOf(T...)
   */
  public static <T> T[] of(T... ts) {
    return arrayOf(ts);
  }

  /**
   * Creates an array of a given type. Makes an array from the given types.
   * With better syntactic sugar than
   * when used with a static import for Arrays2.
   * e.g. String[] strArr = arrayOf("str1", "str2"); // Arrays2 static imported.
   */
  public static <T> T[] arrayOf(T... ts) {
    return ts;
  }

  public static <T> T[] emptyIfNull(T[] ts, Class<T[]> clazz) {
    return ts == null ? (T[]) Array.newInstance(clazz.getComponentType(), 0) : ts;
  }
}
