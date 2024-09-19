package Math;

import java.util.*;

public class RangeAdditionII {
  public static void main(String[] args) {
    //
  }

  public int maxCount(int m, int n, int[][] ops) {
    int minR = m;
    int minC = n;
    for (int[] v : ops) {
      minR = Math.min(minR, v[0]);
      minC = Math.min(minC, v[1]);
    }
    return minR * minC;
  }
}
