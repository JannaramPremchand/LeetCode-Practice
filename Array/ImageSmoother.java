package Array;

public class ImageSmoother {

  int[] R = {1, -1, 0, 0, 1, -1, 1, -1};
  int[] C = {0, 0, -1, 1, 1, 1, -1, -1};

  public static void main(String[] args) throws Exception {}

  public int[][] imageSmoother(int[][] M) {
    int[][] result = new int[M.length][M[0].length];
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[0].length; j++) {
        int numCount = 0;
        int totalCount = 1;
        for (int k = 0; k < 8; k++) {
          int newR = i + R[k];
          int newC = j + C[k];
          if (newR >= 0 && newC >= 0 && newR < M.length && newC < M[0].length) {
            if (M[newR][newC] > 0) {
              numCount += M[newR][newC];
            }
            totalCount++;
          }
        }
        if (M[i][j] == 1) numCount++;
        result[i][j] = numCount / totalCount;
      }
    }
    return result;
  }
}
