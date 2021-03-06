package net.darmo_creations.ti83_compiler.compilers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * This class lists all tokens in several languages.
 *
 * @author Damien Vergnet
 */
public final class Tokens {
  /** A map containing the regexes for the special characters codes. */
  public static final Map<String, String> TAGS_REGEXES;
  /** A list containing all tokens. */
  public static final List<Token> TOKENS;

  public static final Token LINE_END = new Token("\n", (byte) 0x3F);

  static {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("list|liste", "ʟ");
    map.put("expon|expos", "ᴇ");
    map.put("alpha", "α");
    map.put("beta|bêta", "β");
    map.put("Delta", "Δ");
    map.put("delta", "δ");
    map.put("epsilon", "ε");
    map.put("theta|thêta", "θ");
    map.put("lambda", "λ");
    map.put("mu", "μ");
    map.put("pi", "π");
    map.put("rho|rhô", "ρ");
    map.put("Sigma", "Σ");
    map.put("sigma", "σ");
    map.put("tau", "τ");
    map.put("phi", "φ");
    map.put("chi", "χ");
    map.put("Omega|Oméga", "Ω");
    map.put("digamma|F", "Ϝ");
    map.put("point|dot", "·");
    TAGS_REGEXES = Collections.unmodifiableMap(map);

    List<Token> tokens = new ArrayList<>();
    tokens.add(new Token(">DMS", (byte) 0x01));
    tokens.add(new Token(">Dec", (byte) 0x02));
    tokens.add(new Token(">Frac", (byte) 0x03));
    tokens.add(new Token("->", (byte) 0x04));
    tokens.add(new Token("BoxPlot", "en", (byte) 0x05));
    tokens.add(new Token("Carré", "fr", (byte) 0x05));
    tokens.add(new Token("[", (byte) 0x06));
    tokens.add(new Token("]", (byte) 0x07));
    tokens.add(new Token("{", (byte) 0x08));
    tokens.add(new Token("}", (byte) 0x09));
    tokens.add(new Token("&exponr;", "en", (byte) 0x0A));
    tokens.add(new Token("&exposr;", "fr", (byte) 0x0A));
    tokens.add(new Token("°", (byte) 0x0B));
    tokens.add(new Token("⁻¹", (byte) 0x0C));
    tokens.add(new Token("²", (byte) 0x0D));
    tokens.add(new Token("&transpose;", "en", (byte) 0x0E));
    tokens.add(new Token("&transposée;", "fr", (byte) 0x0E));
    tokens.add(new Token("³", (byte) 0x0F));
    tokens.add(new Token("(", (byte) 0x10));
    tokens.add(new Token(")", (byte) 0x11));
    tokens.add(new Token("round(", "en", (byte) 0x12));
    tokens.add(new Token("arrondi(", "fr", (byte) 0x12));
    tokens.add(new Token("pxl-Test(", (byte) 0x13));
    tokens.add(new Token("augment(", "en", (byte) 0x14));
    tokens.add(new Token("chaîne(", "fr", (byte) 0x14));
    tokens.add(new Token("rowSwap(", "en", (byte) 0x15));
    tokens.add(new Token("permutLigne(", "fr", (byte) 0x15));
    tokens.add(new Token("row+(", "en", (byte) 0x16));
    tokens.add(new Token("ligne+(", "fr", (byte) 0x16));
    tokens.add(new Token("*row(", "en", (byte) 0x17));
    tokens.add(new Token("*ligne(", "fr", (byte) 0x17));
    tokens.add(new Token("*row+(", "en", (byte) 0x18));
    tokens.add(new Token("*ligne+(", "fr", (byte) 0x18));
    tokens.add(new Token("max(", (byte) 0x19));
    tokens.add(new Token("min(", (byte) 0x1A));
    tokens.add(new Token("R>Pr(", (byte) 0x1B));
    tokens.add(new Token("R>Pθ(", (byte) 0x1C));
    tokens.add(new Token("P>Rx(", (byte) 0x1D));
    tokens.add(new Token("P>Ry(", (byte) 0x1E));
    tokens.add(new Token("median(", "en", (byte) 0x1F));
    tokens.add(new Token("médiane(", "fr", (byte) 0x1F));
    tokens.add(new Token("randM(", "en", (byte) 0x20));
    tokens.add(new Token("matAléat(", "fr", (byte) 0x20));
    tokens.add(new Token("mean(", "en", (byte) 0x21));
    tokens.add(new Token("moyenne(", "fr", (byte) 0x21));
    tokens.add(new Token("solve(", "en", (byte) 0x22));
    tokens.add(new Token("résoudre(", "fr", (byte) 0x22));
    tokens.add(new Token("seq(", "en", (byte) 0x23));
    tokens.add(new Token("suite(", "fr", (byte) 0x23));
    tokens.add(new Token("fnInt(", "en", (byte) 0x24));
    tokens.add(new Token("intégrFonct(", "fr", (byte) 0x24));
    tokens.add(new Token("nDeriv(", "en", (byte) 0x25));
    tokens.add(new Token("nbreDériv(", "fr", (byte) 0x25));
    tokens.add(new Token("fMin(", "en", (byte) 0x27));
    tokens.add(new Token("xfMin(", "fr", (byte) 0x27));
    tokens.add(new Token("fMax(", "en", (byte) 0x28));
    tokens.add(new Token("xfMax(", "fr", (byte) 0x28));
    tokens.add(new Token(" ", (byte) 0x29));
    tokens.add(new Token("\"", (byte) 0x2A));
    tokens.add(new Token(",", (byte) 0x2B));
    tokens.add(new Token("i_", (byte) 0x2C));
    tokens.add(new Token("!", (byte) 0x2D));
    tokens.add(new Token("CubicReg", "en", (byte) 0x2E));
    tokens.add(new Token("RegCubique", "fr", (byte) 0x2E));
    tokens.add(new Token("QuartReg", "en", (byte) 0x2F));
    tokens.add(new Token("RegQuatre", "fr", (byte) 0x2F));
    for (int i = 0; i < 10; i++) {
      tokens.add(new Token("" + i, (byte) (0x30 + i)));
    }
    tokens.add(new Token(".", (byte) 0x3A));
    tokens.add(new Token("ᴇ", (byte) 0x3B));
    tokens.add(new Token(" or ", "en", (byte) 0x3C));
    tokens.add(new Token(" ou ", "fr", (byte) 0x3C));
    tokens.add(new Token(" xor ", "en", (byte) 0x3D));
    tokens.add(new Token(" ouExcl ", "fr", (byte) 0x3D));
    tokens.add(new Token(":", (byte) 0x3E));
    tokens.add(new Token(" and ", "en", (byte) 0x40));
    tokens.add(new Token(" et ", "fr", (byte) 0x40));
    for (int i = 0; i < 26; i++) {
      tokens.add(new Token("" + (char) ('A' + i), (byte) (0x41 + i)));
    }
    tokens.add(new Token("θ", (byte) 0x5B));
    for (int i = 0; i < 10; i++) {
      tokens.add(new Token("[" + (char) ('A' + i) + "]", (byte) 0x5C, (byte) i));
    }
    for (int i = 0; i < 6; i++) {
      tokens.add(new Token("L" + (i + 1), (byte) 0x5D, (byte) (0x00 + i)));
    }
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token("Y" + (i + 1), (byte) 0x5E, (byte) (0x10 + i)));
    }
    tokens.add(new Token("Y0", (byte) 0x5E, (byte) 0x19));
    int j = 0;
    for (int i = 0; i < 12; i++) {
      if (i % 2 == 0) {
        j++;
        tokens.add(new Token("X" + j + "T", (byte) 0x5E, (byte) (0x20 + i)));
      }
      else {
        tokens.add(new Token("Y" + j + "T", (byte) 0x5E, (byte) (0x20 + i)));
      }
    }
    for (int i = 0; i < 6; i++) {
      tokens.add(new Token("r" + (i + 1), (byte) 0x5E, (byte) (0x40 + i)));
    }
    tokens.add(new Token("_u", (byte) 0x5E, (byte) 0x80));
    tokens.add(new Token("_v", (byte) 0x5E, (byte) 0x81));
    tokens.add(new Token("_w", (byte) 0x5E, (byte) 0x82));
    tokens.add(new Token("prgm", (byte) 0x5F));
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token("Pic" + (i + 1), "en", (byte) 0x60, (byte) (0x00 + i)));
      tokens.add(new Token("Img" + (i + 1), "fr", (byte) 0x60, (byte) (0x00 + i)));
    }
    tokens.add(new Token("Pic0", "en", (byte) 0x60, (byte) 0x09));
    tokens.add(new Token("Img0", "fr", (byte) 0x60, (byte) 0x09));
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token("GDB" + (i + 1), "en", (byte) 0x61, (byte) (0x00 + i)));
      tokens.add(new Token("BDG" + (i + 1), "fr", (byte) 0x61, (byte) (0x00 + i)));
    }
    tokens.add(new Token("GDB0", "en", (byte) 0x61, (byte) 0x09));
    tokens.add(new Token("BDG0", "fr", (byte) 0x61, (byte) 0x09));
    tokens.add(new Token("RegEq", "en", (byte) 0x62, (byte) 0x01));
    tokens.add(new Token("EqReg", "fr", (byte) 0x62, (byte) 0x01));
    tokens.add(new Token("_n", (byte) 0x62, (byte) 0x02));
    tokens.add(new Token("&xmean;", "en", (byte) 0x62, (byte) 0x03));
    tokens.add(new Token("&xmoy;", "fr", (byte) 0x62, (byte) 0x03));
    tokens.add(new Token("Σx²", (byte) 0x62, (byte) 0x05));
    tokens.add(new Token("Σx", (byte) 0x62, (byte) 0x04));
    tokens.add(new Token("Sx", (byte) 0x62, (byte) 0x06));
    tokens.add(new Token("σx", (byte) 0x62, (byte) 0x07));
    tokens.add(new Token("minX", (byte) 0x62, (byte) 0x08));
    tokens.add(new Token("maxX", (byte) 0x62, (byte) 0x09));
    tokens.add(new Token("minY", (byte) 0x62, (byte) 0x0A));
    tokens.add(new Token("maxY", (byte) 0x62, (byte) 0x0B));
    tokens.add(new Token("&ymean;", "en", (byte) 0x62, (byte) 0x0C));
    tokens.add(new Token("&ymoy;", "fr", (byte) 0x62, (byte) 0x0C));
    tokens.add(new Token("Σy²", (byte) 0x62, (byte) 0x0E));
    tokens.add(new Token("Σy", (byte) 0x62, (byte) 0x0D));
    tokens.add(new Token("Sy", (byte) 0x62, (byte) 0x0F));
    tokens.add(new Token("σy", (byte) 0x62, (byte) 0x10));
    tokens.add(new Token("Σxy", (byte) 0x62, (byte) 0x11));
    tokens.add(new Token("_r", (byte) 0x62, (byte) 0x12));
    tokens.add(new Token("Med", (byte) 0x62, (byte) 0x13));
    tokens.add(new Token("Q1", (byte) 0x62, (byte) 0x14));
    tokens.add(new Token("Q3", (byte) 0x62, (byte) 0x15));
    for (int i = 0; i < 5; i++) {
      tokens.add(new Token("_" + (char) ('a' + i), (byte) 0x62, (byte) (0x16 + i)));
    }
    for (int i = 0; i < 3; i++) {
      tokens.add(new Token("x" + (i + 1), (byte) 0x62, (byte) (0x1B + i)));
      tokens.add(new Token("y" + (i + 1), (byte) 0x62, (byte) (0x1E + i)));
    }
    tokens.add(new Token("n_", (byte) 0x62, (byte) 0x21));
    tokens.add(new Token("_p", (byte) 0x62, (byte) 0x22));
    tokens.add(new Token("_z", (byte) 0x62, (byte) 0x23));
    tokens.add(new Token("_t", (byte) 0x62, (byte) 0x24));
    tokens.add(new Token("χ²", (byte) 0x62, (byte) 0x25));
    tokens.add(new Token("Ϝ", (byte) 0x62, (byte) 0x26));
    tokens.add(new Token("df", (byte) 0x62, (byte) 0x27));
    tokens.add(new Token("&pcirc;", (byte) 0x62, (byte) 0x28));
    tokens.add(new Token("&pcirc1;", (byte) 0x62, (byte) 0x29));
    tokens.add(new Token("&pcirc2;", (byte) 0x62, (byte) 0x2A));
    tokens.add(new Token("&xmean1;", "en", (byte) 0x62, (byte) 0x2B));
    tokens.add(new Token("&xmoy1;", "fr", (byte) 0x62, (byte) 0x2B));
    tokens.add(new Token("Sx1", (byte) 0x62, (byte) 0x2C));
    tokens.add(new Token("n1", (byte) 0x62, (byte) 0x2D));
    tokens.add(new Token("&xmean2;", "en", (byte) 0x62, (byte) 0x2E));
    tokens.add(new Token("&xmoy2;", "fr", (byte) 0x62, (byte) 0x2E));
    tokens.add(new Token("Sx2", (byte) 0x62, (byte) 0x2F));
    tokens.add(new Token("n2", (byte) 0x62, (byte) 0x30));
    tokens.add(new Token("Sxp", (byte) 0x62, (byte) 0x31));
    tokens.add(new Token("lower", "en", (byte) 0x62, (byte) 0x32));
    tokens.add(new Token("inf", "fr", (byte) 0x62, (byte) 0x32));
    tokens.add(new Token("upper", "en", (byte) 0x62, (byte) 0x33));
    tokens.add(new Token("sup", "fr", (byte) 0x62, (byte) 0x33));
    tokens.add(new Token("_s", (byte) 0x62, (byte) 0x34));
    tokens.add(new Token("r²", (byte) 0x62, (byte) 0x35));
    tokens.add(new Token("R²", (byte) 0x62, (byte) 0x36));
    tokens.add(new Token("ZXscl", "en", (byte) 0x63, (byte) 0x00));
    tokens.add(new Token("ZXpas", "fr", (byte) 0x63, (byte) 0x00));
    tokens.add(new Token("ZYscl", "en", (byte) 0x63, (byte) 0x01));
    tokens.add(new Token("ZYpas", "fr", (byte) 0x63, (byte) 0x01));
    tokens.add(new Token("Xscl", "en", (byte) 0x63, (byte) 0x02));
    tokens.add(new Token("Xgrad", "fr", (byte) 0x63, (byte) 0x02));
    tokens.add(new Token("Yscl", "en", (byte) 0x63, (byte) 0x03));
    tokens.add(new Token("Ygrad", "fr", (byte) 0x63, (byte) 0x03));
    tokens.add(new Token("u(nMin)", (byte) 0x63, (byte) 0x04));
    tokens.add(new Token("v(nMin)", (byte) 0x63, (byte) 0x05));
    tokens.add(new Token("Zu(nMin)", (byte) 0x63, (byte) 0x08));
    tokens.add(new Token("Zv(nMin)", (byte) 0x63, (byte) 0x09));
    tokens.add(new Token("Xmin", (byte) 0x63, (byte) 0x0A));
    tokens.add(new Token("Xmax", (byte) 0x63, (byte) 0x0B));
    tokens.add(new Token("Ymin", (byte) 0x63, (byte) 0x0C));
    tokens.add(new Token("Ymax", (byte) 0x63, (byte) 0x0D));
    tokens.add(new Token("Tmin", (byte) 0x63, (byte) 0x0E));
    tokens.add(new Token("Tmax", (byte) 0x63, (byte) 0x0F));
    tokens.add(new Token("θmin", (byte) 0x63, (byte) 0x10));
    tokens.add(new Token("θmax", (byte) 0x63, (byte) 0x11));
    tokens.add(new Token("ZXmin", (byte) 0x63, (byte) 0x12));
    tokens.add(new Token("ZXmax", (byte) 0x63, (byte) 0x13));
    tokens.add(new Token("ZYmin", (byte) 0x63, (byte) 0x14));
    tokens.add(new Token("ZYmax", (byte) 0x63, (byte) 0x15));
    tokens.add(new Token("Zθmin", (byte) 0x63, (byte) 0x16));
    tokens.add(new Token("Zθmax", (byte) 0x63, (byte) 0x17));
    tokens.add(new Token("ZTmin", (byte) 0x63, (byte) 0x18));
    tokens.add(new Token("ZTmax", (byte) 0x63, (byte) 0x19));
    tokens.add(new Token("TblStart", "en", (byte) 0x63, (byte) 0x1A));
    tokens.add(new Token("DébutTbl", "fr", (byte) 0x63, (byte) 0x1A));
    tokens.add(new Token("PlotStart", "en", (byte) 0x63, (byte) 0x1B));
    tokens.add(new Token("PointDébut", "fr", (byte) 0x63, (byte) 0x1B));
    tokens.add(new Token("ZPlotStart", "en", (byte) 0x63, (byte) 0x1C));
    tokens.add(new Token("ZPointDébut", "fr", (byte) 0x63, (byte) 0x1C));
    tokens.add(new Token("nMax", (byte) 0x63, (byte) 0x1D));
    tokens.add(new Token("ZnMax", (byte) 0x63, (byte) 0x1E));
    tokens.add(new Token("nMin", (byte) 0x63, (byte) 0x1F));
    tokens.add(new Token("ZnMin", (byte) 0x63, (byte) 0x20));
    tokens.add(new Token("ΔTbl", "en", (byte) 0x63, (byte) 0x21));
    tokens.add(new Token("PasTbl", "fr", (byte) 0x63, (byte) 0x21));
    tokens.add(new Token("Tstep", "en", (byte) 0x63, (byte) 0x22));
    tokens.add(new Token("Tpas", "fr", (byte) 0x63, (byte) 0x22));
    tokens.add(new Token("θstep", "en", (byte) 0x63, (byte) 0x23));
    tokens.add(new Token("θpas", "fr", (byte) 0x63, (byte) 0x23));
    tokens.add(new Token("ZTstep", "en", (byte) 0x63, (byte) 0x24));
    tokens.add(new Token("ZTpas", "fr", (byte) 0x63, (byte) 0x24));
    tokens.add(new Token("Zθstep", "en", (byte) 0x63, (byte) 0x25));
    tokens.add(new Token("Zθpas", "fr", (byte) 0x63, (byte) 0x25));
    tokens.add(new Token("ΔX", "en", (byte) 0x63, (byte) 0x26));
    tokens.add(new Token("PasX", "fr", (byte) 0x63, (byte) 0x26));
    tokens.add(new Token("ΔY", "en", (byte) 0x63, (byte) 0x27));
    tokens.add(new Token("PasY", "fr", (byte) 0x63, (byte) 0x27));
    tokens.add(new Token("XFact", (byte) 0x63, (byte) 0x28));
    tokens.add(new Token("YFact", (byte) 0x63, (byte) 0x29));
    tokens.add(new Token("TblInput", "en", (byte) 0x63, (byte) 0x2A));
    tokens.add(new Token("EntréeTbl", "fr", (byte) 0x63, (byte) 0x2A));
    tokens.add(new Token("&N;", (byte) 0x63, (byte) 0x2B));
    tokens.add(new Token("I%", (byte) 0x63, (byte) 0x2C));
    tokens.add(new Token("PV", "en", (byte) 0x63, (byte) 0x2D));
    tokens.add(new Token("ValAct", "fr", (byte) 0x63, (byte) 0x2D));
    tokens.add(new Token("PMT", (byte) 0x63, (byte) 0x2E));
    tokens.add(new Token("FV", "en", (byte) 0x63, (byte) 0x2F));
    tokens.add(new Token("ValAcq", "fr", (byte) 0x63, (byte) 0x2F));
    tokens.add(new Token("P/Y", "en", (byte) 0x63, (byte) 0x30));
    tokens.add(new Token("Ech/An", "fr", (byte) 0x63, (byte) 0x30));
    tokens.add(new Token("C/Y", "en", (byte) 0x63, (byte) 0x31));
    tokens.add(new Token("Pér/An", "fr", (byte) 0x63, (byte) 0x31));
    tokens.add(new Token("w(nMin)", (byte) 0x63, (byte) 0x32));
    tokens.add(new Token("Zw(nMin)", (byte) 0x63, (byte) 0x33));
    tokens.add(new Token("PlotStep", "en", (byte) 0x63, (byte) 0x34));
    tokens.add(new Token("GraphPas", "fr", (byte) 0x63, (byte) 0x34));
    tokens.add(new Token("ZPlotStep", "en", (byte) 0x63, (byte) 0x35));
    tokens.add(new Token("ZGraphPas", "fr", (byte) 0x63, (byte) 0x35));
    tokens.add(new Token("Xres", (byte) 0x63, (byte) 0x36));
    tokens.add(new Token("ZXres", (byte) 0x63, (byte) 0x37));
    tokens.add(new Token("Radian", (byte) 0x64));
    tokens.add(new Token("Degree", "en", (byte) 0x65));
    tokens.add(new Token("Degré", "fr", (byte) 0x65));
    tokens.add(new Token("Normal", (byte) 0x66));
    tokens.add(new Token("Sci", (byte) 0x67));
    tokens.add(new Token("Eng", "en", (byte) 0x68));
    tokens.add(new Token("Ing", "fr", (byte) 0x68));
    tokens.add(new Token("Float", "en", (byte) 0x69));
    tokens.add(new Token("Flottant", "fr", (byte) 0x69));
    tokens.add(new Token("=", (byte) 0x6A));
    tokens.add(new Token("<", (byte) 0x6B));
    tokens.add(new Token(">", (byte) 0x6C));
    tokens.add(new Token("<=", (byte) 0x6D));
    tokens.add(new Token(">=", (byte) 0x6E));
    tokens.add(new Token("!=", (byte) 0x6F));
    tokens.add(new Token("+", (byte) 0x70));
    tokens.add(new Token("-", (byte) 0x71));
    tokens.add(new Token("Ans", "en", (byte) 0x72));
    tokens.add(new Token("Rep", "fr", (byte) 0x72));
    tokens.add(new Token("Fix ", "en", (byte) 0x73));
    tokens.add(new Token("Fixe ", "fr", (byte) 0x73));
    tokens.add(new Token("Horiz", (byte) 0x74));
    tokens.add(new Token("Full", "en", (byte) 0x75));
    tokens.add(new Token("PleinEcr", "fr", (byte) 0x75));
    tokens.add(new Token("Func", "en", (byte) 0x76));
    tokens.add(new Token("Fonct", "fr", (byte) 0x76));
    tokens.add(new Token("Param", (byte) 0x77));
    tokens.add(new Token("Polar", "en", (byte) 0x78));
    tokens.add(new Token("Polaire", "fr", (byte) 0x78));
    tokens.add(new Token("Seq", "en", (byte) 0x79));
    tokens.add(new Token("Suite", "fr", (byte) 0x79));
    tokens.add(new Token("IndpntAuto", "en", (byte) 0x7A));
    tokens.add(new Token("ValeursAuto", "fr", (byte) 0x7A));
    tokens.add(new Token("IndpntAsk", "en", (byte) 0x7B));
    tokens.add(new Token("ValeursDem", "fr", (byte) 0x7B));
    tokens.add(new Token("DependAuto", "en", (byte) 0x7C));
    tokens.add(new Token("CalculsAuto", "fr", (byte) 0x7C));
    tokens.add(new Token("DependAsk", "en", (byte) 0x7D));
    tokens.add(new Token("CalculsDem", "fr", (byte) 0x7D));
    tokens.add(new Token("Sequential", "en", (byte) 0x7E, (byte) 0x00));
    tokens.add(new Token("Séquentiel", "fr", (byte) 0x7E, (byte) 0x00));
    tokens.add(new Token("Simul", (byte) 0x7E, (byte) 0x01));
    tokens.add(new Token("PolarGC", "en", (byte) 0x7E, (byte) 0x02));
    tokens.add(new Token("CoordPol", "fr", (byte) 0x7E, (byte) 0x02));
    tokens.add(new Token("RectGC", "en", (byte) 0x7E, (byte) 0x03));
    tokens.add(new Token("CoordRect", "fr", (byte) 0x7E, (byte) 0x03));
    tokens.add(new Token("CoordOn", "en", (byte) 0x7E, (byte) 0x04));
    tokens.add(new Token("CoordAff", "fr", (byte) 0x7E, (byte) 0x04));
    tokens.add(new Token("CoordOff", "en", (byte) 0x7E, (byte) 0x05));
    tokens.add(new Token("CoordNAff", "fr", (byte) 0x7E, (byte) 0x05));
    tokens.add(new Token("Connected", "en", (byte) 0x7E, (byte) 0x06));
    tokens.add(new Token("Relié", "fr", (byte) 0x7E, (byte) 0x06));
    tokens.add(new Token("Dot", "en", (byte) 0x7E, (byte) 0x07));
    tokens.add(new Token("NonRelié", "fr", (byte) 0x7E, (byte) 0x07));
    tokens.add(new Token("AxesOn", "en", (byte) 0x7E, (byte) 0x08));
    tokens.add(new Token("AxesAff", "fr", (byte) 0x7E, (byte) 0x08));
    tokens.add(new Token("AxesOff", "en", (byte) 0x7E, (byte) 0x09));
    tokens.add(new Token("AxesNAff", "fr", (byte) 0x7E, (byte) 0x09));
    tokens.add(new Token("GridOn", "en", (byte) 0x7E, (byte) 0x0A));
    tokens.add(new Token("QuadAff", "fr", (byte) 0x7E, (byte) 0x0A));
    tokens.add(new Token("GridOff", "en", (byte) 0x7E, (byte) 0x0B));
    tokens.add(new Token("QuadNAff", "fr", (byte) 0x7E, (byte) 0x0B));
    tokens.add(new Token("LabelOn", "en", (byte) 0x7E, (byte) 0x0C));
    tokens.add(new Token("EtiqAff", "fr", (byte) 0x7E, (byte) 0x0C));
    tokens.add(new Token("LabelOff", "en", (byte) 0x7E, (byte) 0x0D));
    tokens.add(new Token("EtiqNAff", "fr", (byte) 0x7E, (byte) 0x0D));
    tokens.add(new Token("Web", "en", (byte) 0x7E, (byte) 0x0E));
    tokens.add(new Token("Toile", "fr", (byte) 0x7E, (byte) 0x0E));
    tokens.add(new Token("Time", "en", (byte) 0x7E, (byte) 0x0F));
    tokens.add(new Token("f(n)", "fr", (byte) 0x7E, (byte) 0x0F));
    tokens.add(new Token("uvAxes", (byte) 0x7E, (byte) 0x10));
    tokens.add(new Token("vwAxes", (byte) 0x7E, (byte) 0x11));
    tokens.add(new Token("uwAxes", (byte) 0x7E, (byte) 0x12));
    tokens.add(new Token("&square;", "en", (byte) 0x7F));
    tokens.add(new Token("&carré;", "fr", (byte) 0x7F));
    tokens.add(new Token("&cross;", "en", (byte) 0x80));
    tokens.add(new Token("&croix;", "fr", (byte) 0x80));
    tokens.add(new Token("·", (byte) 0x81));
    tokens.add(new Token("*", (byte) 0x82));
    tokens.add(new Token("/", (byte) 0x83));
    tokens.add(new Token("Trace", (byte) 0x84));
    tokens.add(new Token("ClrDraw", "en", (byte) 0x85));
    tokens.add(new Token("EffDessin", "fr", (byte) 0x85));
    tokens.add(new Token("ZStandard", (byte) 0x86));
    tokens.add(new Token("ZTrig", (byte) 0x87));
    tokens.add(new Token("ZBox", "en", (byte) 0x88));
    tokens.add(new Token("Zboîte", "fr", (byte) 0x88));
    tokens.add(new Token("Zoom In", "en", (byte) 0x89));
    tokens.add(new Token("Zoom +", "fr", (byte) 0x89));
    tokens.add(new Token("Zoom Out", "en", (byte) 0x8A));
    tokens.add(new Token("Zoom -", "fr", (byte) 0x8A));
    tokens.add(new Token("ZSquare", "en", (byte) 0x8B));
    tokens.add(new Token("ZOrthonormal", "fr", (byte) 0x8B));
    tokens.add(new Token("ZInteger", "en", (byte) 0x8C));
    tokens.add(new Token("ZEntier", "fr", (byte) 0x8C));
    tokens.add(new Token("ZPrevious", "en", (byte) 0x8D));
    tokens.add(new Token("ZPrécédent", "fr", (byte) 0x8D));
    tokens.add(new Token("ZDecimal", "en", (byte) 0x8E));
    tokens.add(new Token("ZDécimal", "fr", (byte) 0x8E));
    tokens.add(new Token("ZoomStat", (byte) 0x8F));
    tokens.add(new Token("ZoomRcl", "en", (byte) 0x90));
    tokens.add(new Token("ZoomRpl", "fr", (byte) 0x90));
    tokens.add(new Token("PrintScreen", "en", (byte) 0x91));
    tokens.add(new Token("ImprEcr", "fr", (byte) 0x91));
    tokens.add(new Token("ZoomSto", "en", (byte) 0x92));
    tokens.add(new Token("SauveFen", "fr", (byte) 0x92));
    tokens.add(new Token("Text(", "en", (byte) 0x93));
    tokens.add(new Token("Texte(", "fr", (byte) 0x93));
    tokens.add(new Token(" nPr ", "en", (byte) 0x94));
    tokens.add(new Token(" Arrangement ", "fr", (byte) 0x94));
    tokens.add(new Token(" nCr ", "en", (byte) 0x95));
    tokens.add(new Token(" Combinaison ", "fr", (byte) 0x95));
    tokens.add(new Token("FnOn ", "en", (byte) 0x96));
    tokens.add(new Token("FonctAff ", "fr", (byte) 0x96));
    tokens.add(new Token("FnOff ", "en", (byte) 0x97));
    tokens.add(new Token("FonctNAff ", "fr", (byte) 0x97));
    tokens.add(new Token("StorePic ", "en", (byte) 0x98));
    tokens.add(new Token("SauveImage ", "fr", (byte) 0x98));
    tokens.add(new Token("RecallPic ", "en", (byte) 0x99));
    tokens.add(new Token("RappelImage ", "fr", (byte) 0x99));
    tokens.add(new Token("StoreGDB ", "en", (byte) 0x9A));
    tokens.add(new Token("SauveBDG ", "fr", (byte) 0x9A));
    tokens.add(new Token("RecallGDB ", "en", (byte) 0x9B));
    tokens.add(new Token("RappelBDG ", "fr", (byte) 0x9B));
    tokens.add(new Token("Line(", "en", (byte) 0x9C));
    tokens.add(new Token("Ligne(", "fr", (byte) 0x9C));
    tokens.add(new Token("Vertical ", "en", (byte) 0x9D));
    tokens.add(new Token("Verticale ", "fr", (byte) 0x9D));
    tokens.add(new Token("Pt-On(", "en", (byte) 0x9E));
    tokens.add(new Token("Pt-Aff(", "fr", (byte) 0x9E));
    tokens.add(new Token("Pt-Off(", "en", (byte) 0x9F));
    tokens.add(new Token("Pt-NAff(", "fr", (byte) 0x9F));
    tokens.add(new Token("Pt-Change(", (byte) 0xA0));
    tokens.add(new Token("Pxl-On(", "en", (byte) 0xA1));
    tokens.add(new Token("Pxl-Aff(", "fr", (byte) 0xA1));
    tokens.add(new Token("Pxl-Off(", "en", (byte) 0xA2));
    tokens.add(new Token("Pxl-NAff(", "fr", (byte) 0xA2));
    tokens.add(new Token("Pxl-Change(", (byte) 0xA3));
    tokens.add(new Token("Shade(", "en", (byte) 0xA4));
    tokens.add(new Token("Ombre(", "fr", (byte) 0xA4));
    tokens.add(new Token("Circle(", "en", (byte) 0xA5));
    tokens.add(new Token("Cercle(", "fr", (byte) 0xA5));
    tokens.add(new Token("Horizontal ", "en", (byte) 0xA6));
    tokens.add(new Token("Horizontale ", "fr", (byte) 0xA6));
    tokens.add(new Token("Tangent(", "en", (byte) 0xA7));
    tokens.add(new Token("Tangente(", "fr", (byte) 0xA7));
    tokens.add(new Token("DrawInv ", "en", (byte) 0xA8));
    tokens.add(new Token("DessRecip ", "fr", (byte) 0xA8));
    tokens.add(new Token("DrawF ", "en", (byte) 0xA9));
    tokens.add(new Token("DessFonct ", "fr", (byte) 0xA9));
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token("Str" + (i + 1), "en", (byte) 0xAA, (byte) (0x00 + i)));
      tokens.add(new Token("Chaîne" + (i + 1), "fr", (byte) 0xAA, (byte) (0x00 + i)));
    }
    tokens.add(new Token("Str0", "en", (byte) 0xAA, (byte) 0x09));
    tokens.add(new Token("Chaîne0", "fr", (byte) 0xAA, (byte) 0x09));
    tokens.add(new Token("rand", "en", (byte) 0xAB));
    tokens.add(new Token("NbrAléat", "fr", (byte) 0xAB));
    tokens.add(new Token("π", (byte) 0xAC));
    tokens.add(new Token("getKey", "en", (byte) 0xAD));
    tokens.add(new Token("codeTouch(", "fr", (byte) 0xAD));
    tokens.add(new Token("'", (byte) 0xAE));
    tokens.add(new Token("?", (byte) 0xAF));
    tokens.add(new Token("_-", (byte) 0xB0));
    tokens.add(new Token("int(", "en", (byte) 0xB1));
    tokens.add(new Token("partEnt(", "fr", (byte) 0xB1));
    tokens.add(new Token("abs(", (byte) 0xB2));
    tokens.add(new Token("det(", "en", (byte) 0xB3));
    tokens.add(new Token("dét(", "fr", (byte) 0xB3));
    tokens.add(new Token("identity(", "en", (byte) 0xB4));
    tokens.add(new Token("identité(", "fr", (byte) 0xB4));
    tokens.add(new Token("dim(", (byte) 0xB5));
    tokens.add(new Token("sum(", "en", (byte) 0xB6));
    tokens.add(new Token("somme(", "fr", (byte) 0xB6));
    tokens.add(new Token("prod(", (byte) 0xB7));
    tokens.add(new Token("not(", "en", (byte) 0xB8));
    tokens.add(new Token("non(", "fr", (byte) 0xB8));
    tokens.add(new Token("iPart(", "en", (byte) 0xB9));
    tokens.add(new Token("ent(", "fr", (byte) 0xB9));
    tokens.add(new Token("fPart(", "en", (byte) 0xBA));
    tokens.add(new Token("partDéc(", "fr", (byte) 0xBA));
    tokens.add(new Token("npv(", "en", (byte) 0xBB, (byte) 0x00));
    tokens.add(new Token("vActNet(", "fr", (byte) 0xBB, (byte) 0x00));
    tokens.add(new Token("irr(", "en", (byte) 0xBB, (byte) 0x01));
    tokens.add(new Token("tauxRi(", "fr", (byte) 0xBB, (byte) 0x01));
    tokens.add(new Token("bal(", "en", (byte) 0xBB, (byte) 0x02));
    tokens.add(new Token("paSolde(", "fr", (byte) 0xBB, (byte) 0x02));
    tokens.add(new Token("ΣPrn(", "en", (byte) 0xBB, (byte) 0x03));
    tokens.add(new Token("paSomPrinc(", "fr", (byte) 0xBB, (byte) 0x03));
    tokens.add(new Token("ΣInt(", "en", (byte) 0xBB, (byte) 0x04));
    tokens.add(new Token("paInt(", "fr", (byte) 0xBB, (byte) 0x04));
    tokens.add(new Token(">Nom(", (byte) 0xBB, (byte) 0x05));
    tokens.add(new Token(">Eff(", (byte) 0xBB, (byte) 0x06));
    tokens.add(new Token("dbd(", "en", (byte) 0xBB, (byte) 0x07));
    tokens.add(new Token("jed(", "fr", (byte) 0xBB, (byte) 0x07));
    tokens.add(new Token("lcm(", "en", (byte) 0xBB, (byte) 0x08));
    tokens.add(new Token("ppcm(", "fr", (byte) 0xBB, (byte) 0x08));
    tokens.add(new Token("gcd(", "en", (byte) 0xBB, (byte) 0x09));
    tokens.add(new Token("pgcd(", "fr", (byte) 0xBB, (byte) 0x09));
    tokens.add(new Token("randInt(", "en", (byte) 0xBB, (byte) 0x0A));
    tokens.add(new Token("entAléat(", "fr", (byte) 0xBB, (byte) 0x0A));
    tokens.add(new Token("randBin(", "en", (byte) 0xBB, (byte) 0x0B));
    tokens.add(new Token("BinAléat(", "fr", (byte) 0xBB, (byte) 0x0B));
    tokens.add(new Token("sub(", "en", (byte) 0xBB, (byte) 0x0C));
    tokens.add(new Token("sous-Chaîne(", "fr", (byte) 0xBB, (byte) 0x0C));
    tokens.add(new Token("stdDev(", "en", (byte) 0xBB, (byte) 0x0D));
    tokens.add(new Token("ecart-type(", "fr", (byte) 0xBB, (byte) 0x0D));
    tokens.add(new Token("variance(", (byte) 0xBB, (byte) 0x0E));
    tokens.add(new Token("inString(", "en", (byte) 0xBB, (byte) 0x0F));
    tokens.add(new Token("carChaîne(", "fr", (byte) 0xBB, (byte) 0x0F));
    tokens.add(new Token("normalcdf(", "en", (byte) 0xBB, (byte) 0x10));
    tokens.add(new Token("normalFRép(", "fr", (byte) 0xBB, (byte) 0x10));
    tokens.add(new Token("invNorm(", "en", (byte) 0xBB, (byte) 0x11));
    tokens.add(new Token("FracNormale(", "fr", (byte) 0xBB, (byte) 0x11));
    tokens.add(new Token("tcdf(", "en", (byte) 0xBB, (byte) 0x12));
    tokens.add(new Token("studentFRép(", "fr", (byte) 0xBB, (byte) 0x12));
    tokens.add(new Token("χ²cdf(", "en", (byte) 0xBB, (byte) 0x13));
    tokens.add(new Token("χ²FRép(", "fr", (byte) 0xBB, (byte) 0x13));
    tokens.add(new Token("Fcdf(", "en", (byte) 0xBB, (byte) 0x14));
    tokens.add(new Token("FFRép(", "fr", (byte) 0xBB, (byte) 0x14));
    tokens.add(new Token("binompdf(", "en", (byte) 0xBB, (byte) 0x15));
    tokens.add(new Token("binomFdp(", "fr", (byte) 0xBB, (byte) 0x15));
    tokens.add(new Token("binomcdf(", "en", (byte) 0xBB, (byte) 0x16));
    tokens.add(new Token("binomFRép(", "fr", (byte) 0xBB, (byte) 0x16));
    tokens.add(new Token("poissonpdf(", "en", (byte) 0xBB, (byte) 0x17));
    tokens.add(new Token("poissonFdp(", "fr", (byte) 0xBB, (byte) 0x17));
    tokens.add(new Token("poissoncdf(", "en", (byte) 0xBB, (byte) 0x18));
    tokens.add(new Token("poissonFRép(", "fr", (byte) 0xBB, (byte) 0x18));
    tokens.add(new Token("geometpdf(", "en", (byte) 0xBB, (byte) 0x19));
    tokens.add(new Token("géomtFdp(", "fr", (byte) 0xBB, (byte) 0x19));
    tokens.add(new Token("geometcdf(", "en", (byte) 0xBB, (byte) 0x1A));
    tokens.add(new Token("géomtFRép(", "fr", (byte) 0xBB, (byte) 0x1A));
    tokens.add(new Token("normalpdf(", "en", (byte) 0xBB, (byte) 0x1B));
    tokens.add(new Token("normalFdp(", "fr", (byte) 0xBB, (byte) 0x1B));
    tokens.add(new Token("tpdf(", "en", (byte) 0xBB, (byte) 0x1C));
    tokens.add(new Token("studentFdp(", "fr", (byte) 0xBB, (byte) 0x1C));
    tokens.add(new Token("χ²pdf(", "en", (byte) 0xBB, (byte) 0x1D));
    tokens.add(new Token("χ²Fdp(", "fr", (byte) 0xBB, (byte) 0x1D));
    tokens.add(new Token("Fpdf(", "en", (byte) 0xBB, (byte) 0x1E));
    tokens.add(new Token("FFdp(", "fr", (byte) 0xBB, (byte) 0x1E));
    tokens.add(new Token("randNorm(", "en", (byte) 0xBB, (byte) 0x1F));
    tokens.add(new Token("normAléat(", "fr", (byte) 0xBB, (byte) 0x1F));
    tokens.add(new Token("tvm_Pmt", "en", (byte) 0xBB, (byte) 0x20));
    tokens.add(new Token("vat_Pmt", "fr", (byte) 0xBB, (byte) 0x20));
    tokens.add(new Token("tvm_I%", "en", (byte) 0xBB, (byte) 0x21));
    tokens.add(new Token("vat_I%", "fr", (byte) 0xBB, (byte) 0x21));
    tokens.add(new Token("tvm_PV", "en", (byte) 0xBB, (byte) 0x22));
    tokens.add(new Token("vat_Vact", "fr", (byte) 0xBB, (byte) 0x22));
    tokens.add(new Token("tvm_N", "en", (byte) 0xBB, (byte) 0x23));
    tokens.add(new Token("vat_N", "fr", (byte) 0xBB, (byte) 0x23));
    tokens.add(new Token("tvm_FV", "en", (byte) 0xBB, (byte) 0x24));
    tokens.add(new Token("vat_Vacq", "fr", (byte) 0xBB, (byte) 0x24));
    tokens.add(new Token("conj(", (byte) 0xBB, (byte) 0x25));
    tokens.add(new Token("real(", "en", (byte) 0xBB, (byte) 0x26));
    tokens.add(new Token("réel(", "fr", (byte) 0xBB, (byte) 0x26));
    tokens.add(new Token("imag(", (byte) 0xBB, (byte) 0x27));
    tokens.add(new Token("angle(", "en", (byte) 0xBB, (byte) 0x28));
    tokens.add(new Token("argument(", "fr", (byte) 0xBB, (byte) 0x28));
    tokens.add(new Token("cumSum(", "en", (byte) 0xBB, (byte) 0x29));
    tokens.add(new Token("somCum(", "fr", (byte) 0xBB, (byte) 0x29));
    tokens.add(new Token("expr(", (byte) 0xBB, (byte) 0x2A));
    tokens.add(new Token("length(", "en", (byte) 0xBB, (byte) 0x2B));
    tokens.add(new Token("longueur(", "fr", (byte) 0xBB, (byte) 0x2B));
    tokens.add(new Token("ΔList(", "en", (byte) 0xBB, (byte) 0x2C));
    tokens.add(new Token("ΔListe(", "fr", (byte) 0xBB, (byte) 0x2C));
    tokens.add(new Token("ref(", "en", (byte) 0xBB, (byte) 0x2D));
    tokens.add(new Token("Gauss(", "fr", (byte) 0xBB, (byte) 0x2D));
    tokens.add(new Token("rref(", "en", (byte) 0xBB, (byte) 0x2E));
    tokens.add(new Token("Gauss-Jordan(", "fr", (byte) 0xBB, (byte) 0x2E));
    tokens.add(new Token(">Rect", (byte) 0xBB, (byte) 0x2F));
    tokens.add(new Token(">Polar", "en", (byte) 0xBB, (byte) 0x30));
    tokens.add(new Token(">Polaire", "fr", (byte) 0xBB, (byte) 0x30));
    tokens.add(new Token("e_", (byte) 0xBB, (byte) 0x31));
    tokens.add(new Token("SinReg ", "en", (byte) 0xBB, (byte) 0x32));
    tokens.add(new Token("RegSin ", "fr", (byte) 0xBB, (byte) 0x32));
    tokens.add(new Token("Logistic ", "en", (byte) 0xBB, (byte) 0x33));
    tokens.add(new Token("Logistique ", "fr", (byte) 0xBB, (byte) 0x33));
    tokens.add(new Token("LinRegTTest ", "en", (byte) 0xBB, (byte) 0x34));
    tokens.add(new Token("RegLinTTest ", "fr", (byte) 0xBB, (byte) 0x34));
    tokens.add(new Token("ShadeNorm(", "en", (byte) 0xBB, (byte) 0x35));
    tokens.add(new Token("OmbreNorm(", "fr", (byte) 0xBB, (byte) 0x35));
    tokens.add(new Token("Shade_t(", "en", (byte) 0xBB, (byte) 0x36));
    tokens.add(new Token("Ombre_t(", "fr", (byte) 0xBB, (byte) 0x36));
    tokens.add(new Token("Shadeχ²(", "en", (byte) 0xBB, (byte) 0x37));
    tokens.add(new Token("Ombreχ²(", "fr", (byte) 0xBB, (byte) 0x37));
    tokens.add(new Token("ShadeF(", "en", (byte) 0xBB, (byte) 0x38));
    tokens.add(new Token("OmbreF(", "fr", (byte) 0xBB, (byte) 0x38));
    tokens.add(new Token("Matr>list(", "en", (byte) 0xBB, (byte) 0x39));
    tokens.add(new Token("Matr>liste(", "fr", (byte) 0xBB, (byte) 0x39));
    tokens.add(new Token("List>matr(", "en", (byte) 0xBB, (byte) 0x3A));
    tokens.add(new Token("Liste>matr(", "fr", (byte) 0xBB, (byte) 0x3A));
    tokens.add(new Token("Z-Test(", (byte) 0xBB, (byte) 0x3B));
    tokens.add(new Token("T-Test ", (byte) 0xBB, (byte) 0x3C));
    tokens.add(new Token("2-SampZTest(", "en", (byte) 0xBB, (byte) 0x3D));
    tokens.add(new Token("2-CompZTest(", "fr", (byte) 0xBB, (byte) 0x3D));
    tokens.add(new Token("1-PropZTest(", (byte) 0xBB, (byte) 0x3E));
    tokens.add(new Token("2-PropZTest(", (byte) 0xBB, (byte) 0x3F));
    tokens.add(new Token("χ²-Test(", (byte) 0xBB, (byte) 0x40));
    tokens.add(new Token("ZInterval ", "en", (byte) 0xBB, (byte) 0x41));
    tokens.add(new Token("ZIntConf ", "fr", (byte) 0xBB, (byte) 0x41));
    tokens.add(new Token("2-SampZInt(", "en", (byte) 0xBB, (byte) 0x42));
    tokens.add(new Token("2-CompZInt(", "fr", (byte) 0xBB, (byte) 0x42));
    tokens.add(new Token("1-PropZInt(", (byte) 0xBB, (byte) 0x43));
    tokens.add(new Token("2-PropZInt(", (byte) 0xBB, (byte) 0x44));
    tokens.add(new Token("GraphStyle(", (byte) 0xBB, (byte) 0x45));
    tokens.add(new Token("2-SampTTest ", "en", (byte) 0xBB, (byte) 0x46));
    tokens.add(new Token("2-CompTTest ", "fr", (byte) 0xBB, (byte) 0x46));
    tokens.add(new Token("2-SampFTest ", "en", (byte) 0xBB, (byte) 0x47));
    tokens.add(new Token("2-CompFTest ", "fr", (byte) 0xBB, (byte) 0x47));
    tokens.add(new Token("TInterval ", "en", (byte) 0xBB, (byte) 0x48));
    tokens.add(new Token("TIntConf ", "fr", (byte) 0xBB, (byte) 0x48));
    tokens.add(new Token("2-SampTInt ", "en", (byte) 0xBB, (byte) 0x49));
    tokens.add(new Token("2-CompTInt ", "fr", (byte) 0xBB, (byte) 0x49));
    tokens.add(new Token("SetUpEditor ", "en", (byte) 0xBB, (byte) 0x4A));
    tokens.add(new Token("ListesDéfaut ", "fr", (byte) 0xBB, (byte) 0x4A));
    tokens.add(new Token("Pmt_End", "en", (byte) 0xBB, (byte) 0x4B));
    tokens.add(new Token("Pmt_Fin", "fr", (byte) 0xBB, (byte) 0x4B));
    tokens.add(new Token("Pmt_Bgn", "en", (byte) 0xBB, (byte) 0x4C));
    tokens.add(new Token("Pmt_Déb", "fr", (byte) 0xBB, (byte) 0x4C));
    tokens.add(new Token("Real", "en", (byte) 0xBB, (byte) 0x4D));
    tokens.add(new Token("Réel", "fr", (byte) 0xBB, (byte) 0x4D));
    tokens.add(new Token("re^θi", (byte) 0xBB, (byte) 0x4E));
    tokens.add(new Token("a+bi", (byte) 0xBB, (byte) 0x4F));
    tokens.add(new Token("ExprOn", "en", (byte) 0xBB, (byte) 0x50));
    tokens.add(new Token("ExprAff", "fr", (byte) 0xBB, (byte) 0x50));
    tokens.add(new Token("ExprOff", "en", (byte) 0xBB, (byte) 0x51));
    tokens.add(new Token("ExprNAff", "fr", (byte) 0xBB, (byte) 0x51));
    tokens.add(new Token("ClrAllLists", "en", (byte) 0xBB, (byte) 0x52));
    tokens.add(new Token("EffToutListes", "fr", (byte) 0xBB, (byte) 0x52));
    tokens.add(new Token("GetCalc(", "en", (byte) 0xBB, (byte) 0x53));
    tokens.add(new Token("CaptVar(", "fr", (byte) 0xBB, (byte) 0x53));
    tokens.add(new Token("DelVar ", "en", (byte) 0xBB, (byte) 0x54));
    tokens.add(new Token("EffVar ", "fr", (byte) 0xBB, (byte) 0x54));
    tokens.add(new Token("Equ>String(", "en", (byte) 0xBB, (byte) 0x55));
    tokens.add(new Token("Equ>Chaîne(", "fr", (byte) 0xBB, (byte) 0x55));
    tokens.add(new Token("String>Equ(", "en", (byte) 0xBB, (byte) 0x56));
    tokens.add(new Token("Chaîne>Equ(", "fr", (byte) 0xBB, (byte) 0x56));
    tokens.add(new Token("Clear Entries", "en", (byte) 0xBB, (byte) 0x57));
    tokens.add(new Token("Efface entrées", "fr", (byte) 0xBB, (byte) 0x57));
    tokens.add(new Token("Select(", "en", (byte) 0xBB, (byte) 0x58));
    tokens.add(new Token("Sélect(", "fr", (byte) 0xBB, (byte) 0x58));
    tokens.add(new Token("ANOVA(", "en", (byte) 0xBB, (byte) 0x59));
    tokens.add(new Token("ANUVA(", "fr", (byte) 0xBB, (byte) 0x59));
    tokens.add(new Token("ModBoxplot", "en", (byte) 0xBB, (byte) 0x5A));
    tokens.add(new Token("GraphBoitMoust", "fr", (byte) 0xBB, (byte) 0x5A));
    tokens.add(new Token("NormProbPlot", "en", (byte) 0xBB, (byte) 0x5B));
    tokens.add(new Token("GraphProbNorm", "fr", (byte) 0xBB, (byte) 0x5B));
    tokens.add(new Token("G-T", (byte) 0xBB, (byte) 0x64));
    tokens.add(new Token("ZoomFit", "en", (byte) 0xBB, (byte) 0x65));
    tokens.add(new Token("ZMinMax", "fr", (byte) 0xBB, (byte) 0x65));
    tokens.add(new Token("DiagnosticOn", "en", (byte) 0xBB, (byte) 0x66));
    tokens.add(new Token("CorrelAff", "fr", (byte) 0xBB, (byte) 0x66));
    tokens.add(new Token("DiagnosticOff", "en", (byte) 0xBB, (byte) 0x67));
    tokens.add(new Token("CorrelNAff", "fr", (byte) 0xBB, (byte) 0x67));
    tokens.add(new Token("Archive ", (byte) 0xBB, (byte) 0x68));
    tokens.add(new Token("UnArchive ", "en", (byte) 0xBB, (byte) 0x69));
    tokens.add(new Token("Désarchive ", "fr", (byte) 0xBB, (byte) 0x69));
    tokens.add(new Token("Asm(", (byte) 0xBB, (byte) 0x6A));
    tokens.add(new Token("AsmComp(", (byte) 0xBB, (byte) 0x6B));
    tokens.add(new Token("AsmPrgm ", (byte) 0xBB, (byte) 0x6C));
    tokens.add(new Token("Á", (byte) 0xBB, (byte) 0x6E));
    tokens.add(new Token("À", (byte) 0xBB, (byte) 0x6F));
    tokens.add(new Token("Â", (byte) 0xBB, (byte) 0x70));
    tokens.add(new Token("Ä", (byte) 0xBB, (byte) 0x71));
    tokens.add(new Token("á", (byte) 0xBB, (byte) 0x72));
    tokens.add(new Token("à", (byte) 0xBB, (byte) 0x73));
    tokens.add(new Token("â", (byte) 0xBB, (byte) 0x74));
    tokens.add(new Token("ä", (byte) 0xBB, (byte) 0x75));
    tokens.add(new Token("É", (byte) 0xBB, (byte) 0x76));
    tokens.add(new Token("È", (byte) 0xBB, (byte) 0x77));
    tokens.add(new Token("Ê", (byte) 0xBB, (byte) 0x78));
    tokens.add(new Token("Ë", (byte) 0xBB, (byte) 0x79));
    tokens.add(new Token("é", (byte) 0xBB, (byte) 0x7A));
    tokens.add(new Token("è", (byte) 0xBB, (byte) 0x7B));
    tokens.add(new Token("ê", (byte) 0xBB, (byte) 0x7C));
    tokens.add(new Token("ë", (byte) 0xBB, (byte) 0x7D));
    tokens.add(new Token("Ì", (byte) 0xBB, (byte) 0x7F));
    tokens.add(new Token("Î", (byte) 0xBB, (byte) 0x80));
    tokens.add(new Token("Ï", (byte) 0xBB, (byte) 0x81));
    tokens.add(new Token("í", (byte) 0xBB, (byte) 0x82));
    tokens.add(new Token("ì", (byte) 0xBB, (byte) 0x83));
    tokens.add(new Token("î", (byte) 0xBB, (byte) 0x84));
    tokens.add(new Token("ï", (byte) 0xBB, (byte) 0x85));
    tokens.add(new Token("Ó", (byte) 0xBB, (byte) 0x86));
    tokens.add(new Token("Ò", (byte) 0xBB, (byte) 0x87));
    tokens.add(new Token("Ô", (byte) 0xBB, (byte) 0x88));
    tokens.add(new Token("Ö", (byte) 0xBB, (byte) 0x89));
    tokens.add(new Token("ó", (byte) 0xBB, (byte) 0x8A));
    tokens.add(new Token("ò", (byte) 0xBB, (byte) 0x8B));
    tokens.add(new Token("ô", (byte) 0xBB, (byte) 0x8C));
    tokens.add(new Token("ö", (byte) 0xBB, (byte) 0x8D));
    tokens.add(new Token("Ú", (byte) 0xBB, (byte) 0x8E));
    tokens.add(new Token("Ù", (byte) 0xBB, (byte) 0x8F));
    tokens.add(new Token("Û", (byte) 0xBB, (byte) 0x90));
    tokens.add(new Token("Ü", (byte) 0xBB, (byte) 0x91));
    tokens.add(new Token("ú", (byte) 0xBB, (byte) 0x92));
    tokens.add(new Token("ù", (byte) 0xBB, (byte) 0x93));
    tokens.add(new Token("û", (byte) 0xBB, (byte) 0x94));
    tokens.add(new Token("ü", (byte) 0xBB, (byte) 0x95));
    tokens.add(new Token("Ç", (byte) 0xBB, (byte) 0x96));
    tokens.add(new Token("ç", (byte) 0xBB, (byte) 0x97));
    tokens.add(new Token("Ñ", (byte) 0xBB, (byte) 0x98));
    tokens.add(new Token("ñ", (byte) 0xBB, (byte) 0x99));
    tokens.add(new Token("¿", (byte) 0xBB, (byte) 0x9D));
    tokens.add(new Token("¡", (byte) 0xBB, (byte) 0x9E));
    tokens.add(new Token("α", (byte) 0xBB, (byte) 0x9F));
    tokens.add(new Token("β", (byte) 0xBB, (byte) 0xA0));
    tokens.add(new Token("Δ", (byte) 0xBB, (byte) 0xA2));
    tokens.add(new Token("δ", (byte) 0xBB, (byte) 0xA3));
    tokens.add(new Token("ε", (byte) 0xBB, (byte) 0xA4));
    tokens.add(new Token("λ", (byte) 0xBB, (byte) 0xA5));
    // Micro sign
    tokens.add(new Token("µ", (byte) 0xBB, (byte) 0xA6));
    // Mu greek letter
    tokens.add(new Token("μ", (byte) 0xBB, (byte) 0xA6));
    tokens.add(new Token("ρ", (byte) 0xBB, (byte) 0xA8));
    tokens.add(new Token("Σ", (byte) 0xBB, (byte) 0xA9));
    tokens.add(new Token("φ", (byte) 0xBB, (byte) 0xAB));
    tokens.add(new Token("Ω", (byte) 0xBB, (byte) 0xAC));
    // Two loops because there's a gap between 'k' and 'l' codes.
    for (int i = 0; i < 11; i++) {
      tokens.add(new Token("" + (char) ('a' + i), (byte) 0xBB, (byte) (0xB0 + i)));
    }
    for (int i = 0; i < 15; i++) {
      tokens.add(new Token("" + (char) ('l' + i), (byte) 0xBB, (byte) (0xBC + i)));
    }
    tokens.add(new Token("σ", (byte) 0xBB, (byte) 0xCB));
    tokens.add(new Token("τ", (byte) 0xBB, (byte) 0xCC));
    tokens.add(new Token("Í", (byte) 0xBB, (byte) 0xCD));
    tokens.add(new Token("sqrt(", "en", (byte) 0xBC));
    tokens.add(new Token("racine(", "fr", (byte) 0xBC));
    tokens.add(new Token("cbrt(", "en", (byte) 0xBD));
    tokens.add(new Token("racine3(", "fr", (byte) 0xBD));
    tokens.add(new Token("ln(", (byte) 0xBE));
    tokens.add(new Token("e^(", (byte) 0xBF));
    tokens.add(new Token("log(", (byte) 0xC0));
    tokens.add(new Token("10^(", (byte) 0xC1));
    tokens.add(new Token("sin(", (byte) 0xC2));
    tokens.add(new Token("Arcsin(", (byte) 0xC3));
    tokens.add(new Token("cos(", (byte) 0xC4));
    tokens.add(new Token("Arccos(", (byte) 0xC5));
    tokens.add(new Token("tan(", (byte) 0xC6));
    tokens.add(new Token("Arctan(", (byte) 0xC7));
    tokens.add(new Token("sinh(", "en", (byte) 0xC8));
    tokens.add(new Token("sh(", "fr", (byte) 0xC8));
    tokens.add(new Token("Arcsinh(", "en", (byte) 0xC9));
    tokens.add(new Token("Argsh(", "fr", (byte) 0xC9));
    tokens.add(new Token("cosh(", "en", (byte) 0xCA));
    tokens.add(new Token("ch(", "fr", (byte) 0xCA));
    tokens.add(new Token("Arccosh(", "en", (byte) 0xCB));
    tokens.add(new Token("Argch(", "fr", (byte) 0xCB));
    tokens.add(new Token("tanh(", "en", (byte) 0xCC));
    tokens.add(new Token("th(", "fr", (byte) 0xCC));
    tokens.add(new Token("Arctanh(", "en", (byte) 0xCD));
    tokens.add(new Token("Argth(", "fr", (byte) 0xCD));
    tokens.add(new Token("If ", (byte) 0xCE));
    tokens.add(new Token("Then", (byte) 0xCF));
    tokens.add(new Token("Else", (byte) 0xD0));
    tokens.add(new Token("While ", (byte) 0xD1));
    tokens.add(new Token("Repeat ", (byte) 0xD2));
    tokens.add(new Token("For(", (byte) 0xD3));
    tokens.add(new Token("End", (byte) 0xD4));
    tokens.add(new Token("Return", (byte) 0xD5));
    tokens.add(new Token("Lbl ", (byte) 0xD6));
    tokens.add(new Token("Goto ", (byte) 0xD7));
    tokens.add(new Token("Pause ", (byte) 0xD8));
    tokens.add(new Token("Stop", (byte) 0xD9));
    tokens.add(new Token("IS>(", (byte) 0xDA));
    tokens.add(new Token("DS<(", (byte) 0xDB));
    tokens.add(new Token("Input ", (byte) 0xDC));
    tokens.add(new Token("Prompt ", (byte) 0xDD));
    tokens.add(new Token("Disp ", (byte) 0xDE));
    tokens.add(new Token("DispGraph", "en", (byte) 0xDF));
    tokens.add(new Token("AffGraph", "fr", (byte) 0xDF));
    tokens.add(new Token("Output(", (byte) 0xE0));
    tokens.add(new Token("ClrHome", "en", (byte) 0xE1));
    tokens.add(new Token("EffEcr", "fr", (byte) 0xE1));
    tokens.add(new Token("Fill(", "en", (byte) 0xE2));
    tokens.add(new Token("Remplir(", "fr", (byte) 0xE2));
    tokens.add(new Token("SortA(", "en", (byte) 0xE3));
    tokens.add(new Token("Tricroi(", "fr", (byte) 0xE3));
    tokens.add(new Token("SortD(", "en", (byte) 0xE4));
    tokens.add(new Token("TriDécroi(", "fr", (byte) 0xE4));
    tokens.add(new Token("DispTable", "en", (byte) 0xE5));
    tokens.add(new Token("AffTable", "fr", (byte) 0xE5));
    tokens.add(new Token("Menu(", (byte) 0xE6));
    tokens.add(new Token("Send(", "en", (byte) 0xE7));
    tokens.add(new Token("Envoi(", "fr", (byte) 0xE7));
    tokens.add(new Token("Get(", "en", (byte) 0xE8));
    tokens.add(new Token("Capt(", "fr", (byte) 0xE8));
    tokens.add(new Token("PlotsOn ", "en", (byte) 0xE9));
    tokens.add(new Token("GraphAff ", "fr", (byte) 0xE9));
    tokens.add(new Token("PlotsOff ", "en", (byte) 0xEA));
    tokens.add(new Token("GraphNAff ", "fr", (byte) 0xEA));
    tokens.add(new Token("ʟ", (byte) 0xEB));
    tokens.add(new Token("Plot1(", "en", (byte) 0xEC));
    tokens.add(new Token("Graph1(", "fr", (byte) 0xEC));
    tokens.add(new Token("Plot2(", "en", (byte) 0xED));
    tokens.add(new Token("Graph2(", "fr", (byte) 0xED));
    tokens.add(new Token("Plot3(", "en", (byte) 0xEE));
    tokens.add(new Token("Graph3(", "fr", (byte) 0xEE));
    tokens.add(new Token("^", (byte) 0xF0));
    tokens.add(new Token("&xrt;", "en", (byte) 0xF1));
    tokens.add(new Token("&racinex;", "fr", (byte) 0xF1));
    tokens.add(new Token("1-Var Stats ", "en", (byte) 0xF2));
    tokens.add(new Token("Stats 1-Var ", "fr", (byte) 0xF2));
    tokens.add(new Token("2-Var Stats ", "en", (byte) 0xF3));
    tokens.add(new Token("Stats 2-Var ", "fr", (byte) 0xF3));
    tokens.add(new Token("LinReg(a+bx) ", "en", (byte) 0xF4));
    tokens.add(new Token("RegLin(a+bx) ", "fr", (byte) 0xF4));
    tokens.add(new Token("ExpReg ", "en", (byte) 0xF5));
    tokens.add(new Token("RegExp ", "fr", (byte) 0xF5));
    tokens.add(new Token("LnReg ", "en", (byte) 0xF6));
    tokens.add(new Token("RegLn ", "fr", (byte) 0xF6));
    tokens.add(new Token("PwrReg ", "en", (byte) 0xF7));
    tokens.add(new Token("RegPuiss ", "fr", (byte) 0xF7));
    tokens.add(new Token("Med-Med", (byte) 0xF8));
    tokens.add(new Token("QuadReg ", "en", (byte) 0xF9));
    tokens.add(new Token("RegQuad", "fr", (byte) 0xF9));
    tokens.add(new Token("ClrList ", "en", (byte) 0xFA));
    tokens.add(new Token("EffListe ", "fr", (byte) 0xFA));
    tokens.add(new Token("ClrTable", "en", (byte) 0xFB));
    tokens.add(new Token("EffTable", "fr", (byte) 0xFB));
    tokens.add(new Token("Histogram", "en", (byte) 0xFC));
    tokens.add(new Token("Histogramme", "fr", (byte) 0xFC));
    tokens.add(new Token("xyLine", "en", (byte) 0xFD));
    tokens.add(new Token("Polygone", "fr", (byte) 0xFD));
    tokens.add(new Token("Scatter", "en", (byte) 0xFE));
    tokens.add(new Token("Nuage", "fr", (byte) 0xFE));
    tokens.add(new Token("LinReg(ax+b) ", "en", (byte) 0xFF));
    tokens.add(new Token("RegLin(ax+b) ", "fr", (byte) 0xFF));

    Collections.sort(tokens, (t1, t2) -> t2.compareTo(t1));

    TOKENS = tokens;
  }

  /**
   * Return the bytes corresponding to the given instruction.
   * 
   * @param instr the instruction
   * @return the bytes or an empty array if none were found
   */
  public static byte[] getBytes(String instr) {
    Optional<Token> opt = getToken(instr);

    if (opt.isPresent()) {
      return opt.get().getBytes();
    }
    return new byte[]{};
  }

  /**
   * Return the token corresponding to the given instruction.
   * 
   * @param instr the instruction
   * @return the token
   */
  public static Optional<Token> getToken(String instr) {
    return TOKENS.stream().filter(t -> t.getInstruction().equals(instr)).findFirst();
  }

  /**
   * Tells if a token is a digit.
   * 
   * @param token the token
   * @return true if the token is a digit
   */
  public static boolean isDigit(Token token) {
    return token.getInstruction().matches("\\d");
  }

  public static boolean isNewLine(Token token) {
    return LINE_END.equals(token);
  }

  private Tokens() {}
}
