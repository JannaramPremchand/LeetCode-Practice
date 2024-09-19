package Dynamic_Programming;

import java.util.Arrays;

public class RestoreTheArray {
  public static void main(String[] args) {
    System.out.println(new RestoreTheArray().numberOfArrays("19284738192", 90));
  }

  int[] DP;
  int MOD = (int) 1e9 + 7;

  public int numberOfArrays(String s, int k) {
    DP = new int[s.length() + 1];
    Arrays.fill(DP, -1);
    return dp(0, s, k);
  }

  private int dp(int i, String s, int k) {
    if (i == s.length()) return 1;
    else if (DP[i] != -1) return DP[i];
    else if (s.charAt(i) == '0') return 0;
    else {
      long sum = 0L;
      String num = "";
      for (int j = i; j < (i + 10) && j < s.length(); j++) {
        num = num + s.charAt(j);
        if (Long.parseLong(num) <= k) {
          sum = ((sum + dp(j + 1, s, k)) % MOD);
        }
      }
      DP[i] = (int) sum;
      return DP[i];
    }
  }
}
