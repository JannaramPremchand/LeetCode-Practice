package Array;

import java.util.*;


public class MeetingScheduler {
  public static void main(String[] args) {
    int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
    int[][] slots2 = {{0, 15}, {60, 70}};
    List<Integer> result = new MeetingScheduler().minAvailableDuration(slots1, slots2, 12);
    System.out.println();
  }

  private class Node {
    int s, e, type;

    Node(int s, int e, int type) {
      this.s = s;
      this.e = e;
      this.type = type;
    }
  }

  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    PriorityQueue<Node> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              int r = Integer.compare(o1.s, o2.s);
              if (r == 0) {
                return Integer.compare(o1.e, o2.e);
              } else return r;
            });
    for (int[] s : slots1) {
      pq.offer(new Node(s[0], s[1], 1));
    }
    for (int[] s : slots2) {
      pq.offer(new Node(s[0], s[1], 2));
    }
    Node prev = null;
    while (!pq.isEmpty()) {
      Node node = pq.poll();
      if (prev == null) {
        prev = node;
      } else {
        if (prev.type != node.type) {
          int s = Math.max(prev.s, node.s);
          int e = Math.min(prev.e, node.e);
          if ((e - s) >= duration) {
            return Arrays.asList(s, s + duration);
          }
        }
        if (node.e > prev.e) {
          prev = node;
        }
      }
    }
    return new ArrayList<>();
  }
}
