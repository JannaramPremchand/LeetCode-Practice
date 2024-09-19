package Dynamic_Programming;

public class EncodeStringWithShortestLength {

  private String[][] DP;

  public static void main(String[] args) {
    System.out.println(
        new EncodeStringWithShortestLength()
            .encode(
                "xabcabcabcxxabcabcabcxxabcabcabcxxabcdabcabcxxabcabcabcxxabcabcabcxxabcabcabcxxabcabcabcx"));
  }

  public String encode(String s) {
    DP = new String[s.length()][s.length()];
    return encodeStr(s, 0, s.length() - 1);
  }

  private String encodeStr(String s, int i, int j) {
    if (i == j) {
      DP[i][j] = String.valueOf(s.charAt(i));
      return DP[i][j];
    } else if (DP[i][j] != null) return DP[i][j];
    String currSubStr = s.substring(i, j + 1);
    DP[i][j] = currSubStr;
    for (int k = i + 1; k < j + 1; k++) {
      String left = encodeStr(s, i, k - 1);
      String right = encodeStr(s, k, j);
      if (left.length() + right.length() < DP[i][j].length()) {
        DP[i][j] = left + right;
      }
    }
    for (int k = i + 1; k < j + 1; k++) {
      if (currSubStr.length() % (k - i) == 0) {
        String subStr = s.substring(i, k);
        if (currSubStr.replaceAll(subStr, "").trim().isEmpty()) {
          String candidate =
              (currSubStr.length() / subStr.length()) + "[" + encodeStr(s, i, k - 1) + "]";
          if (candidate.length() < DP[i][j].length()) {
            DP[i][j] = candidate;
          }
        }
      }
    }
    return DP[i][j];
  }
}
