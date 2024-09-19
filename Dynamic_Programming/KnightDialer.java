package Dynamic_Programming;

public class KnightDialer {

  final int[] R = {-1, -1, -2, -2, 1, 1, 2, 2};
  final int[] C = {2, -2, -1, 1, 2, -2, 1, -1};

  public static void main(String[] args) {
    System.out.println(new KnightDialer().knightDialer(2));
  }

  int[][][] DP;

  public int knightDialer(int N) {
    DP = new int[4][3][N + 1];
    int ans = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if ((i == 3 && j == 0) || (i == 3 && j == 2)) continue;
        DP[i][j][0] = 1;
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if ((i == 3 && j == 0) || (i == 3 && j == 2)) continue;
        ans += (dp(N - 1, i, j) % 10e9 + 7);
        ans %= 10e9 + 7;
      }
    }
    return ans;
  }

  private int dp(int N, int r, int c) {
    if (N < 0) return 0;
    if (r == 3 && c == 0) return 0;
    if (r == 3 && c == 2) return 0;
    if (DP[r][c][N] != 0) return DP[r][c][N];
    int sum = 0;
    for (int i = 0; i < 8; i++) {
      int newR = r + R[i];
      int newC = c + C[i];
      if (newR >= 0 && newC >= 0 && newR < 4 && newC < 3) {
        sum += (dp(N - 1, newR, newC) % 10e9 + 7);
        sum %= 10e9 + 7;
      }
    }
    DP[r][c][N] = sum;
    return sum;
  }
}
