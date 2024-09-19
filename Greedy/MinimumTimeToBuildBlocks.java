package Greedy;

import java.util.PriorityQueue;

public class MinimumTimeToBuildBlocks {
  public static void main(String[] args) {
    int[] A = {1, 2, 3};
    System.out.println(new MinimumTimeToBuildBlocks().minBuildTime(A, 2));
  }

  public int minBuildTime(int[] blocks, int split) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int b : blocks) queue.offer(b);
    while (queue.size() != 1) {
      int a = queue.poll();
      int b = queue.poll();
      queue.offer(Math.max(a, b) + split);
    }
    return queue.poll();
  }
}
