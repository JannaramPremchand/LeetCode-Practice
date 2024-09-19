package Array;

import java.util.ArrayList;
import java.util.List;


public class TwoSum {

  class NumIndex {
    int i, e;

    NumIndex(int i, int e) {
      this.i = i;
      this.e = e;
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int[] ans = new TwoSum().twoSum(nums, 6);
    for (int i : ans) System.out.println(i);
  }

  public int[] twoSum(int[] nums, int target) {
    List<NumIndex> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      NumIndex n = new NumIndex(i, nums[i]);
      list.add(n);
    }
    list.sort((o1, o2) -> Integer.compare(o1.e, o2.e));

    int[] ans = new int[2];
    for (int i = 0, j = nums.length - 1; i < j; ) {
      NumIndex numi = list.get(i);
      NumIndex numj = list.get(j);
      int sum = numi.e + numj.e;
      if (sum == target) {
        ans[0] = numi.i;
        ans[1] = numj.i;
        return ans;
      } else if (sum > target) {
        j--;
      } else i++;
    }
    return ans;
  }
}
