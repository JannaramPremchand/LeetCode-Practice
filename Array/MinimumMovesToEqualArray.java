package Array;

import java.util.Arrays;


public class MinimumMovesToEqualArray {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 3};
    System.out.println(new MinimumMovesToEqualArray().minMoves2(A));
  }

  public int minMoves2(int[] nums) {
    if (nums.length == 1) return 0;
    else if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
    Arrays.sort(nums);
    int median;
    if ((nums.length % 2) == 1) {
      median = (nums.length / 2);
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += Math.abs(nums[i] - nums[median]);
      }
      return sum;
    } else {
      median = (nums.length / 2) - 1;
      int sum = 0;
      int min;
      for (int i = 0; i < nums.length; i++) {
        sum += Math.abs(nums[i] - nums[median]);
      }
      min = sum;
      sum = 0;
      median = (nums.length / 2);
      for (int i = 0; i < nums.length; i++) {
        sum += Math.abs(nums[i] - nums[median]);
      }
      min = Math.min(min, sum);
      return min;
    }
  }
}
