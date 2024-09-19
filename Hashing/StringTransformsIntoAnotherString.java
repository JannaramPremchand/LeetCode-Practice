package Hashing;

import java.util.*;

public class StringTransformsIntoAnotherString {
  public static void main(String[] args) {
    System.out.println(new StringTransformsIntoAnotherString().canConvert("ab", "ba"));
  }

  public boolean canConvert(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    if (str1.equals(str2)) return true;
    Map<Character, Character> mapping = new HashMap<>();
    for (int i = 0; i < str1.length(); i++) {
      char c1 = str1.charAt(i);
      char c2 = str2.charAt(i);
      if (mapping.containsKey(c1)) {
        if (mapping.get(c1) != c2) return false;
      } else {
        mapping.put(c1, c2);
      }
    }
    Set<Character> set = new HashSet<>();
    for (char k : mapping.keySet()) {
      set.add(mapping.get(k));
    }
    return (set.size() < 26);
  }
}
