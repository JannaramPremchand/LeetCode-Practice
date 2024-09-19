package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 1};
    System.out.println(new ContiguousArray().findMaxLength(A));
  }

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        count--;
      } else count++;
      if (count == 0) {
        max = Math.max(max, i + 1);
      } else {
        if (map.containsKey(count)) {
          int index = map.get(count);
          max = Math.max(max, i - index);
        } else {
          map.put(count, i);
        }
      }
    }
    return max;
  }
}
