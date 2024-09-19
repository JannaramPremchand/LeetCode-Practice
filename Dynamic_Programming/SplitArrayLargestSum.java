package Dynamic_Programming;

public class SplitArrayLargestSum {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {7, 2, 5, 10, 8};
    System.out.println(new SplitArrayLargestSum().splitArray(A, 2));
  }

  public int splitArray(int[] nums, int m) {
    int[][] dp = new int[m][nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (j + 1 >= nums.length) break;
        for (int k = 0; k < m - 1; k++) {
          dp[k + 1][i] = (dp[k + 1][i] == 0) ? Integer.MAX_VALUE : dp[k + 1][i];
          int temp = Math.max(sum, dp[k][j + 1]);
          dp[k + 1][i] = Math.min(dp[k + 1][i], temp);
        }
      }
      dp[0][i] = sum;
    }
    return dp[m - 1][0];
  }
}
