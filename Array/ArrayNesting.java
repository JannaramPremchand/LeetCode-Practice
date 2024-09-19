package Array;

import java.util.*;


public class ArrayNesting {
  public static void main(String[] args) {
    int[] A = {5, 4, 0, 3, 1, 6, 2};
    System.out.println(new ArrayNesting().arrayNesting(A));
  }

  Set<Integer> done;
  int count;

  public int arrayNesting(int[] nums) {
    done = new HashSet<>();
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (!done.contains(i)) {
        count = 0;
        dfs(i, nums);
        max = Math.max(max, count);
      }
    }
    return max;
  }

  private void dfs(int i, int[] nums) {
    done.add(i);
    count++;
    int n = nums[i];
    if (!done.contains(n)) {
      dfs(n, nums);
    }
  }
}
