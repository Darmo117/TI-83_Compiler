package net.darmo_creations.ti83_compiler.compilers;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

  static {
    TAGS_REGEXES = new LinkedHashMap<String, String>();
    TAGS_REGEXES.put("\\^\\((-|&-;)1\\)", "⁻¹");
    TAGS_REGEXES.put("\\^\\(2\\)", "²");
    TAGS_REGEXES.put("\\^\\(3\\)", "³");
    TAGS_REGEXES.put("expon|expos", "ᴇ");
    TAGS_REGEXES.put("theta|thêta", "θ");
    TAGS_REGEXES.put("F", "Ϝ");
    TAGS_REGEXES.put("pi", "π");
    TAGS_REGEXES.put("alpha", "α");
    TAGS_REGEXES.put("beta|bêta", "β");
    TAGS_REGEXES.put("Delta", "Δ");
    TAGS_REGEXES.put("delta", "δ");
    TAGS_REGEXES.put("epsilon", "ε");
    TAGS_REGEXES.put("lambda", "λ");
    TAGS_REGEXES.put("mu", "μ");
    TAGS_REGEXES.put("rho|rhô", "ρ");
    TAGS_REGEXES.put("Sigma", "Σ");
    TAGS_REGEXES.put("phi", "φ");
    TAGS_REGEXES.put("Omega|Oméga", "Ω");
    TAGS_REGEXES.put("sigma", "σ");
    TAGS_REGEXES.put("tau", "τ");
    TAGS_REGEXES.put("point|dot", "·");

    TOKENS = new LinkedList<Token>();
    TOKENS.add(new Token(">DMS", new byte[]{0x01}));
    TOKENS.add(new Token(">Dec", new byte[]{0x02}));
    TOKENS.add(new Token(">Frac", new byte[]{0x03}));
    TOKENS.add(new Token("->", new byte[]{0x04}));
    TOKENS.add(new Token("BoxPlot", "en", new byte[]{0x05}));
    TOKENS.add(new Token("Carré", "fr", new byte[]{0x05}));
    // 0x06: see 0x5CXX
    TOKENS.add(new Token("]", new byte[]{0x07}));
    TOKENS.add(new Token("{", new byte[]{0x08}));
    TOKENS.add(new Token("}", new byte[]{0x09}));
    TOKENS.add(new Token("&exponr;", "en", new byte[]{0x0A}));
    TOKENS.add(new Token("&exposr;", "fr", new byte[]{0x0A}));
    TOKENS.add(new Token("°", new byte[]{0x0B}));
    TOKENS.add(new Token("⁻¹", new byte[]{0x0C}));
    TOKENS.add(new Token("²", new byte[]{0x0D}));
    TOKENS.add(new Token("&exponT;", "en", new byte[]{0x0E}));
    TOKENS.add(new Token("&exposT;", "fr", new byte[]{0x0E}));
    TOKENS.add(new Token("³", new byte[]{0x0F}));
    TOKENS.add(new Token("(", new byte[]{0x10}));
    TOKENS.add(new Token(")", new byte[]{0x11}));
    TOKENS.add(new Token("round(", "en", new byte[]{0x12}));
    TOKENS.add(new Token("arrondi(", "fr", new byte[]{0x12}));
    TOKENS.add(new Token("pxl-Test(", new byte[]{0x13}));
    TOKENS.add(new Token("augment(", "en", new byte[]{0x14}));
    TOKENS.add(new Token("chaîne(", "fr", new byte[]{0x14}));
    TOKENS.add(new Token("rowSwap(", "en", new byte[]{0x15}));
    TOKENS.add(new Token("permutLigne(", "fr", new byte[]{0x15}));
    TOKENS.add(new Token("row+(", "en", new byte[]{0x16}));
    TOKENS.add(new Token("ligne+(", "fr", new byte[]{0x16}));
    TOKENS.add(new Token("*row(", "en", new byte[]{0x17}));
    TOKENS.add(new Token("*ligne(", "fr", new byte[]{0x17}));
    TOKENS.add(new Token("*row+(", "en", new byte[]{0x18}));
    TOKENS.add(new Token("*ligne+(", "fr", new byte[]{0x18}));
    TOKENS.add(new Token("max(", new byte[]{0x19}));
    TOKENS.add(new Token("min(", new byte[]{0x1A}));
    TOKENS.add(new Token("R>Pr(", new byte[]{0x1B}));
    TOKENS.add(new Token("R>Pθ(", new byte[]{0x1C}));
    TOKENS.add(new Token("P>Rx(", new byte[]{0x1D}));
    TOKENS.add(new Token("P>Ry(", new byte[]{0x1E}));
    TOKENS.add(new Token("median(", "en", new byte[]{0x1F}));
    TOKENS.add(new Token("médiane(", "fr", new byte[]{0x1F}));
    TOKENS.add(new Token("randM(", "en", new byte[]{0x20}));
    TOKENS.add(new Token("matAléat(", "fr", new byte[]{0x20}));
    TOKENS.add(new Token("mean(", "en", new byte[]{0x21}));
    TOKENS.add(new Token("moyenne(", "fr", new byte[]{0x21}));
    TOKENS.add(new Token("solve(", "en", new byte[]{0x22}));
    TOKENS.add(new Token("résoudre(", "fr", new byte[]{0x22}));
    TOKENS.add(new Token("seq(", "en", new byte[]{0x23}));
    TOKENS.add(new Token("suite(", "fr", new byte[]{0x23}));
    TOKENS.add(new Token("fnInt(", "en", new byte[]{0x24}));
    TOKENS.add(new Token("intégrFonct(", "fr", new byte[]{0x24}));
    TOKENS.add(new Token("nDeriv(", "en", new byte[]{0x25}));
    TOKENS.add(new Token("nbreDériv(", "fr", new byte[]{0x25}));
    TOKENS.add(new Token("fMin(", "en", new byte[]{0x27}));
    TOKENS.add(new Token("xfMin(", "fr", new byte[]{0x27}));
    TOKENS.add(new Token("fMax(", "en", new byte[]{0x28}));
    TOKENS.add(new Token("xfMax(", "fr", new byte[]{0x28}));
    // 0x29: bottom
    TOKENS.add(new Token("\"", new byte[]{0x2A}));
    TOKENS.add(new Token(",", new byte[]{0x2B}));
    TOKENS.add(new Token("&i;", new byte[]{0x2C}));
    // 0x2D: see 0x6F
    TOKENS.add(new Token("CubicReg", "en", new byte[]{0x2E}));
    TOKENS.add(new Token("RegCubique", "fr", new byte[]{0x2E}));
    TOKENS.add(new Token("QuartReg", "en", new byte[]{0x2F}));
    TOKENS.add(new Token("RegQuatre", "fr", new byte[]{0x2F}));
    // 0x30 - 0x39: bottom
    TOKENS.add(new Token(".", new byte[]{0x3A}));
    TOKENS.add(new Token("ᴇ", new byte[]{0x3B}));
    TOKENS.add(new Token(" or ", "en", new byte[]{0x3C}));
    TOKENS.add(new Token(" ou ", "fr", new byte[]{0x3C}));
    TOKENS.add(new Token(" xor ", "en", new byte[]{0x3D}));
    TOKENS.add(new Token(" ouExcl ", "fr", new byte[]{0x3D}));
    TOKENS.add(new Token(":", new byte[]{0x3E}));
    TOKENS.add(new Token(" and ", "en", new byte[]{0x40}));
    TOKENS.add(new Token(" et ", "fr", new byte[]{0x40}));
    // 0x41 - 0x5B: bottom
    for (int i = 0; i < 10; i++) {
      TOKENS.add(new Token("[" + (char) ('A' + i) + "]", new byte[]{0x5C, (byte) i}));
    }
    TOKENS.add(new Token("[", new byte[]{0x06}));
    for (int i = 0; i < 9; i++) {
      TOKENS.add(new Token("L" + (i + 1), new byte[]{0x5D, (byte) i}));
    }
    TOKENS.add(new Token("L0", new byte[]{0x5D, 0x09}));
    for (int i = 0; i < 9; i++) {
      TOKENS.add(new Token("Y" + (i + 1), new byte[]{0x5E, (byte) (0x10 + i)}));
    }
    TOKENS.add(new Token("Y0", new byte[]{0x5E, 0x19}));
    int j = 0;
    for (int i = 0; i < 12; i++) {
      if (i % 2 == 0) {
        j++;
        TOKENS.add(new Token("X" + j + "T", new byte[]{0x5E, (byte) (0x20 + i)}));
      }
      else {
        TOKENS.add(new Token("Y" + j + "T", new byte[]{0x5E, (byte) (0x20 + i)}));
      }
    }
    for (int i = 0; i < 6; i++) {
      TOKENS.add(new Token("r" + (i + 1), new byte[]{0x5E, (byte) (0x40 + i)}));
    }
    // 0x5E80 - 0x5E82: bottom
    TOKENS.add(new Token("prgm", new byte[]{0x5F}));
    for (int i = 0; i < 9; i++) {
      TOKENS.add(new Token("Pic" + (i + 1), "en", new byte[]{0x60, (byte) (0x00 + i)}));
      TOKENS.add(new Token("Img" + (i + 1), "fr", new byte[]{0x60, (byte) (0x00 + i)}));
    }
    TOKENS.add(new Token("Pic0", "en", new byte[]{0x60, 0x09}));
    TOKENS.add(new Token("Img0", "fr", new byte[]{0x60, 0x09}));
    for (int i = 0; i < 9; i++) {
      TOKENS.add(new Token("GDB" + (i + 1), "en", new byte[]{0x61, (byte) (0x00 + i)}));
      TOKENS.add(new Token("BDG" + (i + 1), "fr", new byte[]{0x61, (byte) (0x00 + i)}));
    }
    TOKENS.add(new Token("GDB0", "en", new byte[]{0x61, 0x09}));
    TOKENS.add(new Token("BDG0", "fr", new byte[]{0x61, 0x09}));
    TOKENS.add(new Token("RegEq", "en", new byte[]{0x62, 0x01}));
    TOKENS.add(new Token("EqReg", "fr", new byte[]{0x62, 0x01}));
    // 0x6202: bottom
    TOKENS.add(new Token("&xmean;", "en", new byte[]{0x62, 0x03}));
    TOKENS.add(new Token("&xmoy;", "fr", new byte[]{0x62, 0x03}));
    TOKENS.add(new Token("Σxy", new byte[]{0x62, 0x11}));
    TOKENS.add(new Token("Σx²", new byte[]{0x62, 0x05}));
    TOKENS.add(new Token("Σx", new byte[]{0x62, 0x04}));
    // 0x6206: see 0x6231
    TOKENS.add(new Token("σx", new byte[]{0x62, 0x07}));
    TOKENS.add(new Token("minX", new byte[]{0x62, 0x08}));
    TOKENS.add(new Token("maxX", new byte[]{0x62, 0x09}));
    TOKENS.add(new Token("minY", new byte[]{0x62, 0x0A}));
    TOKENS.add(new Token("maxY", new byte[]{0x62, 0x0B}));
    TOKENS.add(new Token("&ymean;", "en", new byte[]{0x62, 0x0C}));
    TOKENS.add(new Token("&ymoy;", "fr", new byte[]{0x62, 0x0C}));
    TOKENS.add(new Token("Σy²", new byte[]{0x62, 0x0E}));
    TOKENS.add(new Token("Σy", new byte[]{0x62, 0x0D}));
    TOKENS.add(new Token("Sy", new byte[]{0x62, 0x0F}));
    TOKENS.add(new Token("σy", new byte[]{0x62, 0x10}));
    // 0x6211: 0x6203
    // 0x6212: bottom
    // 0x6213: 0xF8
    TOKENS.add(new Token("Q1", new byte[]{0x62, 0x14}));
    TOKENS.add(new Token("Q3", new byte[]{0x62, 0x15}));
    // 0x6216 - 0x621A: bottom
    for (int i = 0; i < 3; i++) {
      TOKENS.add(new Token("x" + (i + 1), new byte[]{0x62, (byte) (0x1B + i)}));
      TOKENS.add(new Token("y" + (i + 1), new byte[]{0x62, (byte) (0x1E + i)}));
    }
    TOKENS.add(new Token("&n;", new byte[]{0x62, 0x21}));
    // 0x6222 - 0x6226: bottom
    TOKENS.add(new Token("df", new byte[]{0x62, 0x27}));
    TOKENS.add(new Token("&pcirc;", new byte[]{0x62, 0x28}));
    TOKENS.add(new Token("&pcirc1;", new byte[]{0x62, 0x29}));
    TOKENS.add(new Token("&pcirc2;", new byte[]{0x62, 0x2A}));
    TOKENS.add(new Token("&xmean1;", "en", new byte[]{0x62, 0x2B}));
    TOKENS.add(new Token("&xmoy1;", "fr", new byte[]{0x62, 0x2B}));
    TOKENS.add(new Token("Sx1", new byte[]{0x62, 0x2C}));
    TOKENS.add(new Token("n1", new byte[]{0x62, 0x2D}));
    TOKENS.add(new Token("&xmean2;", "en", new byte[]{0x62, 0x2E}));
    TOKENS.add(new Token("&xmoy2;", "fr", new byte[]{0x62, 0x2E}));
    TOKENS.add(new Token("Sx2", new byte[]{0x62, 0x2F}));
    TOKENS.add(new Token("n2", new byte[]{0x62, 0x30}));
    TOKENS.add(new Token("Sxp", new byte[]{0x62, 0x31}));
    TOKENS.add(new Token("Sx", new byte[]{0x62, 0x06}));
    TOKENS.add(new Token("lower", "en", new byte[]{0x62, 0x32}));
    TOKENS.add(new Token("inf", "fr", new byte[]{0x62, 0x32}));
    TOKENS.add(new Token("upper", "en", new byte[]{0x62, 0x33}));
    TOKENS.add(new Token("sup", "fr", new byte[]{0x62, 0x33}));
    // 0x6234: bottom
    TOKENS.add(new Token("r²", new byte[]{0x62, 0x35}));
    TOKENS.add(new Token("R²", new byte[]{0x62, 0x36}));
    TOKENS.add(new Token("ZXscl", "en", new byte[]{0x63, 0x00}));
    TOKENS.add(new Token("ZXpas", "fr", new byte[]{0x63, 0x00}));
    TOKENS.add(new Token("ZYscl", "en", new byte[]{0x63, 0x01}));
    TOKENS.add(new Token("ZYpas", "fr", new byte[]{0x63, 0x01}));
    TOKENS.add(new Token("Xscl", "en", new byte[]{0x63, 0x02}));
    TOKENS.add(new Token("Xgrad", "fr", new byte[]{0x63, 0x02}));
    TOKENS.add(new Token("Yscl", "en", new byte[]{0x63, 0x03}));
    TOKENS.add(new Token("Ygrad", "fr", new byte[]{0x63, 0x03}));
    TOKENS.add(new Token("u(nMin)", new byte[]{0x63, 0x04}));
    TOKENS.add(new Token("v(nMin)", new byte[]{0x63, 0x05}));
    TOKENS.add(new Token("Zu(nMin)", new byte[]{0x63, 0x08}));
    TOKENS.add(new Token("Zv(nMin)", new byte[]{0x63, 0x09}));
    TOKENS.add(new Token("Xmin", new byte[]{0x63, 0x0A}));
    TOKENS.add(new Token("Xmax", new byte[]{0x63, 0x0B}));
    TOKENS.add(new Token("Ymin", new byte[]{0x63, 0x0C}));
    TOKENS.add(new Token("Ymax", new byte[]{0x63, 0x0D}));
    TOKENS.add(new Token("Tmin", new byte[]{0x63, 0x0E}));
    TOKENS.add(new Token("Tmax", new byte[]{0x63, 0x0F}));
    TOKENS.add(new Token("θmin", new byte[]{0x63, 0x10}));
    TOKENS.add(new Token("θmax", new byte[]{0x63, 0x11}));
    TOKENS.add(new Token("ZXmin", new byte[]{0x63, 0x12}));
    TOKENS.add(new Token("ZXmax", new byte[]{0x63, 0x13}));
    TOKENS.add(new Token("ZYmin", new byte[]{0x63, 0x14}));
    TOKENS.add(new Token("ZYmax", new byte[]{0x63, 0x15}));
    TOKENS.add(new Token("Zθmin", new byte[]{0x63, 0x16}));
    TOKENS.add(new Token("Zθmax", new byte[]{0x63, 0x17}));
    TOKENS.add(new Token("ZTmin", new byte[]{0x63, 0x18}));
    TOKENS.add(new Token("ZTmax", new byte[]{0x63, 0x19}));
    TOKENS.add(new Token("TblStart", "en", new byte[]{0x63, 0x1A}));
    TOKENS.add(new Token("DébutTbl", "fr", new byte[]{0x63, 0x1A}));
    TOKENS.add(new Token("PlotStart", "en", new byte[]{0x63, 0x1B}));
    TOKENS.add(new Token("PointDébut", "fr", new byte[]{0x63, 0x1B}));
    TOKENS.add(new Token("ZPlotStart", "en", new byte[]{0x63, 0x1C}));
    TOKENS.add(new Token("ZPointDébut", "fr", new byte[]{0x63, 0x1C}));
    TOKENS.add(new Token("nMax", new byte[]{0x63, 0x1D}));
    TOKENS.add(new Token("ZnMax", new byte[]{0x63, 0x1E}));
    TOKENS.add(new Token("nMin", new byte[]{0x63, 0x1F}));
    TOKENS.add(new Token("ZnMin", new byte[]{0x63, 0x20}));
    TOKENS.add(new Token("ΔTbl", "en", new byte[]{0x63, 0x21}));
    TOKENS.add(new Token("PasTbl", "fr", new byte[]{0x63, 0x21}));
    TOKENS.add(new Token("Tstep", "en", new byte[]{0x63, 0x22}));
    TOKENS.add(new Token("Tpas", "fr", new byte[]{0x63, 0x22}));
    TOKENS.add(new Token("θstep", "en", new byte[]{0x63, 0x23}));
    TOKENS.add(new Token("θpas", "fr", new byte[]{0x63, 0x23}));
    TOKENS.add(new Token("ZTstep", "en", new byte[]{0x63, 0x24}));
    TOKENS.add(new Token("ZTpas", "fr", new byte[]{0x63, 0x24}));
    TOKENS.add(new Token("Zθstep", "en", new byte[]{0x63, 0x25}));
    TOKENS.add(new Token("Zθpas", "fr", new byte[]{0x63, 0x25}));
    TOKENS.add(new Token("ΔX", "en", new byte[]{0x63, 0x26}));
    TOKENS.add(new Token("PasX", "fr", new byte[]{0x63, 0x26}));
    TOKENS.add(new Token("ΔY", "en", new byte[]{0x63, 0x27}));
    TOKENS.add(new Token("PasY", "fr", new byte[]{0x63, 0x27}));
    TOKENS.add(new Token("XFact", new byte[]{0x63, 0x28}));
    TOKENS.add(new Token("YFact", new byte[]{0x63, 0x29}));
    TOKENS.add(new Token("TblInput", "en", new byte[]{0x63, 0x2A}));
    TOKENS.add(new Token("EntréeTbl", "fr", new byte[]{0x63, 0x2A}));
    TOKENS.add(new Token("&N;", new byte[]{0x63, 0x2B}));
    TOKENS.add(new Token("I%", new byte[]{0x63, 0x2C}));
    TOKENS.add(new Token("PV", "en", new byte[]{0x63, 0x2D}));
    TOKENS.add(new Token("ValAct", "fr", new byte[]{0x63, 0x2D}));
    TOKENS.add(new Token("PMT", new byte[]{0x63, 0x2E}));
    TOKENS.add(new Token("FV", "en", new byte[]{0x63, 0x2F}));
    TOKENS.add(new Token("ValAcq", "fr", new byte[]{0x63, 0x2F}));
    TOKENS.add(new Token("P/Y", "en", new byte[]{0x63, 0x30}));
    TOKENS.add(new Token("Ech/An", "fr", new byte[]{0x63, 0x30}));
    TOKENS.add(new Token("C/Y", "en", new byte[]{0x63, 0x31}));
    TOKENS.add(new Token("Pér/An", "fr", new byte[]{0x63, 0x31}));
    TOKENS.add(new Token("w(nMin)", new byte[]{0x63, 0x32}));
    TOKENS.add(new Token("Zw(nMin)", new byte[]{0x63, 0x33}));
    TOKENS.add(new Token("PlotStep", "en", new byte[]{0x63, 0x34}));
    TOKENS.add(new Token("GraphPas", "fr", new byte[]{0x63, 0x34}));
    TOKENS.add(new Token("ZPlotStep", "en", new byte[]{0x63, 0x35}));
    TOKENS.add(new Token("ZGraphPas", "fr", new byte[]{0x63, 0x35}));
    TOKENS.add(new Token("Xres", new byte[]{0x63, 0x36}));
    TOKENS.add(new Token("ZXres", new byte[]{0x63, 0x37}));
    TOKENS.add(new Token("Radian", new byte[]{0x64}));
    TOKENS.add(new Token("Degree", "en", new byte[]{0x65}));
    TOKENS.add(new Token("Degré", "fr", new byte[]{0x65}));
    TOKENS.add(new Token("Normal", new byte[]{0x66}));
    TOKENS.add(new Token("Sci", new byte[]{0x67}));
    TOKENS.add(new Token("Eng", "en", new byte[]{0x68}));
    TOKENS.add(new Token("Ing", "fr", new byte[]{0x68}));
    TOKENS.add(new Token("Float", "en", new byte[]{0x69}));
    TOKENS.add(new Token("Flottant", "fr", new byte[]{0x69}));
    TOKENS.add(new Token("=", new byte[]{0x6A}));
    // 0x6C: bottom
    TOKENS.add(new Token("<=", new byte[]{0x6D}));
    TOKENS.add(new Token("<", new byte[]{0x6B}));
    TOKENS.add(new Token(">=", new byte[]{0x6E}));
    TOKENS.add(new Token("!=", new byte[]{0x6F}));
    TOKENS.add(new Token("!", new byte[]{0x2D}));
    TOKENS.add(new Token("+", new byte[]{0x70}));
    TOKENS.add(new Token("-", new byte[]{0x71}));
    // 0x72: see 0xD2
    TOKENS.add(new Token("Fix ", "en", new byte[]{0x73}));
    TOKENS.add(new Token("Fixe ", "fr", new byte[]{0x73}));
    // 0x74: see 0xA6
    TOKENS.add(new Token("Full", "en", new byte[]{0x75}));
    TOKENS.add(new Token("PleinEcr", "fr", new byte[]{0x75}));
    // 0x76: see 0x97
    TOKENS.add(new Token("Param", new byte[]{0x77}));
    // 0x78: see 0xBB30
    // 0x79: see 0x7E00
    TOKENS.add(new Token("IndpntAuto", "en", new byte[]{0x7A}));
    TOKENS.add(new Token("ValeursAuto", "fr", new byte[]{0x7A}));
    TOKENS.add(new Token("IndpntAsk", "en", new byte[]{0x7B}));
    TOKENS.add(new Token("ValeursDem", "fr", new byte[]{0x7B}));
    TOKENS.add(new Token("DependAuto", "en", new byte[]{0x7C}));
    TOKENS.add(new Token("CalculsAuto", "fr", new byte[]{0x7C}));
    TOKENS.add(new Token("DependAsk", "en", new byte[]{0x7D}));
    TOKENS.add(new Token("CalculsDem", "fr", new byte[]{0x7D}));
    TOKENS.add(new Token("Sequential", "en", new byte[]{0x7E, 0x00}));
    TOKENS.add(new Token("Séquentiel", "fr", new byte[]{0x7E, 0x00}));
    TOKENS.add(new Token("Seq", "en", new byte[]{0x79}));
    TOKENS.add(new Token("Suite", "fr", new byte[]{0x79}));
    TOKENS.add(new Token("Simul", new byte[]{0x7E, 0x01}));
    TOKENS.add(new Token("PolarGC", "en", new byte[]{0x7E, 0x02}));
    TOKENS.add(new Token("CoordPol", "fr", new byte[]{0x7E, 0x02}));
    TOKENS.add(new Token("RectGC", "en", new byte[]{0x7E, 0x03}));
    TOKENS.add(new Token("CoordRect", "fr", new byte[]{0x7E, 0x03}));
    TOKENS.add(new Token("CoordOn", "en", new byte[]{0x7E, 0x04}));
    TOKENS.add(new Token("CoordAff", "fr", new byte[]{0x7E, 0x04}));
    TOKENS.add(new Token("CoordOff", "en", new byte[]{0x7E, 0x05}));
    TOKENS.add(new Token("CoordNAff", "fr", new byte[]{0x7E, 0x05}));
    TOKENS.add(new Token("Connected", "en", new byte[]{0x7E, 0x06}));
    TOKENS.add(new Token("Relié", "fr", new byte[]{0x7E, 0x06}));
    TOKENS.add(new Token("Dot", "en", new byte[]{0x7E, 0x07}));
    TOKENS.add(new Token("NonRelié", "fr", new byte[]{0x7E, 0x07}));
    TOKENS.add(new Token("AxesOn", "en", new byte[]{0x7E, 0x08}));
    TOKENS.add(new Token("AxesAff", "fr", new byte[]{0x7E, 0x08}));
    TOKENS.add(new Token("AxesOff", "en", new byte[]{0x7E, 0x09}));
    TOKENS.add(new Token("AxesNAff", "fr", new byte[]{0x7E, 0x09}));
    TOKENS.add(new Token("GridOn", "en", new byte[]{0x7E, 0x0A}));
    TOKENS.add(new Token("QuadAff", "fr", new byte[]{0x7E, 0x0A}));
    TOKENS.add(new Token("GridOff", "en", new byte[]{0x7E, 0x0B}));
    TOKENS.add(new Token("QuadNAff", "fr", new byte[]{0x7E, 0x0B}));
    TOKENS.add(new Token("LabelOn", "en", new byte[]{0x7E, 0x0C}));
    TOKENS.add(new Token("EtiqAff", "fr", new byte[]{0x7E, 0x0C}));
    TOKENS.add(new Token("LabelOff", "en", new byte[]{0x7E, 0x0D}));
    TOKENS.add(new Token("EtiqNAff", "fr", new byte[]{0x7E, 0x0D}));
    TOKENS.add(new Token("Web", "en", new byte[]{0x7E, 0x0E}));
    TOKENS.add(new Token("Toile", "fr", new byte[]{0x7E, 0x0E}));
    TOKENS.add(new Token("Time", "en", new byte[]{0x7E, 0x0F}));
    TOKENS.add(new Token("f(n)", "fr", new byte[]{0x7E, 0x0F}));
    TOKENS.add(new Token("uvAxes", new byte[]{0x7E, 0x10}));
    TOKENS.add(new Token("vwAxes", new byte[]{0x7E, 0x11}));
    TOKENS.add(new Token("uwAxes", new byte[]{0x7E, 0x12}));
    TOKENS.add(new Token("&square;", "en", new byte[]{0x7F}));
    TOKENS.add(new Token("&carré;", "fr", new byte[]{0x7F}));
    TOKENS.add(new Token("&cross;", "en", new byte[]{(byte) 0x80}));
    TOKENS.add(new Token("&croix;", "fr", new byte[]{(byte) 0x80}));
    TOKENS.add(new Token("·", new byte[]{(byte) 0x81}));
    TOKENS.add(new Token("*", new byte[]{(byte) 0x82}));
    TOKENS.add(new Token("/", new byte[]{(byte) 0x83}));
    TOKENS.add(new Token("Trace", new byte[]{(byte) 0x84}));
    TOKENS.add(new Token("ClrDraw", "en", new byte[]{(byte) 0x85}));
    TOKENS.add(new Token("EffDessin", "fr", new byte[]{(byte) 0x85}));
    TOKENS.add(new Token("ZStandard", new byte[]{(byte) 0x86}));
    TOKENS.add(new Token("ZTrig", new byte[]{(byte) 0x87}));
    TOKENS.add(new Token("ZBox", "en", new byte[]{(byte) 0x88}));
    TOKENS.add(new Token("Zboîte", "fr", new byte[]{(byte) 0x88}));
    TOKENS.add(new Token("Zoom In", "en", new byte[]{(byte) 0x89}));
    TOKENS.add(new Token("Zoom +", "fr", new byte[]{(byte) 0x89}));
    TOKENS.add(new Token("Zoom Out", "en", new byte[]{(byte) 0x8A}));
    TOKENS.add(new Token("Zoom -", "fr", new byte[]{(byte) 0x8A}));
    TOKENS.add(new Token("ZSquare", "en", new byte[]{(byte) 0x8B}));
    TOKENS.add(new Token("ZOrthonormal", "fr", new byte[]{(byte) 0x8B}));
    TOKENS.add(new Token("ZInteger", "en", new byte[]{(byte) 0x8C}));
    TOKENS.add(new Token("ZEntier", "fr", new byte[]{(byte) 0x8C}));
    TOKENS.add(new Token("ZPrevious", "en", new byte[]{(byte) 0x8D}));
    TOKENS.add(new Token("ZPrécédent", "fr", new byte[]{(byte) 0x8D}));
    TOKENS.add(new Token("ZDecimal", "en", new byte[]{(byte) 0x8E}));
    TOKENS.add(new Token("ZDécimal", "fr", new byte[]{(byte) 0x8E}));
    TOKENS.add(new Token("ZoomStat", new byte[]{(byte) 0x8F}));
    TOKENS.add(new Token("ZoomRcl", "en", new byte[]{(byte) 0x90}));
    TOKENS.add(new Token("ZoomRpl", "fr", new byte[]{(byte) 0x90}));
    TOKENS.add(new Token("PrintScreen", "en", new byte[]{(byte) 0x91}));
    TOKENS.add(new Token("ImprEcr", "fr", new byte[]{(byte) 0x91}));
    TOKENS.add(new Token("ZoomSto", "en", new byte[]{(byte) 0x92}));
    TOKENS.add(new Token("SauveFen", "fr", new byte[]{(byte) 0x92}));
    TOKENS.add(new Token("Text(", "en", new byte[]{(byte) 0x93}));
    TOKENS.add(new Token("Texte(", "fr", new byte[]{(byte) 0x93}));
    TOKENS.add(new Token(" nPr ", "en", new byte[]{(byte) 0x94}));
    TOKENS.add(new Token(" Arrangement ", "fr", new byte[]{(byte) 0x94}));
    TOKENS.add(new Token(" nCr ", "en", new byte[]{(byte) 0x95}));
    TOKENS.add(new Token(" Combinaison ", "fr", new byte[]{(byte) 0x95}));
    TOKENS.add(new Token("FnOn ", "en", new byte[]{(byte) 0x96}));
    TOKENS.add(new Token("FonctAff ", "fr", new byte[]{(byte) 0x96}));
    TOKENS.add(new Token("FnOff ", "en", new byte[]{(byte) 0x97}));
    TOKENS.add(new Token("FonctNAff ", "fr", new byte[]{(byte) 0x97}));
    TOKENS.add(new Token("Func", "en", new byte[]{0x76}));
    TOKENS.add(new Token("Fonct", "fr", new byte[]{0x76}));
    TOKENS.add(new Token("StorePic ", "en", new byte[]{(byte) 0x98}));
    TOKENS.add(new Token("SauveImage ", "fr", new byte[]{(byte) 0x98}));
    TOKENS.add(new Token("RecallPic ", "en", new byte[]{(byte) 0x99}));
    TOKENS.add(new Token("RappelImage ", "fr", new byte[]{(byte) 0x99}));
    TOKENS.add(new Token("StoreGDB ", "en", new byte[]{(byte) 0x9A}));
    TOKENS.add(new Token("SauveBDG ", "fr", new byte[]{(byte) 0x9A}));
    TOKENS.add(new Token("RecallGDB ", "en", new byte[]{(byte) 0x9B}));
    TOKENS.add(new Token("RappelBDG ", "fr", new byte[]{(byte) 0x9B}));
    TOKENS.add(new Token("Line(", "en", new byte[]{(byte) 0x9C}));
    TOKENS.add(new Token("Ligne(", "fr", new byte[]{(byte) 0x9C}));
    TOKENS.add(new Token("Vertical ", "en", new byte[]{(byte) 0x9D}));
    TOKENS.add(new Token("Verticale ", "fr", new byte[]{(byte) 0x9D}));
    TOKENS.add(new Token("Pt-On(", "en", new byte[]{(byte) 0x9E}));
    TOKENS.add(new Token("Pt-Aff(", "fr", new byte[]{(byte) 0x9E}));
    TOKENS.add(new Token("Pt-Off(", "en", new byte[]{(byte) 0x9F}));
    TOKENS.add(new Token("Pt-NAff(", "fr", new byte[]{(byte) 0x9F}));
    TOKENS.add(new Token("Pt-Change(", new byte[]{(byte) 0xA0}));
    TOKENS.add(new Token("Pxl-On(", "en", new byte[]{(byte) 0xA1}));
    TOKENS.add(new Token("Pxl-Aff(", "fr", new byte[]{(byte) 0xA1}));
    TOKENS.add(new Token("Pxl-Off(", "en", new byte[]{(byte) 0xA2}));
    TOKENS.add(new Token("Pxl-NAff(", "fr", new byte[]{(byte) 0xA2}));
    TOKENS.add(new Token("Pxl-Change(", "en", new byte[]{(byte) 0xA3}));
    TOKENS.add(new Token("Shade(", "en", new byte[]{(byte) 0xA4}));
    TOKENS.add(new Token("Ombre(", "fr", new byte[]{(byte) 0xA4}));
    TOKENS.add(new Token("Circle(", "en", new byte[]{(byte) 0xA5}));
    TOKENS.add(new Token("Cercle(", "fr", new byte[]{(byte) 0xA5}));
    TOKENS.add(new Token("Horizontal ", "en", new byte[]{(byte) 0xA6}));
    TOKENS.add(new Token("Horizontale ", "fr", new byte[]{(byte) 0xA6}));
    TOKENS.add(new Token("Horiz", new byte[]{0x74}));
    TOKENS.add(new Token("Tangent(", "en", new byte[]{(byte) 0xA7}));
    TOKENS.add(new Token("Tangente(", "fr", new byte[]{(byte) 0xA7}));
    TOKENS.add(new Token("DrawInv ", "en", new byte[]{(byte) 0xA8}));
    TOKENS.add(new Token("DessRecip ", "fr", new byte[]{(byte) 0xA8}));
    TOKENS.add(new Token("DrawF ", "en", new byte[]{(byte) 0xA9}));
    TOKENS.add(new Token("DessFonct ", "fr", new byte[]{(byte) 0xA9}));
    for (int i = 0; i < 9; i++) {
      TOKENS.add(new Token("Str" + (i + 1), "en", new byte[]{(byte) 0xAA, (byte) (0x00 + i)}));
      TOKENS.add(new Token("Chaîne" + (i + 1), "fr", new byte[]{(byte) 0xAA, (byte) (0x00 + i)}));
    }
    TOKENS.add(new Token("Str0", "en", new byte[]{(byte) 0xAA, 0x09}));
    TOKENS.add(new Token("Chaîne0", "fr", new byte[]{(byte) 0xAA, 0x09}));
    TOKENS.add(new Token("rand", "en", new byte[]{(byte) 0xAB}));
    TOKENS.add(new Token("NbrAléat", "fr", new byte[]{(byte) 0xAB}));
    TOKENS.add(new Token("π", new byte[]{(byte) 0xAC}));
    TOKENS.add(new Token("getKey", "en", new byte[]{(byte) 0xAD}));
    TOKENS.add(new Token("codeTouch(", "fr", new byte[]{(byte) 0xAD}));
    TOKENS.add(new Token("'", new byte[]{(byte) 0xAE}));
    TOKENS.add(new Token("?", new byte[]{(byte) 0xAF}));
    TOKENS.add(new Token("&-;", new byte[]{(byte) 0xB0}));
    TOKENS.add(new Token("int(", "en", new byte[]{(byte) 0xB1}));
    TOKENS.add(new Token("partEnt(", "fr", new byte[]{(byte) 0xB1}));
    TOKENS.add(new Token("abs(", new byte[]{(byte) 0xB2}));
    TOKENS.add(new Token("det(", "en", new byte[]{(byte) 0xB3}));
    TOKENS.add(new Token("dét(", "fr", new byte[]{(byte) 0xB3}));
    TOKENS.add(new Token("identity(", "en", new byte[]{(byte) 0xB4}));
    TOKENS.add(new Token("identité(", "fr", new byte[]{(byte) 0xB4}));
    TOKENS.add(new Token("dim(", new byte[]{(byte) 0xB5}));
    TOKENS.add(new Token("sum(", "en", new byte[]{(byte) 0xB6}));
    TOKENS.add(new Token("somme(", "fr", new byte[]{(byte) 0xB6}));
    TOKENS.add(new Token("prod(", new byte[]{(byte) 0xB7}));
    TOKENS.add(new Token("not(", "en", new byte[]{(byte) 0xB8}));
    TOKENS.add(new Token("non(", "fr", new byte[]{(byte) 0xB8}));
    TOKENS.add(new Token("iPart(", "en", new byte[]{(byte) 0xB9}));
    TOKENS.add(new Token("ent(", "fr", new byte[]{(byte) 0xB9}));
    TOKENS.add(new Token("fPart(", "en", new byte[]{(byte) 0xBA}));
    TOKENS.add(new Token("partDéc(", "fr", new byte[]{(byte) 0xBA}));
    TOKENS.add(new Token("npv(", "en", new byte[]{(byte) 0xBB, 0x00}));
    TOKENS.add(new Token("vActNet(", "fr", new byte[]{(byte) 0xBB, 0x00}));
    TOKENS.add(new Token("irr(", "en", new byte[]{(byte) 0xBB, 0x01}));
    TOKENS.add(new Token("tauxRi(", "fr", new byte[]{(byte) 0xBB, 0x01}));
    TOKENS.add(new Token("bal(", "en", new byte[]{(byte) 0xBB, 0x02}));
    TOKENS.add(new Token("paSolde(", "fr", new byte[]{(byte) 0xBB, 0x02}));
    TOKENS.add(new Token("ΣPrn(", "en", new byte[]{(byte) 0xBB, 0x03}));
    TOKENS.add(new Token("paSomPrinc(", "fr", new byte[]{(byte) 0xBB, 0x03}));
    TOKENS.add(new Token("ΣInt(", "en", new byte[]{(byte) 0xBB, 0x04}));
    TOKENS.add(new Token("paInt(", "fr", new byte[]{(byte) 0xBB, 0x04}));
    TOKENS.add(new Token(">Nom(", new byte[]{(byte) 0xBB, 0x05}));
    TOKENS.add(new Token(">Eff(", new byte[]{(byte) 0xBB, 0x06}));
    TOKENS.add(new Token("dbd(", "en", new byte[]{(byte) 0xBB, 0x07}));
    TOKENS.add(new Token("jed(", "fr", new byte[]{(byte) 0xBB, 0x07}));
    TOKENS.add(new Token("lcm(", "en", new byte[]{(byte) 0xBB, 0x08}));
    TOKENS.add(new Token("ppcm(", "fr", new byte[]{(byte) 0xBB, 0x08}));
    TOKENS.add(new Token("gcd(", "en", new byte[]{(byte) 0xBB, 0x09}));
    TOKENS.add(new Token("pgcd(", "fr", new byte[]{(byte) 0xBB, 0x09}));
    TOKENS.add(new Token("randInt(", "en", new byte[]{(byte) 0xBB, 0x0A}));
    TOKENS.add(new Token("entAléat(", "fr", new byte[]{(byte) 0xBB, 0x0A}));
    TOKENS.add(new Token("randBin(", "en", new byte[]{(byte) 0xBB, 0x0B}));
    TOKENS.add(new Token("BinAléat(", "fr", new byte[]{(byte) 0xBB, 0x0B}));
    TOKENS.add(new Token("sub(", "en", new byte[]{(byte) 0xBB, 0x0C}));
    TOKENS.add(new Token("sous-Chaîne(", "fr", new byte[]{(byte) 0xBB, 0x0C}));
    TOKENS.add(new Token("stdDev(", "en", new byte[]{(byte) 0xBB, 0x0D}));
    TOKENS.add(new Token("ecart-type(", "fr", new byte[]{(byte) 0xBB, 0x0D}));
    TOKENS.add(new Token("variance(", new byte[]{(byte) 0xBB, 0x0E}));
    TOKENS.add(new Token("inString(", "en", new byte[]{(byte) 0xBB, 0x0F}));
    TOKENS.add(new Token("carChaîne(", "fr", new byte[]{(byte) 0xBB, 0x0F}));
    TOKENS.add(new Token("normalcdf(", "en", new byte[]{(byte) 0xBB, 0x10}));
    TOKENS.add(new Token("normalFRép(", "fr", new byte[]{(byte) 0xBB, 0x10}));
    TOKENS.add(new Token("invNorm(", "en", new byte[]{(byte) 0xBB, 0x11}));
    TOKENS.add(new Token("FracNormale(", "fr", new byte[]{(byte) 0xBB, 0x11}));
    TOKENS.add(new Token("tcdf(", "en", new byte[]{(byte) 0xBB, 0x12}));
    TOKENS.add(new Token("studentFRép(", "fr", new byte[]{(byte) 0xBB, 0x12}));
    TOKENS.add(new Token("χ²cdf(", "en", new byte[]{(byte) 0xBB, 0x13}));
    TOKENS.add(new Token("χ²FRép(", "fr", new byte[]{(byte) 0xBB, 0x13}));
    TOKENS.add(new Token("Ϝcdf(", "en", new byte[]{(byte) 0xBB, 0x14}));
    TOKENS.add(new Token("ϜFRép(", "fr", new byte[]{(byte) 0xBB, 0x14}));
    TOKENS.add(new Token("binompdf(", "en", new byte[]{(byte) 0xBB, 0x15}));
    TOKENS.add(new Token("binomFdp(", "fr", new byte[]{(byte) 0xBB, 0x15}));
    TOKENS.add(new Token("binomcdf(", "en", new byte[]{(byte) 0xBB, 0x16}));
    TOKENS.add(new Token("binomFRép(", "fr", new byte[]{(byte) 0xBB, 0x16}));
    TOKENS.add(new Token("poissonpdf(", "en", new byte[]{(byte) 0xBB, 0x17}));
    TOKENS.add(new Token("poissonFdp(", "fr", new byte[]{(byte) 0xBB, 0x17}));
    TOKENS.add(new Token("poissoncdf(", "en", new byte[]{(byte) 0xBB, 0x18}));
    TOKENS.add(new Token("poissonFRép(", "fr", new byte[]{(byte) 0xBB, 0x18}));
    TOKENS.add(new Token("geometpdf(", "en", new byte[]{(byte) 0xBB, 0x19}));
    TOKENS.add(new Token("géomtFdp(", "fr", new byte[]{(byte) 0xBB, 0x19}));
    TOKENS.add(new Token("geometcdf(", "en", new byte[]{(byte) 0xBB, 0x1A}));
    TOKENS.add(new Token("géomtFRép(", "fr", new byte[]{(byte) 0xBB, 0x1A}));
    TOKENS.add(new Token("normalpdf(", "en", new byte[]{(byte) 0xBB, 0x1B}));
    TOKENS.add(new Token("normalFdp(", "fr", new byte[]{(byte) 0xBB, 0x1B}));
    TOKENS.add(new Token("tpdf(", "en", new byte[]{(byte) 0xBB, 0x1C}));
    TOKENS.add(new Token("studentFdp(", "fr", new byte[]{(byte) 0xBB, 0x1C}));
    TOKENS.add(new Token("χ²pdf(", "en", new byte[]{(byte) 0xBB, 0x1D}));
    TOKENS.add(new Token("χ²Fdp(", "fr", new byte[]{(byte) 0xBB, 0x1D}));
    TOKENS.add(new Token("Ϝpdf(", "en", new byte[]{(byte) 0xBB, 0x1E}));
    TOKENS.add(new Token("ϜFdp(", "fr", new byte[]{(byte) 0xBB, 0x1E}));
    TOKENS.add(new Token("randNorm(", "en", new byte[]{(byte) 0xBB, 0x1F}));
    TOKENS.add(new Token("normAléat(", "fr", new byte[]{(byte) 0xBB, 0x1F}));
    TOKENS.add(new Token("tvm_Pmt", "en", new byte[]{(byte) 0xBB, 0x20}));
    TOKENS.add(new Token("vat_Pmt", "fr", new byte[]{(byte) 0xBB, 0x20}));
    TOKENS.add(new Token("tvm_I%", "en", new byte[]{(byte) 0xBB, 0x21}));
    TOKENS.add(new Token("vat_I%", "fr", new byte[]{(byte) 0xBB, 0x21}));
    TOKENS.add(new Token("tvm_PV", "en", new byte[]{(byte) 0xBB, 0x22}));
    TOKENS.add(new Token("vat_Vact", "fr", new byte[]{(byte) 0xBB, 0x22}));
    TOKENS.add(new Token("tvm_N", "en", new byte[]{(byte) 0xBB, 0x23}));
    TOKENS.add(new Token("vat_N", "fr", new byte[]{(byte) 0xBB, 0x23}));
    TOKENS.add(new Token("tvm_FV", "en", new byte[]{(byte) 0xBB, 0x24}));
    TOKENS.add(new Token("vat_Vacq", "fr", new byte[]{(byte) 0xBB, 0x24}));
    TOKENS.add(new Token("conj(", new byte[]{(byte) 0xBB, 0x25}));
    TOKENS.add(new Token("real(", "en", new byte[]{(byte) 0xBB, 0x26}));
    TOKENS.add(new Token("réel(", "fr", new byte[]{(byte) 0xBB, 0x26}));
    TOKENS.add(new Token("imag(", new byte[]{(byte) 0xBB, 0x27}));
    TOKENS.add(new Token("angle(", "en", new byte[]{(byte) 0xBB, 0x28}));
    TOKENS.add(new Token("argument(", "fr", new byte[]{(byte) 0xBB, 0x28}));
    TOKENS.add(new Token("cumSum(", "en", new byte[]{(byte) 0xBB, 0x29}));
    TOKENS.add(new Token("somCum(", "fr", new byte[]{(byte) 0xBB, 0x29}));
    TOKENS.add(new Token("expr(", new byte[]{(byte) 0xBB, 0x2A}));
    TOKENS.add(new Token("length(", "en", new byte[]{(byte) 0xBB, 0x2B}));
    TOKENS.add(new Token("longueur(", "fr", new byte[]{(byte) 0xBB, 0x2B}));
    TOKENS.add(new Token("ΔList(", "en", new byte[]{(byte) 0xBB, 0x2C}));
    TOKENS.add(new Token("ΔListe(", "fr", new byte[]{(byte) 0xBB, 0x2C}));
    TOKENS.add(new Token("ref(", "en", new byte[]{(byte) 0xBB, 0x2D}));
    TOKENS.add(new Token("Gauss(", "fr", new byte[]{(byte) 0xBB, 0x2D}));
    TOKENS.add(new Token("rref(", "en", new byte[]{(byte) 0xBB, 0x2E}));
    TOKENS.add(new Token("Gauss-Jordan(", "fr", new byte[]{(byte) 0xBB, 0x2E}));
    TOKENS.add(new Token(">Rect", new byte[]{(byte) 0xBB, 0x2F}));
    TOKENS.add(new Token(">Polar", "en", new byte[]{(byte) 0xBB, 0x30}));
    TOKENS.add(new Token(">Polaire", "fr", new byte[]{(byte) 0xBB, 0x30}));
    TOKENS.add(new Token("Polar", "en", new byte[]{0x78}));
    TOKENS.add(new Token("Polaire", "fr", new byte[]{0x78}));
    TOKENS.add(new Token("&exp;", new byte[]{(byte) 0xBB, 0x31}));
    TOKENS.add(new Token("SinReg ", "en", new byte[]{(byte) 0xBB, 0x32}));
    TOKENS.add(new Token("RegSin ", "fr", new byte[]{(byte) 0xBB, 0x32}));
    TOKENS.add(new Token("Logistic ", "en", new byte[]{(byte) 0xBB, 0x33}));
    TOKENS.add(new Token("Logistique ", "fr", new byte[]{(byte) 0xBB, 0x33}));
    TOKENS.add(new Token("LinRegTTest ", "en", new byte[]{(byte) 0xBB, 0x34}));
    TOKENS.add(new Token("RegLinTTest ", "fr", new byte[]{(byte) 0xBB, 0x34}));
    TOKENS.add(new Token("ShadeNorm(", "en", new byte[]{(byte) 0xBB, 0x35}));
    TOKENS.add(new Token("OmbreNorm(", "fr", new byte[]{(byte) 0xBB, 0x35}));
    TOKENS.add(new Token("Shade_t(", "en", new byte[]{(byte) 0xBB, 0x36}));
    TOKENS.add(new Token("Ombre_t(", "fr", new byte[]{(byte) 0xBB, 0x36}));
    TOKENS.add(new Token("Shadeχ²(", "en", new byte[]{(byte) 0xBB, 0x37}));
    TOKENS.add(new Token("Ombreχ²(", "fr", new byte[]{(byte) 0xBB, 0x37}));
    TOKENS.add(new Token("ShadeϜ(", "en", new byte[]{(byte) 0xBB, 0x38}));
    TOKENS.add(new Token("OmbreϜ(", "fr", new byte[]{(byte) 0xBB, 0x38}));
    TOKENS.add(new Token("Matr>list(", "en", new byte[]{(byte) 0xBB, 0x39}));
    TOKENS.add(new Token("Matr>liste(", "fr", new byte[]{(byte) 0xBB, 0x39}));
    TOKENS.add(new Token("List>matr(", "en", new byte[]{(byte) 0xBB, 0x3A}));
    TOKENS.add(new Token("Liste>matr(", "fr", new byte[]{(byte) 0xBB, 0x3A}));
    TOKENS.add(new Token("Z-Test(", new byte[]{(byte) 0xBB, 0x3B}));
    TOKENS.add(new Token("T-Test ", new byte[]{(byte) 0xBB, 0x3C}));
    TOKENS.add(new Token("2-SampZTest(", "en", new byte[]{(byte) 0xBB, 0x3D}));
    TOKENS.add(new Token("2-CompZTest(", "fr", new byte[]{(byte) 0xBB, 0x3D}));
    TOKENS.add(new Token("1-PropZTest(", new byte[]{(byte) 0xBB, 0x3E}));
    TOKENS.add(new Token("2-PropZTest(", new byte[]{(byte) 0xBB, 0x3F}));
    TOKENS.add(new Token("χ²-Test(", new byte[]{(byte) 0xBB, 0x40}));
    TOKENS.add(new Token("ZInterval ", "en", new byte[]{(byte) 0xBB, 0x41}));
    TOKENS.add(new Token("ZIntConf ", "fr", new byte[]{(byte) 0xBB, 0x41}));
    TOKENS.add(new Token("2-SampZInt(", "en", new byte[]{(byte) 0xBB, 0x42}));
    TOKENS.add(new Token("2-CompZInt(", "fr", new byte[]{(byte) 0xBB, 0x42}));
    TOKENS.add(new Token("1-PropZInt(", new byte[]{(byte) 0xBB, 0x43}));
    TOKENS.add(new Token("2-PropZInt(", new byte[]{(byte) 0xBB, 0x44}));
    TOKENS.add(new Token("GraphStyle(", new byte[]{(byte) 0xBB, 0x45}));
    TOKENS.add(new Token("2-SampTTest ", "en", new byte[]{(byte) 0xBB, 0x46}));
    TOKENS.add(new Token("2-CompTTest ", "fr", new byte[]{(byte) 0xBB, 0x46}));
    TOKENS.add(new Token("2-SampϜTest ", "en", new byte[]{(byte) 0xBB, 0x47}));
    TOKENS.add(new Token("2-CompϜTest ", "fr", new byte[]{(byte) 0xBB, 0x47}));
    TOKENS.add(new Token("TInterval ", "en", new byte[]{(byte) 0xBB, 0x48}));
    TOKENS.add(new Token("TIntConf ", "fr", new byte[]{(byte) 0xBB, 0x48}));
    TOKENS.add(new Token("2-SampTInt ", "en", new byte[]{(byte) 0xBB, 0x49}));
    TOKENS.add(new Token("2-CompTInt ", "fr", new byte[]{(byte) 0xBB, 0x49}));
    TOKENS.add(new Token("SetUpEditor ", "en", new byte[]{(byte) 0xBB, 0x4A}));
    TOKENS.add(new Token("ListesDéfaut ", "fr", new byte[]{(byte) 0xBB, 0x4A}));
    TOKENS.add(new Token("Pmt_End", "en", new byte[]{(byte) 0xBB, 0x4B}));
    TOKENS.add(new Token("Pmt_Fin", "fr", new byte[]{(byte) 0xBB, 0x4B}));
    TOKENS.add(new Token("Pmt_Bgn", "en", new byte[]{(byte) 0xBB, 0x4C}));
    TOKENS.add(new Token("Pmt_Déb", "fr", new byte[]{(byte) 0xBB, 0x4C}));
    TOKENS.add(new Token("Real", "en", new byte[]{(byte) 0xBB, 0x4D}));
    TOKENS.add(new Token("Réel", "fr", new byte[]{(byte) 0xBB, 0x4D}));
    TOKENS.add(new Token("re^θi", new byte[]{(byte) 0xBB, 0x4E}));
    TOKENS.add(new Token("a+bi", new byte[]{(byte) 0xBB, 0x4F}));
    TOKENS.add(new Token("ExprOn", "en", new byte[]{(byte) 0xBB, 0x50}));
    TOKENS.add(new Token("ExprAff", "fr", new byte[]{(byte) 0xBB, 0x50}));
    TOKENS.add(new Token("ExprOff", "en", new byte[]{(byte) 0xBB, 0x51}));
    TOKENS.add(new Token("ExprNAff", "fr", new byte[]{(byte) 0xBB, 0x51}));
    TOKENS.add(new Token("ClrAllLists", "en", new byte[]{(byte) 0xBB, 0x52}));
    TOKENS.add(new Token("EffToutListes", "fr", new byte[]{(byte) 0xBB, 0x52}));
    TOKENS.add(new Token("GetCalc(", "en", new byte[]{(byte) 0xBB, 0x53}));
    TOKENS.add(new Token("CaptVar(", "fr", new byte[]{(byte) 0xBB, 0x53}));
    TOKENS.add(new Token("DelVar ", "en", new byte[]{(byte) 0xBB, 0x54}));
    TOKENS.add(new Token("EffVar ", "fr", new byte[]{(byte) 0xBB, 0x54}));
    TOKENS.add(new Token("Equ>String(", "en", new byte[]{(byte) 0xBB, 0x55}));
    TOKENS.add(new Token("Equ>Chaîne(", "fr", new byte[]{(byte) 0xBB, 0x55}));
    TOKENS.add(new Token("String>Equ(", "en", new byte[]{(byte) 0xBB, 0x56}));
    TOKENS.add(new Token("Chaîne>Equ(", "fr", new byte[]{(byte) 0xBB, 0x56}));
    TOKENS.add(new Token("Clear Entries", "en", new byte[]{(byte) 0xBB, 0x57}));
    TOKENS.add(new Token("Efface entrées", "fr", new byte[]{(byte) 0xBB, 0x57}));
    TOKENS.add(new Token("Select(", "en", new byte[]{(byte) 0xBB, 0x58}));
    TOKENS.add(new Token("Sélect(", "fr", new byte[]{(byte) 0xBB, 0x58}));
    TOKENS.add(new Token("ANOVA(", "en", new byte[]{(byte) 0xBB, 0x59}));
    TOKENS.add(new Token("ANUVA(", "fr", new byte[]{(byte) 0xBB, 0x59}));
    TOKENS.add(new Token("ModBoxplot", "en", new byte[]{(byte) 0xBB, 0x5A}));
    TOKENS.add(new Token("GraphBoitMoust", "fr", new byte[]{(byte) 0xBB, 0x5A}));
    TOKENS.add(new Token("NormProbPlot", "en", new byte[]{(byte) 0xBB, 0x5B}));
    TOKENS.add(new Token("GraphProbNorm", "fr", new byte[]{(byte) 0xBB, 0x5B}));
    TOKENS.add(new Token("G_T", new byte[]{(byte) 0xBB, 0x64}));
    TOKENS.add(new Token("ZoomFit", "en", new byte[]{(byte) 0xBB, 0x65}));
    TOKENS.add(new Token("ZMinMax", "fr", new byte[]{(byte) 0xBB, 0x65}));
    TOKENS.add(new Token("DiagnosticOn", "en", new byte[]{(byte) 0xBB, 0x66}));
    TOKENS.add(new Token("CorrelAff", "fr", new byte[]{(byte) 0xBB, 0x66}));
    TOKENS.add(new Token("DiagnosticOff", "en", new byte[]{(byte) 0xBB, 0x67}));
    TOKENS.add(new Token("CorrelNAff", "fr", new byte[]{(byte) 0xBB, 0x67}));
    TOKENS.add(new Token("Archive ", new byte[]{(byte) 0xBB, 0x68}));
    TOKENS.add(new Token("UnArchive ", "en", new byte[]{(byte) 0xBB, 0x69}));
    TOKENS.add(new Token("Désarchive ", "fr", new byte[]{(byte) 0xBB, 0x69}));
    TOKENS.add(new Token("Asm(", new byte[]{(byte) 0xBB, 0x6A}));
    TOKENS.add(new Token("AsmComp(", new byte[]{(byte) 0xBB, 0x6B}));
    TOKENS.add(new Token("AsmPrgm ", new byte[]{(byte) 0xBB, 0x6C}));
    TOKENS.add(new Token("Á", new byte[]{(byte) 0xBB, 0x6E}));
    TOKENS.add(new Token("À", new byte[]{(byte) 0xBB, 0x6F}));
    TOKENS.add(new Token("Â", new byte[]{(byte) 0xBB, 0x70}));
    TOKENS.add(new Token("Ä", new byte[]{(byte) 0xBB, 0x71}));
    TOKENS.add(new Token("á", new byte[]{(byte) 0xBB, 0x72}));
    TOKENS.add(new Token("à", new byte[]{(byte) 0xBB, 0x73}));
    TOKENS.add(new Token("â", new byte[]{(byte) 0xBB, 0x74}));
    TOKENS.add(new Token("ä", new byte[]{(byte) 0xBB, 0x75}));
    TOKENS.add(new Token("É", new byte[]{(byte) 0xBB, 0x76}));
    TOKENS.add(new Token("È", new byte[]{(byte) 0xBB, 0x77}));
    TOKENS.add(new Token("Ê", new byte[]{(byte) 0xBB, 0x78}));
    TOKENS.add(new Token("Ë", new byte[]{(byte) 0xBB, 0x79}));
    TOKENS.add(new Token("é", new byte[]{(byte) 0xBB, 0x7A}));
    TOKENS.add(new Token("è", new byte[]{(byte) 0xBB, 0x7B}));
    TOKENS.add(new Token("ê", new byte[]{(byte) 0xBB, 0x7C}));
    TOKENS.add(new Token("ë", new byte[]{(byte) 0xBB, 0x7D}));
    TOKENS.add(new Token("Ì", new byte[]{(byte) 0xBB, 0x7F}));
    TOKENS.add(new Token("Î", new byte[]{(byte) 0xBB, (byte) 0x80}));
    TOKENS.add(new Token("Ï", new byte[]{(byte) 0xBB, (byte) 0x81}));
    TOKENS.add(new Token("í", new byte[]{(byte) 0xBB, (byte) 0x82}));
    TOKENS.add(new Token("ì", new byte[]{(byte) 0xBB, (byte) 0x83}));
    TOKENS.add(new Token("î", new byte[]{(byte) 0xBB, (byte) 0x84}));
    TOKENS.add(new Token("ï", new byte[]{(byte) 0xBB, (byte) 0x85}));
    TOKENS.add(new Token("Ó", new byte[]{(byte) 0xBB, (byte) 0x86}));
    TOKENS.add(new Token("Ò", new byte[]{(byte) 0xBB, (byte) 0x87}));
    TOKENS.add(new Token("Ô", new byte[]{(byte) 0xBB, (byte) 0x88}));
    TOKENS.add(new Token("Ö", new byte[]{(byte) 0xBB, (byte) 0x89}));
    TOKENS.add(new Token("ó", new byte[]{(byte) 0xBB, (byte) 0x8A}));
    TOKENS.add(new Token("ò", new byte[]{(byte) 0xBB, (byte) 0x8B}));
    TOKENS.add(new Token("ô", new byte[]{(byte) 0xBB, (byte) 0x8C}));
    TOKENS.add(new Token("ö", new byte[]{(byte) 0xBB, (byte) 0x8D}));
    TOKENS.add(new Token("Ú", new byte[]{(byte) 0xBB, (byte) 0x8E}));
    TOKENS.add(new Token("Ù", new byte[]{(byte) 0xBB, (byte) 0x8F}));
    TOKENS.add(new Token("Û", new byte[]{(byte) 0xBB, (byte) 0x90}));
    TOKENS.add(new Token("Ü", new byte[]{(byte) 0xBB, (byte) 0x91}));
    TOKENS.add(new Token("ú", new byte[]{(byte) 0xBB, (byte) 0x92}));
    TOKENS.add(new Token("ù", new byte[]{(byte) 0xBB, (byte) 0x93}));
    TOKENS.add(new Token("û", new byte[]{(byte) 0xBB, (byte) 0x94}));
    TOKENS.add(new Token("ü", new byte[]{(byte) 0xBB, (byte) 0x95}));
    TOKENS.add(new Token("Ç", new byte[]{(byte) 0xBB, (byte) 0x96}));
    TOKENS.add(new Token("ç", new byte[]{(byte) 0xBB, (byte) 0x97}));
    TOKENS.add(new Token("Ñ", new byte[]{(byte) 0xBB, (byte) 0x98}));
    TOKENS.add(new Token("ñ", new byte[]{(byte) 0xBB, (byte) 0x99}));
    TOKENS.add(new Token("¿", new byte[]{(byte) 0xBB, (byte) 0x9D}));
    TOKENS.add(new Token("¡", new byte[]{(byte) 0xBB, (byte) 0x9E}));
    TOKENS.add(new Token("α", new byte[]{(byte) 0xBB, (byte) 0x9F}));
    TOKENS.add(new Token("β", new byte[]{(byte) 0xBB, (byte) 0xA0}));
    TOKENS.add(new Token("Δ", new byte[]{(byte) 0xBB, (byte) 0xA2}));
    TOKENS.add(new Token("δ", new byte[]{(byte) 0xBB, (byte) 0xA3}));
    TOKENS.add(new Token("ε", new byte[]{(byte) 0xBB, (byte) 0xA4}));
    TOKENS.add(new Token("λ", new byte[]{(byte) 0xBB, (byte) 0xA5}));
    // Micro sign
    TOKENS.add(new Token("µ", new byte[]{(byte) 0xBB, (byte) 0xA6}));
    // Mu greek letter
    TOKENS.add(new Token("μ", new byte[]{(byte) 0xBB, (byte) 0xA6}));
    TOKENS.add(new Token("ρ", new byte[]{(byte) 0xBB, (byte) 0xA8}));
    TOKENS.add(new Token("Σ", new byte[]{(byte) 0xBB, (byte) 0xA9}));
    TOKENS.add(new Token("φ", new byte[]{(byte) 0xBB, (byte) 0xAB}));
    TOKENS.add(new Token("Ω", new byte[]{(byte) 0xBB, (byte) 0xAC}));
    // 0xBBB0 - 0xBBCA: bottom
    TOKENS.add(new Token("σ", new byte[]{(byte) 0xBB, (byte) 0xCB}));
    TOKENS.add(new Token("τ", new byte[]{(byte) 0xBB, (byte) 0xCC}));
    TOKENS.add(new Token("Í", new byte[]{(byte) 0xBB, (byte) 0xCD}));
    TOKENS.add(new Token("√(", new byte[]{(byte) 0xBC}));
    TOKENS.add(new Token("sqrt(", "en", new byte[]{(byte) 0xBC}));
    TOKENS.add(new Token("racine(", "fr", new byte[]{(byte) 0xBC}));
    TOKENS.add(new Token("∛(", new byte[]{(byte) 0xBD}));
    TOKENS.add(new Token("cbrt(", "en", new byte[]{(byte) 0xBD}));
    TOKENS.add(new Token("racine3(", "fr", new byte[]{(byte) 0xBD}));
    TOKENS.add(new Token("ln(", new byte[]{(byte) 0xBE}));
    TOKENS.add(new Token("exp(", new byte[]{(byte) 0xBF}));
    TOKENS.add(new Token("log(", new byte[]{(byte) 0xC0}));
    TOKENS.add(new Token("exp10(", new byte[]{(byte) 0xC1}));
    TOKENS.add(new Token("sin(", new byte[]{(byte) 0xC2}));
    TOKENS.add(new Token("Arcsin(", new byte[]{(byte) 0xC3}));
    TOKENS.add(new Token("cos(", new byte[]{(byte) 0xC4}));
    TOKENS.add(new Token("Arccos(", new byte[]{(byte) 0xC5}));
    TOKENS.add(new Token("tan(", new byte[]{(byte) 0xC6}));
    TOKENS.add(new Token("Arctan(", new byte[]{(byte) 0xC7}));
    TOKENS.add(new Token("sinh(", "en", new byte[]{(byte) 0xC8}));
    TOKENS.add(new Token("sh(", "fr", new byte[]{(byte) 0xC8}));
    TOKENS.add(new Token("Arcsinh(", "en", new byte[]{(byte) 0xC9}));
    TOKENS.add(new Token("Argsh(", "fr", new byte[]{(byte) 0xC9}));
    TOKENS.add(new Token("cosh(", "en", new byte[]{(byte) 0xCA}));
    TOKENS.add(new Token("ch(", "fr", new byte[]{(byte) 0xCA}));
    TOKENS.add(new Token("Arccosh(", "en", new byte[]{(byte) 0xCB}));
    TOKENS.add(new Token("Argch(", "fr", new byte[]{(byte) 0xCB}));
    TOKENS.add(new Token("tanh(", "en", new byte[]{(byte) 0xCC}));
    TOKENS.add(new Token("th(", "fr", new byte[]{(byte) 0xCC}));
    TOKENS.add(new Token("Arctanh(", "en", new byte[]{(byte) 0xCD}));
    TOKENS.add(new Token("Argth(", "fr", new byte[]{(byte) 0xCD}));
    TOKENS.add(new Token("If ", new byte[]{(byte) 0xCE}));
    TOKENS.add(new Token("Then", new byte[]{(byte) 0xCF}));
    TOKENS.add(new Token("Else", new byte[]{(byte) 0xD0}));
    TOKENS.add(new Token("While ", new byte[]{(byte) 0xD1}));
    TOKENS.add(new Token("Repeat ", new byte[]{(byte) 0xD2}));
    TOKENS.add(new Token("Ans", "en", new byte[]{0x72}));
    TOKENS.add(new Token("Rep", new byte[]{0x72}));
    TOKENS.add(new Token("For(", new byte[]{(byte) 0xD3}));
    TOKENS.add(new Token("End", new byte[]{(byte) 0xD4}));
    TOKENS.add(new Token("Return", new byte[]{(byte) 0xD5}));
    TOKENS.add(new Token("Lbl ", new byte[]{(byte) 0xD6}));
    TOKENS.add(new Token("Goto ", new byte[]{(byte) 0xD7}));
    TOKENS.add(new Token("Pause ", new byte[]{(byte) 0xD8}));
    TOKENS.add(new Token("Stop", new byte[]{(byte) 0xD9}));
    TOKENS.add(new Token("IS>(", new byte[]{(byte) 0xDA}));
    TOKENS.add(new Token("DS<(", new byte[]{(byte) 0xDB}));
    TOKENS.add(new Token("Input ", new byte[]{(byte) 0xDC}));
    TOKENS.add(new Token("Prompt ", new byte[]{(byte) 0xDD}));
    TOKENS.add(new Token("Disp ", new byte[]{(byte) 0xDE}));
    TOKENS.add(new Token("DispGraph", "en", new byte[]{(byte) 0xDF}));
    TOKENS.add(new Token("AffGraph", "fr", new byte[]{(byte) 0xDF}));
    TOKENS.add(new Token("Output(", new byte[]{(byte) 0xE0}));
    TOKENS.add(new Token("ClrHome", "en", new byte[]{(byte) 0xE1}));
    TOKENS.add(new Token("EffEcr", "fr", new byte[]{(byte) 0xE1}));
    TOKENS.add(new Token("Fill(", "en", new byte[]{(byte) 0xE2}));
    TOKENS.add(new Token("Remplir(", "fr", new byte[]{(byte) 0xE2}));
    TOKENS.add(new Token("SortA(", "en", new byte[]{(byte) 0xE3}));
    TOKENS.add(new Token("Tricroi(", "fr", new byte[]{(byte) 0xE3}));
    TOKENS.add(new Token("SortD(", "en", new byte[]{(byte) 0xE4}));
    TOKENS.add(new Token("TriDécroi(", "fr", new byte[]{(byte) 0xE4}));
    TOKENS.add(new Token("DispTable", "en", new byte[]{(byte) 0xE5}));
    TOKENS.add(new Token("AffTable", "fr", new byte[]{(byte) 0xE5}));
    TOKENS.add(new Token("Menu(", new byte[]{(byte) 0xE6}));
    TOKENS.add(new Token("Send(", "en", new byte[]{(byte) 0xE7}));
    TOKENS.add(new Token("Envoi(", "fr", new byte[]{(byte) 0xE7}));
    TOKENS.add(new Token("Get(", "en", new byte[]{(byte) 0xE8}));
    TOKENS.add(new Token("Capt(", "fr", new byte[]{(byte) 0xE8}));
    TOKENS.add(new Token("PlotsOn ", "en", new byte[]{(byte) 0xE9}));
    TOKENS.add(new Token("GraphAff ", "fr", new byte[]{(byte) 0xE9}));
    TOKENS.add(new Token("PlotsOff ", "en", new byte[]{(byte) 0xEA}));
    TOKENS.add(new Token("GraphNAff ", "fr", new byte[]{(byte) 0xEA}));
    TOKENS.add(new Token("ʟ", new byte[]{(byte) 0xEB}));
    TOKENS.add(new Token("Plot1(", "en", new byte[]{(byte) 0xEC}));
    TOKENS.add(new Token("Graph1(", "fr", new byte[]{(byte) 0xEC}));
    TOKENS.add(new Token("Plot2(", "en", new byte[]{(byte) 0xED}));
    TOKENS.add(new Token("Graph2(", "fr", new byte[]{(byte) 0xED}));
    TOKENS.add(new Token("Plot3(", "en", new byte[]{(byte) 0xEE}));
    TOKENS.add(new Token("Graph3(", "fr", new byte[]{(byte) 0xEE}));
    TOKENS.add(new Token("^", new byte[]{(byte) 0xF0}));
    TOKENS.add(new Token("xrt(", "en", new byte[]{(byte) 0xF1}));
    TOKENS.add(new Token("racinex(", "fr", new byte[]{(byte) 0xF1}));
    TOKENS.add(new Token("1-Var Stats ", "en", new byte[]{(byte) 0xF2}));
    TOKENS.add(new Token("Stats 1-Var ", "fr", new byte[]{(byte) 0xF2}));
    TOKENS.add(new Token("2-Var Stats ", "en", new byte[]{(byte) 0xF3}));
    TOKENS.add(new Token("Stats 2-Var ", "fr", new byte[]{(byte) 0xF3}));
    TOKENS.add(new Token("LinReg(a+bx) ", "en", new byte[]{(byte) 0xF4}));
    TOKENS.add(new Token("RegLin(a+bx)", "fr", new byte[]{(byte) 0xF4}));
    TOKENS.add(new Token("ExpReg ", "en", new byte[]{(byte) 0xF5}));
    TOKENS.add(new Token("RegExp ", "fr", new byte[]{(byte) 0xF5}));
    TOKENS.add(new Token("LnReg ", "en", new byte[]{(byte) 0xF6}));
    TOKENS.add(new Token("RegLn ", "fr", new byte[]{(byte) 0xF6}));
    TOKENS.add(new Token("PwrReg ", "en", new byte[]{(byte) 0xF7}));
    TOKENS.add(new Token("RegPuiss", "fr", new byte[]{(byte) 0xF7}));
    TOKENS.add(new Token("Med-Med", new byte[]{(byte) 0xF8}));
    TOKENS.add(new Token("Med", new byte[]{0x62, 0x13}));
    TOKENS.add(new Token("QuadReg ", "en", new byte[]{(byte) 0xF9}));
    TOKENS.add(new Token("RegQuad", "fr", new byte[]{(byte) 0xF9}));
    TOKENS.add(new Token("ClrList ", "en", new byte[]{(byte) 0xFA}));
    TOKENS.add(new Token("EffListe ", "fr", new byte[]{(byte) 0xFA}));
    TOKENS.add(new Token("ClrTable", "en", new byte[]{(byte) 0xFB}));
    TOKENS.add(new Token("EffTable", "fr", new byte[]{(byte) 0xFB}));
    TOKENS.add(new Token("Histogramme", "fr", new byte[]{(byte) 0xFC}));
    TOKENS.add(new Token("Histogram", "en", new byte[]{(byte) 0xFC}));
    TOKENS.add(new Token("xyLine", "en", new byte[]{(byte) 0xFD}));
    TOKENS.add(new Token("Polygone", "fr", new byte[]{(byte) 0xFD}));
    TOKENS.add(new Token("Scatter", "en", new byte[]{(byte) 0xFE}));
    TOKENS.add(new Token("Nuage", "fr", new byte[]{(byte) 0xFE}));
    TOKENS.add(new Token("LinReg(ax+b) ", "en", new byte[]{(byte) 0xFF}));
    TOKENS.add(new Token("RegLin(ax+b) ", "fr", new byte[]{(byte) 0xFF}));

    // bottom

    TOKENS.add(new Token(" ", new byte[]{0x29}));
    for (int i = 0; i < 10; i++) {
      TOKENS.add(new Token("" + i, new byte[]{(byte) (0x30 + i)}));
    }
    for (int i = 0; i < 26; i++) {
      TOKENS.add(new Token("" + (char) ('A' + i), new byte[]{(byte) (0x41 + i)}));
    }
    TOKENS.add(new Token("θ", new byte[]{0x5B}));
    TOKENS.add(new Token("u", new byte[]{0x5E, (byte) 0x80}));
    TOKENS.add(new Token("v", new byte[]{0x5E, (byte) 0x81}));
    TOKENS.add(new Token("w", new byte[]{0x5E, (byte) 0x82}));
    TOKENS.add(new Token("n", new byte[]{0x62, 0x02}));
    TOKENS.add(new Token("r", new byte[]{0x62, 0x12}));
    for (int i = 0; i < 5; i++) {
      TOKENS.add(new Token("" + (char) ('a' + i), new byte[]{0x62, (byte) (0x16 + i)}));
    }
    TOKENS.add(new Token("p", new byte[]{0x62, 0x22}));
    TOKENS.add(new Token("z", new byte[]{0x62, 0x23}));
    TOKENS.add(new Token("t", new byte[]{0x62, 0x24}));
    TOKENS.add(new Token("χ²", new byte[]{0x62, 0x25}));
    TOKENS.add(new Token("Ϝ", new byte[]{0x62, 0x26}));
    TOKENS.add(new Token("s", new byte[]{0x62, 0x34}));
    TOKENS.add(new Token(">", new byte[]{0x6C}));
    for (int i = 0; i < 11; i++) {
      TOKENS.add(new Token("" + (char) ('a' + i), new byte[]{(byte) 0xBB, (byte) (0xB0 + i)}));
    }
    for (int i = 0; i < 15; i++) {
      TOKENS.add(new Token("" + (char) ('l' + i), new byte[]{(byte) 0xBB, (byte) (0xBC + i)}));
    }
  }

  /**
   * Return the token corresponding to the given instruction.
   * 
   * @param instr the instruction
   * @return the token or {@code null} if none were found
   */
  public static Token getToken(String instr) {
    for (Token token : TOKENS) {
      if (token.getInstruction().equals(instr)) {
        return token;
      }
    }

    return null;
  }

  /**
   * Tells if a token is a digit.
   * 
   * @param token the token
   * @return true if the token is a digit
   */
  public static boolean isDigit(String token) {
    return token.matches("\\d");
  }

  private Tokens() {}
}
