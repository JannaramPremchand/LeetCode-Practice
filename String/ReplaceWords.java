package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ReplaceWords {
  class Trie {
    private Map<Character, Trie> map;

    /** Initialize your data structure here. */
    public Trie() {
      map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      if (word != null) {
        add(0, word, word.length());
      }
    }

    public String find(String s) {
      return search(this, s, 0, new StringBuilder());
    }

    private void add(int i, String word, int length) {
      if (i < length) {
        char c = word.charAt(i);
        Trie subTrie = map.get(c);
        if (subTrie == null) {
          subTrie = new Trie();
          map.put(c, subTrie);
        }
        subTrie.add(i + 1, word, length);
      } else map.put(null, new Trie()); // use null to indicate end of string
    }

    private String search(Trie curr, String s, int i, StringBuilder sb) {
      if (s.length() == i) return sb.toString();
      else {
        Trie subTrie = curr.map.get(s.charAt(i));
        if (subTrie == null) {
          return curr.map.containsKey(null) ? sb.toString() : "";
        } else {
          sb.append(s.charAt(i));
          if (subTrie.map.containsKey(null)) return sb.toString();
          return search(subTrie, s, i + 1, sb);
        }
      }
    }
  }

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    List<String> words = Arrays.asList("a", "aa", "aaa");
    String sentence = "aa aa";
    System.out.println(new ReplaceWords().replaceWords(words, sentence));
  }

  public String replaceWords(List<String> dict, String sentence) {
    Trie root = new Trie();
    dict.forEach(root::insert);
    String[] words = sentence.split(" ");
    StringBuilder result = new StringBuilder();
    Stream.of(words)
        .map(
            w -> {
              String s = root.find(w);
              return s.isEmpty() ? w.concat(" ") : s.concat(" ");
            })
        .forEach(result::append);
    return result.toString().trim();
  }
}
