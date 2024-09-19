package Dynamic_Programming;

public class StoneGameIII {
  private class State {
    int a, b;

    State(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static void main(String[] args) {
    int[] V = {-1, -2, -3};
    System.out.println(new StoneGameIII().stoneGameIII(V));
  }

  private State[][] DP;

  public String stoneGameIII(int[] stoneValue) {
    DP = new State[2][stoneValue.length];
    State result = dp(0, 0, stoneValue);
    return (result.a > result.b) ? "Alice" : (result.b > result.a) ? "Bob" : "Tie";
  }

  private State dp(int i, int p, int[] stoneValue) {
    if (i >= stoneValue.length) return new State(0, 0);
    else if (DP[p][i] != null) return DP[p][i];
    else {
      int sum = 0;
      for (int j = 0; j < 3; j++) {
        if (i + j >= stoneValue.length) break;
        sum += (stoneValue[i + j]);
        State result = dp(i + j + 1, (p + 1) % 2, stoneValue);
        if (p == 0) {
          if (DP[p][i] == null) {
            DP[p][i] = new State((sum + result.a), result.b);
          } else if (DP[p][i].a < (sum + result.a)) {
            DP[p][i] = new State((sum + result.a), result.b);
          }
        } else {
          if (DP[p][i] == null) {
            DP[p][i] = new State(result.a, (sum + result.b));
          } else if (DP[p][i].b < (sum + result.b)) {
            DP[p][i] = new State(result.a, (sum + result.b));
          }
        }
      }
      return DP[p][i];
    }
  }
}
