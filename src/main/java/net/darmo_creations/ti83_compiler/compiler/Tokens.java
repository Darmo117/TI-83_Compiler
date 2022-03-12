package net.darmo_creations.ti83_compiler.compiler;

import java.util.*;

/**
 * This class lists all tokens in several languages.
 *
 * @author Damien Vergnet
 */
public final class Tokens {
  /**
   * A map containing the regexes for the special characters codes.
   */
  public static final Map<LocalizedAlias, String> ALIASES;
  /**
   * A list containing all tokens.
   */
  public static final List<Token> TOKENS;

  public static final Token LINE_END = new Token((byte) 0x3F).instruction("\n");

  static {
    Map<LocalizedAlias, String> aliasesMap = new LinkedHashMap<>();
    aliasesMap.put(new LocalizedAlias("L"), "ʟ");
    aliasesMap.put(new LocalizedAlias("expon", Language.ENGLISH), "ᴇ");
    aliasesMap.put(new LocalizedAlias("expos", Language.FRENCH), "ᴇ");
    aliasesMap.put(new LocalizedAlias("alpha"), "α");
    aliasesMap.put(new LocalizedAlias("beta", Language.ENGLISH), "β");
    aliasesMap.put(new LocalizedAlias("bêta", Language.FRENCH), "β");
    aliasesMap.put(new LocalizedAlias("Delta"), "Δ");
    aliasesMap.put(new LocalizedAlias("delta"), "δ");
    aliasesMap.put(new LocalizedAlias("epsilon"), "ε");
    aliasesMap.put(new LocalizedAlias("theta", Language.ENGLISH), "θ");
    aliasesMap.put(new LocalizedAlias("thêta", Language.FRENCH), "θ");
    aliasesMap.put(new LocalizedAlias("lambda"), "λ");
    aliasesMap.put(new LocalizedAlias("mu"), "μ");
    aliasesMap.put(new LocalizedAlias("pi"), "π");
    aliasesMap.put(new LocalizedAlias("rho", Language.ENGLISH), "ρ");
    aliasesMap.put(new LocalizedAlias("rhô", Language.FRENCH), "ρ");
    aliasesMap.put(new LocalizedAlias("Sigma"), "Σ");
    aliasesMap.put(new LocalizedAlias("sigma"), "σ");
    aliasesMap.put(new LocalizedAlias("tau"), "τ");
    aliasesMap.put(new LocalizedAlias("phi"), "φ");
    aliasesMap.put(new LocalizedAlias("chi"), "χ");
    aliasesMap.put(new LocalizedAlias("Omega", Language.ENGLISH), "Ω");
    aliasesMap.put(new LocalizedAlias("Oméga", Language.FRENCH), "Ω");
    aliasesMap.put(new LocalizedAlias("digamma"), "Ϝ");
    aliasesMap.put(new LocalizedAlias("F"), "Ϝ");
    aliasesMap.put(new LocalizedAlias("point", Language.ENGLISH), "·");
    aliasesMap.put(new LocalizedAlias("dot", Language.FRENCH), "·");
    aliasesMap.put(new LocalizedAlias("pcirc"), "p̂");
    aliasesMap.put(new LocalizedAlias("xbar", Language.ENGLISH), "x̄");
    aliasesMap.put(new LocalizedAlias("xbarre", Language.FRENCH), "x̄");
    aliasesMap.put(new LocalizedAlias("ybar", Language.ENGLISH), "ȳ");
    aliasesMap.put(new LocalizedAlias("ybarre", Language.FRENCH), "ȳ");
    aliasesMap.put(new LocalizedAlias("larrow", Language.ENGLISH), "←");
    aliasesMap.put(new LocalizedAlias("flècheg", Language.FRENCH), "←");
    aliasesMap.put(new LocalizedAlias("rarrow", Language.ENGLISH), "→");
    aliasesMap.put(new LocalizedAlias("flèched", Language.FRENCH), "→");
    aliasesMap.put(new LocalizedAlias("uarrow", Language.ENGLISH), "↑");
    aliasesMap.put(new LocalizedAlias("flècheh", Language.FRENCH), "↑");
    aliasesMap.put(new LocalizedAlias("darrow", Language.ENGLISH), "↓");
    aliasesMap.put(new LocalizedAlias("flècheb", Language.FRENCH), "↓");
    aliasesMap.put(new LocalizedAlias("int"), "∫");
    aliasesMap.put(new LocalizedAlias("angle"), "∠");
    aliasesMap.put(new LocalizedAlias("bolduarrow", Language.ENGLISH), "⬆");
    aliasesMap.put(new LocalizedAlias("flèchehg", Language.FRENCH), "⬆");
    aliasesMap.put(new LocalizedAlias("bolddarrow", Language.ENGLISH), "⬇");
    aliasesMap.put(new LocalizedAlias("flèchebg", Language.FRENCH), "⬇");
    aliasesMap.put(new LocalizedAlias("sqrt", Language.ENGLISH), "√");
    aliasesMap.put(new LocalizedAlias("racine", Language.FRENCH), "√");
    aliasesMap.put(new LocalizedAlias("cbrt", Language.ENGLISH), "∛");
    aliasesMap.put(new LocalizedAlias("racine3", Language.FRENCH), "∛");
    aliasesMap.put(new LocalizedAlias("times", Language.ENGLISH), "×");
    aliasesMap.put(new LocalizedAlias("fois", Language.FRENCH), "×");
    ALIASES = Collections.unmodifiableMap(aliasesMap);

    List<Token> tokens = new ArrayList<>();
    tokens.add(new Token((byte) 0x01).instruction(">DMS"));
    tokens.add(new Token((byte) 0x02).instruction(">Dec"));
    tokens.add(new Token((byte) 0x03).instruction(">Frac"));
    tokens.add(new Token((byte) 0x04).instruction("->"));
    tokens.add(new Token((byte) 0x05)
        .instruction("BoxPlot", Language.ENGLISH)
        .instruction("Carré", Language.FRENCH));
    tokens.add(new Token((byte) 0x06).instruction("["));
    tokens.add(new Token((byte) 0x07).instruction("]"));
    tokens.add(new Token((byte) 0x08).instruction("{"));
    tokens.add(new Token((byte) 0x09).instruction("}"));
    tokens.add(new Token((byte) 0x0A)
        .instruction("&rexpon;", Language.ENGLISH)
        .instruction("&rexpos;", Language.FRENCH));
    tokens.add(new Token((byte) 0x0B).instruction("°"));
    tokens.add(new Token((byte) 0x0C).instruction("⁻¹"));
    tokens.add(new Token((byte) 0x0D).instruction("²"));
    tokens.add(new Token((byte) 0x0E)
        .instruction("&transpose;", Language.ENGLISH)
        .instruction("&transposée;", Language.FRENCH));
    tokens.add(new Token((byte) 0x0F).instruction("³"));
    tokens.add(new Token((byte) 0x10).instruction("("));
    tokens.add(new Token((byte) 0x11).instruction(")"));
    tokens.add(new Token((byte) 0x12)
        .instruction("round(", Language.ENGLISH)
        .instruction("arrondi(", Language.FRENCH));
    tokens.add(new Token((byte) 0x13).instruction("pxl-Test("));
    tokens.add(new Token((byte) 0x14)
        .instruction("augment(", Language.ENGLISH)
        .instruction("chaîne(", Language.FRENCH));
    tokens.add(new Token((byte) 0x15)
        .instruction("rowSwap(", Language.ENGLISH)
        .instruction("permutLigne(", Language.FRENCH));
    tokens.add(new Token((byte) 0x16)
        .instruction("row+(", Language.ENGLISH)
        .instruction("ligne+(", Language.FRENCH));
    tokens.add(new Token((byte) 0x17)
        .instruction("*row(", Language.ENGLISH)
        .instruction("*ligne(", Language.FRENCH));
    tokens.add(new Token((byte) 0x18)
        .instruction("*row+(", Language.ENGLISH)
        .instruction("*ligne+(", Language.FRENCH));
    tokens.add(new Token((byte) 0x19).instruction("max("));
    tokens.add(new Token((byte) 0x1A).instruction("min("));
    tokens.add(new Token((byte) 0x1B).instruction("R>Pr("));
    tokens.add(new Token((byte) 0x1C).instruction("R>Pθ("));
    tokens.add(new Token((byte) 0x1D).instruction("P>Rx("));
    tokens.add(new Token((byte) 0x1E).instruction("P>Ry("));
    tokens.add(new Token((byte) 0x1F)
        .instruction("median(", Language.ENGLISH)
        .instruction("médiane(", Language.FRENCH));
    tokens.add(new Token((byte) 0x20)
        .instruction("randM(", Language.ENGLISH)
        .instruction("matAléat(", Language.FRENCH));
    tokens.add(new Token((byte) 0x21)
        .instruction("mean(", Language.ENGLISH)
        .instruction("moyenne(", Language.FRENCH));
    tokens.add(new Token((byte) 0x22)
        .instruction("solve(", Language.ENGLISH)
        .instruction("résoudre(", Language.FRENCH));
    tokens.add(new Token((byte) 0x23)
        .instruction("seq(", Language.ENGLISH)
        .instruction("suite(", Language.FRENCH));
    tokens.add(new Token((byte) 0x24)
        .instruction("fnInt(", Language.ENGLISH)
        .instruction("intégrFonct(", Language.FRENCH));
    tokens.add(new Token((byte) 0x25)
        .instruction("nDeriv(", Language.ENGLISH)
        .instruction("nbreDériv(", Language.FRENCH));
    tokens.add(new Token((byte) 0x27)
        .instruction("fMin(", Language.ENGLISH)
        .instruction("xfMin(", Language.FRENCH));
    tokens.add(new Token((byte) 0x28)
        .instruction("fMax(", Language.ENGLISH)
        .instruction("xfMax(", Language.FRENCH));
    tokens.add(new Token((byte) 0x29).instruction(" "));
    tokens.add(new Token((byte) 0x2A).instruction("\""));
    tokens.add(new Token((byte) 0x2B).instruction(","));
    tokens.add(new Token((byte) 0x2C).instruction("&imag;"));
    tokens.add(new Token((byte) 0x2D).instruction("!"));
    tokens.add(new Token((byte) 0x2E)
        .instruction("CubicReg", Language.ENGLISH)
        .instruction("RegCubique", Language.FRENCH));
    tokens.add(new Token((byte) 0x2F)
        .instruction("QuartReg", Language.ENGLISH)
        .instruction("RegQuatre", Language.FRENCH));
    for (int i = 0; i < 10; i++) {
      tokens.add(new Token((byte) (0x30 + i)).instruction("" + i));
    }
    tokens.add(new Token((byte) 0x3A).instruction("."));
    tokens.add(new Token((byte) 0x3B).instruction("ᴇ"));
    tokens.add(new Token((byte) 0x3C)
        .instruction(" or ", Language.ENGLISH)
        .instruction(" ou ", Language.FRENCH));
    tokens.add(new Token((byte) 0x3D)
        .instruction(" xor ", Language.ENGLISH)
        .instruction(" ouExcl ", Language.FRENCH));
    tokens.add(new Token((byte) 0x3E).instruction(":"));
    tokens.add(new Token((byte) 0x40)
        .instruction(" and ", Language.ENGLISH)
        .instruction(" et ", Language.FRENCH));
    for (int i = 0; i < 26; i++) {
      tokens.add(new Token((byte) (0x41 + i)).instruction("" + (char) ('A' + i)));
    }
    tokens.add(new Token((byte) 0x5B).instruction("θ"));
    for (int i = 0; i < 10; i++) {
      tokens.add(new Token((byte) 0x5C, (byte) i).instruction("[" + (char) ('A' + i) + "]"));
    }
    for (int i = 0; i < 6; i++) {
      tokens.add(new Token((byte) 0x5D, (byte) i).instruction("L" + (i + 1)));
    }
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token((byte) 0x5E, (byte) (0x10 + i)).instruction("Y" + (i + 1)));
    }
    tokens.add(new Token((byte) 0x5E, (byte) 0x19).instruction("Y0"));
    int j = 0;
    for (int i = 0; i < 12; i++) {
      if (i % 2 == 0) {
        j++;
        tokens.add(new Token((byte) 0x5E, (byte) (0x20 + i)).instruction("X" + j + "T"));
      } else {
        tokens.add(new Token((byte) 0x5E, (byte) (0x20 + i)).instruction("Y" + j + "T"));
      }
    }
    for (int i = 0; i < 6; i++) {
      tokens.add(new Token((byte) 0x5E, (byte) (0x40 + i)).instruction("r" + (i + 1)));
    }
    tokens.add(new Token((byte) 0x5E, (byte) 0x80).instruction("&varu;"));
    tokens.add(new Token((byte) 0x5E, (byte) 0x81).instruction("&varv;"));
    tokens.add(new Token((byte) 0x5E, (byte) 0x82).instruction("&varw;"));
    tokens.add(new Token((byte) 0x5F).instruction("prgm"));
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token((byte) 0x60, (byte) i)
          .instruction("Pic" + (i + 1), Language.ENGLISH)
          .instruction("Img" + (i + 1), Language.FRENCH));
    }
    tokens.add(new Token((byte) 0x60, (byte) 0x09)
        .instruction("Pic0", Language.ENGLISH)
        .instruction("Img0", Language.FRENCH));
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token((byte) 0x61, (byte) i)
          .instruction("GDB" + (i + 1), Language.ENGLISH)
          .instruction("BDG" + (i + 1), Language.FRENCH));
    }
    tokens.add(new Token((byte) 0x61, (byte) 0x09)
        .instruction("GDB0", Language.ENGLISH)
        .instruction("BDG0", Language.FRENCH));
    tokens.add(new Token((byte) 0x62, (byte) 0x01)
        .instruction("RegEq", Language.ENGLISH)
        .instruction("EqReg", Language.FRENCH));
    tokens.add(new Token((byte) 0x62, (byte) 0x02).instruction("&varn;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x03).instruction("x̄"));
    tokens.add(new Token((byte) 0x62, (byte) 0x05).instruction("Σx²"));
    tokens.add(new Token((byte) 0x62, (byte) 0x04).instruction("Σx"));
    tokens.add(new Token((byte) 0x62, (byte) 0x06).instruction("Sx"));
    tokens.add(new Token((byte) 0x62, (byte) 0x07).instruction("σx"));
    tokens.add(new Token((byte) 0x62, (byte) 0x08).instruction("minX"));
    tokens.add(new Token((byte) 0x62, (byte) 0x09).instruction("maxX"));
    tokens.add(new Token((byte) 0x62, (byte) 0x0A).instruction("minY"));
    tokens.add(new Token((byte) 0x62, (byte) 0x0B).instruction("maxY"));
    tokens.add(new Token((byte) 0x62, (byte) 0x0C).instruction("ȳ"));
    tokens.add(new Token((byte) 0x62, (byte) 0x0E).instruction("Σy²"));
    tokens.add(new Token((byte) 0x62, (byte) 0x0D).instruction("Σy"));
    tokens.add(new Token((byte) 0x62, (byte) 0x0F).instruction("Sy"));
    tokens.add(new Token((byte) 0x62, (byte) 0x10).instruction("σy"));
    tokens.add(new Token((byte) 0x62, (byte) 0x11).instruction("Σxy"));
    tokens.add(new Token((byte) 0x62, (byte) 0x12).instruction("&varr;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x13).instruction("Med"));
    tokens.add(new Token((byte) 0x62, (byte) 0x14).instruction("Q1"));
    tokens.add(new Token((byte) 0x62, (byte) 0x15).instruction("Q3"));
    for (int i = 0; i < 5; i++) {
      tokens.add(new Token((byte) 0x62, (byte) (0x16 + i)).instruction("&var" + (char) ('a' + i) + ";"));
    }
    for (int i = 0; i < 3; i++) {
      tokens.add(new Token((byte) 0x62, (byte) (0x1B + i)).instruction("x" + (i + 1)));
      tokens.add(new Token((byte) 0x62, (byte) (0x1E + i)).instruction("y" + (i + 1)));
    }
    tokens.add(new Token((byte) 0x62, (byte) 0x21).instruction("&nital;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x22).instruction("&varp;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x23).instruction("&varz;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x24).instruction("&vart;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x25).instruction("χ²"));
    tokens.add(new Token((byte) 0x62, (byte) 0x26).instruction("Ϝ"));
    tokens.add(new Token((byte) 0x62, (byte) 0x27).instruction("df"));
    tokens.add(new Token((byte) 0x62, (byte) 0x28).instruction("p̂"));
    tokens.add(new Token((byte) 0x62, (byte) 0x29).instruction("p̂1"));
    tokens.add(new Token((byte) 0x62, (byte) 0x2A).instruction("p̂2"));
    tokens.add(new Token((byte) 0x62, (byte) 0x2B).instruction("x̄1"));
    tokens.add(new Token((byte) 0x62, (byte) 0x2C).instruction("Sx1"));
    tokens.add(new Token((byte) 0x62, (byte) 0x2D).instruction("n1"));
    tokens.add(new Token((byte) 0x62, (byte) 0x2E).instruction("x̄2"));
    tokens.add(new Token((byte) 0x62, (byte) 0x2F).instruction("Sx2"));
    tokens.add(new Token((byte) 0x62, (byte) 0x30).instruction("n2"));
    tokens.add(new Token((byte) 0x62, (byte) 0x31).instruction("Sxp"));
    tokens.add(new Token((byte) 0x62, (byte) 0x32)
        .instruction("lower", Language.ENGLISH)
        .instruction("inf", Language.FRENCH));
    tokens.add(new Token((byte) 0x62, (byte) 0x33)
        .instruction("upper", Language.ENGLISH)
        .instruction("sup", Language.FRENCH));
    tokens.add(new Token((byte) 0x62, (byte) 0x34).instruction("&vars;"));
    tokens.add(new Token((byte) 0x62, (byte) 0x35).instruction("r²"));
    tokens.add(new Token((byte) 0x62, (byte) 0x36).instruction("R²"));
    tokens.add(new Token((byte) 0x63, (byte) 0x00)
        .instruction("ZXscl", Language.ENGLISH)
        .instruction("ZXpas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x01)
        .instruction("ZYscl", Language.ENGLISH)
        .instruction("ZYpas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x02)
        .instruction("Xscl", Language.ENGLISH)
        .instruction("Xgrad", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x03)
        .instruction("Yscl", Language.ENGLISH)
        .instruction("Ygrad", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x04).instruction("u(nMin)"));
    tokens.add(new Token((byte) 0x63, (byte) 0x05).instruction("v(nMin)"));
    tokens.add(new Token((byte) 0x63, (byte) 0x08).instruction("Zu(nMin)"));
    tokens.add(new Token((byte) 0x63, (byte) 0x09).instruction("Zv(nMin)"));
    tokens.add(new Token((byte) 0x63, (byte) 0x0A).instruction("Xmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x0B).instruction("Xmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x0C).instruction("Ymin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x0D).instruction("Ymax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x0E).instruction("Tmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x0F).instruction("Tmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x10).instruction("θmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x11).instruction("θmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x12).instruction("ZXmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x13).instruction("ZXmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x14).instruction("ZYmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x15).instruction("ZYmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x16).instruction("Zθmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x17).instruction("Zθmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x18).instruction("ZTmin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x19).instruction("ZTmax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x1A)
        .instruction("TblStart", Language.ENGLISH)
        .instruction("DébutTbl", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x1B)
        .instruction("PlotStart", Language.ENGLISH)
        .instruction("PointDébut", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x1C)
        .instruction("ZPlotStart", Language.ENGLISH)
        .instruction("ZPointDébut", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x1D).instruction("nMax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x1E).instruction("ZnMax"));
    tokens.add(new Token((byte) 0x63, (byte) 0x1F).instruction("nMin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x20).instruction("ZnMin"));
    tokens.add(new Token((byte) 0x63, (byte) 0x21)
        .instruction("ΔTbl", Language.ENGLISH)
        .instruction("PasTbl", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x22)
        .instruction("Tstep", Language.ENGLISH)
        .instruction("Tpas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x23)
        .instruction("θstep", Language.ENGLISH)
        .instruction("θpas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x24)
        .instruction("ZTstep", Language.ENGLISH)
        .instruction("ZTpas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x25)
        .instruction("Zθstep", Language.ENGLISH)
        .instruction("Zθpas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x26)
        .instruction("ΔX", Language.ENGLISH)
        .instruction("PasX", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x27)
        .instruction("ΔY", Language.ENGLISH)
        .instruction("PasY", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x28).instruction("XFact"));
    tokens.add(new Token((byte) 0x63, (byte) 0x29).instruction("YFact"));
    tokens.add(new Token((byte) 0x63, (byte) 0x2A)
        .instruction("TblInput", Language.ENGLISH)
        .instruction("EntréeTbl", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x2B).instruction("&N;"));
    tokens.add(new Token((byte) 0x63, (byte) 0x2C).instruction("I%"));
    tokens.add(new Token((byte) 0x63, (byte) 0x2D)
        .instruction("PV", Language.ENGLISH)
        .instruction("ValAct", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x2E).instruction("PMT"));
    tokens.add(new Token((byte) 0x63, (byte) 0x2F)
        .instruction("FV", Language.ENGLISH)
        .instruction("ValAcq", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x30)
        .instruction("P/Y", Language.ENGLISH)
        .instruction("Ech/An", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x31)
        .instruction("C/Y", Language.ENGLISH)
        .instruction("Pér/An", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x32).instruction("w(nMin)"));
    tokens.add(new Token((byte) 0x63, (byte) 0x33).instruction("Zw(nMin)"));
    tokens.add(new Token((byte) 0x63, (byte) 0x34)
        .instruction("PlotStep", Language.ENGLISH)
        .instruction("GraphPas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x35)
        .instruction("ZPlotStep", Language.ENGLISH)
        .instruction("ZGraphPas", Language.FRENCH));
    tokens.add(new Token((byte) 0x63, (byte) 0x36).instruction("Xres"));
    tokens.add(new Token((byte) 0x63, (byte) 0x37).instruction("ZXres"));
    tokens.add(new Token((byte) 0x64).instruction("Radian"));
    tokens.add(new Token((byte) 0x65)
        .instruction("Degree", Language.ENGLISH)
        .instruction("Degré", Language.FRENCH));
    tokens.add(new Token((byte) 0x66).instruction("Normal"));
    tokens.add(new Token((byte) 0x67).instruction("Sci"));
    tokens.add(new Token((byte) 0x68)
        .instruction("Eng", Language.ENGLISH)
        .instruction("Ing", Language.FRENCH));
    tokens.add(new Token((byte) 0x69)
        .instruction("Float", Language.ENGLISH)
        .instruction("Flottant", Language.FRENCH));
    tokens.add(new Token((byte) 0x6A).instruction("="));
    tokens.add(new Token((byte) 0x6B).instruction("<"));
    tokens.add(new Token((byte) 0x6C).instruction(">"));
    tokens.add(new Token((byte) 0x6D).instruction("≤"));
    tokens.add(new Token((byte) 0x6D).instruction("<="));
    tokens.add(new Token((byte) 0x6E).instruction("≥"));
    tokens.add(new Token((byte) 0x6E).instruction(">="));
    tokens.add(new Token((byte) 0x6F).instruction("≠"));
    tokens.add(new Token((byte) 0x6F).instruction("!="));
    tokens.add(new Token((byte) 0x70).instruction("+"));
    tokens.add(new Token((byte) 0x71).instruction("-"));
    tokens.add(new Token((byte) 0x72)
        .instruction("Ans", Language.ENGLISH)
        .instruction("Rep", Language.FRENCH));
    tokens.add(new Token((byte) 0x73)
        .instruction("Fix ", Language.ENGLISH)
        .instruction("Fixe ", Language.FRENCH));
    tokens.add(new Token((byte) 0x74).instruction("Horiz"));
    tokens.add(new Token((byte) 0x75)
        .instruction("Full", Language.ENGLISH)
        .instruction("PleinEcr", Language.FRENCH));
    tokens.add(new Token((byte) 0x76)
        .instruction("Func", Language.ENGLISH)
        .instruction("Fonct", Language.FRENCH));
    tokens.add(new Token((byte) 0x77).instruction("Param"));
    tokens.add(new Token((byte) 0x78)
        .instruction("Polar", Language.ENGLISH)
        .instruction("Polaire", Language.FRENCH));
    tokens.add(new Token((byte) 0x79)
        .instruction("Seq", Language.ENGLISH)
        .instruction("Suite", Language.FRENCH));
    tokens.add(new Token((byte) 0x7A)
        .instruction("IndpntAuto", Language.ENGLISH)
        .instruction("ValeursAuto", Language.FRENCH));
    tokens.add(new Token((byte) 0x7B)
        .instruction("IndpntAsk", Language.ENGLISH)
        .instruction("ValeursDem", Language.FRENCH));
    tokens.add(new Token((byte) 0x7C)
        .instruction("DependAuto", Language.ENGLISH)
        .instruction("CalculsAuto", Language.FRENCH));
    tokens.add(new Token((byte) 0x7D)
        .instruction("DependAsk", Language.ENGLISH)
        .instruction("CalculsDem", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x00)
        .instruction("Sequential", Language.ENGLISH)
        .instruction("Séquentiel", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x01).instruction("Simul"));
    tokens.add(new Token((byte) 0x7E, (byte) 0x02)
        .instruction("PolarGC", Language.ENGLISH)
        .instruction("CoordPol", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x03)
        .instruction("RectGC", Language.ENGLISH)
        .instruction("CoordRect", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x04)
        .instruction("CoordOn", Language.ENGLISH)
        .instruction("CoordAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x05)
        .instruction("CoordOff", Language.ENGLISH)
        .instruction("CoordNAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x06)
        .instruction("Connected", Language.ENGLISH)
        .instruction("Relié", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x07)
        .instruction("Dot", Language.ENGLISH)
        .instruction("NonRelié", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x08)
        .instruction("AxesOn", Language.ENGLISH)
        .instruction("AxesAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x09)
        .instruction("AxesOff", Language.ENGLISH)
        .instruction("AxesNAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x0A)
        .instruction("GridOn", Language.ENGLISH)
        .instruction("QuadAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x0B)
        .instruction("GridOff", Language.ENGLISH)
        .instruction("QuadNAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x0C)
        .instruction("LabelOn", Language.ENGLISH)
        .instruction("EtiqAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x0D)
        .instruction("LabelOff", Language.ENGLISH)
        .instruction("EtiqNAff", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x0E)
        .instruction("Web", Language.ENGLISH)
        .instruction("Toile", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x0F)
        .instruction("Time", Language.ENGLISH)
        .instruction("f(n)", Language.FRENCH));
    tokens.add(new Token((byte) 0x7E, (byte) 0x10).instruction("uvAxes"));
    tokens.add(new Token((byte) 0x7E, (byte) 0x11).instruction("vwAxes"));
    tokens.add(new Token((byte) 0x7E, (byte) 0x12).instruction("uwAxes"));
    tokens.add(new Token((byte) 0x7F)
        .instruction("&square;", Language.ENGLISH)
        .instruction("&carré;", Language.FRENCH));
    tokens.add(new Token((byte) 0x80)
        .instruction("&cross;", Language.ENGLISH)
        .instruction("&croix;", Language.FRENCH));
    tokens.add(new Token((byte) 0x81).instruction("·"));
    tokens.add(new Token((byte) 0x82).instruction("*"));
    tokens.add(new Token((byte) 0x83).instruction("/"));
    tokens.add(new Token((byte) 0x84).instruction("Trace"));
    tokens.add(new Token((byte) 0x85)
        .instruction("ClrDraw", Language.ENGLISH)
        .instruction("EffDessin", Language.FRENCH));
    tokens.add(new Token((byte) 0x86).instruction("ZStandard"));
    tokens.add(new Token((byte) 0x87).instruction("ZTrig"));
    tokens.add(new Token((byte) 0x88)
        .instruction("ZBox", Language.ENGLISH)
        .instruction("Zboîte", Language.FRENCH));
    tokens.add(new Token((byte) 0x89)
        .instruction("Zoom In", Language.ENGLISH)
        .instruction("Zoom +", Language.FRENCH));
    tokens.add(new Token((byte) 0x8A)
        .instruction("Zoom Out", Language.ENGLISH)
        .instruction("Zoom -", Language.FRENCH));
    tokens.add(new Token((byte) 0x8B)
        .instruction("ZSquare", Language.ENGLISH)
        .instruction("ZOrthonormal", Language.FRENCH));
    tokens.add(new Token((byte) 0x8C)
        .instruction("ZInteger", Language.ENGLISH)
        .instruction("ZEntier", Language.FRENCH));
    tokens.add(new Token((byte) 0x8D)
        .instruction("ZPrevious", Language.ENGLISH)
        .instruction("ZPrécédent", Language.FRENCH));
    tokens.add(new Token((byte) 0x8E)
        .instruction("ZDecimal", Language.ENGLISH)
        .instruction("ZDécimal", Language.FRENCH));
    tokens.add(new Token((byte) 0x8F).instruction("ZoomStat"));
    tokens.add(new Token((byte) 0x90)
        .instruction("ZoomRcl", Language.ENGLISH)
        .instruction("ZoomRpl", Language.FRENCH));
    tokens.add(new Token((byte) 0x91)
        .instruction("PrintScreen", Language.ENGLISH)
        .instruction("ImprEcr", Language.FRENCH));
    tokens.add(new Token((byte) 0x92)
        .instruction("ZoomSto", Language.ENGLISH)
        .instruction("SauveFen", Language.FRENCH));
    tokens.add(new Token((byte) 0x93)
        .instruction("Text(", Language.ENGLISH)
        .instruction("Texte(", Language.FRENCH));
    tokens.add(new Token((byte) 0x94)
        .instruction(" nPr ", Language.ENGLISH)
        .instruction(" Arrangement ", Language.FRENCH));
    tokens.add(new Token((byte) 0x95)
        .instruction(" nCr ", Language.ENGLISH)
        .instruction(" Combinaison ", Language.FRENCH));
    tokens.add(new Token((byte) 0x96)
        .instruction("FnOn ", Language.ENGLISH)
        .instruction("FonctAff ", Language.FRENCH));
    tokens.add(new Token((byte) 0x97)
        .instruction("FnOff ", Language.ENGLISH)
        .instruction("FonctNAff ", Language.FRENCH));
    tokens.add(new Token((byte) 0x98)
        .instruction("StorePic ", Language.ENGLISH)
        .instruction("SauveImage ", Language.FRENCH));
    tokens.add(new Token((byte) 0x99)
        .instruction("RecallPic ", Language.ENGLISH)
        .instruction("RappelImage ", Language.FRENCH));
    tokens.add(new Token((byte) 0x9A)
        .instruction("StoreGDB ", Language.ENGLISH)
        .instruction("SauveBDG ", Language.FRENCH));
    tokens.add(new Token((byte) 0x9B)
        .instruction("RecallGDB ", Language.ENGLISH)
        .instruction("RappelBDG ", Language.FRENCH));
    tokens.add(new Token((byte) 0x9C)
        .instruction("Line(", Language.ENGLISH)
        .instruction("Ligne(", Language.FRENCH));
    tokens.add(new Token((byte) 0x9D)
        .instruction("Vertical ", Language.ENGLISH)
        .instruction("Verticale ", Language.FRENCH));
    tokens.add(new Token((byte) 0x9E)
        .instruction("Pt-On(", Language.ENGLISH)
        .instruction("Pt-Aff(", Language.FRENCH));
    tokens.add(new Token((byte) 0x9F)
        .instruction("Pt-Off(", Language.ENGLISH)
        .instruction("Pt-NAff(", Language.FRENCH));
    tokens.add(new Token((byte) 0xA0).instruction("Pt-Change("));
    tokens.add(new Token((byte) 0xA1)
        .instruction("Pxl-On(", Language.ENGLISH)
        .instruction("Pxl-Aff(", Language.FRENCH));
    tokens.add(new Token((byte) 0xA2)
        .instruction("Pxl-Off(", Language.ENGLISH)
        .instruction("Pxl-NAff(", Language.FRENCH));
    tokens.add(new Token((byte) 0xA3).instruction("Pxl-Change("));
    tokens.add(new Token((byte) 0xA4)
        .instruction("Shade(", Language.ENGLISH)
        .instruction("Ombre(", Language.FRENCH));
    tokens.add(new Token((byte) 0xA5)
        .instruction("Circle(", Language.ENGLISH)
        .instruction("Cercle(", Language.FRENCH));
    tokens.add(new Token((byte) 0xA6)
        .instruction("Horizontal ", Language.ENGLISH)
        .instruction("Horizontale ", Language.FRENCH));
    tokens.add(new Token((byte) 0xA7)
        .instruction("Tangent(", Language.ENGLISH)
        .instruction("Tangente(", Language.FRENCH));
    tokens.add(new Token((byte) 0xA8)
        .instruction("DrawInv ", Language.ENGLISH)
        .instruction("DessRecip ", Language.FRENCH));
    tokens.add(new Token((byte) 0xA9)
        .instruction("DrawF ", Language.ENGLISH)
        .instruction("DessFonct ", Language.FRENCH));
    for (int i = 0; i < 9; i++) {
      tokens.add(new Token((byte) 0xAA, (byte) i)
          .instruction("Str" + (i + 1), Language.ENGLISH)
          .instruction("Chaîne" + (i + 1), Language.FRENCH));
    }
    tokens.add(new Token((byte) 0xAA, (byte) 0x09)
        .instruction("Str0", Language.ENGLISH)
        .instruction("Chaîne0", Language.FRENCH));
    tokens.add(new Token((byte) 0xAB)
        .instruction("rand", Language.ENGLISH)
        .instruction("NbrAléat", Language.FRENCH));
    tokens.add(new Token((byte) 0xAC).instruction("π"));
    tokens.add(new Token((byte) 0xAD)
        .instruction("getKey", Language.ENGLISH)
        .instruction("codeTouch(", Language.FRENCH));
    tokens.add(new Token((byte) 0xAE).instruction("'"));
    tokens.add(new Token((byte) 0xAF).instruction("?"));
    tokens.add(new Token((byte) 0xB0).instruction("_-"));
    tokens.add(new Token((byte) 0xB1)
        .instruction("int(", Language.ENGLISH)
        .instruction("partEnt(", Language.FRENCH));
    tokens.add(new Token((byte) 0xB2).instruction("abs("));
    tokens.add(new Token((byte) 0xB3)
        .instruction("det(", Language.ENGLISH)
        .instruction("dét(", Language.FRENCH));
    tokens.add(new Token((byte) 0xB4)
        .instruction("identity(", Language.ENGLISH)
        .instruction("identité(", Language.FRENCH));
    tokens.add(new Token((byte) 0xB5).instruction("dim("));
    tokens.add(new Token((byte) 0xB6)
        .instruction("sum(", Language.ENGLISH)
        .instruction("somme(", Language.FRENCH));
    tokens.add(new Token((byte) 0xB7).instruction("prod("));
    tokens.add(new Token((byte) 0xB8)
        .instruction("not(", Language.ENGLISH)
        .instruction("non(", Language.FRENCH));
    tokens.add(new Token((byte) 0xB9)
        .instruction("iPart(", Language.ENGLISH)
        .instruction("ent(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBA)
        .instruction("fPart(", Language.ENGLISH)
        .instruction("partDéc(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x00)
        .instruction("npv(", Language.ENGLISH)
        .instruction("vActNet(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x01)
        .instruction("irr(", Language.ENGLISH)
        .instruction("tauxRi(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x02)
        .instruction("bal(", Language.ENGLISH)
        .instruction("paSolde(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x03)
        .instruction("ΣPrn(", Language.ENGLISH)
        .instruction("paSomPrinc(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x04)
        .instruction("ΣInt(", Language.ENGLISH)
        .instruction("paInt(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x05).instruction(">Nom("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x06).instruction(">Eff("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x07)
        .instruction("dbd(", Language.ENGLISH)
        .instruction("jed(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x08)
        .instruction("lcm(", Language.ENGLISH)
        .instruction("ppcm(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x09)
        .instruction("gcd(", Language.ENGLISH)
        .instruction("pgcd(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x0A)
        .instruction("randInt(", Language.ENGLISH)
        .instruction("entAléat(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x0B)
        .instruction("randBin(", Language.ENGLISH)
        .instruction("BinAléat(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x0C)
        .instruction("sub(", Language.ENGLISH)
        .instruction("sous-Chaîne(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x0D)
        .instruction("stdDev(", Language.ENGLISH)
        .instruction("ecart-type(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x0E).instruction("variance("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x0F)
        .instruction("inString(", Language.ENGLISH)
        .instruction("carChaîne(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x10)
        .instruction("normalcdf(", Language.ENGLISH)
        .instruction("normalFRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x11)
        .instruction("invNorm(", Language.ENGLISH)
        .instruction("FracNormale(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x12)
        .instruction("tcdf(", Language.ENGLISH)
        .instruction("studentFRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x13)
        .instruction("χ²cdf(", Language.ENGLISH)
        .instruction("χ²FRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x14)
        .instruction("Ϝcdf(", Language.ENGLISH)
        .instruction("ϜFRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x15)
        .instruction("binompdf(", Language.ENGLISH)
        .instruction("binomFdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x16)
        .instruction("binomcdf(", Language.ENGLISH)
        .instruction("binomFRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x17)
        .instruction("poissonpdf(", Language.ENGLISH)
        .instruction("poissonFdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x18)
        .instruction("poissoncdf(", Language.ENGLISH)
        .instruction("poissonFRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x19)
        .instruction("geometpdf(", Language.ENGLISH)
        .instruction("géomtFdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x1A)
        .instruction("geometcdf(", Language.ENGLISH)
        .instruction("géomtFRép(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x1B)
        .instruction("normalpdf(", Language.ENGLISH)
        .instruction("normalFdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x1C)
        .instruction("tpdf(", Language.ENGLISH)
        .instruction("studentFdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x1D)
        .instruction("χ²pdf(", Language.ENGLISH)
        .instruction("χ²Fdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x1E)
        .instruction("Ϝpdf(", Language.ENGLISH)
        .instruction("ϜFdp(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x1F)
        .instruction("randNorm(", Language.ENGLISH)
        .instruction("normAléat(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x20)
        .instruction("tvm_Pmt", Language.ENGLISH)
        .instruction("vat_Pmt", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x21)
        .instruction("tvm_I%", Language.ENGLISH)
        .instruction("vat_I%", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x22)
        .instruction("tvm_PV", Language.ENGLISH)
        .instruction("vat_Vact", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x23)
        .instruction("tvm_N", Language.ENGLISH)
        .instruction("vat_N", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x24)
        .instruction("tvm_FV", Language.ENGLISH)
        .instruction("vat_Vacq", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x25).instruction("conj("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x26)
        .instruction("real(", Language.ENGLISH)
        .instruction("réel(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x27).instruction("imag("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x28)
        .instruction("angle(", Language.ENGLISH)
        .instruction("argument(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x29)
        .instruction("cumSum(", Language.ENGLISH).instruction("somCum(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x2A).instruction("expr("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x2B)
        .instruction("length(", Language.ENGLISH)
        .instruction("longueur(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x2C)
        .instruction("ΔList(", Language.ENGLISH)
        .instruction("ΔListe(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x2D)
        .instruction("ref(", Language.ENGLISH)
        .instruction("Gauss(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x2E)
        .instruction("rref(", Language.ENGLISH)
        .instruction("Gauss-Jordan(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x2F).instruction(">Rect"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x30)
        .instruction(">Polar", Language.ENGLISH)
        .instruction(">Polaire", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x31).instruction("&exp;"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x32)
        .instruction("SinReg ", Language.ENGLISH)
        .instruction("RegSin ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x33)
        .instruction("Logistic ", Language.ENGLISH)
        .instruction("Logistique ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x34)
        .instruction("LinRegTTest ", Language.ENGLISH)
        .instruction("RegLinTTest ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x35)
        .instruction("ShadeNorm(", Language.ENGLISH)
        .instruction("OmbreNorm(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x36)
        .instruction("Shade_t(", Language.ENGLISH)
        .instruction("Ombre_t(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x37)
        .instruction("Shadeχ²(", Language.ENGLISH)
        .instruction("Ombreχ²(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x38)
        .instruction("ShadeϜ(", Language.ENGLISH)
        .instruction("OmbreϜ(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x39)
        .instruction("Matr>list(", Language.ENGLISH)
        .instruction("Matr>liste(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x3A)
        .instruction("List>matr(", Language.ENGLISH)
        .instruction("Liste>matr(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x3B).instruction("Z-Test("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x3C).instruction("T-Test "));
    tokens.add(new Token((byte) 0xBB, (byte) 0x3D)
        .instruction("2-SampZTest(", Language.ENGLISH)
        .instruction("2-CompZTest(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x3E).instruction("1-PropZTest("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x3F).instruction("2-PropZTest("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x40).instruction("χ²-Test("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x41)
        .instruction("ZInterval ", Language.ENGLISH)
        .instruction("ZIntConf ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x42)
        .instruction("2-SampZInt(", Language.ENGLISH)
        .instruction("2-CompZInt(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x43).instruction("1-PropZInt("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x44).instruction("2-PropZInt("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x45).instruction("GraphStyle("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x46)
        .instruction("2-SampTTest ", Language.ENGLISH)
        .instruction("2-CompTTest ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x47)
        .instruction("2-SampFTest ", Language.ENGLISH)
        .instruction("2-CompFTest ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x48)
        .instruction("TInterval ", Language.ENGLISH)
        .instruction("TIntConf ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x49)
        .instruction("2-SampTInt ", Language.ENGLISH)
        .instruction("2-CompTInt ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x4A)
        .instruction("SetUpEditor ", Language.ENGLISH)
        .instruction("ListesDéfaut ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x4B)
        .instruction("Pmt_End", Language.ENGLISH)
        .instruction("Pmt_Fin", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x4C)
        .instruction("Pmt_Bgn", Language.ENGLISH)
        .instruction("Pmt_Déb", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x4D)
        .instruction("Real", Language.ENGLISH)
        .instruction("Réel", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x4E).instruction("re^θi"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x4F).instruction("a+bi"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x50)
        .instruction("ExprOn", Language.ENGLISH)
        .instruction("ExprAff", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x51)
        .instruction("ExprOff", Language.ENGLISH)
        .instruction("ExprNAff", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x52)
        .instruction("ClrAllLists", Language.ENGLISH)
        .instruction("EffToutListes", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x53)
        .instruction("GetCalc(", Language.ENGLISH)
        .instruction("CaptVar(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x54)
        .instruction("DelVar ", Language.ENGLISH)
        .instruction("EffVar ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x55)
        .instruction("Equ>String(", Language.ENGLISH)
        .instruction("Equ>Chaîne(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x56)
        .instruction("String>Equ(", Language.ENGLISH)
        .instruction("Chaîne>Equ(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x57)
        .instruction("Clear Entries", Language.ENGLISH)
        .instruction("Efface entrées", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x58)
        .instruction("Select(", Language.ENGLISH)
        .instruction("Sélect(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x59)
        .instruction("ANOVA(", Language.ENGLISH)
        .instruction("ANUVA(", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x5A)
        .instruction("ModBoxplot", Language.ENGLISH)
        .instruction("GraphBoitMoust", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x5B)
        .instruction("NormProbPlot", Language.ENGLISH)
        .instruction("GraphProbNorm", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x64).instruction("G-T"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x65)
        .instruction("ZoomFit", Language.ENGLISH)
        .instruction("ZMinMax", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x66)
        .instruction("DiagnosticOn", Language.ENGLISH)
        .instruction("CorrelAff", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x67)
        .instruction("DiagnosticOff", Language.ENGLISH)
        .instruction("CorrelNAff", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x68).instruction("Archive "));
    tokens.add(new Token((byte) 0xBB, (byte) 0x69)
        .instruction("UnArchive ", Language.ENGLISH)
        .instruction("Désarchive ", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0x6A).instruction("Asm("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x6B).instruction("AsmComp("));
    tokens.add(new Token((byte) 0xBB, (byte) 0x6C).instruction("AsmPrgm "));
    tokens.add(new Token((byte) 0xBB, (byte) 0x6E).instruction("Á"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x6F).instruction("À"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x70).instruction("Â"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x71).instruction("Ä"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x72).instruction("á"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x73).instruction("à"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x74).instruction("â"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x75).instruction("ä"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x76).instruction("É"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x77).instruction("È"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x78).instruction("Ê"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x79).instruction("Ë"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x7A).instruction("é"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x7B).instruction("è"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x7C).instruction("ê"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x7D).instruction("ë"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x7F).instruction("Ì"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x80).instruction("Î"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x81).instruction("Ï"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x82).instruction("í"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x83).instruction("ì"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x84).instruction("î"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x85).instruction("ï"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x86).instruction("Ó"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x87).instruction("Ò"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x88).instruction("Ô"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x89).instruction("Ö"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x8A).instruction("ó"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x8B).instruction("ò"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x8C).instruction("ô"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x8D).instruction("ö"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x8E).instruction("Ú"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x8F).instruction("Ù"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x90).instruction("Û"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x91).instruction("Ü"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x92).instruction("ú"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x93).instruction("ù"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x94).instruction("û"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x95).instruction("ü"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x96).instruction("Ç"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x97).instruction("ç"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x98).instruction("Ñ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x99).instruction("ñ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x9D).instruction("¿"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x9E).instruction("¡"));
    tokens.add(new Token((byte) 0xBB, (byte) 0x9F).instruction("α"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA0).instruction("β"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA2).instruction("Δ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA3).instruction("δ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA4).instruction("ε"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA5).instruction("λ"));
    // Mu greek letter
    tokens.add(new Token((byte) 0xBB, (byte) 0xA6).instruction("μ"));
    // Micro sign
    tokens.add(new Token((byte) 0xBB, (byte) 0xA6).instruction("µ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA8).instruction("ρ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xA9).instruction("Σ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xAB).instruction("φ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xAC).instruction("Ω"));
    // Two loops because there’s a gap between 'k' and 'l' codes.
    for (int i = 0; i < 11; i++) {
      tokens.add(new Token((byte) 0xBB, (byte) (0xB0 + i)).instruction("" + (char) ('a' + i)));
    }
    for (int i = 0; i < 15; i++) {
      tokens.add(new Token((byte) 0xBB, (byte) (0xBC + i)).instruction("" + (char) ('l' + i)));
    }
    tokens.add(new Token((byte) 0xBB, (byte) 0xCB).instruction("σ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xCC).instruction("τ"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xCD).instruction("Í"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xCE)
        .instruction("GarbageCollect", Language.ENGLISH)
        .instruction("RéorganiserMém", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0xCF).instruction("~"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD1).instruction("@"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD2).instruction("#"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD3).instruction("$"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD4).instruction("&"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD5).instruction("`"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD6).instruction(";"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD7).instruction("\\"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD8).instruction("|"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xD9).instruction("_"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xDA).instruction("%"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xDB).instruction("…"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xDC).instruction("∠"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xDD).instruction("ß"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xDE)
        .instruction("&xexpon;", Language.ENGLISH)
        .instruction("&xexpos;", Language.FRENCH));
    tokens.add(new Token((byte) 0xBB, (byte) 0xDF).instruction("&T;"));
    for (int i = 0; i < 11; i++) {
      tokens.add(new Token((byte) 0xBB, (byte) (0xE0 + i)).instruction("&sub" + i + ";"));
    }
    tokens.add(new Token((byte) 0xBB, (byte) 0xEB).instruction("←"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xEC).instruction("→"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xED).instruction("↑"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xEE).instruction("↓"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xF0).instruction("×"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xF1).instruction("∫"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xF2).instruction("⬆")); // Bold upwards arrow
    tokens.add(new Token((byte) 0xBB, (byte) 0xF3).instruction("⬇")); // Bold downwards arrow
    tokens.add(new Token((byte) 0xBB, (byte) 0xF4).instruction("√"));
    tokens.add(new Token((byte) 0xBB, (byte) 0xF5)
        .instruction("&invertedequal;", Language.ENGLISH)
        .instruction("&égalinversé;", Language.FRENCH));
    tokens.add(new Token((byte) 0xBC).instruction("√("));
    tokens.add(new Token((byte) 0xBD).instruction("∛("));
    tokens.add(new Token((byte) 0xBE).instruction("ln("));
    tokens.add(new Token((byte) 0xBF).instruction("e^("));
    tokens.add(new Token((byte) 0xC0).instruction("log("));
    tokens.add(new Token((byte) 0xC1).instruction("10^("));
    tokens.add(new Token((byte) 0xC2).instruction("sin("));
    tokens.add(new Token((byte) 0xC3)
        .instruction("sin-1(", Language.ENGLISH)
        .instruction("Arcsin(", Language.FRENCH));
    tokens.add(new Token((byte) 0xC4).instruction("cos("));
    tokens.add(new Token((byte) 0xC5)
        .instruction("cos-1(", Language.ENGLISH)
        .instruction("Arccos(", Language.FRENCH));
    tokens.add(new Token((byte) 0xC6).instruction("tan("));
    tokens.add(new Token((byte) 0xC7)
        .instruction("tan-1(", Language.ENGLISH)
        .instruction("Arctan(", Language.FRENCH));
    tokens.add(new Token((byte) 0xC8)
        .instruction("sinh(", Language.ENGLISH)
        .instruction("sh(", Language.FRENCH));
    tokens.add(new Token((byte) 0xC9)
        .instruction("Arcsinh(", Language.ENGLISH)
        .instruction("Argsh(", Language.FRENCH));
    tokens.add(new Token((byte) 0xCA)
        .instruction("cosh(", Language.ENGLISH)
        .instruction("ch(", Language.FRENCH));
    tokens.add(new Token((byte) 0xCB)
        .instruction("Arccosh(", Language.ENGLISH)
        .instruction("Argch(", Language.FRENCH));
    tokens.add(new Token((byte) 0xCC)
        .instruction("tanh(", Language.ENGLISH)
        .instruction("th(", Language.FRENCH));
    tokens.add(new Token((byte) 0xCD)
        .instruction("Arctanh(", Language.ENGLISH)
        .instruction("Argth(", Language.FRENCH));
    tokens.add(new Token((byte) 0xCE).instruction("If "));
    tokens.add(new Token((byte) 0xCF).instruction("Then"));
    tokens.add(new Token((byte) 0xD0).instruction("Else"));
    tokens.add(new Token((byte) 0xD1).instruction("While "));
    tokens.add(new Token((byte) 0xD2).instruction("Repeat "));
    tokens.add(new Token((byte) 0xD3).instruction("For("));
    tokens.add(new Token((byte) 0xD4).instruction("End"));
    tokens.add(new Token((byte) 0xD5).instruction("Return"));
    tokens.add(new Token((byte) 0xD6).instruction("Lbl "));
    tokens.add(new Token((byte) 0xD7).instruction("Goto "));
    tokens.add(new Token((byte) 0xD8).instruction("Pause "));
    tokens.add(new Token((byte) 0xD9).instruction("Stop"));
    tokens.add(new Token((byte) 0xDA).instruction("IS>("));
    tokens.add(new Token((byte) 0xDB).instruction("DS<("));
    tokens.add(new Token((byte) 0xDC).instruction("Input "));
    tokens.add(new Token((byte) 0xDD).instruction("Prompt "));
    tokens.add(new Token((byte) 0xDE).instruction("Disp "));
    tokens.add(new Token((byte) 0xDF)
        .instruction("DispGraph", Language.ENGLISH)
        .instruction("AffGraph", Language.FRENCH));
    tokens.add(new Token((byte) 0xE0).instruction("Output("));
    tokens.add(new Token((byte) 0xE1)
        .instruction("ClrHome", Language.ENGLISH)
        .instruction("EffEcr", Language.FRENCH));
    tokens.add(new Token((byte) 0xE2)
        .instruction("Fill(", Language.ENGLISH)
        .instruction("Remplir(", Language.FRENCH));
    tokens.add(new Token((byte) 0xE3)
        .instruction("SortA(", Language.ENGLISH)
        .instruction("Tricroi(", Language.FRENCH));
    tokens.add(new Token((byte) 0xE4)
        .instruction("SortD(", Language.ENGLISH)
        .instruction("TriDécroi(", Language.FRENCH));
    tokens.add(new Token((byte) 0xE5)
        .instruction("DispTable", Language.ENGLISH)
        .instruction("AffTable", Language.FRENCH));
    tokens.add(new Token((byte) 0xE6).instruction("Menu("));
    tokens.add(new Token((byte) 0xE7)
        .instruction("Send(", Language.ENGLISH)
        .instruction("Envoi(", Language.FRENCH));
    tokens.add(new Token((byte) 0xE8)
        .instruction("Get(", Language.ENGLISH)
        .instruction("Capt(", Language.FRENCH));
    tokens.add(new Token((byte) 0xE9)
        .instruction("PlotsOn ", Language.ENGLISH)
        .instruction("GraphAff ", Language.FRENCH));
    tokens.add(new Token((byte) 0xEA)
        .instruction("PlotsOff ", Language.ENGLISH)
        .instruction("GraphNAff ", Language.FRENCH));
    tokens.add(new Token((byte) 0xEB).instruction("ʟ"));
    tokens.add(new Token((byte) 0xEC)
        .instruction("Plot1(", Language.ENGLISH)
        .instruction("Graph1(", Language.FRENCH));
    tokens.add(new Token((byte) 0xED)
        .instruction("Plot2(", Language.ENGLISH)
        .instruction("Graph2(", Language.FRENCH));
    tokens.add(new Token((byte) 0xEE)
        .instruction("Plot3(", Language.ENGLISH)
        .instruction("Graph3(", Language.FRENCH));
    tokens.add(new Token((byte) 0xF0).instruction("^"));
    tokens.add(new Token((byte) 0xF1)
        .instruction("&xrt;", Language.ENGLISH)
        .instruction("&racinex;", Language.FRENCH));
    tokens.add(new Token((byte) 0xF2)
        .instruction("1-Var Stats ", Language.ENGLISH)
        .instruction("Stats 1-Var ", Language.FRENCH));
    tokens.add(new Token((byte) 0xF3)
        .instruction("2-Var Stats ", Language.ENGLISH)
        .instruction("Stats 2-Var ", Language.FRENCH));
    tokens.add(new Token((byte) 0xF4)
        .instruction("LinReg(a+bx) ", Language.ENGLISH)
        .instruction("RegLin(a+bx) ", Language.FRENCH));
    tokens.add(new Token((byte) 0xF5)
        .instruction("ExpReg ", Language.ENGLISH)
        .instruction("RegExp ", Language.FRENCH));
    tokens.add(new Token((byte) 0xF6)
        .instruction("LnReg ", Language.ENGLISH)
        .instruction("RegLn ", Language.FRENCH));
    tokens.add(new Token((byte) 0xF7)
        .instruction("PwrReg ", Language.ENGLISH)
        .instruction("RegPuiss ", Language.FRENCH));
    tokens.add(new Token((byte) 0xF8).instruction("Med-Med"));
    tokens.add(new Token((byte) 0xF9)
        .instruction("QuadReg ", Language.ENGLISH)
        .instruction("RegQuad", Language.FRENCH));
    tokens.add(new Token((byte) 0xFA)
        .instruction("ClrList ", Language.ENGLISH)
        .instruction("EffListe ", Language.FRENCH));
    tokens.add(new Token((byte) 0xFB)
        .instruction("ClrTable", Language.ENGLISH)
        .instruction("EffTable", Language.FRENCH));
    tokens.add(new Token((byte) 0xFC)
        .instruction("Histogram", Language.ENGLISH)
        .instruction("Histogramme", Language.FRENCH));
    tokens.add(new Token((byte) 0xFD)
        .instruction("xyLine", Language.ENGLISH)
        .instruction("Polygone", Language.FRENCH));
    tokens.add(new Token((byte) 0xFE)
        .instruction("Scatter", Language.ENGLISH)
        .instruction("Nuage", Language.FRENCH));
    tokens.add(new Token((byte) 0xFF)
        .instruction("LinReg(ax+b) ", Language.ENGLISH)
        .instruction("RegLin(ax+b) ", Language.FRENCH));

    TOKENS = tokens;
  }

  /**
   * Return the token corresponding to the given instruction.
   *
   * @param instr the instruction
   * @return the token
   */
  public static Optional<Token> getToken(final Language language, final String instr) {
    return TOKENS.stream().filter(t -> t.getInstruction(language).equals(instr)).findFirst();
  }

  /**
   * Check whether a token is a not digit.
   *
   * @param token The token.
   * @return True if the token is a not digit, false otherwise.
   */
  public static boolean isNonDigit(final Token token) {
    byte[] bytes = token.getBytes();
    return bytes.length != 1 || bytes[0] < 0x30 || bytes[0] > 0x39;
  }

  /**
   * Check whether this token is a new line.
   *
   * @param token The token to check.
   * @return True if the token is a new line, false otherwise.
   */
  public static boolean isNewLine(final Token token) {
    return LINE_END.equals(token);
  }

  private Tokens() {
  }
}
