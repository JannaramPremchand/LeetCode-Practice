package Dynamic_Programming;

public class TossStrangeCoins {
  public static void main(String[] args) {
    double[] A = {0.4, 0.4};
    System.out.println(new TossStrangeCoins().probabilityOfHeads(A, 1));
  }

  public double probabilityOfHeads(double[] prob, int target) {
    double[][] DP = new double[target + 1][prob.length];
    DP[0][0] = 1 - prob[0];
    DP[1][0] = prob[0];
    for (int c = 1; c < prob.length; c++) {
      for (int t = 0; t <= target; t++) {
        if (t == 0) DP[t][c] = DP[t][c - 1] * (1 - prob[c]);
        else DP[t][c] = DP[t][c - 1] * (1 - prob[c]) + DP[t - 1][c - 1] * (prob[c]);
      }
    }
    return DP[target][prob.length - 1];
  }
}
