package net.darmo_creations.ti83_compiler;

import net.darmo_creations.ti83_compiler.compiler.Compiler;
import net.darmo_creations.ti83_compiler.utils.ArraysUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class represents a .8xp program file.
 *
 * @author Damien Vergnet
 */
public class BinaryFile {
  public static final String EXTENSION = "8xp";
  public static final String HEADER = "**TI83F*\u001a\n\n";
  public static final String COMMENT = "Created by Java TI-Compiler v" + Compiler.VERSION;

  private final String path;
  private final String name;
  private final byte[] data;
  private final boolean editable;

  /**
   * Create a new .8xp file.
   *
   * @param path     File’s path.
   * @param name     File’s name without the extension.
   * @param data     File’s data. Tokens validity is not checked.
   * @param editable Whether the resulting file should be editable from calculators.
   */
  public BinaryFile(final String path, final String name, final byte[] data, final boolean editable) {
    this.path = path;
    if (!name.matches("[A-Zθ][A-Zθ0-9]{0,7}")) {
      throw new IllegalArgumentException("invalid program name");
    }
    this.name = name;
    this.data = data;
    this.editable = editable;
  }

  /**
   * Return the full path of this file (path + name + extension).
   */
  public String getFullPath() {
    return this.path + File.separator + this.name + "." + EXTENSION;
  }

  /**
   * Return true if this file will be editable from calculators, false otherwise.
   */
  public boolean isEditable() {
    return this.editable;
  }

  /**
   * Write the file to disk.
   *
   * @throws IOException If the file could not be written.
   */
  public void writeFile() throws IOException {
    byte[] header = new byte[74];

    // File type
    ArraysUtil.stringCopy(HEADER, header, 0, 11);
    // Comment
    ArraysUtil.stringCopy(COMMENT, header, 11, 42);
    // Comment delimiter
    header[52] = 0x00;
    // Data length + 19 (little-endian)
    int dataLength19 = this.data.length + 19;
    header[53] = (byte) (dataLength19 & 0x00FF);
    header[54] = (byte) ((dataLength19 & 0xFF00) >> 8);
    // Things
    header[55] = 0x0D;
    header[56] = 0x00;
    // Data length + 2 (little-endian)
    int dataLength2 = this.data.length + 2;
    header[57] = (byte) (dataLength2 & 0x00FF);
    header[58] = (byte) ((dataLength2 & 0xFF00) >> 8);
    // Protection
    header[59] = (byte) (this.isEditable() ? 0x05 : 0x06);
    // Program name
    ArraysUtil.stringCopy(this.name, header, 60, 8);
    // More things
    header[68] = 0x00;
    header[69] = 0x00;
    // Data length + 2 (little-endian)
    header[70] = (byte) (dataLength2 & 0x00FF);
    header[71] = (byte) ((dataLength2 & 0xFF00) >> 8);
    // Data length (little-endian)
    header[72] = (byte) (this.data.length & 0x00FF);
    header[73] = (byte) ((this.data.length & 0xFF00) >> 8);

    byte[] content = new byte[header.length + this.data.length + 2];

    // Header and program data insertion
    ArraysUtil.arrayCopy(header, content, 0);
    ArraysUtil.arrayCopy(this.data, content, header.length);

    // Checksum (little-endian)
    int checkSum = 0;
    for (int i = 0x37; i < content.length - 2; i++) {
      checkSum += (content[i] < 0) ? content[i] + 256 : content[i];
    }
    content[content.length - 2] = (byte) (checkSum & 0x00FF);
    content[content.length - 1] = (byte) ((checkSum & 0xFF00) >> 8);

    try (FileOutputStream fos = new FileOutputStream(this.getFullPath())) {
      fos.write(content);
    }
  }
}
