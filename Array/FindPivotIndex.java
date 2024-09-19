package Array;

import java.util.*;


public class FindPivotIndex {
  public static void main(String[] args) {}

  public int pivotIndex(int[] nums) {
    if (nums.length == 1) return 0;
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    left[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      left[i] = left[i - 1] + nums[i];
    }
    right[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      right[i] = right[i + 1] + nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      int l, r;
      if (i == 0) {
        l = 0;
      } else {
        l = left[i - 1];
      }

      if (i == nums.length - 1) {
        r = 0;
      } else {
        r = right[i + 1];
      }
      if (l == r) return i;
    }
    return -1;
  }
}
