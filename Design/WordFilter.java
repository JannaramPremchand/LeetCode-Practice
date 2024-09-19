package Design;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

  private Trie trie;
  private int maxWeight; // max weight possible
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    String[] words = {"apple", "cat", "mat", "mars", "abxcd", "abycd", "apple"};
    WordFilter wf = new WordFilter(words);
    System.out.println(wf.f("abx", ""));
  }

  public WordFilter(String[] words) {
    trie = new Trie();
    trie.weight = -1;
    maxWeight = words.length - 1;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      trie.insert("#" + word, i);
      for (int j = 0, l = word.length(); j < l; j++) {
        trie.insert(word.substring(j, l) + "#" + word, i);
      }
    }
  }

  public int f(String prefix, String suffix) {
    if ((suffix == null || suffix.isEmpty()) && (prefix == null || prefix.isEmpty())) {
      return maxWeight;
    } else if (prefix == null || prefix.isEmpty()) {
      return trie.search(suffix + "#");
    } else if (suffix == null || suffix.isEmpty()) {
      return trie.search("#" + prefix);
    } else {
      return trie.search(suffix + "#" + prefix);
    }
  }

  public static class Trie {

    private Map<Character, Trie> map;
    int weight;

    /** Initialize your data structure here. */
    public Trie() {
      map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word, int weight) {
      if (word != null) {
        add(0, word, word.length(), weight);
      }
    }

    private void add(int i, String word, int length, int weight) {
      if (i < length) {
        char c = word.charAt(i);
        map.putIfAbsent(c, new Trie());
        Trie subTrie = map.get(c);
        subTrie.weight = weight;
        subTrie.add(i + 1, word, length, weight);
      }
    }

    /** Returns if the word is in the trie. */
    public int search(String word) {
      if (word != null) {
        return search(0, word, word.length());
      }
      return -1;
    }

    private int search(int i, String word, int length) {
      if (i < length) {
        char c = word.charAt(i);
        Trie subTrie = map.get(c);
        if (subTrie == null) return -1;
        return subTrie.search(i + 1, word, length);
      }
      return this.weight;
    }
  }
}
