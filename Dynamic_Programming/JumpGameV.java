package Dynamic_Programming;

public class JumpGameV {
  public static void main(String[] args) {
    int[] A = {7, 1, 7, 1, 7, 1};
    System.out.println(new JumpGameV().maxJumps(A, 2));
  }

  int[] DP;

  public int maxJumps(int[] arr, int d) {
    DP = new int[arr.length];
    // Arrays.fill(DP, -1);
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, dp(arr, d, i));
    }
    return max;
  }

  private int dp(int[] A, int d, int i) {
    if (DP[i] != 0) return DP[i];
    int max = 1;
    for (int j = i - 1; j >= (i - d); j--) {
      if (j < 0 || A[j] >= A[i]) break;
      max = Math.max(max, dp(A, d, j) + 1);
    }
    for (int j = i + 1; j <= (i + d); j++) {
      if (j >= A.length || A[j] >= A[i]) break;
      max = Math.max(max, dp(A, d, j) + 1);
    }
    DP[i] = max;
    return max;
  }
}
