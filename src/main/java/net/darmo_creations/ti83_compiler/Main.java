package net.darmo_creations.ti83_compiler;

import net.darmo_creations.ti83_compiler.compiler.Compiler;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "ti83_compiler", version = Compiler.VERSION, mixinStandardHelpOptions = true,
    description = "Compiles/Decompiles TI-83 program files.")
public class Main implements Callable<Integer> {
  @Parameters(index = "0", description = "The file to compile/decompile.")
  private String file;

  /**
   * Main options group. Needed to make both subgroups mutually exclusive.
   */
  @ArgGroup
  private Groups options;

  /**
   * Options of each subgroup are not mutually exclusive in their respective group.
   */
  private static class Groups {
    @ArgGroup(exclusive = false, heading = "Compiling options%n")
    CompilingOptionsGroup compilingOptions;

    @ArgGroup(exclusive = false, heading = "Decompiling options%n")
    DecompilingOptionsGroup decompilingOptions;
  }

  /**
   * Compiling options.
   */
  private static class CompilingOptionsGroup {
    @SuppressWarnings("unused") // Not actually used in the code but necessary to create the command line option
    @Option(names = {"-c", "--compile"}, required = true,
        description = "Compile the file. The language to use is given by the file’s extension.")
    boolean compile;

    @Option(names = {"-o", "--optimize"}, description = "Try to optimize the compiled code.")
    boolean optimize;

    @Option(names = {"-L", "--lock"}, description = "Disable edition of the compiled program from calculators.")
    boolean lock;
  }

  /**
   * Decompiling options.
   */
  private static class DecompilingOptionsGroup {
    @Option(names = {"-d", "--decompile"}, required = true,
        description = "Decompile the file.")
    boolean decompile;

    @Option(names = {"-l", "--lang", "--language"}, arity = "1", paramLabel = "language", required = true,
        description = "The language to use for the generated sources.")
    String langCode;

    @Option(names = {"-i", "--ident"}, arity = "1", paramLabel = "amount", defaultValue = "2",
        description = "Number of spaces to use for a single line indent (default: 2).")
    int indent;
  }

  @Override
  public Integer call() {
    System.out.printf("** TI-83 Compiler/Decompiler v%s **%n", Compiler.VERSION);
    try {
      if (this.options.decompilingOptions.decompile) {
        Compiler.decompile(this.file, this.options.decompilingOptions.langCode, this.options.decompilingOptions.indent);
      } else {
        Compiler.compile(this.file, this.options.compilingOptions.optimize, !this.options.compilingOptions.lock);
      }
    } catch (Exception ex) {
      System.err.println(ex.getMessage());
      return 1;
    }
    return 0;
  }

  public static void main(String... args) {
    int exitCode = new CommandLine(new Main()).execute(args);
    System.exit(exitCode);
  }
}
