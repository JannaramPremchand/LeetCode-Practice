package Heap;

import java.util.*;

public class KClosestPointsToOrigin {
  public static void main(String[] args) {
    int[][] A = {{3, 3}, {5, -1}, {-2, 4}};
    int[][] ans = new KClosestPointsToOrigin().kClosest(A, 2);
    System.out.println();
  }

  class Point {
    int a, b;

    Point(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public long distance() {
      return (long) (a * a) + (long) (b * b);
    }
  }

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<Point> pq =
        new PriorityQueue<>((o1, o2) -> Long.compare(o2.distance(), o1.distance()));
    for (int[] p : points) {
      pq.offer(new Point(p[0], p[1]));
      if (pq.size() > K) {
        pq.poll();
      }
    }
    int[][] ans = new int[K][2];
    int i = 0;
    while (!pq.isEmpty()) {
      Point point = pq.poll();
      ans[i][0] = point.a;
      ans[i++][1] = point.b;
    }
    return ans;
  }
}
