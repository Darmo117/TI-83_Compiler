package net.darmo_creations.ti83_compiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.darmo_creations.ti83_compiler.utils.ArraysUtil;

public class BinaryFile {
  private String path;
  private String name;
  private byte[] data;

  public static final String FORMAT = "8xp";
  public static final String FILE_TYPE = "**TI83F*\u001a\n\0";
  public static final String COMMENT = "Created by Java TI-Compiler";

  public BinaryFile(String path, String name, byte[] data) {
    this.path = path;
    setName(name);
    setData(data);
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getAbsolutePath() {
    return getPath() + File.separator + getName() + "." + FORMAT;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (!name.matches("[A-Zθ][A-Zθ0-9]{0,7}")) {
      throw new IllegalArgumentException("invalid program name");
    }

    this.name = name;
  }

  /**
   * Changes the program's data.<br />
   * <b>NOTE: the tokens are not checked!</b>
   * 
   * @param data the program's data
   */
  public void setData(byte[] data) {
    this.data = data;
  }

  /**
   * Writes the file.
   * 
   * @throws IOException if the file could not be written
   */
  public void writeFile() throws IOException {
    byte[] header = new byte[74];
    int l;

    // File type
    ArraysUtil.stringCopy(FILE_TYPE, header, 0, 11);
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
    header[59] = 0x05;
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

    try (FileOutputStream fos = new FileOutputStream(new File(this.path + File.separator + this.name + "." + FORMAT))) {
      fos.write(content);
    }
  }
}
