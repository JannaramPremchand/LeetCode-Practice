package Dynamic_Programming;

public class MinCostClimbingStairs {
  public static void main(String[] args) throws Exception {}

  public int minCostClimbingStairs(int[] cost) {
    for (int i = cost.length - 1; i >= 0; i--) {
      if (i + 1 < cost.length && i + 2 < cost.length) {
        cost[i] = Math.min(cost[i] + cost[i + 1], cost[i] + cost[i + 2]);
      }
    }
    return Math.min(cost[0], cost[1]);
  }
}
