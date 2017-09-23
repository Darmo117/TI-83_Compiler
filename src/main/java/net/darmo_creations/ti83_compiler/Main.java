package net.darmo_creations.ti83_compiler;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import net.darmo_creations.ti83_compiler.compilers.Compiler;
import net.darmo_creations.ti83_compiler.compilers.Decompiler;

public class Main {
  public static void main(String[] args) {
    List<String> argz = Arrays.asList(args);

    try {
      if (argz.size() == 1 && argz.get(0).equals("-h")) {
        printUsage(false);
      }
      else {
        if (!argz.contains("-f") || argz.indexOf("-f") == argz.size() - 1) {
          throw new IllegalArgumentException("No file specified!");
        }

        String file = argz.get(argz.indexOf("-f") + 1);
        boolean uncompile = argz.contains("-u");

        if (!uncompile) {
          boolean optimise = argz.contains("-O");
          boolean editable = !argz.contains("-L");
          new Compiler().compile(file, optimise, editable);
        }
        else {
          int index = argz.indexOf("-u") + 1;
          if (index > argz.size() - 1)
            throw new IllegalAccessException("Missing target language!");

          String lang = argz.get(index);
          new Decompiler().decompile(file, lang);
        }
      }
    }
    catch (IllegalArgumentException ex) {
      System.err.println(ex.getMessage());
      printUsage(true);
    }
    catch (Exception ex) {
      System.err.println(ex.getMessage());
    }
  }

  private static void printUsage(boolean error) {
    try (PrintStream out = error ? System.err : System.out) {
      out.println("Usage: -f <file> {[-OL]|-u <lang>}");
      out.println("       -h");
      out.println("Options:");
      out.println("  -f <file>");
      out.println("\tpath to the file to compile/uncompile");
      out.println("  -O");
      out.println("\toptimise compiled program");
      out.println("  -L");
      out.println("\tlock program editing from calculator");
      out.println("  -u <lang>");
      out.println("\tuncompile the program into the given language (e.g.: en, fr...)");
      out.println("  -h");
      out.println("\tshow usage");
    }
  }
}