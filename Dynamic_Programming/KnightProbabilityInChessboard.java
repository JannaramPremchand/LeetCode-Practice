package Dynamic_Programming;

import java.util.Arrays;

public class KnightProbabilityInChessboard {

  int[] R = {1, -1, 2, -2, -1, -2, 2, 1};
  int[] C = {2, 2, 1, 1, -2, -1, -1, -2};

  double[][][] dp;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new KnightProbabilityInChessboard().knightProbability(3, 2, 0, 0));
  }

  public double knightProbability(int N, int K, int r, int c) {
    dp = new double[N][N][K + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        Arrays.fill(dp[i][j], -1.0D);
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        dp[i][j][0] = 1.0D;
      }
    }
    return dp(dp, r, c, K, N);
  }

  private double dp(double[][][] dp, int r, int c, int K, int N) {
    if (r < 0 || r >= N || c < 0 || c >= N) return 0.0D;
    if (dp[r][c][K] != -1.0D) return dp[r][c][K];
    double sum = 0.0D;
    for (int i = 0; i < 8; i++) {
      int newR = r + R[i];
      int newC = c + C[i];
      if (newR >= 0 && newR < N && newC >= 0 && newC < N) {
        sum += dp(dp, newR, newC, K - 1, N);
      }
    }
    dp[r][c][K] = (sum / 8.0);
    return dp[r][c][K];
  }
}
