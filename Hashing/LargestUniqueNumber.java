package Hashing;

import java.util.*;

public class LargestUniqueNumber {
  public static void main(String[] args) {
    //
  }

  public int largestUniqueNumber(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : A) {
      map.putIfAbsent(i, 0);
      int v = map.get(i) + 1;
      map.put(i, v);
    }
    int max = -1;
    for (int k : map.keySet()) {
      if (map.get(k) == 1) {
        max = Math.max(max, k);
      }
    }
    return max;
  }
}
