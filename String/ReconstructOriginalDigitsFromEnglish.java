package String;

import java.util.*;


public class ReconstructOriginalDigitsFromEnglish {
  public static void main(String[] args) {
    System.out.println(
        new ReconstructOriginalDigitsFromEnglish()
            .originalDigits(
                "fviefurofviefurofviefurofviefurofviefurofviefurofviefurofviefurofviefurofviefuro"));
  }

  public String originalDigits(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }
    Map<Integer, Integer> intMap = new HashMap<>();
    if (map.containsKey('x')) {
      update(map, intMap, 6, 'x', Arrays.asList('s', 'i', 'x'));
    }
    if (map.containsKey('g')) {
      update(map, intMap, 8, 'g', Arrays.asList('e', 'i', 'g', 'h', 't'));
    }
    if (map.containsKey('w')) {
      update(map, intMap, 2, 'w', Arrays.asList('t', 'w', 'o'));
    }
    if (map.containsKey('z')) {
      update(map, intMap, 0, 'z', Arrays.asList('z', 'e', 'r', 'o'));
    }
    if (map.containsKey('u')) {
      update(map, intMap, 4, 'u', Arrays.asList('f', 'o', 'u', 'r'));
    }
    if (map.containsKey('f')) {
      update(map, intMap, 5, 'f', Arrays.asList('f', 'i', 'v', 'e'));
    }
    if (map.containsKey('v')) {
      update(map, intMap, 7, 'v', Arrays.asList('s', 'e', 'v', 'e', 'n'));
    }
    if (map.containsKey('i')) {
      update(map, intMap, 9, 'i', Arrays.asList('n', 'i', 'n', 'e'));
    }
    if (map.containsKey('t')) {
      update(map, intMap, 3, 't', Arrays.asList('t', 'h', 'r', 'e', 'e'));
    }
    if (map.containsKey('o')) {
      update(map, intMap, 1, 'o', Arrays.asList('o', 'n', 'e'));
    }
    Set<Integer> keys = intMap.keySet();
    List<Integer> list = new ArrayList<>(keys);
    list.sort(Comparator.comparingInt(o -> o));
    StringBuilder sb = new StringBuilder();
    for (int i : list) {
      int count = intMap.get(i);
      while (count-- > 0) {
        sb.append(i);
      }
    }
    return sb.toString();
  }

  private void update(
      Map<Character, Integer> map,
      Map<Integer, Integer> intMap,
      int num,
      char id,
      List<Character> list) {
    if (map.containsKey(id)) {
      int count = map.get(id);
      intMap.put(num, count);
      while (count-- > 0) {
        for (char c : list) {
          map.put(c, map.get(c) - 1);
        }
      }
    }
  }
}
