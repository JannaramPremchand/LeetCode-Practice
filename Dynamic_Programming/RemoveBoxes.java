package Dynamic_Programming;

public class RemoveBoxes {

  int[][][] dp;

  public static void main(String[] args) {
    int[] boxes = {3, 3, 3};
    System.out.println(new RemoveBoxes().removeBoxes(boxes));
  }

  public int removeBoxes(int[] boxes) {
    dp = new int[boxes.length][boxes.length][boxes.length + 1];
    return calculate(0, boxes.length - 1, 1, boxes);
  }

  int calculate(int l, int r, int n, int[] boxes) {
    if (l > r) return 0;
    else {
      if (dp[l][r][n] != 0) return dp[l][r][n];
      dp[l][r][n] = (n * n) + calculate(l + 1, r, 1, boxes);
      for (int i = l + 1; i <= r; i++) {
        int center = 0, next = 0;
        if (boxes[l] == boxes[i]) {
          center = calculate(l + 1, i - 1, 1, boxes);
          next = calculate(i, r, n + 1, boxes);
        }
        dp[l][r][n] = Math.max(dp[l][r][n], center + next);
      }
    }
    return dp[l][r][n];
  }
}
