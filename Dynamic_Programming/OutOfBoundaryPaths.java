package Dynamic_Programming;

public class OutOfBoundaryPaths {

  final int[] R = {1, -1, 0, 0};
  final int[] C = {0, 0, 1, -1};
  int[][][] DP;
  int mod = 1000000007;

  public static void main(String[] args) {
    System.out.println(new OutOfBoundaryPaths().findPaths(2, 2, 2, 0, 0));
  }

  public int findPaths(int m, int n, int N, int a, int b) {
    if (N == 0) return 0;
    DP = new int[m][n][N + 1];

    for (int k = 1; k <= N; k++) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          for (int p = 0; p < 4; p++) {
            int newR = i + R[p];
            int newC = j + C[p];
            if (newR < 0 || newC < 0 || newR >= m || newC >= n) {
              DP[i][j][k] = ((DP[i][j][k] + 1) % mod);
            } else {
              DP[i][j][k] = (((DP[i][j][k] + DP[newR][newC][k - 1])) % mod);
            }
          }
        }
      }
    }

    return DP[a][b][N];
  }
}
