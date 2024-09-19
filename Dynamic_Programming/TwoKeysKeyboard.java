package Dynamic_Programming;

public class TwoKeysKeyboard {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new TwoKeysKeyboard().minSteps(8));
  }

  public int minSteps(int n) {
    int[] DP = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      DP[i] = i;
      for (int j = 2; j < i; j++) {
        if ((i % j) == 0) {
          DP[i] = Math.min(DP[i], DP[j] + (i / j));
        }
      }
    }
    return DP[n];
  }
}
