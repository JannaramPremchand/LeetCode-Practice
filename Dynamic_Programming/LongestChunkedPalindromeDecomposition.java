package Dynamic_Programming;

public class LongestChunkedPalindromeDecomposition {
  public static void main(String[] args) {
    System.out.println(
        new LongestChunkedPalindromeDecomposition().longestDecomposition("merchant"));
  }

  private int[] DP;

  public int longestDecomposition(String text) {
    DP = new int[text.length()];
    return dp(0, text.length() - 1, text);
  }

  private int dp(int i, int e, String text) {
    if (i > e) return 0;
    else if (i == e) return 1;
    else if (DP[i] > 0) return DP[i];
    else {
      for (int j = e; j > i; j--) {
        if (text.charAt(j) == text.charAt(i)) {
          if (text.substring(j, e + 1).equals(text.substring(i, i + (e - j + 1)))) {
            DP[i] = Math.max(DP[i], dp(i + (e - j + 1), j - 1, text) + 2);
          }
        }
      }
      DP[i] = DP[i] == 0 ? 1 : DP[i];
      return DP[i];
    }
  }
}
