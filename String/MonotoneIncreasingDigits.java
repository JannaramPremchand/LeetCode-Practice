package String;


public class MonotoneIncreasingDigits {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(100001));
  }

  public int monotoneIncreasingDigits(int N) {
    String s = String.valueOf(N);
    if (s.length() == 1) return N;
    int p = -1;
    int prev = N % 10;
    for (int i = s.length() - 2; i >= 0; i--) {
      int curr = Integer.parseInt(String.valueOf(s.charAt(i)));
      if (curr > prev) {
        p = i;
        prev = curr - 1;
      } else {
        prev = curr;
      }
    }
    if (p == -1) return N;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (i == p) {
        int pV = Integer.parseInt(String.valueOf(s.charAt(i)));
        result.append(pV - 1);
        break;
      }
      result.append(String.valueOf(s.charAt(i)));
    }
    for (int i = p + 1; i < s.length(); i++) {
      result.append("9");
    }
    return Integer.parseInt(result.toString());
  }
}
