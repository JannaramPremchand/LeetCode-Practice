package Dynamic_Programming;

public class NumberOfDiceRollsWithTargetSum {
  public static void main(String[] args) {
    System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(3, 3, 3));
  }

  private final int MOD = 1000000007;

  public int numRollsToTarget(int d, int f, int target) {
    int[][] DP = new int[d + 1][target + 1];
    for (int i = 1; i <= Math.min(f, target); i++) {
      DP[1][i] = 1;
    }
    for (int i = 2; i <= d; i++) {
      for (int j = 1; j <= target; j++) {
        for (int k = 1; k <= Math.min(f, j); k++) {
          DP[i][j] = (DP[i - 1][j - k]) == 0 ? DP[i][j] : ((DP[i][j] + (DP[i - 1][j - k])) % MOD);
        }
      }
    }
    return DP[d][target];
  }
}
