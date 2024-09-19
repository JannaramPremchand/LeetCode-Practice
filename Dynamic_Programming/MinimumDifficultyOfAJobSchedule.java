package Dynamic_Programming;

public class MinimumDifficultyOfAJobSchedule {
  public static void main(String[] args) {
    int[] A = {11, 111, 22, 222, 33, 333, 44, 444};
    System.out.println(new MinimumDifficultyOfAJobSchedule().minDifficulty(A, 6));
  }

  int[][] DP;

  public int minDifficulty(int[] jobDifficulty, int d) {
    DP = new int[jobDifficulty.length][d + 1];
    int result = dp(0, d, jobDifficulty);
    if (result == 50000) return -1;
    else return result;
  }

  private int dp(int i, int d, int[] J) {
    if (i >= J.length && d == 0) return 0;
    else if (J.length - i < d || d <= 0) return 50000;
    else if (DP[i][d] != 0) return DP[i][d];
    int max = J[i];
    int min = Integer.MAX_VALUE;
    for (int k = i; k <= J.length - 1; k++) {
      max = Math.max(max, J[k]);
      min = Math.min(min, max + dp(k + 1, d - 1, J));
    }
    DP[i][d] = min;
    return min;
  }
}
