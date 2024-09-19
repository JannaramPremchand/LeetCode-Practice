package Dynamic_Programming;

import java.util.Arrays;

public class ValidPalindromeIII {
  public static void main(String[] args) {
    System.out.println(new ValidPalindromeIII().isValidPalindrome("abc", 0));
  }

  int[][] DP;

  public boolean isValidPalindrome(String s, int k) {
    DP = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      Arrays.fill(DP[i], -1);
    }
    return dp(0, s.length() - 1, s) <= k;
  }

  private int dp(int i, int j, String S) {
    if (i == j) return 0;
    else if (i > j) return 0;
    else if (DP[i][j] != -1) return DP[i][j];
    else {
      int min = Integer.MAX_VALUE;
      if (S.charAt(i) != S.charAt(j)) {
        min = Math.min(min, Math.min(dp(i + 1, j, S), dp(i, j - 1, S)) + 1);
      } else {
        min = dp(i + 1, j - 1, S);
      }
      DP[i][j] = min;
      return min;
    }
  }
}
