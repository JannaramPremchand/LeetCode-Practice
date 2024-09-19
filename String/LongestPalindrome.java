package String;

import java.util.*;

public class LongestPalindrome {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int result = new LongestPalindrome().longestPalindrome("asdfasdf");
    System.out.println(result);
  }

  public int longestPalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.putIfAbsent(c, 0);
      int count = map.get(c);
      map.put(c, count + 1);
    }
    int max = 0;
    boolean odd = false;
    for (char c : map.keySet()) {
      int count = map.get(c);
      max += count;
      if ((count % 2) != 0) {
        max--;
        odd = true;
      }
    }
    if (odd) max++;
    return max;
  }
}
