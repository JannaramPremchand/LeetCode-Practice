package Dynamic_Programming;

import java.util.*;

public class TallestBillboard {

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6};
    System.out.println(new TallestBillboard().tallestBillboard(A));
  }

  public int tallestBillboard(int[] rods) {
    if (rods.length == 0) return 0;
    Map<Integer, Integer> leftMap = partition(rods, 0, rods.length / 2);
    Map<Integer, Integer> rightMap = partition(rods, (rods.length / 2) + 1, rods.length - 1);
    int max = 0;
    for (int d : leftMap.keySet()) {
      if (rightMap.containsKey(d)) {
        int m1 = leftMap.get(d);
        int m2 = rightMap.get(d);
        max = Math.max(max, m1 + (m2 - d));
        max = Math.max(max, m2 + (m1 - d));
      }
    }
    return max;
  }

  private Map<Integer, Integer> partition(int[] rods, int i, int j) {
    if (i > j) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 0);
      return map;
    } else if (i == j) {
      Map<Integer, Integer> map = new HashMap<>();
      map.put(rods[i], rods[i]);
      map.put(0, 0);
      return map;
    } else {
      int m = (i + (j - i) / 2);
      Map<Integer, Integer> left = partition(rods, i, m);
      Map<Integer, Integer> right = partition(rods, m + 1, j);
      Map<Integer, Integer> newMap = new HashMap<>();
      for (int lDiff : left.keySet()) {
        int lMax = left.get(lDiff);
        for (int rDiff : right.keySet()) {
          int rMax = right.get(rDiff);
          int r1, r2, r3, r4;
          r1 = lMax;
          r2 = lMax - lDiff;
          r3 = rMax;
          r4 = rMax - rDiff;
          update(newMap, Math.abs(((r1 + r3) - (r2 + r4))), r1 + r3, r2 + r4);
          update(newMap, Math.abs(((r1 + r4) - (r2 + r3))), r1 + r4, r2 + r3);
        }
      }
      return newMap;
    }
  }

  private void update(Map<Integer, Integer> map, int diff, int rod1, int rod2) {
    if (map.getOrDefault(diff, 0) < Math.max(rod1, rod2)) {
      map.put(diff, Math.max(rod1, rod2));
    }
  }
}
