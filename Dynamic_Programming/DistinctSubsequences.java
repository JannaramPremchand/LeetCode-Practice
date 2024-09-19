package Dynamic_Programming;

import java.util.Arrays;

public class DistinctSubsequences {
  int[][] DP;

  public static void main(String[] args) {
    System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
  }

  public int numDistinct(String s, String t) {
    DP = new int[s.length()][t.length()];
    for (int i = 0; i < s.length(); i++) {
      Arrays.fill(DP[i], -1);
    }
    return dp(0, 0, s, t);
  }

  private int dp(int i, int j, String s, String t) {
    if (j >= t.length()) return 1;
    else if (i >= s.length()) return 0;
    else if (DP[i][j] != -1) return DP[i][j];
    else {
      if (s.charAt(i) != t.charAt(j)) {
        DP[i][j] = dp(i + 1, j, s, t);
      } else {
        DP[i][j] = dp(i + 1, j + 1, s, t) + dp(i + 1, j, s, t);
      }
      return DP[i][j];
    }
  }
}
