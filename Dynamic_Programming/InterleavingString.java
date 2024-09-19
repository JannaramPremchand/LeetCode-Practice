package Dynamic_Programming;

public class InterleavingString {
  public static void main(String[] args) {
    System.out.println(new InterleavingString().isInterleave("aabcc", "aabcc", "aabcaabccc"));
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
    DP[0][0] = true;
    if (s3.length() != (s2.length() + s1.length())) return false;
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) continue;
        int index = (i + j);
        if (j > 0) {
          if (s3.charAt(index - 1) == s2.charAt(j - 1) && DP[i][j - 1]) {
            DP[i][j] = true;
          }
        }
        if (i > 0) {
          if (s3.charAt(index - 1) == s1.charAt(i - 1) && DP[i - 1][j]) {
            DP[i][j] = true;
          }
        }
      }
    }
    return DP[s1.length()][s2.length()];
  }
}
