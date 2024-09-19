package Greedy;

import java.util.*;

public class BoatsToSavePeople {
  public static void main(String[] args) {
    int[] A = {3, 5, 3, 4};
    System.out.println(new BoatsToSavePeople().numRescueBoats(A, 8));
  }

  public int numRescueBoats(int[] people, int limit) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int boats = 0;
    for (int p : people) {
      treeMap.putIfAbsent(p, 0);
      treeMap.put(p, treeMap.get(p) + 1);
    }
    Arrays.sort(people);
    for (int p : people) {
      if (treeMap.containsKey(p)) {
        int count = treeMap.remove(p);
        --count;
        if (count != 0) {
          treeMap.put(p, count);
        }
        int balance = limit - p;
        Map.Entry<Integer, Integer> floor = treeMap.floorEntry(balance);
        if (floor != null) {
          int c = floor.getValue();
          --c;
          treeMap.remove(floor.getKey());
          if (c != 0) {
            treeMap.put(floor.getKey(), c);
          }
        }
        boats++;
      }
    }
    return boats;
  }
}
