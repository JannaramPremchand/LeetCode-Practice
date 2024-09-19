package Dynamic_Programming;

import java.util.Arrays;

public class CombinationSumIV {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 3};
    System.out.println(new CombinationSumIV().combinationSum4(A, 4));
  }

  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return backtrack(nums, dp, target);
  }

  private int backtrack(int[] nums, int[] dp, int sum) {
    int total = 0;
    if (sum < 0) return 0;
    if (dp[sum] != -1) return dp[sum];
    else {
      for (int num : nums) {
        total += backtrack(nums, dp, sum - num);
      }
    }
    dp[sum] = total;
    return dp[sum];
  }
}
