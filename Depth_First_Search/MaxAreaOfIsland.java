package Depth_First_Search;


public class MaxAreaOfIsland {
  final int[] R = {0, 0, -1, 1};
  final int[] C = {1, -1, 0, 0};

  int count = 0;
  int max = 0;
  boolean[][] done;

  public static void main(String[] args) {
    int[][] grid = {
      {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
  }

  public int maxAreaOfIsland(int[][] grid) {
    done = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !done[i][j]) {
          count = 0;
          dfs(grid, i, j);
          max = Math.max(max, count);
        }
      }
    }
    return max;
  }

  private void dfs(int[][] grid, int r, int c) {
    done[r][c] = true;
    count++;
    for (int i = 0; i < 4; i++) {
      int newR = r + R[i];
      int newC = c + C[i];
      if (newR >= 0
          && newC >= 0
          && newR < grid.length
          && newC < grid[0].length
          && !done[newR][newC]
          && grid[newR][newC] == 1) {
        dfs(grid, newR, newC);
      }
    }
  }
}
