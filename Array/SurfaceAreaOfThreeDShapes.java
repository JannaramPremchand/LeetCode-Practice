package Array;


public class SurfaceAreaOfThreeDShapes {

  private final int[] R = {0, 0, -1, 1};
  private final int[] C = {1, -1, 0, 0};
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] A = {{2}};
    System.out.println(new SurfaceAreaOfThreeDShapes().surfaceArea(A));
  }

  public int surfaceArea(int[][] grid) {
    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int cell = grid[i][j];
        for (int k = 0; k < 4; k++) {
          int newR = i + R[k];
          int newC = j + C[k];
          if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length) {
            int adjacent = grid[newR][newC];
            if (cell > adjacent) {
              sum += (cell - adjacent);
            }
          } else if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) {
            sum += cell;
          }
        }
        if (cell > 0) {
          sum += 2;
        }
      }
    }
    return sum;
  }
}
