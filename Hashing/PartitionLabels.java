package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new PartitionLabels().partitionLabels("abc"));
  }

  public List<Integer> partitionLabels(String S) {
    if (S == null || S.trim().isEmpty()) return new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = S.length() - 1; i >= 0; i--) {
      char c = S.charAt(i);
      map.putIfAbsent(c, i);
    }
    List<Integer> result = new ArrayList<>();
    int start = 0;
    int max = map.get(S.charAt(0));
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (map.get(c) > max) {
        max = map.get(c);
      } else if (i == max) {
        result.add(max - start + 1);
        if (i < S.length() - 1) {
          start = i + 1;
          max = map.get(S.charAt(i + 1));
        }
      }
    }
    return result;
  }
}
