package Hashing;

import java.util.*;

public class CustomSortString {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new CustomSortString().customSortString("cba", "abcd"));
  }

  public String customSortString(String S, String T) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < T.length(); i++) {
      if (!map.containsKey(T.charAt(i))) {
        map.put(T.charAt(i), 1);
      } else {
        map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
      }
    }
    StringBuilder result = new StringBuilder();
    for (char c : S.toCharArray()) {
      if (map.containsKey(c)) {
        int count = map.remove(c);
        for (int i = 0; i < count; i++) {
          result.append(c);
        }
      }
    }
    for (char c : map.keySet()) {
      int count = map.get(c);
      for (int i = 0; i < count; i++) {
        result.append(c);
      }
    }
    return result.toString();
  }
}
