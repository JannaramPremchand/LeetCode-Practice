package Dynamic_Programming;

import java.util.Arrays;

public class LargestMultipleOfThree {
  public static void main(String[] args) {
    int[] A = {8, 4, 1, 7};
    System.out.println(new LargestMultipleOfThree().largestMultipleOfThree(A));
  }

  int[][][] DP;

  public String largestMultipleOfThree(int[] digits) {
    Arrays.sort(digits);
    for (int i = 0, j = digits.length - 1; i < j; i++, j--) {
      int t = digits[i];
      digits[i] = digits[j];
      digits[j] = t;
    }
    DP = new int[digits.length][3][2];
    for (int i = 0; i < digits.length; i++) {
      for (int j = 0; j < 3; j++) {
        Arrays.fill(DP[i][j], -2);
      }
    }
    dp(0, 0, digits);
    StringBuilder sb = new StringBuilder();
    int r = 0;
    for (int i = 0; i < digits.length; i++) {
      if (DP[i][r][1] >= DP[i][r][0]) {
        if (sb.length() != 1 || sb.charAt(0) != '0') {
          sb.append(digits[i]);
        }
        r = (Integer.parseInt(String.valueOf(r + "" + digits[i])) % 3);
      }
    }
    return sb.toString();
  }

  private int dp(int i, int r, int[] A) {
    if (i == A.length) {
      return r == 0 ? 0 : -1;
    } else if (DP[i][r][0] != -2) {
      return Math.max(DP[i][r][0], DP[i][r][1]);
    } else {
      int d = A[i];
      int newR = (Integer.parseInt(String.valueOf(r + "" + d)) % 3);
      int result = dp(i + 1, newR, A);
      if (result >= 0) {
        result = result + 1;
      }
      DP[i][r][1] = result;
      DP[i][r][0] = dp(i + 1, r, A);
      return Math.max(DP[i][r][0], DP[i][r][1]);
    }
  }
}
