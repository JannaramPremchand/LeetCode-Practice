package Dynamic_Programming;

import java.util.*;

public class StoneGameIV {
  public static void main(String[] args) {
    System.out.println(new StoneGameIV().winnerSquareGame(1000));
  }

  public boolean winnerSquareGame(int n) {
    Set<Integer> perfectSquare = new HashSet<>();
    perfectSquare.add(1);
    for (int i = 2; (long) (i * i) <= n; i++) {
      genSquare(i * i, n, perfectSquare);
    }
    int[] pq = new int[perfectSquare.size()];
    int i = 0;
    for (int s : perfectSquare) {
      pq[i++] = s;
    }
    Arrays.sort(pq);
    int[] DP = new int[n + 1];
    int status = dp(n, 0, pq, DP);
    return status != 1;
  }

  private int dp(int n, int p, int[] perfectSquares, int[] DP) {
    if (n == 0) return 1;
    else if (DP[n] != 0) return DP[n];
    else {
      int result = 1;
      for (int sq : perfectSquares) {
        if (n < sq) break;
        int r = dp(n - sq, ((p + 1) % 2), perfectSquares, DP);
        if (r == 1) {
          result = 2;
          break;
        }
      }
      DP[n] = result;
      return result;
    }
  }

  private void genSquare(int sq, int limit, Set<Integer> perfectSquare) {
    if (!perfectSquare.contains(sq)) {
      perfectSquare.add(sq);
      if (((long) sq * sq) <= limit) {
        genSquare(sq * sq, limit, perfectSquare);
      }
    }
  }
}
