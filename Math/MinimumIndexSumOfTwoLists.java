package Math;

import java.util.*;
public class MinimumIndexSumOfTwoLists {
  public static void main(String[] args) {
    //
  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> index = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
      String s = list2[i];
      index.put(s, i);
    }
    int min = Integer.MAX_VALUE;
    List<String> list = new ArrayList<>();
    for (int i = 0; i < list1.length; i++) {
      if (index.containsKey(list1[i])) {
        if (i + index.get(list1[i]) <= min) {
          min = i + index.get(list1[i]);
        }
      }
    }
    for (int i = 0; i < list1.length; i++) {
      if (index.containsKey(list1[i])) {
        if (i + index.get(list1[i]) == min) {
          list.add(list1[i]);
        }
      }
    }
    String[] ans = new String[list.size()];
    int i = 0;
    for (String s : list) {
      ans[i++] = s;
    }
    return ans;
  }
}
