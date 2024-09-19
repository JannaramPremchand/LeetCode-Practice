package Dynamic_Programming;

public class PaintHouseII {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[][] A = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    System.out.println(new PaintHouseII().minCostII(A));
  }

  public int minCostII(int[][] costs) {
    if (costs.length == 0) return 0;
    int[][] lMin = new int[costs.length][costs[0].length];
    int[][] rMin = new int[costs.length][costs[0].length];
    for (int i = costs.length - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < costs[0].length; j++) {
        lMin[i + 1][j] = min;
        min = Math.min(min, costs[i + 1][j]);
      }
      min = Integer.MAX_VALUE;
      for (int j = costs[0].length - 1; j >= 0; j--) {
        rMin[i + 1][j] = min;
        min = Math.min(min, costs[i + 1][j]);
      }

      for (int j = 0; j < costs[0].length; j++) {
        if (j == 0) {
          costs[i][j] = costs[i][j] + rMin[i + 1][j];
        } else if (j == costs[0].length - 1) {
          costs[i][j] = costs[i][j] + lMin[i + 1][j];
        } else {
          costs[i][j] = costs[i][j] + Math.min(lMin[i + 1][j], rMin[i + 1][j]);
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < costs[0].length; i++) {
      min = Math.min(min, costs[0][i]);
    }
    return min;
  }
}
