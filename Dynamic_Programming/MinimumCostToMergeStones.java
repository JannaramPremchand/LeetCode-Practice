package Dynamic_Programming;

public class MinimumCostToMergeStones {
  public static void main(String[] args) {
    int[] A = {3, 5, 1, 2, 6};
    System.out.println(new MinimumCostToMergeStones().mergeStones(A, 2));
  }

  private int[][][] DP;
  private int K;
  private int[] sum;

  public int mergeStones(int[] stones, int K) {
    if (((stones.length - 1) % (K - 1)) != 0) return -1;
    DP = new int[stones.length][stones.length][K + 1];
    this.K = K;
    sum = new int[stones.length];
    sum[0] = stones[0];
    for (int i = 1; i < stones.length; i++) {
      sum[i] = (sum[i - 1] + stones[i]);
    }
    for (int i = 0; i < stones.length; i++) {
      for (int j = 0; j < stones.length; j++) {
        for (int k = 1; k <= K; k++) {
          if (k == 1 && i == j) {
            DP[i][j][k] = 0;
          } else DP[i][j][k] = 999999;
        }
      }
    }
    for (int r = 2; r <= stones.length; r++) {
      for (int i = 0; i < stones.length; i++) {
        int j = i + r - 1;
        if (j < stones.length) {
          for (int k = 2; k <= K; k++) {
            int min = Integer.MAX_VALUE;
            for (int t = i; t < j; t++) {
              min = Math.min(min, DP[i][t][k - 1] + DP[t + 1][j][1]);
            }
            DP[i][j][k] = min;
          }
          DP[i][j][1] = DP[i][j][K] + (sum[j] - ((i - 1) >= 0 ? sum[i - 1] : 0));
        }
      }
    }
    return DP[0][stones.length - 1][1];
    // return dp(0, stones.length - 1, 1);
  }

  private int dp(int s, int e, int X) {
    if (s == e) {
      if (X == 1) return 0;
      else return 999999;
    }
    if (DP[s][e][X] != 0) return DP[s][e][X];
    if (X == 1) {
      DP[s][e][X] = dp(s, e, K) + sum[e] - ((s - 1) >= 0 ? sum[s - 1] : 0);
      return DP[s][e][X];
    } else {
      int min = Integer.MAX_VALUE;
      for (int t = s; t < e; t++) {
        min = Math.min(min, dp(s, t, X - 1) + dp(t + 1, e, 1));
      }
      DP[s][e][X] = min;
      return DP[s][e][X];
    }
  }
}
