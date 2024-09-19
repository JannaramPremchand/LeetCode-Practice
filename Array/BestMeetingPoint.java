package Array;


public class BestMeetingPoint {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
    System.out.println(new BestMeetingPoint().minTotalDistance(grid));
  }

  public int minTotalDistance(int[][] grid) {
    int[] countR = new int[grid.length];
    int[] countC = new int[grid[0].length];

    int[] distR = new int[grid.length];
    int[] distC = new int[grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          countR[i]++;
          countC[j]++;
        }
      }
    }

    for (int i = 0; i < distR.length; i++) {
      for (int j = 0; j < distR.length; j++) {
        if (countR[j] != 0) {
          distR[i] += Math.abs(j - i) * countR[j];
        }
      }
    }

    for (int i = 0; i < distC.length; i++) {
      for (int j = 0; j < distC.length; j++) {
        if (countC[j] != 0) {
          distC[i] += Math.abs(j - i) * countC[j];
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < distR.length; i++) {
      for (int j = 0; j < distC.length; j++) {
        min = Math.min(min, distR[i] + distC[j]);
      }
    }

    return min;
  }
}
