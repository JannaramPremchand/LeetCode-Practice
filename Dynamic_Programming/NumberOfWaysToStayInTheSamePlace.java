package Dynamic_Programming;

import java.util.Arrays;

public class NumberOfWaysToStayInTheSamePlace {

  private static final int MOD = (int) (1e9 + 7);

  public static void main(String[] args) {
    System.out.println(new NumberOfWaysToStayInTheSamePlace().numWays(500, 1000000));
  }

  int[][] DP;

  public int numWays(int steps, int arrLen) {
    int colLimit = arrLen < steps ? arrLen : steps;
    DP = new int[colLimit + 1][steps + 1];
    for (int i = 0; i <= colLimit; i++) {
      Arrays.fill(DP[i], -1);
    }
    DP[0][0] = 1;
    return (int) dp(0, steps, arrLen);
  }

  private long dp(int i, int n, int A) {
    if (i < 0 || i >= A) return 0;
    else if (n < 0) return 0;
    if (DP[i][n] != -1) return DP[i][n];
    DP[i][n] =
        (int)
            (((((dp(i, n - 1, A) % MOD) + (dp(i - 1, n - 1, A) % MOD)) % MOD)
                    + (dp(i + 1, n - 1, A) % MOD))
                % MOD);
    return DP[i][n];
  }
}
