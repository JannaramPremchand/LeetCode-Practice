package Dynamic_Programming;

public class MaximumVacationDays {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] flights = {
      {0, 1, 0, 1, 1}, {1, 0, 0, 1, 1}, {1, 0, 0, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}
    };
    int[][] days = {
      {0, 4, 1, 6, 6}, {4, 3, 3, 0, 1}, {3, 6, 6, 5, 0}, {1, 3, 1, 1, 4}, {5, 3, 3, 3, 4}
    };
    System.out.println(new MaximumVacationDays().maxVacationDays(flights, days));
  }

  public int maxVacationDays(int[][] flights, int[][] days) {
    int N = days.length;
    int W = days[0].length;
    int[][] DP = new int[N][W + 1];
    for (int w = W - 1; w >= 0; w--) {
      for (int n = 0; n < N; n++) {
        DP[n][w] = days[n][w] + DP[n][w + 1];
      }

      for (int n = 0; n < N; n++) {
        int max = Integer.MIN_VALUE;
        int[] F = flights[n];
        for (int i = 0; i < F.length; i++) {
          if (F[i] == 1) {
            max = Math.max(max, days[i][w] + DP[i][w + 1]);
          }
        }
        DP[n][w] = Math.max(DP[n][w], max);
      }
    }
    return DP[0][0];
  }
}
