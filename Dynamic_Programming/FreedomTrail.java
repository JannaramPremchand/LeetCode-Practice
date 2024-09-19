package Dynamic_Programming;

public class FreedomTrail {
  public static void main(String[] args) {
    System.out.println(new FreedomTrail().findRotateSteps("godding", "gd"));
  }

  int[][] DP;

  public int findRotateSteps(String ring, String key) {
    DP = new int[ring.length()][key.length()];
    return dp(0, ring, key, 0) + key.length();
  }

  private int dp(int i, String ring, String key, int k) {
    if (k == key.length()) return 0;
    else {
      if (DP[i][k] != 0) return DP[i][k];
      char c = key.charAt(k);
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < ring.length(); j++) {
        if (ring.charAt(j) == c) {
          min =
              Math.min(
                  min,
                  Math.min(Math.abs(i - j), ring.length() - Math.abs(i - j))
                      + dp(j, ring, key, k + 1));
        }
      }
      DP[i][k] = min;
      return min;
    }
  }
}
