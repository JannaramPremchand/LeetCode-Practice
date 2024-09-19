package Dynamic_Programming;

import java.util.*;

public class RussianDollEnvelopes {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] A = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
    System.out.println(new RussianDollEnvelopes().maxEnvelopes(A));
  }

  class Envelope {
    int l, b;

    Envelope(int l, int b) {
      this.l = l;
      this.b = b;
    }
  }
  /**
   * @param envelopes
   * @return
   */
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length == 0) return 0;
    List<Envelope> list = new ArrayList<>();
    for (int[] row : envelopes) {
      list.add(new Envelope(row[0], row[1]));
    }
    list.sort(((o1, o2) -> Integer.compare(o2.l * o2.b, o1.l * o1.b)));
    int[] DP = new int[envelopes.length];
    Arrays.fill(DP, 1);
    for (int i = list.size() - 1; i >= 0; i--) {
      Envelope env = list.get(i);
      for (int j = i + 1, l = list.size(); j < l; j++) {
        Envelope childEnv = list.get(j);
        if (env.l > childEnv.l && env.b > childEnv.b) {
          DP[i] = Math.max(DP[i], DP[j] + 1);
        }
      }
    }
    int ans = 1;
    for (int i : DP) {
      ans = Math.max(ans, i);
    }
    return ans;
  }
}
