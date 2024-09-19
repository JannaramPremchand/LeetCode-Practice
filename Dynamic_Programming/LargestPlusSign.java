package Dynamic_Programming;

public class LargestPlusSign {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[][] M = {{4, 2}};
    System.out.println(new LargestPlusSign().orderOfLargestPlusSign(5, M));
  }

  public int orderOfLargestPlusSign(int N, int[][] mines) {
    int[][] A = new int[N][N]; // array to save the mines information.
    int[][] B = new int[N][N]; // array to save the minimum distance to the cell containing 0
    for (int[] row : mines) {
      int r = row[0];
      int c = row[1];
      A[r][c] = 1;
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j] == 0) {
          A[i][j] = 1;
        } else {
          A[i][j] = 0;
        }
        B[i][j] = Integer.MAX_VALUE;
      }
    }
    // For each rwo
    for (int i = 0; i < A.length; i++) {
      int prev = 0;
      // forward direction
      for (int j = 0; j < A[0].length; j++) {
        if (A[i][j] == 0) {
          prev = 0;
          B[i][j] = 0;
        } else {
          prev++;
          B[i][j] = Math.min(B[i][j], prev);
        }
      }
      prev = 0;
      // backward direction
      for (int j = N - 1; j >= 0; j--) {
        if (A[i][j] == 0) {
          prev = 0;
          B[i][j] = 0;
        } else {
          prev++;
          B[i][j] = Math.min(B[i][j], prev);
        }
      }
    }

    // for each column
    for (int j = 0; j < B[0].length; j++) {
      int prev = 0;
      // downward direction
      for (int i = 0; i < B.length; i++) {
        if (A[i][j] == 0) {
          prev = 0;
          B[i][j] = 0;
        } else {
          prev++;
          B[i][j] = Math.min(B[i][j], prev);
        }
      }
      prev = 0;
      // upward direction
      for (int i = N - 1; i >= 0; i--) {
        if (A[i][j] == 0) {
          prev = 0;
          B[i][j] = 0;
        } else {
          prev++;
          B[i][j] = Math.min(B[i][j], prev);
        }
      }
    }

    int result = 0;
    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        result = Math.max(result, B[i][j]);
      }
    }
    return result;
  }
}
