package Dynamic_Programming;

public class LargestSumOfAverages {

  public static void main(String[] args) {
    int[] A = {9, 1, 2, 3, 9};
    System.out.println(new LargestSumOfAverages().largestSumOfAverages(A, 3));
  }

  public double largestSumOfAverages(int[] A, int K) {
    double[][] dp = new double[K][A.length];
    for (int i = dp[0].length - 1; i >= 0; i--) {
      dp[0][i] = A[i];
      if (i + 1 < dp[0].length) {
        dp[0][i] += dp[0][i + 1];
      }
    }

    for (int i = dp[0].length - 1, j = 1; i >= 0; i--, j++) {
      dp[0][i] = dp[0][i] / j;
    }

    for (int i = dp[0].length - 1; i >= 0; i--) {
      for (int j = 1; j < dp.length; j++) {
        double sum = 0.0D;
        for (int k = i, c = 1; k < dp[0].length; k++, c++) {
          sum += A[k];
          if (k + 1 < dp[0].length) {
            double avg = sum / c;
            avg += dp[j - 1][k + 1];
            dp[j][i] = Math.max(dp[j][i], avg);
          }
        }
      }
    }
    return dp[K - 1][0];
  }
}
