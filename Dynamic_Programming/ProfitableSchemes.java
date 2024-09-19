package Dynamic_Programming;

public class ProfitableSchemes {

  private final int MOD = 1000000007;
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] group = {2, 3};
    int[] profit = {2, 5};
    System.out.println(new ProfitableSchemes().profitableSchemes(5, 2, group, profit));
  }

  public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    int[][] DP = new int[G + 1][P + 1];
    int ans = 0;
    DP[0][0] = 1;
    for (int k = group.length - 1; k >= 0; k--) {
      int g = group[k];
      int p = profit[k];
      for (int i = DP.length - 1; i >= 0; i--) {
        for (int j = DP[0].length - 1; j >= 0; j--) {
          int r1 = (i - g < 0) ? 0 : DP[i - g][Math.max(0, j - p)];
          int r2 = DP[i][j];
          DP[i][j] = ((r1 % MOD) + (r2 % MOD)) % MOD;
        }
      }
    }
    for (int i = 0; i < DP.length; i++) {
      ans = (ans + DP[i][P]) % MOD;
    }
    return ans;
  }
}
