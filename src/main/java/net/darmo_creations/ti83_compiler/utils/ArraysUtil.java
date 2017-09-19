package net.darmo_creations.ti83_compiler.utils;

public final class ArraysUtil {
  /**
   * Prints an array recursively.
   * 
   * @param array the array
   */
  public static void print_r(Object[] array) {
    print_r(array, 0);
  }

  /**
   * Prints an array recursively.
   */
  private static void print_r(Object[] array, int recursionLevel) {
    String indent = "";

    for (int i = 0; i < recursionLevel * 4; i++) {
      indent += " ";
    }

    if (array == null) {
      System.out.println(indent + "null");
      return;
    }

    System.out.println(array.getClass().getSimpleName() + " {");
    for (int i = 0; i < array.length; i++) {
      Object o = array[i];

      System.out.print(indent + "    [" + i + "] => ");
      if (o instanceof Object[]) {
        print_r((Object[]) o, recursionLevel + 1);
      }
      else {
        if (o == null) {
          System.out.println("null");
        }
        else {
          String className = o.getClass().getSimpleName();

          System.out.println(className + ": " + (className.equals("String") ? "\"" + o + "\"" : o));
        }
      }
    }
    System.out.println(indent + "}");
  }

  /**
   * Copies a string to a byte array.
   * 
   * @param ascii the ascii string
   * @param array the destination array
   * @param start array's start index
   * @param maxLength output max length
   */
  public static void stringCopy(String ascii, byte[] array, int start, int maxLength) {
    maxLength = Math.abs(maxLength);
    if (start < 0 || start >= array.length) {
      throw new ArrayIndexOutOfBoundsException(start);
    }
    if (start + maxLength > array.length) {
      throw new ArrayIndexOutOfBoundsException(start + maxLength);
    }

    for (int i = 0; i < maxLength; i++) {
      array[i + start] = (i < ascii.length()) ? (byte) ascii.charAt(i) : 0x00;
    }
  }

  /**
   * Copies an array into another.
   * 
   * @param array1 source array
   * @param array2 destination array
   * @param start start index in the destination array
   */
  public static void arrayCopy(byte[] array1, byte[] array2, int start) {
    if (start < 0 || start > array2.length)
      throw new ArrayIndexOutOfBoundsException(start);

    for (int i = 0; i < array1.length && i + start < array2.length; i++) {
      array2[i + start] = array1[i];
    }
  }

  private ArraysUtil() {}
}
