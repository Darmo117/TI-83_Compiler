package net.darmo_creations.ti83_compiler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;

import net.darmo_creations.ti83_compiler.compilers.Tokens;

public class GenerateTestCases {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    try (PrintWriter ps = new PrintWriter("./tests.java", "UTF-8")) {
      Tokens.TOKENS.forEach(t -> {
        StringJoiner bytes = new StringJoiner("");
        for (byte b : t.getBytes())
          bytes.add(getByte(b));
        String lang = t.getLanguage() != null ? t.getLanguage() : "";
        String instr = t.getInstruction();

        if (instr.equals("\""))
          instr = "\\\"";

        ps.format("\n\n  @Test\n  public void testInstr0x%s%s() throws UnknownInstructionException {\n", bytes, lang);
        ps.format("    token[0] = \"%s\";\n", instr);
        ps.format("    byte[] bytes = parser.parse(token, false);\n");
        bytes = new StringJoiner(", (byte) 0x", "(byte) 0x", "");
        for (byte b : t.getBytes())
          bytes.add(getByte(b));
        bytes.add(getByte(Tokens.LINE_END.getBytes()[0]));
        ps.format("    assertArrayEquals(new byte[]{%s}, bytes);\n", bytes);
        ps.format("  }");
      });
    }
    System.out.println("Done.");
  }

  public static String getByte(byte b) {
    String b1 = Integer.toHexString(b < 0 ? b + 256 : b).toUpperCase();
    return String.format("%2s", b1).replace(' ', '0');
  }
}
