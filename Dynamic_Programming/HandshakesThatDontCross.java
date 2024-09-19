package Dynamic_Programming;

import java.util.Arrays;

public class HandshakesThatDontCross {
  public static void main(String[] args) {
    System.out.println(new HandshakesThatDontCross().numberOfWays(20));
  }

  int[] DP;
  final int MOD = 1000000007;

  public int numberOfWays(int N) {
    // DP = new int[N + 1][N + 1];
    DP = new int[N + 1];
    Arrays.fill(DP, -1);
    //
    //      for(int i = 0; i <= N; i ++){
    //          Arrays.fill(DP[i], -1);
    //      }
    return dp(0, N - 1);
  }

  private int dp(int i, int j) {
    if (i > j) return 1;
    else if ((j - i + 1) % 2 != 0) return 0;
    else if (DP[j - i + 1] != -1) return DP[j - i + 1];
    else {
      int sum = 0;
      for (int k = i; k <= j; k++) {
        int left = (dp(i + 1, k - 1) % MOD);
        int right = (dp(k + 1, j) % MOD);
        sum = ((sum + ((left * right) % MOD)) % MOD);
      }
      DP[j - i + 1] = sum;
      return sum;
    }
  }
}
