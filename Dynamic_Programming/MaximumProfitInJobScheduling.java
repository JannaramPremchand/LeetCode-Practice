package Dynamic_Programming;

import java.util.*;

public class MaximumProfitInJobScheduling {
  private class Pair {
    int a, b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) {
    int[] st = {4, 2, 4, 8, 2};
    int[] et = {5, 5, 5, 10, 8};
    int[] p = {1, 2, 8, 10, 4};
    System.out.println(new MaximumProfitInJobScheduling().jobScheduling(st, et, p));
  }

  Map<Integer, Integer> DP;
  TreeMap<Integer, List<Pair>> graph;

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    DP = new HashMap<>();
    graph = new TreeMap<>();
    int start = 0;
    for (int i = 0; i < startTime.length; i++) {
      List<Pair> children = graph.getOrDefault(startTime[i], new ArrayList<>());
      children.add(new Pair(endTime[i], profit[i]));
      graph.putIfAbsent(startTime[i], children);
      start = Math.min(start, startTime[i]);
    }
    return dp(start);
  }

  private int dp(int i) {
    Integer current = graph.ceilingKey(i);
    if (current == null) return 0;
    else if (DP.containsKey(current)) return DP.get(current);
    else {
      List<Pair> children = graph.get(current);
      int profit = 0;
      for (Pair c : children) {
        profit = Math.max(profit, dp(c.a) + c.b);
      }
      profit = Math.max(profit, dp(current + 1));
      DP.put(current, profit);
      return profit;
    }
  }
}
