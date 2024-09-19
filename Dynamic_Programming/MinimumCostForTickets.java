package Dynamic_Programming;

import java.util.Arrays;

public class MinimumCostForTickets {

  public static void main(String[] args) {
    int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
    int[] costs = {2, 7, 15};
    System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
  }
  /**
   * Main method
   *
   * @param days
   * @param costs
   * @return
   */
  public int mincostTickets(int[] days, int[] costs) {
    int[] min = new int[days.length];
    Arrays.fill(min, Integer.MAX_VALUE);
    for (int i = days.length - 1; i >= 0; i--) {
      for (int j = 0; j < costs.length; j++) {
        if (j == 0) {
          min[i] = Math.min(min[i], costs[j] + ((i + 1 >= min.length) ? 0 : min[i + 1]));
        } else if (j == 1) {
          int c = 0;
          for (int k = i + 1; k < days.length; k++) {
            if (days[k] >= (days[i] + 7)) {
              c = min[k];
              break;
            }
          }
          min[i] = Math.min(min[i], costs[j] + c);
        } else {
          int c = 0;
          for (int k = i + 1; k < days.length; k++) {
            if (days[k] >= (days[i] + 30)) {
              c = min[k];
              break;
            }
          }
          min[i] = Math.min(min[i], costs[j] + c);
        }
      }
    }
    return min[0];
  }
}
