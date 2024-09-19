package Array;

import java.util.HashMap;
import java.util.Map;


public class SubarraySumEqualsK {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 1, -2, 3, -1, -1};
    System.out.println(new SubarraySumEqualsK().subarraySum(A, 2));
  }

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    for (int i : nums) {
      sum += i;
      Integer count = map.get(sum);
      if (count == null) {
        map.put(sum, 1);
      } else {
        map.put(sum, count + 1);
      }
    }
    sum = 0;
    int result = 0;
    for (int i : nums) {
      int key = sum + k;
      if (map.containsKey(key)) {
        int count = map.get(key);
        result += count;
      }
      sum += i;
      if (map.containsKey(sum)) {
        int count = map.get(sum);
        if (count - 1 > 0) {
          map.put(sum, count - 1);
        } else {
          map.remove(sum);
        }
      }
    }
    return result;
  }
}
