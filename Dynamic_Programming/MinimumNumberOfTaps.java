package Dynamic_Programming;

import java.util.Arrays;

public class MinimumNumberOfTaps {
  public static void main(String[] args) {
    int[] A = {0, 1, 2, 0, 0, 1, 1, 0};
    System.out.println(new MinimumNumberOfTaps().minTaps(7, A));
  }

  int[] DP;

  public int minTaps(int n, int[] ranges) {
    DP = new int[n + 1];
    Arrays.fill(DP, -2);
    return dp(0, 0, ranges, n);
  }

  private int dp(int i, int prev, int[] R, int n) {
    if (i > n) return 0;
    else if (DP[i] != -2) return DP[i];
    else {
      int min = Integer.MAX_VALUE;
      int start = R[prev] > 0 ? prev : i;
      for (int j = start; j < start + 100 && j <= n; j++) {
        if (j - R[j] <= prev) {
          int result = dp(j + R[j] + 1, j + R[j], R, n);
          if (result >= 0) {
            min = Math.min(min, result + 1);
          }
        }
      }
      DP[i] = (min == Integer.MAX_VALUE ? -1 : min);
      return DP[i];
    }
  }
}
