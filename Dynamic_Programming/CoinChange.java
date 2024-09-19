package Dynamic_Programming;

public class CoinChange {
  private int[][] DP;

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] coins = {1, 2, 5};
    System.out.println(new CoinChange().coinChange(coins, 11));
  }

  public int coinChange(int[] coins, int amount) {
    DP = new int[coins.length][amount + 1];
    int result = dp(amount, 0, coins);
    if (result == Integer.MAX_VALUE - 1) return -1;
    return result;
  }

  private int dp(int amount, int i, int[] coins) {
    if (amount == 0) return 0;
    else if (i >= coins.length || amount < 0) return Integer.MAX_VALUE - 1;
    if (DP[i][amount] != 0) return DP[i][amount];
    DP[i][amount] = Math.min(1 + dp(amount - coins[i], i, coins), dp(amount, i + 1, coins));
    return DP[i][amount];
  }
}
