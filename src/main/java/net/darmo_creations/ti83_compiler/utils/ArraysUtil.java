package net.darmo_creations.ti83_compiler.utils;

public class ArraysUtil {
  public static void print_r(Object[] array) {
    print_r(array, 0);
  }

  private static void print_r(Object[] array, int lvl) {
    String indent = "";

    for (int i = 0; i < lvl * 4; i++) {
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
        print_r((Object[]) o, lvl + 1);
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

  public static void arrayCopy(byte[] array1, byte[] array2, int start) {
    if (start < 0 || start > array2.length) {
      throw new ArrayIndexOutOfBoundsException(start);
    }

    for (int i = 0; i < array1.length && i + start < array2.length; i++) {
      array2[i + start] = array1[i];
    }
  }

  private ArraysUtil() {}
}
