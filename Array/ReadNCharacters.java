package Array;


public class ReadNCharacters {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {}

  /**
   * @param buf
   * @param n
   * @return
   */
  public int read(char[] buf, int n) {
    int i = 0;
    int toRead = Math.min(n, buf.length);
    while (i < toRead) {
      char[] temp = new char[4];
      int r = read4(temp);
      for (int j = 0; j < r && i < toRead; j++) {
        buf[i] = temp[j];
        i++;
      }
      if (r < 4) break;
    }
    return Math.min(i, toRead);
  }

  private int read4(char[] buf) {
    return 1; // return fake value just to resolve compilation error
  }
}
