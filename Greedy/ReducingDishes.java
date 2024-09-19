package Greedy;

import java.util.*;

public class ReducingDishes {
  public static void main(String[] args) {
    int[] A = {4, 3, 2};
    System.out.println(new ReducingDishes().maxSatisfaction(A));
  }

  public int maxSatisfaction(int[] satisfaction) {
    Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    Arrays.stream(satisfaction).forEach(pq::offer);
    int max = 0, sum = 0;
    while (!pq.isEmpty()) {
      if ((max + sum) >= max) {
        max += sum;
        sum += pq.poll();
      } else break;
    }
    return max;
  }
}
