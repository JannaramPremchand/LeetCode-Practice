package Dynamic_Programming;

public class CornerRectangles {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[][] A = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    System.out.println(new CornerRectangles().countCornerRectangles(A));
  }

  public int countCornerRectangles(int[][] grid) {
    int[][] count = new int[grid[0].length][grid[0].length];
    int result = 0;
    for (int[] row : grid) {
      for (int i = 0; i < row.length; i++) {
        if (row[i] == 1) {
          for (int j = i + 1; j < row.length; j++) {
            if (row[j] == 1) {
              if (count[i][j] > 0) {
                result += count[i][j];
              }
              count[i][j]++;
            }
          }
        }
      }
    }
    return result;
  }
}
