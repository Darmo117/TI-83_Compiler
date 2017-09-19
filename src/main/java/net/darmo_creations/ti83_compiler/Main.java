package net.darmo_creations.ti83_compiler;

import net.darmo_creations.ti83_compiler.compilers.Compiler;
import net.darmo_creations.ti83_compiler.compilers.Decompiler;

public class Main {
  public static void main(String[] args) {
    // args = new String[1];
    // args[0] = "C:\\Users\\Darmo\\Darmo\\Programmation\\Calculatrice\\MyTIData\\Backups\\TI83
    // Plus\\Programmes\\GTEST.ti83fr"; //*/
    // args = new String[3];
    // args[0] =
    // "C:\\Users\\Darmo\\Desktop\\Untitled1.8xp";//"C:\\Users\\Darmo\\Darmo\\Programmation\\Calculatrice\\MyTIData\\Backups\\TI83
    // Plus\\Programmes\\GTEST.8xp";
    // args[1] = "-u";
    // args[2] = "en";

    try {
      switch (args.length) {
        case 0:
          throw new IllegalArgumentException("No file specified.");
        case 1:
          Compiler.compile(args[0]);
          break;
        case 3:
          String lang;

          if (args[1].equals("-u")) {
            lang = args[2];
          }
          else {
            throw new IllegalArgumentException("Unknown option " + args[1] + ".");
          }

          Decompiler.decompile(args[0], lang);
          break;
        default:
          throw new IllegalArgumentException("Malformed command.");
      }
    }
    catch (Exception ex) {
      Throwable cause = ex.getCause();

      System.err.println(ex.getClass().getSimpleName() + ": " + ex.getMessage());
      if (cause != null) {
        System.err.println(
            "Caused by: " + cause.getClass().getSimpleName() + (cause.getMessage() != null ? ": " + cause.getMessage() : ""));
      }
    }
  }
}