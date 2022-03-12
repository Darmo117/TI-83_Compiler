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
   * Return this file’s path.
   */
  public String getPath() {
    return this.path;
  }

  /**
   * Return this file’s name without the extension.
   */
  public String getName() {
    return this.name;
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
    int l;

    // File type
    ArraysUtil.stringCopy(HEADER, header, 0, 11);
    // Comment
    ArraysUtil.stringCopy(COMMENT, header, 11, 42);
    // Comment delimiter
    header[52] = 0x00;
    // Data length + 19 (little-endian)
    l = this.data.length + 19;
    header[53] = (byte) (l & 0x00FF);
    header[54] = (byte) ((l & 0xFF00) >> 8);
    // Things
    header[55] = 0x0D;
    header[56] = 0x00;
    // Data length + 2 (little-endian)
    l = this.data.length + 2;
    header[57] = (byte) (l & 0x00FF);
    header[58] = (byte) ((l & 0xFF00) >> 8);
    // Protection
    header[59] = (byte) (this.isEditable() ? 0x05 : 0x06);
    // Program name
    ArraysUtil.stringCopy(this.name, header, 60, 8);
    // More things
    header[68] = 0x00;
    header[69] = 0x00;
    // Data length + 2 (little-endian)
    header[70] = (byte) (l & 0x00FF);
    header[71] = (byte) ((l & 0xFF00) >> 8);
    // Data length (little-endian)
    l = this.data.length;
    header[72] = (byte) (l & 0x00FF);
    header[73] = (byte) ((l & 0xFF00) >> 8);

    byte[] content = new byte[header.length + this.data.length + 2];

    // Header and program data insertion.
    ArraysUtil.arrayCopy(header, content, 0);
    ArraysUtil.arrayCopy(this.data, content, header.length);

    // Checksum (little-endian)
    l = 0;
    for (int i = 0x37; i < content.length - 2; i++) {
      l += (content[i] < 0) ? content[i] + 256 : content[i];
    }

    content[content.length - 2] = (byte) (l & 0x00FF);
    content[content.length - 1] = (byte) ((l & 0xFF00) >> 8);

    try (FileOutputStream fos = new FileOutputStream(this.getFullPath())) {
      fos.write(content);
    }
  }
}
