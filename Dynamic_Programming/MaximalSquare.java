package Dynamic_Programming;

public class MaximalSquare {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    char[][] A = {
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}
    };
    System.out.println(new MaximalSquare().maximalSquare(A));
  }

  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (j - 1 >= 0 && i - 1 >= 0) {
          if (matrix[i][j] == '1') {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
          }
        } else {
          dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        max = Math.max(max, dp[i][j]);
      }
    }
    return max * max;
  }
}
