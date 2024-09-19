package Math;

public class ProjectionAreaOf3DShapes {
  public static void main(String[] args) {
    //
  }

  public int projectionArea(int[][] grid) {
    int area = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        area += (grid[i][j] > 0 ? 1 : 0);
      }
    }

    for (int i = 0; i < grid.length; i++) {
      int max = 0;
      for (int j = 0; j < grid[0].length; j++) {
        max = Math.max(max, grid[i][j]);
      }
      area += max;
    }

    for (int i = 0; i < grid[0].length; i++) {
      int max = 0;
      for (int j = 0; j < grid.length; j++) {
        max = Math.max(max, grid[j][i]);
      }
      area += max;
    }

    return area;
  }
}
