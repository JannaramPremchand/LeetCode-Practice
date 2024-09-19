package Dynamic_Programming;

import java.util.*;

public class CountVowelsPermutation {
  public static void main(String[] args) {}

  public int countVowelPermutation(int n) {
    if (n == 1) return 5;
    Map<Character, List<Character>> graph = new HashMap<>();
    List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    Map<Character, Integer> count = new HashMap<>();
    vowels.forEach(v -> graph.put(v, new ArrayList<>()));
    graph.get('a').add('e');
    graph.get('e').add('a');
    graph.get('e').add('i');
    graph.get('i').add('a');
    graph.get('i').add('e');
    graph.get('i').add('o');
    graph.get('i').add('u');
    graph.get('u').add('a');
    graph.get('o').add('i');
    graph.get('o').add('u');
    count.put('a', 1);
    count.put('e', 2);
    count.put('i', 4);
    count.put('o', 2);
    count.put('u', 1);
    int[] charCount = new int[5];
    for (int i = 2; i < n; i++) {
      int j = 0;
      Arrays.fill(charCount, 0);
      for (char c : vowels) {
        List<Character> children = graph.get(c);
        for (char child : children) {
          charCount[j] = ((charCount[j] + count.get(child)) % 1000000007);
        }
        j++;
      }
      j = 0;
      for (char c : vowels) {
        count.put(c, charCount[j++]);
      }
    }
    int sum = 0;
    for (char c : vowels) {
      sum = ((sum + (count.get(c))) % 1000000007);
    }
    return sum;
  }
}
