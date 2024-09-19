package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 3, 6, 12, 7};
    System.out.println(new ContinuousSubarraySum().checkSubarraySum(A, 6));
  }

  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int mod = (k == 0) ? sum : sum % k; // this is to handle case where k is 0
      if (map.containsKey(mod)) {
        if (i - map.get(mod) > 1) {
          return true;
        }
      } else {
        map.put(mod, i);
      }
    }
    return false;
  }
}
