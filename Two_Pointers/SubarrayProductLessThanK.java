package Two_Pointers;

import java.util.ArrayDeque;
import java.util.Queue;

public class SubarrayProductLessThanK {

  public static void main(String[] args) throws Exception {
    int[] A = {10, 2, 2, 5, 4, 4, 4, 3, 7, 7};
    System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(A, 289));
  }

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    long prod = 1;
    int count = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < k) {
        count++;
        if ((prod * nums[i]) < k) {
          prod *= nums[i];
          if (!queue.isEmpty()) {
            count += (i - queue.peek());
          }
        } else {
          while (!queue.isEmpty()) {
            int last = queue.poll();
            prod /= nums[last];
            if ((prod * nums[i]) < k) {
              prod = prod * nums[i];
              if (!queue.isEmpty()) {
                count += (i - queue.peek());
              }
              break;
            }
          }
        }
        if (queue.isEmpty()) {
          prod = nums[i];
        }
        queue.offer(i);
      } else {
        queue.clear();
      }
    }
    return count;
  }
}
