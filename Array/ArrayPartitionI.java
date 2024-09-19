package Array;

import java.util.*;


public class ArrayPartitionI {
  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4};
    System.out.println(new ArrayPartitionI().arrayPairSum(A));
  }

  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 1; i < nums.length; i += 2) {
      sum += Math.min(nums[i - 1], nums[i]);
    }
    return sum;
  }
}
