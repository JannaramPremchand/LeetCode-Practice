package Dynamic_Programming;

import java.util.Arrays;

public class PaintHouseIII {
  public static void main(String[] args) {
    //        int[] h = {0,0};
    //        int[][] cost = {{1,2}, {1,2}};
    int[] h = {3, 1, 2, 3};
    int[][] cost = {{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}};
    int m = 5;
    int n = 2;
    int target = 5;
    System.out.println(new PaintHouseIII().minCost(h, cost, m, n, target));
  }

  int[][][] DP;

  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    DP = new int[houses.length][target + 1][n + 1];
    for (int i = 0; i < houses.length; i++) {
      for (int j = 0; j < target + 1; j++) {
        Arrays.fill(DP[i][j], -2);
      }
    }
    int result = dp(0, 0, target, cost, houses);
    return result;
  }

  private int dp(int i, int c, int t, int[][] cost, int[] houses) {
    if (t == 0 && i == houses.length) return 0;
    else if (t == -1 || i == houses.length) return -1;
    else if (DP[i][t][c] != -2) return DP[i][t][c];
    else {
      int min = Integer.MAX_VALUE;
      if (houses[i] != 0) {
        int result;
        if (houses[i] == c) {
          result = dp(i + 1, c, t, cost, houses);
        } else {
          result = dp(i + 1, houses[i], t - 1, cost, houses);
        }
        if (result != -1) {
          if (c != 0) {
            min = Math.min(min, result);
          } else min = result;
        }
      } else {
        for (int co = 1; co < cost[0].length + 1; co++) {
          int result;
          if (co != c) {
            result = dp(i + 1, co, t - 1, cost, houses);
          } else {
            result = dp(i + 1, co, t, cost, houses);
          }
          if (result != -1) {
            min = Math.min(min, cost[i][co - 1] + result);
          }
        }
      }
      DP[i][t][c] = (min == Integer.MAX_VALUE ? -1 : min);
      return DP[i][t][c];
    }
  }
}
