package Dynamic_Programming;

public class DistinctSubsequencesII {
  public static void main(String[] args) {
    System.out.println(new DistinctSubsequencesII().distinctSubseqII("abac"));
  }

  final int MOD = (int) 1e9 + 7;

  public int distinctSubseqII(String S) {
    int[] DP = new int[S.length() + 1];
    DP[S.length()] = 1;
    for (int i = S.length() - 1; i >= 0; i--) {
      int sum = 0;
      for (int j = i + 1; j <= S.length(); j++) {
        sum = ((sum + DP[j]) % MOD);
        if (j < S.length() && S.charAt(j) == S.charAt(i)) {
          break;
        }
      }
      DP[i] = sum;
    }
    int ans = 0;
    for (int i : DP) {
      ans = ((ans + i) % MOD);
    }
    return ans - 1;
  }
}
