package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MinimumIndexSumOfTwoLists {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    String[] A1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] A2 = {"Tapioca Express", "Shogun", "Burger King"};
    String[] ans = new MinimumIndexSumOfTwoLists().findRestaurant(A1, A2);
    for (String s : ans) {
      System.out.println(s);
    }
  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    int min = Integer.MAX_VALUE;
    List<String> result = new ArrayList<>();
    if (list2.length == 0) return new String[0];
    Map<String, Integer> index = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
      index.put(list2[i], i);
    }
    for (int i = 0; i < list1.length; i++) {
      String s = list1[i];
      if (index.containsKey(s)) {
        int sum = i + index.get(s);
        min = Math.min(min, sum);
      }
    }

    for (int i = 0; i < list1.length; i++) {
      String s = list1[i];
      if (index.containsKey(s)) {
        int sum = i + index.get(s);
        if (sum == min) {
          result.add(s);
        }
      }
    }
    String[] resArr = new String[result.size()];
    result.toArray(resArr);
    return resArr;
  }
}
