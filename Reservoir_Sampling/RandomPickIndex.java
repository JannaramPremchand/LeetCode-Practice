package Reservoir_Sampling;

import java.util.Random;


public class RandomPickIndex {

  private int[] nums;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 3, 3, 3};
    System.out.println(new RandomPickIndex(A).pick(1));
  }

  public RandomPickIndex(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    int count = 0;
    for (int num : nums) {
      if (num == target) {
        count++;
      }
    }
    Random random = new Random();
    int nPick = 1 + random.nextInt(count);
    count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (++count == nPick) {
          return i;
        }
      }
    }
    return 0; // this is impossible
  }
}
