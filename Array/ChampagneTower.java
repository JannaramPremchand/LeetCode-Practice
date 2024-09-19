package Array;

/**
 * @see PascalsTriangle
 */
public class ChampagneTower {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new ChampagneTower().champagneTower(4, 2, 1));
  }

  public double champagneTower(int poured, int query_row, int query_glass) {
    double[][] A = new double[query_row + 1][query_row + 1];
    A[0][0] = poured;
    for (int i = 1; i <= query_row; i++) {
      for (int j = 0; j <= query_row; j++) {
        if (A[i - 1][j] > 1.0) {
          A[i][j] += (A[i - 1][j] - 1.0) / 2;
        }
        if (j == 0) continue;
        if (A[i - 1][j - 1] > 1.0) {
          A[i][j] += (A[i - 1][j - 1] - 1.0) / 2;
        }
      }
    }
    if (A[query_row][query_glass] > 1.0) return 1;
    else return A[query_row][query_glass];
  }
}
