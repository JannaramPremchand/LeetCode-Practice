package Dynamic_Programming;

public class MinimumDistanceToTypeAWordUsingTwoFingers {
  int[][] DP;
  int[][] dist;

  public static void main(String[] args) {
    System.out.println(new MinimumDistanceToTypeAWordUsingTwoFingers().minimumDistance("YEAR"));
  }

  public int minimumDistance(String word) {
    DP = new int[word.length()][word.length()];
    dist = new int[26][26];
    char[][] chars = {
      {'A', 'B', 'C', 'D', 'E', 'F'},
      {'G', 'H', 'I', 'J', 'K', 'L'},
      {'M', 'N', 'O', 'P', 'Q', 'R'},
      {'S', 'T', 'U', 'V', 'W', 'X'},
      {'Y', 'Z', ' ', ' ', ' ', ' '}
    };
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars[0].length; j++) {
        char from = chars[i][j];
        if (from == ' ') break;
        for (int k = 0; k < chars.length; k++) {
          for (int l = 0; l < chars[0].length; l++) {
            char to = chars[k][l];
            if (to == ' ') break;
            dist[from - 'A'][to - 'A'] = Math.abs(k - i) + Math.abs(l - j);
          }
        }
      }
    }
    for (int i = 0; i < word.length(); i++) {
      for (int j = 0; j < word.length(); j++) {
        DP[i][j] = -1;
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < word.length(); i++) {
      min = Math.min(min, dp(0, i, word));
    }
    return min;
  }

  private int dp(int p, int i, String S) {
    if (DP[p][i] != -1) return DP[p][i];
    else {
      int left = Integer.MAX_VALUE, right;
      int min = Integer.MAX_VALUE;
      if (p + 1 == S.length()) return 0;
      if (p + 1 != i) {
        left = dp(p + 1, i, S) + dist[S.charAt(p) - 'A'][S.charAt(p + 1) - 'A'];
      }
      right = dp(p + 1, p, S) + dist[S.charAt(i) - 'A'][S.charAt(p + 1) - 'A'];
      DP[p][i] = Math.min(min, Math.min(left, right));
      return DP[p][i];
    }
  }
}
