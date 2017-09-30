package net.darmo_creations.ti83_compiler.compilers;

import static org.junit.Assert.*;

import java.util.StringJoiner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.darmo_creations.ti83_compiler.GenerateTestCases;
import net.darmo_creations.ti83_compiler.exceptions.UnknownInstructionException;

public class SourceCodeParserTest {
  private static SourceCodeParser parser;

  @BeforeClass
  public static void setUpBeforeClass() {
    parser = new SourceCodeParser();
  }

  private String[] token;

  @Before
  public void setUp() {
    this.token = new String[1];
  }

  public static void displayBytes(byte[] bytes) {
    StringJoiner sj = new StringJoiner(", 0x", "[0x", "]");

    for (byte b : bytes)
      sj.add(GenerateTestCases.getByte(b));

    System.out.println(sj);
  }

  @Test
  public void testInstr0xBB5Afr() throws UnknownInstructionException {
    this.token[0] = "GraphBoitMoust";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x5A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB57fr() throws UnknownInstructionException {
    this.token[0] = "Efface entrées";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x57, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFFfr() throws UnknownInstructionException {
    this.token[0] = "RegLin(ax+b) ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Afr() throws UnknownInstructionException {
    this.token[0] = "ListesDéfaut ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFFen() throws UnknownInstructionException {
    this.token[0] = "LinReg(ax+b) ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF4en() throws UnknownInstructionException {
    this.token[0] = "LinReg(a+bx) ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB5Bfr() throws UnknownInstructionException {
    this.token[0] = "GraphProbNorm";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x5B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Efr() throws UnknownInstructionException {
    this.token[0] = "Gauss-Jordan(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB52fr() throws UnknownInstructionException {
    this.token[0] = "EffToutListes";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x52, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB67en() throws UnknownInstructionException {
    this.token[0] = "DiagnosticOff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x67, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB57en() throws UnknownInstructionException {
    this.token[0] = "Clear Entries";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x57, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x95fr() throws UnknownInstructionException {
    this.token[0] = ": Combinaison ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x95, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x94fr() throws UnknownInstructionException {
    this.token[0] = ": Arrangement ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x94, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB12fr() throws UnknownInstructionException {
    this.token[0] = "studentFRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Cfr() throws UnknownInstructionException {
    this.token[0] = "sous-Chaîne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB18fr() throws UnknownInstructionException {
    this.token[0] = "poissonFRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x15fr() throws UnknownInstructionException {
    this.token[0] = "permutLigne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x24fr() throws UnknownInstructionException {
    this.token[0] = "intégrFonct(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Bfr() throws UnknownInstructionException {
    this.token[0] = "ZOrthonormal";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF3fr() throws UnknownInstructionException {
    this.token[0] = "Stats 2-Var ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF2fr() throws UnknownInstructionException {
    this.token[0] = "Stats 1-Var ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Aen() throws UnknownInstructionException {
    this.token[0] = "SetUpEditor ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB34fr() throws UnknownInstructionException {
    this.token[0] = "RegLinTTest ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x34, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF4fr() throws UnknownInstructionException {
    this.token[0] = "RegLin(a+bx)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x99fr() throws UnknownInstructionException {
    this.token[0] = "RappelImage ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x99, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB5Ben() throws UnknownInstructionException {
    this.token[0] = "NormProbPlot";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x5B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB34en() throws UnknownInstructionException {
    this.token[0] = "LinRegTTest ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x34, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA6fr() throws UnknownInstructionException {
    this.token[0] = "Horizontale ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB11fr() throws UnknownInstructionException {
    this.token[0] = "FracNormale(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB66en() throws UnknownInstructionException {
    this.token[0] = "DiagnosticOn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x66, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF3en() throws UnknownInstructionException {
    this.token[0] = "2-Var Stats ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB47en() throws UnknownInstructionException {
    this.token[0] = "2-SampϜTest ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x47, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3Den() throws UnknownInstructionException {
    this.token[0] = "2-SampZTest(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB46en() throws UnknownInstructionException {
    this.token[0] = "2-SampTTest ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x46, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3F() throws UnknownInstructionException {
    this.token[0] = "2-PropZTest(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB47fr() throws UnknownInstructionException {
    this.token[0] = "2-CompϜTest ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x47, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3Dfr() throws UnknownInstructionException {
    this.token[0] = "2-CompZTest(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB46fr() throws UnknownInstructionException {
    this.token[0] = "2-CompTTest ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x46, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF2en() throws UnknownInstructionException {
    this.token[0] = "1-Var Stats ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3E() throws UnknownInstructionException {
    this.token[0] = "1-PropZTest(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0Efr() throws UnknownInstructionException {
    this.token[0] = "&transposée;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Cfr() throws UnknownInstructionException {
    this.token[0] = "studentFdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB17en() throws UnknownInstructionException {
    this.token[0] = "poissonpdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB18en() throws UnknownInstructionException {
    this.token[0] = "poissoncdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB17fr() throws UnknownInstructionException {
    this.token[0] = "poissonFdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB03fr() throws UnknownInstructionException {
    this.token[0] = "paSomPrinc(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB10fr() throws UnknownInstructionException {
    this.token[0] = "normalFRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Dfr() throws UnknownInstructionException {
    this.token[0] = "ecart-type(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631Cfr() throws UnknownInstructionException {
    this.token[0] = "ZPointDébut";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Afr() throws UnknownInstructionException {
    this.token[0] = "ValeursAuto";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB56en() throws UnknownInstructionException {
    this.token[0] = "String>Equ(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x56, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x98fr() throws UnknownInstructionException {
    this.token[0] = "SauveImage ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x98, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA3() throws UnknownInstructionException {
    this.token[0] = "Pxl-Change(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x91en() throws UnknownInstructionException {
    this.token[0] = "PrintScreen";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x91, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB39fr() throws UnknownInstructionException {
    this.token[0] = "Matr>liste(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x39, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB33fr() throws UnknownInstructionException {
    this.token[0] = "Logistique ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x33, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3Afr() throws UnknownInstructionException {
    this.token[0] = "Liste>matr(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA6en() throws UnknownInstructionException {
    this.token[0] = "Horizontal ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFCfr() throws UnknownInstructionException {
    this.token[0] = "Histogramme";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB45() throws UnknownInstructionException {
    this.token[0] = "GraphStyle(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x45, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB55en() throws UnknownInstructionException {
    this.token[0] = "Equ>String(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x55, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB55fr() throws UnknownInstructionException {
    this.token[0] = "Equ>Chaîne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x55, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB69fr() throws UnknownInstructionException {
    this.token[0] = "Désarchive ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x69, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB52en() throws UnknownInstructionException {
    this.token[0] = "ClrAllLists";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x52, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB56fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne>Equ(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x56, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Cfr() throws UnknownInstructionException {
    this.token[0] = "CalculsAuto";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB42en() throws UnknownInstructionException {
    this.token[0] = "2-SampZInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x42, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB49en() throws UnknownInstructionException {
    this.token[0] = "2-SampTInt ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x49, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB44() throws UnknownInstructionException {
    this.token[0] = "2-PropZInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x44, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB42fr() throws UnknownInstructionException {
    this.token[0] = "2-CompZInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x42, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB49fr() throws UnknownInstructionException {
    this.token[0] = "2-CompTInt ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x49, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB43() throws UnknownInstructionException {
    this.token[0] = "1-PropZInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x43, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0Een() throws UnknownInstructionException {
    this.token[0] = "&transpose;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Ben() throws UnknownInstructionException {
    this.token[0] = "normalpdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB10en() throws UnknownInstructionException {
    this.token[0] = "normalcdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Bfr() throws UnknownInstructionException {
    this.token[0] = "normalFdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Ffr() throws UnknownInstructionException {
    this.token[0] = "normAléat(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x25fr() throws UnknownInstructionException {
    this.token[0] = "nbreDériv(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Afr() throws UnknownInstructionException {
    this.token[0] = "géomtFRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB19en() throws UnknownInstructionException {
    this.token[0] = "geometpdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x19, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Aen() throws UnknownInstructionException {
    this.token[0] = "geometcdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xADfr() throws UnknownInstructionException {
    this.token[0] = "codeTouch(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Ffr() throws UnknownInstructionException {
    this.token[0] = "carChaîne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB16fr() throws UnknownInstructionException {
    this.token[0] = "binomFRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Dfr() throws UnknownInstructionException {
    this.token[0] = "ZPrécédent";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631Cen() throws UnknownInstructionException {
    this.token[0] = "ZPlotStart";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB41en() throws UnknownInstructionException {
    this.token[0] = "ZInterval ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x41, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Dfr() throws UnknownInstructionException {
    this.token[0] = "Verticale ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Bfr() throws UnknownInstructionException {
    this.token[0] = "ValeursDem";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB69en() throws UnknownInstructionException {
    this.token[0] = "UnArchive ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x69, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE4fr() throws UnknownInstructionException {
    this.token[0] = "TriDécroi(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB48en() throws UnknownInstructionException {
    this.token[0] = "TInterval ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x48, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E00fr() throws UnknownInstructionException {
    this.token[0] = "Séquentiel";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB35en() throws UnknownInstructionException {
    this.token[0] = "ShadeNorm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x35, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E00en() throws UnknownInstructionException {
    this.token[0] = "Sequential";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2Efr() throws UnknownInstructionException {
    this.token[0] = "RegCubique";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x99en() throws UnknownInstructionException {
    this.token[0] = "RecallPic ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x99, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Ben() throws UnknownInstructionException {
    this.token[0] = "RecallGDB ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Bfr() throws UnknownInstructionException {
    this.token[0] = "RappelBDG ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA0() throws UnknownInstructionException {
    this.token[0] = "Pt-Change(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631Bfr() throws UnknownInstructionException {
    this.token[0] = "PointDébut";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB35fr() throws UnknownInstructionException {
    this.token[0] = "OmbreNorm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x35, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB5Aen() throws UnknownInstructionException {
    this.token[0] = "ModBoxplot";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x5A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB39en() throws UnknownInstructionException {
    this.token[0] = "Matr>list(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x39, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3Aen() throws UnknownInstructionException {
    this.token[0] = "List>matr(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Aen() throws UnknownInstructionException {
    this.token[0] = "IndpntAuto";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEAfr() throws UnknownInstructionException {
    this.token[0] = "GraphNAff ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x97fr() throws UnknownInstructionException {
    this.token[0] = "FonctNAff ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x97, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA8fr() throws UnknownInstructionException {
    this.token[0] = "DessRecip ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA9fr() throws UnknownInstructionException {
    this.token[0] = "DessFonct ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Cen() throws UnknownInstructionException {
    this.token[0] = "DependAuto";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB67fr() throws UnknownInstructionException {
    this.token[0] = "CorrelNAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x67, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Dfr() throws UnknownInstructionException {
    this.token[0] = "CalculsDem";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0E() throws UnknownInstructionException {
    this.token[0] = "variance(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x22fr() throws UnknownInstructionException {
    this.token[0] = "résoudre(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Fen() throws UnknownInstructionException {
    this.token[0] = "randNorm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x13() throws UnknownInstructionException {
    this.token[0] = "pxl-Test(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x13, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x20fr() throws UnknownInstructionException {
    this.token[0] = "matAléat(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Bfr() throws UnknownInstructionException {
    this.token[0] = "longueur(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Fen() throws UnknownInstructionException {
    this.token[0] = "inString(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB4fr() throws UnknownInstructionException {
    this.token[0] = "identité(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB4en() throws UnknownInstructionException {
    this.token[0] = "identity(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB19fr() throws UnknownInstructionException {
    this.token[0] = "géomtFdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x19, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Afr() throws UnknownInstructionException {
    this.token[0] = "entAléat(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB15en() throws UnknownInstructionException {
    this.token[0] = "binompdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB16en() throws UnknownInstructionException {
    this.token[0] = "binomcdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB15fr() throws UnknownInstructionException {
    this.token[0] = "binomFdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB28fr() throws UnknownInstructionException {
    this.token[0] = "argument(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x86() throws UnknownInstructionException {
    this.token[0] = "ZStandard";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x86, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Den() throws UnknownInstructionException {
    this.token[0] = "ZPrevious";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6335en() throws UnknownInstructionException {
    this.token[0] = "ZPlotStep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x35, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB41fr() throws UnknownInstructionException {
    this.token[0] = "ZIntConf ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x41, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6335fr() throws UnknownInstructionException {
    this.token[0] = "ZGraphPas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x35, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Den() throws UnknownInstructionException {
    this.token[0] = "Vertical ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA7fr() throws UnknownInstructionException {
    this.token[0] = "Tangente(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB48fr() throws UnknownInstructionException {
    this.token[0] = "TIntConf ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x48, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x98en() throws UnknownInstructionException {
    this.token[0] = "StorePic ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x98, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Aen() throws UnknownInstructionException {
    this.token[0] = "StoreGDB ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Afr() throws UnknownInstructionException {
    this.token[0] = "SauveBDG ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2Ffr() throws UnknownInstructionException {
    this.token[0] = "RegQuatre";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA2fr() throws UnknownInstructionException {
    this.token[0] = "Pxl-NAff(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEAen() throws UnknownInstructionException {
    this.token[0] = "PlotsOff ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631Ben() throws UnknownInstructionException {
    this.token[0] = "PlotStart";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB33en() throws UnknownInstructionException {
    this.token[0] = "Logistic ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x33, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Ben() throws UnknownInstructionException {
    this.token[0] = "IndpntAsk";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFCen() throws UnknownInstructionException {
    this.token[0] = "Histogram";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE9fr() throws UnknownInstructionException {
    this.token[0] = "GraphAff ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x96fr() throws UnknownInstructionException {
    this.token[0] = "FonctAff ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x96, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632Afr() throws UnknownInstructionException {
    this.token[0] = "EntréeTbl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFAfr() throws UnknownInstructionException {
    this.token[0] = "EffListe ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x85fr() throws UnknownInstructionException {
    this.token[0] = "EffDessin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x85, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE5en() throws UnknownInstructionException {
    this.token[0] = "DispTable";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDFen() throws UnknownInstructionException {
    this.token[0] = "DispGraph";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Den() throws UnknownInstructionException {
    this.token[0] = "DependAsk";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB66fr() throws UnknownInstructionException {
    this.token[0] = "CorrelAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x66, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E03fr() throws UnknownInstructionException {
    this.token[0] = "CoordRect";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E05fr() throws UnknownInstructionException {
    this.token[0] = "CoordNAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E06en() throws UnknownInstructionException {
    this.token[0] = "Connected";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Bfr() throws UnknownInstructionException {
    this.token[0] = "BinAléat(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB40() throws UnknownInstructionException {
    this.token[0] = "χ²-Test(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x40, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB22fr() throws UnknownInstructionException {
    this.token[0] = "vat_Vact";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB24fr() throws UnknownInstructionException {
    this.token[0] = "vat_Vacq";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB00fr() throws UnknownInstructionException {
    this.token[0] = "vActNet(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x15en() throws UnknownInstructionException {
    this.token[0] = "rowSwap(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Aen() throws UnknownInstructionException {
    this.token[0] = "randInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Ben() throws UnknownInstructionException {
    this.token[0] = "randBin(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF1fr() throws UnknownInstructionException {
    this.token[0] = "racinex(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBDfr() throws UnknownInstructionException {
    this.token[0] = "racine3(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB1fr() throws UnknownInstructionException {
    this.token[0] = "partEnt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBAfr() throws UnknownInstructionException {
    this.token[0] = "partDéc(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB02fr() throws UnknownInstructionException {
    this.token[0] = "paSolde(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1Ffr() throws UnknownInstructionException {
    this.token[0] = "médiane(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x21fr() throws UnknownInstructionException {
    this.token[0] = "moyenne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB11en() throws UnknownInstructionException {
    this.token[0] = "invNorm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x14en() throws UnknownInstructionException {
    this.token[0] = "augment(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x12fr() throws UnknownInstructionException {
    this.token[0] = "arrondi(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6333() throws UnknownInstructionException {
    this.token[0] = "Zw(nMin)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x33, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6309() throws UnknownInstructionException {
    this.token[0] = "Zv(nMin)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6308() throws UnknownInstructionException {
    this.token[0] = "Zu(nMin)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8F() throws UnknownInstructionException {
    this.token[0] = "ZoomStat";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Aen() throws UnknownInstructionException {
    this.token[0] = "Zoom Out";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Cen() throws UnknownInstructionException {
    this.token[0] = "ZInteger";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Efr() throws UnknownInstructionException {
    this.token[0] = "ZDécimal";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Een() throws UnknownInstructionException {
    this.token[0] = "ZDecimal";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE3fr() throws UnknownInstructionException {
    this.token[0] = "Tricroi(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631Aen() throws UnknownInstructionException {
    this.token[0] = "TblStart";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632Aen() throws UnknownInstructionException {
    this.token[0] = "TblInput";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA7en() throws UnknownInstructionException {
    this.token[0] = "Tangent(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB37en() throws UnknownInstructionException {
    this.token[0] = "Shadeχ²(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x37, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB36en() throws UnknownInstructionException {
    this.token[0] = "Shade_t(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x36, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x92fr() throws UnknownInstructionException {
    this.token[0] = "SauveFen";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x92, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE2fr() throws UnknownInstructionException {
    this.token[0] = "Remplir(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF7fr() throws UnknownInstructionException {
    this.token[0] = "RegPuiss";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2Fen() throws UnknownInstructionException {
    this.token[0] = "QuartReg";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF9en() throws UnknownInstructionException {
    this.token[0] = "QuadReg ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Bfr() throws UnknownInstructionException {
    this.token[0] = "QuadNAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA2en() throws UnknownInstructionException {
    this.token[0] = "Pxl-Off(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA1fr() throws UnknownInstructionException {
    this.token[0] = "Pxl-Aff(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Ffr() throws UnknownInstructionException {
    this.token[0] = "Pt-NAff(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFDfr() throws UnknownInstructionException {
    this.token[0] = "Polygone";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE9en() throws UnknownInstructionException {
    this.token[0] = "PlotsOn ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6334en() throws UnknownInstructionException {
    this.token[0] = "PlotStep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x34, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x75fr() throws UnknownInstructionException {
    this.token[0] = "PleinEcr";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x75, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB37fr() throws UnknownInstructionException {
    this.token[0] = "Ombreχ²(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x37, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB36fr() throws UnknownInstructionException {
    this.token[0] = "Ombre_t(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x36, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E07fr() throws UnknownInstructionException {
    this.token[0] = "NonRelié";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xABfr() throws UnknownInstructionException {
    this.token[0] = "NbrAléat";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Den() throws UnknownInstructionException {
    this.token[0] = "LabelOff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6334fr() throws UnknownInstructionException {
    this.token[0] = "GraphPas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x34, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB53en() throws UnknownInstructionException {
    this.token[0] = "GetCalc(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x53, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x69fr() throws UnknownInstructionException {
    this.token[0] = "Flottant";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x69, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB51fr() throws UnknownInstructionException {
    this.token[0] = "ExprNAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x51, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Dfr() throws UnknownInstructionException {
    this.token[0] = "EtiqNAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFBfr() throws UnknownInstructionException {
    this.token[0] = "EffTable";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631Afr() throws UnknownInstructionException {
    this.token[0] = "DébutTbl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA8en() throws UnknownInstructionException {
    this.token[0] = "DrawInv ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2Een() throws UnknownInstructionException {
    this.token[0] = "CubicReg";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E02fr() throws UnknownInstructionException {
    this.token[0] = "CoordPol";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E05en() throws UnknownInstructionException {
    this.token[0] = "CoordOff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E04fr() throws UnknownInstructionException {
    this.token[0] = "CoordAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFBen() throws UnknownInstructionException {
    this.token[0] = "ClrTable";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFAen() throws UnknownInstructionException {
    this.token[0] = "ClrList ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB53fr() throws UnknownInstructionException {
    this.token[0] = "CaptVar(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x53, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E09fr() throws UnknownInstructionException {
    this.token[0] = "AxesNAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB6C() throws UnknownInstructionException {
    this.token[0] = "AsmPrgm ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x6C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB6B() throws UnknownInstructionException {
    this.token[0] = "AsmComp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x6B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCDen() throws UnknownInstructionException {
    this.token[0] = "Arctanh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC9en() throws UnknownInstructionException {
    this.token[0] = "Arcsinh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB68() throws UnknownInstructionException {
    this.token[0] = "Archive ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x68, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCBen() throws UnknownInstructionException {
    this.token[0] = "Arccosh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE5fr() throws UnknownInstructionException {
    this.token[0] = "AffTable";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDFfr() throws UnknownInstructionException {
    this.token[0] = "AffGraph";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB30fr() throws UnknownInstructionException {
    this.token[0] = ">Polaire";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x30, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x18fr() throws UnknownInstructionException {
    this.token[0] = "*ligne+(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622Een() throws UnknownInstructionException {
    this.token[0] = "&xmean2;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622Ben() throws UnknownInstructionException {
    this.token[0] = "&xmean1;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Fen() throws UnknownInstructionException {
    this.token[0] = "&square;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622A() throws UnknownInstructionException {
    this.token[0] = "&pcirc2;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6229() throws UnknownInstructionException {
    this.token[0] = "&pcirc1;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x29, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0Afr() throws UnknownInstructionException {
    this.token[0] = "&exposr;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0Aen() throws UnknownInstructionException {
    this.token[0] = "&exponr;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3Dfr() throws UnknownInstructionException {
    this.token[0] = ": ouExcl ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x3D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB13fr() throws UnknownInstructionException {
    this.token[0] = "χ²FRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x13, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Cfr() throws UnknownInstructionException {
    this.token[0] = "ΔListe(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6332() throws UnknownInstructionException {
    this.token[0] = "w(nMin)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x32, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB20fr() throws UnknownInstructionException {
    this.token[0] = "vat_Pmt";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6305() throws UnknownInstructionException {
    this.token[0] = "v(nMin)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6304() throws UnknownInstructionException {
    this.token[0] = "u(nMin)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB20en() throws UnknownInstructionException {
    this.token[0] = "tvm_Pmt";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB01fr() throws UnknownInstructionException {
    this.token[0] = "tauxRi(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Den() throws UnknownInstructionException {
    this.token[0] = "stdDev(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB29fr() throws UnknownInstructionException {
    this.token[0] = "somCum(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x29, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBCfr() throws UnknownInstructionException {
    this.token[0] = "racine(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x25en() throws UnknownInstructionException {
    this.token[0] = "nDeriv(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1Fen() throws UnknownInstructionException {
    this.token[0] = "median(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x16fr() throws UnknownInstructionException {
    this.token[0] = "ligne+(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Ben() throws UnknownInstructionException {
    this.token[0] = "length(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB29en() throws UnknownInstructionException {
    this.token[0] = "cumSum(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x29, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x14fr() throws UnknownInstructionException {
    this.token[0] = "chaîne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x92en() throws UnknownInstructionException {
    this.token[0] = "ZoomSto";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x92, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x90fr() throws UnknownInstructionException {
    this.token[0] = "ZoomRpl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x90, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x90en() throws UnknownInstructionException {
    this.token[0] = "ZoomRcl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x90, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB65en() throws UnknownInstructionException {
    this.token[0] = "ZoomFit";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x65, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x89en() throws UnknownInstructionException {
    this.token[0] = "Zoom In";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x89, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Ben() throws UnknownInstructionException {
    this.token[0] = "ZSquare";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB65fr() throws UnknownInstructionException {
    this.token[0] = "ZMinMax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x65, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Cfr() throws UnknownInstructionException {
    this.token[0] = "ZEntier";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3B() throws UnknownInstructionException {
    this.token[0] = "Z-Test(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB3C() throws UnknownInstructionException {
    this.token[0] = "T-Test ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x3C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB58fr() throws UnknownInstructionException {
    this.token[0] = "Sélect(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x58, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB32en() throws UnknownInstructionException {
    this.token[0] = "SinReg ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x32, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB38en() throws UnknownInstructionException {
    this.token[0] = "ShadeϜ(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x38, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB58en() throws UnknownInstructionException {
    this.token[0] = "Select(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x58, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFEen() throws UnknownInstructionException {
    this.token[0] = "Scatter";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD2() throws UnknownInstructionException {
    this.token[0] = "Repeat ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB32fr() throws UnknownInstructionException {
    this.token[0] = "RegSin ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x32, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF9fr() throws UnknownInstructionException {
    this.token[0] = "RegQuad";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF5fr() throws UnknownInstructionException {
    this.token[0] = "RegExp ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Afr() throws UnknownInstructionException {
    this.token[0] = "QuadAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA1en() throws UnknownInstructionException {
    this.token[0] = "Pxl-On(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF7en() throws UnknownInstructionException {
    this.token[0] = "PwrReg ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Fen() throws UnknownInstructionException {
    this.token[0] = "Pt-Off(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Efr() throws UnknownInstructionException {
    this.token[0] = "Pt-Aff(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDD() throws UnknownInstructionException {
    this.token[0] = "Prompt ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E02en() throws UnknownInstructionException {
    this.token[0] = "PolarGC";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x78fr() throws UnknownInstructionException {
    this.token[0] = "Polaire";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x78, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Bfr() throws UnknownInstructionException {
    this.token[0] = "Pmt_Fin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Ben() throws UnknownInstructionException {
    this.token[0] = "Pmt_End";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Cfr() throws UnknownInstructionException {
    this.token[0] = "Pmt_Déb";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Cen() throws UnknownInstructionException {
    this.token[0] = "Pmt_Bgn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE0() throws UnknownInstructionException {
    this.token[0] = "Output(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB38fr() throws UnknownInstructionException {
    this.token[0] = "OmbreϜ(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x38, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF8() throws UnknownInstructionException {
    this.token[0] = "Med-Med";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Cen() throws UnknownInstructionException {
    this.token[0] = "LabelOn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x91fr() throws UnknownInstructionException {
    this.token[0] = "ImprEcr";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x91, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Ben() throws UnknownInstructionException {
    this.token[0] = "GridOff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEEfr() throws UnknownInstructionException {
    this.token[0] = "Graph3(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEDfr() throws UnknownInstructionException {
    this.token[0] = "Graph2(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xED, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xECfr() throws UnknownInstructionException {
    this.token[0] = "Graph1(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB51en() throws UnknownInstructionException {
    this.token[0] = "ExprOff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x51, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB50fr() throws UnknownInstructionException {
    this.token[0] = "ExprAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x50, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF5en() throws UnknownInstructionException {
    this.token[0] = "ExpReg ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Cfr() throws UnknownInstructionException {
    this.token[0] = "EtiqAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB54fr() throws UnknownInstructionException {
    this.token[0] = "EffVar ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x54, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB54en() throws UnknownInstructionException {
    this.token[0] = "DelVar ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x54, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E04en() throws UnknownInstructionException {
    this.token[0] = "CoordOn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE1en() throws UnknownInstructionException {
    this.token[0] = "ClrHome";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x85en() throws UnknownInstructionException {
    this.token[0] = "ClrDraw";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x85, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA5en() throws UnknownInstructionException {
    this.token[0] = "Circle(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA08fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA07fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA06fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA05fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA04fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA03fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA02fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA01fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA00fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA09fr() throws UnknownInstructionException {
    this.token[0] = "Chaîne0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA5fr() throws UnknownInstructionException {
    this.token[0] = "Cercle(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x05en() throws UnknownInstructionException {
    this.token[0] = "BoxPlot";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E09en() throws UnknownInstructionException {
    this.token[0] = "AxesOff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E08fr() throws UnknownInstructionException {
    this.token[0] = "AxesAff";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC7() throws UnknownInstructionException {
    this.token[0] = "Arctan(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC3() throws UnknownInstructionException {
    this.token[0] = "Arcsin(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC5() throws UnknownInstructionException {
    this.token[0] = "Arccos(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x17fr() throws UnknownInstructionException {
    this.token[0] = "*ligne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620Cen() throws UnknownInstructionException {
    this.token[0] = "&ymean;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622Efr() throws UnknownInstructionException {
    this.token[0] = "&xmoy2;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622Bfr() throws UnknownInstructionException {
    this.token[0] = "&xmoy1;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6203en() throws UnknownInstructionException {
    this.token[0] = "&xmean;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6228() throws UnknownInstructionException {
    this.token[0] = "&pcirc;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x80en() throws UnknownInstructionException {
    this.token[0] = "&cross;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x80, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x80fr() throws UnknownInstructionException {
    this.token[0] = "&croix;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x80, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7Ffr() throws UnknownInstructionException {
    this.token[0] = "&carré;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB14fr() throws UnknownInstructionException {
    this.token[0] = "ϜFRép(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Den() throws UnknownInstructionException {
    this.token[0] = "χ²pdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB13en() throws UnknownInstructionException {
    this.token[0] = "χ²cdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x13, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Dfr() throws UnknownInstructionException {
    this.token[0] = "χ²Fdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Cen() throws UnknownInstructionException {
    this.token[0] = "ΔList(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFDen() throws UnknownInstructionException {
    this.token[0] = "xyLine";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x27fr() throws UnknownInstructionException {
    this.token[0] = "xfMin(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x28fr() throws UnknownInstructionException {
    this.token[0] = "xfMax(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E11() throws UnknownInstructionException {
    this.token[0] = "vwAxes";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB21fr() throws UnknownInstructionException {
    this.token[0] = "vat_I%";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E12() throws UnknownInstructionException {
    this.token[0] = "uwAxes";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E10() throws UnknownInstructionException {
    this.token[0] = "uvAxes";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB22en() throws UnknownInstructionException {
    this.token[0] = "tvm_PV";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB21en() throws UnknownInstructionException {
    this.token[0] = "tvm_I%";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB24en() throws UnknownInstructionException {
    this.token[0] = "tvm_FV";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x23fr() throws UnknownInstructionException {
    this.token[0] = "suite(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB6fr() throws UnknownInstructionException {
    this.token[0] = "somme(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x22en() throws UnknownInstructionException {
    this.token[0] = "solve(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x12en() throws UnknownInstructionException {
    this.token[0] = "round(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x20en() throws UnknownInstructionException {
    this.token[0] = "randM(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB04fr() throws UnknownInstructionException {
    this.token[0] = "paInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB9en() throws UnknownInstructionException {
    this.token[0] = "iPart(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xADen() throws UnknownInstructionException {
    this.token[0] = "getKey";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x24en() throws UnknownInstructionException {
    this.token[0] = "fnInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBAen() throws UnknownInstructionException {
    this.token[0] = "fPart(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB28en() throws UnknownInstructionException {
    this.token[0] = "angle(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6325en() throws UnknownInstructionException {
    this.token[0] = "Zθstep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x8Afr() throws UnknownInstructionException {
    this.token[0] = "Zoom -";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x8A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x89fr() throws UnknownInstructionException {
    this.token[0] = "Zoom +";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x89, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x88fr() throws UnknownInstructionException {
    this.token[0] = "Zboîte";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x88, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6324en() throws UnknownInstructionException {
    this.token[0] = "ZTstep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD1() throws UnknownInstructionException {
    this.token[0] = "While ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632Dfr() throws UnknownInstructionException {
    this.token[0] = "ValAct";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632Ffr() throws UnknownInstructionException {
    this.token[0] = "ValAcq";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x93fr() throws UnknownInstructionException {
    this.token[0] = "Texte(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x93, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE4en() throws UnknownInstructionException {
    this.token[0] = "SortD(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE3en() throws UnknownInstructionException {
    this.token[0] = "SortA(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA4en() throws UnknownInstructionException {
    this.token[0] = "Shade(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD5() throws UnknownInstructionException {
    this.token[0] = "Return";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF6fr() throws UnknownInstructionException {
    this.token[0] = "RegLn ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E03en() throws UnknownInstructionException {
    this.token[0] = "RectGC";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x64() throws UnknownInstructionException {
    this.token[0] = "Radian";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x64, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6331fr() throws UnknownInstructionException {
    this.token[0] = "Pér/An";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x31, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Een() throws UnknownInstructionException {
    this.token[0] = "Pt-On(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEEen() throws UnknownInstructionException {
    this.token[0] = "Plot3(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEDen() throws UnknownInstructionException {
    this.token[0] = "Plot2(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xED, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xECen() throws UnknownInstructionException {
    this.token[0] = "Plot1(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD8() throws UnknownInstructionException {
    this.token[0] = "Pause ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6321fr() throws UnknownInstructionException {
    this.token[0] = "PasTbl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA4fr() throws UnknownInstructionException {
    this.token[0] = "Ombre(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x66() throws UnknownInstructionException {
    this.token[0] = "Normal";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x66, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF6en() throws UnknownInstructionException {
    this.token[0] = "LnReg ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Cfr() throws UnknownInstructionException {
    this.token[0] = "Ligne(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDC() throws UnknownInstructionException {
    this.token[0] = "Input ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Aen() throws UnknownInstructionException {
    this.token[0] = "GridOn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Dfr() throws UnknownInstructionException {
    this.token[0] = "Gauss(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x97en() throws UnknownInstructionException {
    this.token[0] = "FnOff ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x97, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB50en() throws UnknownInstructionException {
    this.token[0] = "ExprOn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x50, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE7fr() throws UnknownInstructionException {
    this.token[0] = "Envoi(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE1fr() throws UnknownInstructionException {
    this.token[0] = "EffEcr";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6330fr() throws UnknownInstructionException {
    this.token[0] = "Ech/An";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x30, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xA9en() throws UnknownInstructionException {
    this.token[0] = "DrawF ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xA9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x65en() throws UnknownInstructionException {
    this.token[0] = "Degree";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x65, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E08en() throws UnknownInstructionException {
    this.token[0] = "AxesOn";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCDfr() throws UnknownInstructionException {
    this.token[0] = "Argth(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC9fr() throws UnknownInstructionException {
    this.token[0] = "Argsh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCBfr() throws UnknownInstructionException {
    this.token[0] = "Argch(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB59fr() throws UnknownInstructionException {
    this.token[0] = "ANUVA(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x59, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB59en() throws UnknownInstructionException {
    this.token[0] = "ANOVA(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x59, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB30en() throws UnknownInstructionException {
    this.token[0] = ">Polar";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x30, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x18en() throws UnknownInstructionException {
    this.token[0] = "*row+(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620Cfr() throws UnknownInstructionException {
    this.token[0] = "&ymoy;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6203fr() throws UnknownInstructionException {
    this.token[0] = "&xmoy;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Een() throws UnknownInstructionException {
    this.token[0] = "Ϝpdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB14en() throws UnknownInstructionException {
    this.token[0] = "Ϝcdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Efr() throws UnknownInstructionException {
    this.token[0] = "ϜFdp(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6323en() throws UnknownInstructionException {
    this.token[0] = "θstep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB03en() throws UnknownInstructionException {
    this.token[0] = "ΣPrn(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB04en() throws UnknownInstructionException {
    this.token[0] = "ΣInt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB23fr() throws UnknownInstructionException {
    this.token[0] = "vat_N";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6233en() throws UnknownInstructionException {
    this.token[0] = "upper";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x33, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB23en() throws UnknownInstructionException {
    this.token[0] = "tvm_N";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB1Cen() throws UnknownInstructionException {
    this.token[0] = "tpdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x1C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB12en() throws UnknownInstructionException {
    this.token[0] = "tcdf(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCCen() throws UnknownInstructionException {
    this.token[0] = "tanh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBCen() throws UnknownInstructionException {
    this.token[0] = "sqrt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC8en() throws UnknownInstructionException {
    this.token[0] = "sinh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB26fr() throws UnknownInstructionException {
    this.token[0] = "réel(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x26, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Een() throws UnknownInstructionException {
    this.token[0] = "rref(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x16en() throws UnknownInstructionException {
    this.token[0] = "row+(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB26en() throws UnknownInstructionException {
    this.token[0] = "real(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x26, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4E() throws UnknownInstructionException {
    this.token[0] = "re^θi";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB7() throws UnknownInstructionException {
    this.token[0] = "prod(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB08fr() throws UnknownInstructionException {
    this.token[0] = "ppcm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB09fr() throws UnknownInstructionException {
    this.token[0] = "pgcd(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x21en() throws UnknownInstructionException {
    this.token[0] = "mean(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6232en() throws UnknownInstructionException {
    this.token[0] = "lower";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x32, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB27() throws UnknownInstructionException {
    this.token[0] = "imag(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x27en() throws UnknownInstructionException {
    this.token[0] = "fMin(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x28en() throws UnknownInstructionException {
    this.token[0] = "fMax(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2A() throws UnknownInstructionException {
    this.token[0] = "expr(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCAen() throws UnknownInstructionException {
    this.token[0] = "cosh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB25() throws UnknownInstructionException {
    this.token[0] = "conj(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBDen() throws UnknownInstructionException {
    this.token[0] = "cbrt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6325fr() throws UnknownInstructionException {
    this.token[0] = "Zθpas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6316() throws UnknownInstructionException {
    this.token[0] = "Zθmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6317() throws UnknownInstructionException {
    this.token[0] = "Zθmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6320() throws UnknownInstructionException {
    this.token[0] = "ZnMin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631E() throws UnknownInstructionException {
    this.token[0] = "ZnMax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6301en() throws UnknownInstructionException {
    this.token[0] = "ZYscl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6301fr() throws UnknownInstructionException {
    this.token[0] = "ZYpas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6314() throws UnknownInstructionException {
    this.token[0] = "ZYmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6315() throws UnknownInstructionException {
    this.token[0] = "ZYmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6300en() throws UnknownInstructionException {
    this.token[0] = "ZXscl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6337() throws UnknownInstructionException {
    this.token[0] = "ZXres";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x37, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6300fr() throws UnknownInstructionException {
    this.token[0] = "ZXpas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6312() throws UnknownInstructionException {
    this.token[0] = "ZXmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6313() throws UnknownInstructionException {
    this.token[0] = "ZXmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x13, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x87() throws UnknownInstructionException {
    this.token[0] = "ZTrig";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x87, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6324fr() throws UnknownInstructionException {
    this.token[0] = "ZTpas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6318() throws UnknownInstructionException {
    this.token[0] = "ZTmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6319() throws UnknownInstructionException {
    this.token[0] = "ZTmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x19, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6303fr() throws UnknownInstructionException {
    this.token[0] = "Ygrad";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6329() throws UnknownInstructionException {
    this.token[0] = "YFact";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x29, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6302fr() throws UnknownInstructionException {
    this.token[0] = "Xgrad";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6328() throws UnknownInstructionException {
    this.token[0] = "XFact";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6322en() throws UnknownInstructionException {
    this.token[0] = "Tstep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x84() throws UnknownInstructionException {
    this.token[0] = "Trace";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x84, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Efr() throws UnknownInstructionException {
    this.token[0] = "Toile";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x93en() throws UnknownInstructionException {
    this.token[0] = "Text(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x93, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x79fr() throws UnknownInstructionException {
    this.token[0] = "Suite";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x79, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E01() throws UnknownInstructionException {
    this.token[0] = "Simul";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE7en() throws UnknownInstructionException {
    this.token[0] = "Send(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E06fr() throws UnknownInstructionException {
    this.token[0] = "Relié";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6201en() throws UnknownInstructionException {
    this.token[0] = "RegEq";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1C() throws UnknownInstructionException {
    this.token[0] = "R>Pθ(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1B() throws UnknownInstructionException {
    this.token[0] = "R>Pr(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x78en() throws UnknownInstructionException {
    this.token[0] = "Polar";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x78, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x77() throws UnknownInstructionException {
    this.token[0] = "Param";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x77, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1E() throws UnknownInstructionException {
    this.token[0] = "P>Ry(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1D() throws UnknownInstructionException {
    this.token[0] = "P>Rx(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xFEfr() throws UnknownInstructionException {
    this.token[0] = "Nuage";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xFE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE6() throws UnknownInstructionException {
    this.token[0] = "Menu(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x9Cen() throws UnknownInstructionException {
    this.token[0] = "Line(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x9C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x74() throws UnknownInstructionException {
    this.token[0] = "Horiz";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x74, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD7() throws UnknownInstructionException {
    this.token[0] = "Goto ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x76fr() throws UnknownInstructionException {
    this.token[0] = "Fonct";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x76, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x96en() throws UnknownInstructionException {
    this.token[0] = "FnOn ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x96, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x69en() throws UnknownInstructionException {
    this.token[0] = "Float";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x69, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x73fr() throws UnknownInstructionException {
    this.token[0] = "Fixe ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x73, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE2en() throws UnknownInstructionException {
    this.token[0] = "Fill(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6201fr() throws UnknownInstructionException {
    this.token[0] = "EqReg";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDE() throws UnknownInstructionException {
    this.token[0] = "Disp ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x65fr() throws UnknownInstructionException {
    this.token[0] = "Degré";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x65, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x05fr() throws UnknownInstructionException {
    this.token[0] = "Carré";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE8fr() throws UnknownInstructionException {
    this.token[0] = "Capt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2F() throws UnknownInstructionException {
    this.token[0] = ">Rect";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB05() throws UnknownInstructionException {
    this.token[0] = ">Nom(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x03() throws UnknownInstructionException {
    this.token[0] = ">Frac";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB06() throws UnknownInstructionException {
    this.token[0] = ">Eff(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x17en() throws UnknownInstructionException {
    this.token[0] = "*row(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3Den() throws UnknownInstructionException {
    this.token[0] = ": xor ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x3D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x94en() throws UnknownInstructionException {
    this.token[0] = ": nPr ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x94, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x95en() throws UnknownInstructionException {
    this.token[0] = ": nCr ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x95, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x40en() throws UnknownInstructionException {
    this.token[0] = ": and ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x40, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6323fr() throws UnknownInstructionException {
    this.token[0] = "θpas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6310() throws UnknownInstructionException {
    this.token[0] = "θmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6311() throws UnknownInstructionException {
    this.token[0] = "θmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6321en() throws UnknownInstructionException {
    this.token[0] = "ΔTbl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF1en() throws UnknownInstructionException {
    this.token[0] = "xrt(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC6() throws UnknownInstructionException {
    this.token[0] = "tan(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB6en() throws UnknownInstructionException {
    this.token[0] = "sum(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB0Cen() throws UnknownInstructionException {
    this.token[0] = "sub(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC2() throws UnknownInstructionException {
    this.token[0] = "sin(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x23en() throws UnknownInstructionException {
    this.token[0] = "seq(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB2Den() throws UnknownInstructionException {
    this.token[0] = "ref(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x2D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xABen() throws UnknownInstructionException {
    this.token[0] = "rand";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5F() throws UnknownInstructionException {
    this.token[0] = "prgm";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB00en() throws UnknownInstructionException {
    this.token[0] = "npv(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB8en() throws UnknownInstructionException {
    this.token[0] = "not(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB8fr() throws UnknownInstructionException {
    this.token[0] = "non(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631F() throws UnknownInstructionException {
    this.token[0] = "nMin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x631D() throws UnknownInstructionException {
    this.token[0] = "nMax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x1D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620A() throws UnknownInstructionException {
    this.token[0] = "minY";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6208() throws UnknownInstructionException {
    this.token[0] = "minX";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x1A() throws UnknownInstructionException {
    this.token[0] = "min(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x1A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620B() throws UnknownInstructionException {
    this.token[0] = "maxY";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6209() throws UnknownInstructionException {
    this.token[0] = "maxX";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x19() throws UnknownInstructionException {
    this.token[0] = "max(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x19, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC0() throws UnknownInstructionException {
    this.token[0] = "log(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB08en() throws UnknownInstructionException {
    this.token[0] = "lcm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB07fr() throws UnknownInstructionException {
    this.token[0] = "jed(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB01en() throws UnknownInstructionException {
    this.token[0] = "irr(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB1en() throws UnknownInstructionException {
    this.token[0] = "int(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB09en() throws UnknownInstructionException {
    this.token[0] = "gcd(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Ffr() throws UnknownInstructionException {
    this.token[0] = "f(n)";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB9fr() throws UnknownInstructionException {
    this.token[0] = "ent(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB3fr() throws UnknownInstructionException {
    this.token[0] = "dét(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB5() throws UnknownInstructionException {
    this.token[0] = "dim(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB3en() throws UnknownInstructionException {
    this.token[0] = "det(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB07en() throws UnknownInstructionException {
    this.token[0] = "dbd(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC4() throws UnknownInstructionException {
    this.token[0] = "cos(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB02en() throws UnknownInstructionException {
    this.token[0] = "bal(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB2() throws UnknownInstructionException {
    this.token[0] = "abs(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4F() throws UnknownInstructionException {
    this.token[0] = "a+bi";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x88en() throws UnknownInstructionException {
    this.token[0] = "ZBox";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x88, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6303en() throws UnknownInstructionException {
    this.token[0] = "Yscl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x630C() throws UnknownInstructionException {
    this.token[0] = "Ymin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x630D() throws UnknownInstructionException {
    this.token[0] = "Ymax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6302en() throws UnknownInstructionException {
    this.token[0] = "Xscl";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6336() throws UnknownInstructionException {
    this.token[0] = "Xres";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x36, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x630A() throws UnknownInstructionException {
    this.token[0] = "Xmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x0A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x630B() throws UnknownInstructionException {
    this.token[0] = "Xmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6322fr() throws UnknownInstructionException {
    this.token[0] = "Tpas";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x630E() throws UnknownInstructionException {
    this.token[0] = "Tmin";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x630F() throws UnknownInstructionException {
    this.token[0] = "Tmax";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Fen() throws UnknownInstructionException {
    this.token[0] = "Time";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCF() throws UnknownInstructionException {
    this.token[0] = "Then";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA08en() throws UnknownInstructionException {
    this.token[0] = "Str9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA07en() throws UnknownInstructionException {
    this.token[0] = "Str8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA06en() throws UnknownInstructionException {
    this.token[0] = "Str7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA05en() throws UnknownInstructionException {
    this.token[0] = "Str6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA04en() throws UnknownInstructionException {
    this.token[0] = "Str5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA03en() throws UnknownInstructionException {
    this.token[0] = "Str4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA02en() throws UnknownInstructionException {
    this.token[0] = "Str3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA01en() throws UnknownInstructionException {
    this.token[0] = "Str2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA00en() throws UnknownInstructionException {
    this.token[0] = "Str1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAA09en() throws UnknownInstructionException {
    this.token[0] = "Str0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD9() throws UnknownInstructionException {
    this.token[0] = "Stop";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Dfr() throws UnknownInstructionException {
    this.token[0] = "Réel";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB4Den() throws UnknownInstructionException {
    this.token[0] = "Real";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x4D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6008en() throws UnknownInstructionException {
    this.token[0] = "Pic9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6007en() throws UnknownInstructionException {
    this.token[0] = "Pic8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6006en() throws UnknownInstructionException {
    this.token[0] = "Pic7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6005en() throws UnknownInstructionException {
    this.token[0] = "Pic6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6004en() throws UnknownInstructionException {
    this.token[0] = "Pic5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6003en() throws UnknownInstructionException {
    this.token[0] = "Pic4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6002en() throws UnknownInstructionException {
    this.token[0] = "Pic3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6001en() throws UnknownInstructionException {
    this.token[0] = "Pic2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6000en() throws UnknownInstructionException {
    this.token[0] = "Pic1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6009en() throws UnknownInstructionException {
    this.token[0] = "Pic0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6327fr() throws UnknownInstructionException {
    this.token[0] = "PasY";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6326fr() throws UnknownInstructionException {
    this.token[0] = "PasX";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x26, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD6() throws UnknownInstructionException {
    this.token[0] = "Lbl ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6008fr() throws UnknownInstructionException {
    this.token[0] = "Img9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6007fr() throws UnknownInstructionException {
    this.token[0] = "Img8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6006fr() throws UnknownInstructionException {
    this.token[0] = "Img7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6005fr() throws UnknownInstructionException {
    this.token[0] = "Img6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6004fr() throws UnknownInstructionException {
    this.token[0] = "Img5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6003fr() throws UnknownInstructionException {
    this.token[0] = "Img4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6002fr() throws UnknownInstructionException {
    this.token[0] = "Img3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6001fr() throws UnknownInstructionException {
    this.token[0] = "Img2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6000fr() throws UnknownInstructionException {
    this.token[0] = "Img1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6009fr() throws UnknownInstructionException {
    this.token[0] = "Img0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x60, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDA() throws UnknownInstructionException {
    this.token[0] = "IS>(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xE8en() throws UnknownInstructionException {
    this.token[0] = "Get(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xE8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6108en() throws UnknownInstructionException {
    this.token[0] = "GDB9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6107en() throws UnknownInstructionException {
    this.token[0] = "GDB8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6106en() throws UnknownInstructionException {
    this.token[0] = "GDB7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6105en() throws UnknownInstructionException {
    this.token[0] = "GDB6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6104en() throws UnknownInstructionException {
    this.token[0] = "GDB5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6103en() throws UnknownInstructionException {
    this.token[0] = "GDB4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6102en() throws UnknownInstructionException {
    this.token[0] = "GDB3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6101en() throws UnknownInstructionException {
    this.token[0] = "GDB2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6100en() throws UnknownInstructionException {
    this.token[0] = "GDB1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6109en() throws UnknownInstructionException {
    this.token[0] = "GDB0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x76en() throws UnknownInstructionException {
    this.token[0] = "Func";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x76, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x75en() throws UnknownInstructionException {
    this.token[0] = "Full";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x75, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD3() throws UnknownInstructionException {
    this.token[0] = "For(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x73en() throws UnknownInstructionException {
    this.token[0] = "Fix ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x73, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD0() throws UnknownInstructionException {
    this.token[0] = "Else";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xDB() throws UnknownInstructionException {
    this.token[0] = "DS<(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xDB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6108fr() throws UnknownInstructionException {
    this.token[0] = "BDG9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6107fr() throws UnknownInstructionException {
    this.token[0] = "BDG8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6106fr() throws UnknownInstructionException {
    this.token[0] = "BDG7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6105fr() throws UnknownInstructionException {
    this.token[0] = "BDG6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6104fr() throws UnknownInstructionException {
    this.token[0] = "BDG5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6103fr() throws UnknownInstructionException {
    this.token[0] = "BDG4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6102fr() throws UnknownInstructionException {
    this.token[0] = "BDG3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6101fr() throws UnknownInstructionException {
    this.token[0] = "BDG2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6100fr() throws UnknownInstructionException {
    this.token[0] = "BDG1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6109fr() throws UnknownInstructionException {
    this.token[0] = "BDG0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x61, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB6A() throws UnknownInstructionException {
    this.token[0] = "Asm(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x6A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x02() throws UnknownInstructionException {
    this.token[0] = ">Dec";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x01() throws UnknownInstructionException {
    this.token[0] = ">DMS";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC1() throws UnknownInstructionException {
    this.token[0] = "10^(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3Cfr() throws UnknownInstructionException {
    this.token[0] = ": ou ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x3C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3Cen() throws UnknownInstructionException {
    this.token[0] = ": or ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x3C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x40fr() throws UnknownInstructionException {
    this.token[0] = ": et ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x40, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620E() throws UnknownInstructionException {
    this.token[0] = "Σy²";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6205() throws UnknownInstructionException {
    this.token[0] = "Σx²";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6211() throws UnknownInstructionException {
    this.token[0] = "Σxy";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCCfr() throws UnknownInstructionException {
    this.token[0] = "th(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6233fr() throws UnknownInstructionException {
    this.token[0] = "sup";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x33, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xC8fr() throws UnknownInstructionException {
    this.token[0] = "sh(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xC8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBE() throws UnknownInstructionException {
    this.token[0] = "ln(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6232fr() throws UnknownInstructionException {
    this.token[0] = "inf";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x32, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBF() throws UnknownInstructionException {
    this.token[0] = "e^(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCAfr() throws UnknownInstructionException {
    this.token[0] = "ch(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C09() throws UnknownInstructionException {
    this.token[0] = "[J]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C08() throws UnknownInstructionException {
    this.token[0] = "[I]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C07() throws UnknownInstructionException {
    this.token[0] = "[H]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C06() throws UnknownInstructionException {
    this.token[0] = "[G]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C05() throws UnknownInstructionException {
    this.token[0] = "[F]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C04() throws UnknownInstructionException {
    this.token[0] = "[E]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C03() throws UnknownInstructionException {
    this.token[0] = "[D]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C02() throws UnknownInstructionException {
    this.token[0] = "[C]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C01() throws UnknownInstructionException {
    this.token[0] = "[B]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5C00() throws UnknownInstructionException {
    this.token[0] = "[A]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5C, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E2B() throws UnknownInstructionException {
    this.token[0] = "Y6T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E29() throws UnknownInstructionException {
    this.token[0] = "Y5T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x29, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E27() throws UnknownInstructionException {
    this.token[0] = "Y4T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E25() throws UnknownInstructionException {
    this.token[0] = "Y3T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E23() throws UnknownInstructionException {
    this.token[0] = "Y2T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E21() throws UnknownInstructionException {
    this.token[0] = "Y1T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E2A() throws UnknownInstructionException {
    this.token[0] = "X6T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x2A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E28() throws UnknownInstructionException {
    this.token[0] = "X5T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x28, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E26() throws UnknownInstructionException {
    this.token[0] = "X4T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x26, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E24() throws UnknownInstructionException {
    this.token[0] = "X3T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E22() throws UnknownInstructionException {
    this.token[0] = "X2T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E20() throws UnknownInstructionException {
    this.token[0] = "X1T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E0Een() throws UnknownInstructionException {
    this.token[0] = "Web";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x0E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6231() throws UnknownInstructionException {
    this.token[0] = "Sxp";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x31, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622F() throws UnknownInstructionException {
    this.token[0] = "Sx2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622C() throws UnknownInstructionException {
    this.token[0] = "Sx1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x79en() throws UnknownInstructionException {
    this.token[0] = "Seq";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x79, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x67() throws UnknownInstructionException {
    this.token[0] = "Sci";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x67, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x72fr() throws UnknownInstructionException {
    this.token[0] = "Rep";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x72, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632E() throws UnknownInstructionException {
    this.token[0] = "PMT";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6330en() throws UnknownInstructionException {
    this.token[0] = "P/Y";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x30, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6213() throws UnknownInstructionException {
    this.token[0] = "Med";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x13, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x68fr() throws UnknownInstructionException {
    this.token[0] = "Ing";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x68, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xCE() throws UnknownInstructionException {
    this.token[0] = "If ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xCE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB64() throws UnknownInstructionException {
    this.token[0] = "G-T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x64, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x68en() throws UnknownInstructionException {
    this.token[0] = "Eng";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x68, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xD4() throws UnknownInstructionException {
    this.token[0] = "End";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xD4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x7E07en() throws UnknownInstructionException {
    this.token[0] = "Dot";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x7E, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6331en() throws UnknownInstructionException {
    this.token[0] = "C/Y";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x31, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x72en() throws UnknownInstructionException {
    this.token[0] = "Ans";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x72, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632B() throws UnknownInstructionException {
    this.token[0] = "&N;";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBD() throws UnknownInstructionException {
    this.token[0] = "∛(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBC() throws UnknownInstructionException {
    this.token[0] = "√(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0C() throws UnknownInstructionException {
    this.token[0] = "⁻¹";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6225() throws UnknownInstructionException {
    this.token[0] = "χ²";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x25, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6210() throws UnknownInstructionException {
    this.token[0] = "σy";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6207() throws UnknownInstructionException {
    this.token[0] = "σx";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620D() throws UnknownInstructionException {
    this.token[0] = "Σy";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6204() throws UnknownInstructionException {
    this.token[0] = "Σx";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6327en() throws UnknownInstructionException {
    this.token[0] = "ΔY";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6326en() throws UnknownInstructionException {
    this.token[0] = "ΔX";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x26, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6220() throws UnknownInstructionException {
    this.token[0] = "y3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x20, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x621F() throws UnknownInstructionException {
    this.token[0] = "y2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x1F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x621E() throws UnknownInstructionException {
    this.token[0] = "y1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x1E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x621D() throws UnknownInstructionException {
    this.token[0] = "x3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x1D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x621C() throws UnknownInstructionException {
    this.token[0] = "x2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x1C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x621B() throws UnknownInstructionException {
    this.token[0] = "x1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x1B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6235() throws UnknownInstructionException {
    this.token[0] = "r²";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x35, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E45() throws UnknownInstructionException {
    this.token[0] = "r6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x45, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E44() throws UnknownInstructionException {
    this.token[0] = "r5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x44, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E43() throws UnknownInstructionException {
    this.token[0] = "r4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x43, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E42() throws UnknownInstructionException {
    this.token[0] = "r3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x42, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E41() throws UnknownInstructionException {
    this.token[0] = "r2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x41, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E40() throws UnknownInstructionException {
    this.token[0] = "r1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x40, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6221() throws UnknownInstructionException {
    this.token[0] = "n_";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x21, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6230() throws UnknownInstructionException {
    this.token[0] = "n2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x30, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x622D() throws UnknownInstructionException {
    this.token[0] = "n1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x2D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2C() throws UnknownInstructionException {
    this.token[0] = "i_";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB31() throws UnknownInstructionException {
    this.token[0] = "e_";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x31, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6227() throws UnknownInstructionException {
    this.token[0] = "df";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x27, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6223() throws UnknownInstructionException {
    this.token[0] = "_z";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x23, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E82() throws UnknownInstructionException {
    this.token[0] = "_w";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x82, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E81() throws UnknownInstructionException {
    this.token[0] = "_v";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x81, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E80() throws UnknownInstructionException {
    this.token[0] = "_u";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x80, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6224() throws UnknownInstructionException {
    this.token[0] = "_t";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x24, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6234() throws UnknownInstructionException {
    this.token[0] = "_s";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x34, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6212() throws UnknownInstructionException {
    this.token[0] = "_r";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6222() throws UnknownInstructionException {
    this.token[0] = "_p";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x22, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6202() throws UnknownInstructionException {
    this.token[0] = "_n";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x621A() throws UnknownInstructionException {
    this.token[0] = "_e";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x1A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6219() throws UnknownInstructionException {
    this.token[0] = "_d";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x19, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6218() throws UnknownInstructionException {
    this.token[0] = "_c";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6217() throws UnknownInstructionException {
    this.token[0] = "_b";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6216() throws UnknownInstructionException {
    this.token[0] = "_a";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xB0() throws UnknownInstructionException {
    this.token[0] = "_-";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xB0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E18() throws UnknownInstructionException {
    this.token[0] = "Y9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x18, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E17() throws UnknownInstructionException {
    this.token[0] = "Y8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x17, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E16() throws UnknownInstructionException {
    this.token[0] = "Y7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x16, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E15() throws UnknownInstructionException {
    this.token[0] = "Y6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E14() throws UnknownInstructionException {
    this.token[0] = "Y5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E13() throws UnknownInstructionException {
    this.token[0] = "Y4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x13, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E12() throws UnknownInstructionException {
    this.token[0] = "Y3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x12, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E11() throws UnknownInstructionException {
    this.token[0] = "Y2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E10() throws UnknownInstructionException {
    this.token[0] = "Y1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5E19() throws UnknownInstructionException {
    this.token[0] = "Y0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5E, (byte) 0x19, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x620F() throws UnknownInstructionException {
    this.token[0] = "Sy";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6206() throws UnknownInstructionException {
    this.token[0] = "Sx";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6236() throws UnknownInstructionException {
    this.token[0] = "R²";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x36, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6215() throws UnknownInstructionException {
    this.token[0] = "Q3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x15, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6214() throws UnknownInstructionException {
    this.token[0] = "Q1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x14, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632Den() throws UnknownInstructionException {
    this.token[0] = "PV";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5D05() throws UnknownInstructionException {
    this.token[0] = "L6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5D, (byte) 0x05, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5D04() throws UnknownInstructionException {
    this.token[0] = "L5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5D, (byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5D03() throws UnknownInstructionException {
    this.token[0] = "L4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5D, (byte) 0x03, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5D02() throws UnknownInstructionException {
    this.token[0] = "L3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5D, (byte) 0x02, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5D01() throws UnknownInstructionException {
    this.token[0] = "L2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5D, (byte) 0x01, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5D00() throws UnknownInstructionException {
    this.token[0] = "L1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5D, (byte) 0x00, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632C() throws UnknownInstructionException {
    this.token[0] = "I%";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x632Fen() throws UnknownInstructionException {
    this.token[0] = "FV";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x63, (byte) 0x2F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6E() throws UnknownInstructionException {
    this.token[0] = ">=";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x6E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6D() throws UnknownInstructionException {
    this.token[0] = "<=";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x6D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x04() throws UnknownInstructionException {
    this.token[0] = "->";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x04, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6F() throws UnknownInstructionException {
    this.token[0] = "!=";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x6F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3B() throws UnknownInstructionException {
    this.token[0] = "ᴇ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6226() throws UnknownInstructionException {
    this.token[0] = "Ϝ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x62, (byte) 0x26, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBAB() throws UnknownInstructionException {
    this.token[0] = "φ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xAB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBCC() throws UnknownInstructionException {
    this.token[0] = "τ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xCC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBCB() throws UnknownInstructionException {
    this.token[0] = "σ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xCB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA8() throws UnknownInstructionException {
    this.token[0] = "ρ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAC() throws UnknownInstructionException {
    this.token[0] = "π";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA6_1() throws UnknownInstructionException {
    this.token[0] = "μ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA5() throws UnknownInstructionException {
    this.token[0] = "λ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5B() throws UnknownInstructionException {
    this.token[0] = "θ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA4() throws UnknownInstructionException {
    this.token[0] = "ε";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA3() throws UnknownInstructionException {
    this.token[0] = "δ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA0() throws UnknownInstructionException {
    this.token[0] = "β";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB9F() throws UnknownInstructionException {
    this.token[0] = "α";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x9F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBAC() throws UnknownInstructionException {
    this.token[0] = "Ω";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xAC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA9() throws UnknownInstructionException {
    this.token[0] = "Σ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA2() throws UnknownInstructionException {
    this.token[0] = "Δ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xEB() throws UnknownInstructionException {
    this.token[0] = "ʟ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xEB, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB95() throws UnknownInstructionException {
    this.token[0] = "ü";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x95, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB94() throws UnknownInstructionException {
    this.token[0] = "û";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x94, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB92() throws UnknownInstructionException {
    this.token[0] = "ú";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x92, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB93() throws UnknownInstructionException {
    this.token[0] = "ù";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x93, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB8D() throws UnknownInstructionException {
    this.token[0] = "ö";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x8D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB8C() throws UnknownInstructionException {
    this.token[0] = "ô";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x8C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB8A() throws UnknownInstructionException {
    this.token[0] = "ó";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x8A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB8B() throws UnknownInstructionException {
    this.token[0] = "ò";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x8B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB99() throws UnknownInstructionException {
    this.token[0] = "ñ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x99, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB85() throws UnknownInstructionException {
    this.token[0] = "ï";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x85, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB84() throws UnknownInstructionException {
    this.token[0] = "î";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x84, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB82() throws UnknownInstructionException {
    this.token[0] = "í";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x82, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB83() throws UnknownInstructionException {
    this.token[0] = "ì";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x83, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB7D() throws UnknownInstructionException {
    this.token[0] = "ë";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x7D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB7C() throws UnknownInstructionException {
    this.token[0] = "ê";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x7C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB7A() throws UnknownInstructionException {
    this.token[0] = "é";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x7A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB7B() throws UnknownInstructionException {
    this.token[0] = "è";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x7B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB97() throws UnknownInstructionException {
    this.token[0] = "ç";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x97, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB75() throws UnknownInstructionException {
    this.token[0] = "ä";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x75, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB74() throws UnknownInstructionException {
    this.token[0] = "â";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x74, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB72() throws UnknownInstructionException {
    this.token[0] = "á";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x72, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB73() throws UnknownInstructionException {
    this.token[0] = "à";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x73, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB91() throws UnknownInstructionException {
    this.token[0] = "Ü";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x91, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB90() throws UnknownInstructionException {
    this.token[0] = "Û";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x90, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB8E() throws UnknownInstructionException {
    this.token[0] = "Ú";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x8E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB8F() throws UnknownInstructionException {
    this.token[0] = "Ù";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x8F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB89() throws UnknownInstructionException {
    this.token[0] = "Ö";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x89, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB88() throws UnknownInstructionException {
    this.token[0] = "Ô";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x88, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB86() throws UnknownInstructionException {
    this.token[0] = "Ó";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x86, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB87() throws UnknownInstructionException {
    this.token[0] = "Ò";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x87, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB98() throws UnknownInstructionException {
    this.token[0] = "Ñ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x98, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB81() throws UnknownInstructionException {
    this.token[0] = "Ï";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x81, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB80() throws UnknownInstructionException {
    this.token[0] = "Î";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x80, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBCD() throws UnknownInstructionException {
    this.token[0] = "Í";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xCD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB7F() throws UnknownInstructionException {
    this.token[0] = "Ì";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x7F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB79() throws UnknownInstructionException {
    this.token[0] = "Ë";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x79, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB78() throws UnknownInstructionException {
    this.token[0] = "Ê";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x78, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB76() throws UnknownInstructionException {
    this.token[0] = "É";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x76, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB77() throws UnknownInstructionException {
    this.token[0] = "È";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x77, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB96() throws UnknownInstructionException {
    this.token[0] = "Ç";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x96, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB71() throws UnknownInstructionException {
    this.token[0] = "Ä";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x71, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB70() throws UnknownInstructionException {
    this.token[0] = "Â";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x70, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB6E() throws UnknownInstructionException {
    this.token[0] = "Á";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x6E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB6F() throws UnknownInstructionException {
    this.token[0] = "À";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x6F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB9D() throws UnknownInstructionException {
    this.token[0] = "¿";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x9D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x81() throws UnknownInstructionException {
    this.token[0] = "·";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x81, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBA6_2() throws UnknownInstructionException {
    this.token[0] = "µ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xA6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0F() throws UnknownInstructionException {
    this.token[0] = "³";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0D() throws UnknownInstructionException {
    this.token[0] = "²";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x0B() throws UnknownInstructionException {
    this.token[0] = "°";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x0B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBB9E() throws UnknownInstructionException {
    this.token[0] = "¡";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0x9E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x09() throws UnknownInstructionException {
    this.token[0] = "}";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x09, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x08() throws UnknownInstructionException {
    this.token[0] = "{";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x08, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBCA() throws UnknownInstructionException {
    this.token[0] = "z";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xCA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC9() throws UnknownInstructionException {
    this.token[0] = "y";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC8() throws UnknownInstructionException {
    this.token[0] = "x";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC7() throws UnknownInstructionException {
    this.token[0] = "w";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC6() throws UnknownInstructionException {
    this.token[0] = "v";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC5() throws UnknownInstructionException {
    this.token[0] = "u";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC4() throws UnknownInstructionException {
    this.token[0] = "t";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC3() throws UnknownInstructionException {
    this.token[0] = "s";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC2() throws UnknownInstructionException {
    this.token[0] = "r";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC1() throws UnknownInstructionException {
    this.token[0] = "q";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBC0() throws UnknownInstructionException {
    this.token[0] = "p";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xC0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBBF() throws UnknownInstructionException {
    this.token[0] = "o";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xBF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBBE() throws UnknownInstructionException {
    this.token[0] = "n";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xBE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBBD() throws UnknownInstructionException {
    this.token[0] = "m";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xBD, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBBC() throws UnknownInstructionException {
    this.token[0] = "l";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xBC, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBBA() throws UnknownInstructionException {
    this.token[0] = "k";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xBA, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB9() throws UnknownInstructionException {
    this.token[0] = "j";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB9, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB8() throws UnknownInstructionException {
    this.token[0] = "i";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB8, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB7() throws UnknownInstructionException {
    this.token[0] = "h";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB7, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB6() throws UnknownInstructionException {
    this.token[0] = "g";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB6, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB5() throws UnknownInstructionException {
    this.token[0] = "f";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB5, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB4() throws UnknownInstructionException {
    this.token[0] = "e";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB4, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB3() throws UnknownInstructionException {
    this.token[0] = "d";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB3, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB2() throws UnknownInstructionException {
    this.token[0] = "c";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB2, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB1() throws UnknownInstructionException {
    this.token[0] = "b";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB1, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xBBB0() throws UnknownInstructionException {
    this.token[0] = "a";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xBB, (byte) 0xB0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xF0() throws UnknownInstructionException {
    this.token[0] = "^";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xF0, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x07() throws UnknownInstructionException {
    this.token[0] = "]";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x07, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x06() throws UnknownInstructionException {
    this.token[0] = "[";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x06, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x5A() throws UnknownInstructionException {
    this.token[0] = "Z";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x5A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x59() throws UnknownInstructionException {
    this.token[0] = "Y";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x59, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x58() throws UnknownInstructionException {
    this.token[0] = "X";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x58, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x57() throws UnknownInstructionException {
    this.token[0] = "W";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x57, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x56() throws UnknownInstructionException {
    this.token[0] = "V";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x56, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x55() throws UnknownInstructionException {
    this.token[0] = "U";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x55, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x54() throws UnknownInstructionException {
    this.token[0] = "T";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x54, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x53() throws UnknownInstructionException {
    this.token[0] = "S";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x53, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x52() throws UnknownInstructionException {
    this.token[0] = "R";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x52, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x51() throws UnknownInstructionException {
    this.token[0] = "Q";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x51, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x50() throws UnknownInstructionException {
    this.token[0] = "P";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x50, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x4F() throws UnknownInstructionException {
    this.token[0] = "O";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x4F, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x4E() throws UnknownInstructionException {
    this.token[0] = "N";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x4E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x4D() throws UnknownInstructionException {
    this.token[0] = "M";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x4D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x4C() throws UnknownInstructionException {
    this.token[0] = "L";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x4C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x4B() throws UnknownInstructionException {
    this.token[0] = "K";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x4B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x4A() throws UnknownInstructionException {
    this.token[0] = "J";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x4A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x49() throws UnknownInstructionException {
    this.token[0] = "I";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x49, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x48() throws UnknownInstructionException {
    this.token[0] = "H";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x48, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x47() throws UnknownInstructionException {
    this.token[0] = "G";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x47, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x46() throws UnknownInstructionException {
    this.token[0] = "F";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x46, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x45() throws UnknownInstructionException {
    this.token[0] = "E";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x45, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x44() throws UnknownInstructionException {
    this.token[0] = "D";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x44, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x43() throws UnknownInstructionException {
    this.token[0] = "C";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x43, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x42() throws UnknownInstructionException {
    this.token[0] = "B";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x42, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x41() throws UnknownInstructionException {
    this.token[0] = "A";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x41, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAF() throws UnknownInstructionException {
    this.token[0] = "?";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAF, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6C() throws UnknownInstructionException {
    this.token[0] = ">";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x6C, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6A() throws UnknownInstructionException {
    this.token[0] = "=";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x6A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x6B() throws UnknownInstructionException {
    this.token[0] = "<";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x6B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3E() throws UnknownInstructionException {
    this.token[0] = ":";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x39() throws UnknownInstructionException {
    this.token[0] = "9";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x39, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x38() throws UnknownInstructionException {
    this.token[0] = "8";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x38, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x37() throws UnknownInstructionException {
    this.token[0] = "7";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x37, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x36() throws UnknownInstructionException {
    this.token[0] = "6";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x36, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x35() throws UnknownInstructionException {
    this.token[0] = "5";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x35, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x34() throws UnknownInstructionException {
    this.token[0] = "4";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x34, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x33() throws UnknownInstructionException {
    this.token[0] = "3";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x33, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x32() throws UnknownInstructionException {
    this.token[0] = "2";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x32, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x31() throws UnknownInstructionException {
    this.token[0] = "1";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x31, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x30() throws UnknownInstructionException {
    this.token[0] = "0";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x30, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x83() throws UnknownInstructionException {
    this.token[0] = "/";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x83, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x3A() throws UnknownInstructionException {
    this.token[0] = ".";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x71() throws UnknownInstructionException {
    this.token[0] = "-";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x71, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2B() throws UnknownInstructionException {
    this.token[0] = ",";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2B, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x70() throws UnknownInstructionException {
    this.token[0] = "+";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x70, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x82() throws UnknownInstructionException {
    this.token[0] = "*";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x82, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x11() throws UnknownInstructionException {
    this.token[0] = ")";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x11, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x10() throws UnknownInstructionException {
    this.token[0] = "(";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x10, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0xAE() throws UnknownInstructionException {
    this.token[0] = "'";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0xAE, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2A() throws UnknownInstructionException {
    this.token[0] = "\"";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2A, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x2D() throws UnknownInstructionException {
    this.token[0] = "!";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x2D, (byte) 0x3F}, bytes);
  }

  @Test
  public void testInstr0x29() throws UnknownInstructionException {
    this.token[0] = ": ";
    byte[] bytes = parser.parse(this.token, false);
    assertArrayEquals(new byte[]{(byte) 0x3E, (byte) 0x29, (byte) 0x3F}, bytes);
  }
}
