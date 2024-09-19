package Dynamic_Programming;

public class MinimumNumberOfRefuelingStops {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int target = 100, startFuel = 10;
    int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
    System.out.println(
        new MinimumNumberOfRefuelingStops().minRefuelStops(target, startFuel, stations));
  }

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    long[] dp = new long[stations.length + 1];
    dp[0] = startFuel;
    for (int i = 0; i < stations.length; i++) {
      int d = stations[i][0];
      int f = stations[i][1];
      for (int j = i; j >= 0; j--) {
        if (dp[j] >= d) {
          dp[j + 1] = Math.max(dp[j + 1], dp[j] + f);
        }
      }
    }
    for (int i = 0; i < dp.length; i++) {
      if (dp[i] >= target) {
        return i;
      }
    }
    return -1;
  }
}
