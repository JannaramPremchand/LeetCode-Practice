package String;

public class StringCompression {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    char[] A = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    System.out.println(new StringCompression().compress(A));
  }

  public int compress(char[] chars) {
    int count = 0;
    int i = 0;
    int p = 0;
    for (int j = 0; j < chars.length; j++) {
      if (chars[i] == chars[j]) {
        count++;
      } else {
        chars[p] = chars[i];
        p++;
        if (count > 1) {
          String countStr = String.valueOf(count);
          for (int l = 0; l < countStr.length(); l++) {
            chars[p++] = countStr.charAt(l);
          }
        }
        i = j;
        count = 1;
      }
    }
    chars[p] = chars[i];
    p++;
    if (count > 1) {
      String countStr = String.valueOf(count);
      for (int l = 0; l < countStr.length(); l++) {
        chars[p++] = countStr.charAt(l);
      }
    }
    return p;
  }
}
