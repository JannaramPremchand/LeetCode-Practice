package Array;

import java.util.*;


public class RelativeSortArray {
  public static void main(String[] args) {
    //
  }

  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    List<Integer> notPresent = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int i : arr2) {
      set.add(i);
    }
    for (int i : arr1) {
      map.putIfAbsent(i, 0);
      map.put(i, map.get(i) + 1);
    }
    List<Integer> result = new ArrayList<>();
    for (int i : arr2) {
      int count = map.get(i);
      for (int j = 0; j < count; j++) {
        result.add(i);
      }
    }
    for (int k : map.keySet()) {
      if (!set.contains(k)) {
        int count = map.get(k);
        for (int i = 0; i < count; i++) {
          notPresent.add(k);
        }
      }
    }
    notPresent.sort(Comparator.comparingInt(o -> o));
    result.addAll(notPresent);
    int[] resA = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resA[i] = result.get(i);
    }
    return resA;
  }
}
