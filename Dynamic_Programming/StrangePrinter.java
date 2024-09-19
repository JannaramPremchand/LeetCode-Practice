package Dynamic_Programming;

public class StrangePrinter {
  public static void main(String[] args) {
    String A = "aaaaaaa";
    System.out.println(new StrangePrinter().strangePrinter(A));
  }

  int DP[][];

  public int strangePrinter(String s) {
    DP = new int[s.length() + 1][s.length() + 1];
    return calculate(0, s.length() - 1, s);
  }

  private int calculate(int i, int j, String s) {
    if (i > j) return 0;
    else if (DP[i][j] != 0) return DP[i][j];
    else {
      DP[i][j] = calculate(i, j - 1, s) + 1;
      int min = DP[i][j];
      for (int m = i; m < j; m++) {
        if (s.charAt(m) == s.charAt(j)) {
          min = Math.min(min, calculate(i, m, s) + calculate(m + 1, j - 1, s));
        }
      }
      DP[i][j] = min;
      return DP[i][j];
    }
  }
}
