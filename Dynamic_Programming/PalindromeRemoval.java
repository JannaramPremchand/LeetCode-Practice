package Dynamic_Programming;

public class PalindromeRemoval {
  public static void main(String[] args) {
    int[] A = {1, 3, 1, 2, 4, 2};
    System.out.println(new PalindromeRemoval().minimumMoves(A));
  }

  int[][] DP;

  public int minimumMoves(int[] arr) {
    DP = new int[arr.length][arr.length];
    return dp(0, arr.length - 1, arr);
  }

  private int dp(int i, int j, int[] arr) {
    if (i > j) return 1;
    else if (DP[i][j] != 0) return DP[i][j];
    else {
      int min = Integer.MAX_VALUE;
      for (int t = j; t >= i; t--) {
        if (arr[i] == arr[t]) {
          min = Math.min(min, dp(i + 1, t - 1, arr) + ((t + 1 > j) ? 0 : dp(t + 1, j, arr)));
        }
      }
      DP[i][j] = min;
      return min;
    }
  }
}
