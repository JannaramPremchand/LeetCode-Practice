package Dynamic_Programming;

public class PalindromicSubstrings {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
  }

  public int countSubstrings(String s) {
    boolean[][] T = new boolean[s.length()][s.length()];
    int count = s.length();
    for (int i = 0, j = 0; i < T.length; i++, j++) {
      T[i][j] = true;
    }

    for (int k = 1, col = s.length(); k < col; k++) {
      for (int i = 0, j = k; i < col && j < col; i++, j++) {
        if (k == 1) {
          if (s.charAt(i) == s.charAt(j)) {
            T[i][j] = true;
            count++;
          }
        } else {
          if (s.charAt(i) == s.charAt(j) && T[i + 1][j - 1]) {
            T[i][j] = true;
            count++;
          }
        }
      }
    }
    return count;
  }
}
