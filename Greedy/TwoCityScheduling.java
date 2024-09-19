package Greedy;

import java.util.*;

public class TwoCityScheduling {
  public static void main(String[] args) {
    int[][] A = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
    System.out.println(new TwoCityScheduling().twoCitySchedCost(A));
  }

  class Pair {
    int max, i;

    Pair(int max, int i) {
      this.max = max;
      this.i = i;
    }
  }

  public int twoCitySchedCost(int[][] costs) {
    int min = 0;

    for (int i = 0; i < costs.length; i++) {
      min += costs[i][0];
    }

    List<Pair> list = new ArrayList<>();
    for (int i = 0; i < costs.length; i++) {
      list.add(new Pair(costs[i][0] - costs[i][1], i));
    }
    list.sort((o1, o2) -> Integer.compare(o2.max, o1.max));

    for (int i = 0, N = (list.size() / 2); i < N; i++) {
      min -= list.get(i).max;
    }
    return min;
  }
}
