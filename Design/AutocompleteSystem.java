package Design;

import java.util.*;

public class AutocompleteSystem {

  private Map<String, Integer> hotTextMap; // Maintain a hash-map of sentences and degree
  private Trie curr, trie, root;
  private StringBuilder
      currSentence; // StringBuilder class to maintain current input sentence (until '#')

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
    int[] degree = {5, 3, 2, 2};
    AutocompleteSystem autocomplete = new AutocompleteSystem(sentences, degree);
    List<String> result = autocomplete.input('i');
    result.forEach(System.out::println);
    result = autocomplete.input(' ');
    result.forEach(System.out::println);
    result = autocomplete.input('a');
    result.forEach(System.out::println);
    result = autocomplete.input('#');
    result.forEach(System.out::println);
  }

  /**
   * Initialize the trie data-structure
   *
   * @param sentences array of sentences
   * @param times degree
   */
  public AutocompleteSystem(String[] sentences, int[] times) {
    hotTextMap = new HashMap<>();
    trie = new Trie();
    for (int i = 0; i < sentences.length; i++) {
      hotTextMap.put(sentences[i], times[i]);
      trie.insert(sentences[i]);
      trie.update(sentences[i]);
    }
    curr = trie;
    root = trie;
    currSentence = new StringBuilder();
  }

  /**
   * Accept input and return hot-text for the current char
   *
   * @param c char
   * @return List of top 3 hot-text
   */
  public List<String> input(char c) {
    List<String> result = new ArrayList<>();
    if (c == '#') {
      String sentence = currSentence.toString();
      if (hotTextMap.containsKey(sentence)) {
        // already a known sentence hence only update in necessary
        hotTextMap.put(sentence, hotTextMap.get(sentence) + 1);
        trie.update(sentence);
      } else {
        // insert a new sentence and update the degree
        hotTextMap.put(sentence, 1);
        trie.insert(sentence);
        trie.update(sentence);
      }
      currSentence = new StringBuilder(); // reset StringBuilder
      curr = root; // point to root of the trie
    } else {
      if (curr != null) {
        if (curr.containsChild(c)) {
          List<String> hotText = curr.getSubtrie(c).getTop3HotText();
          hotText
              .stream()
              .forEach((x) -> result.add(currSentence.toString() + x)); // each node only returns
          // the hot-text for the current and child nodes hence we have to attach the prefix string
          curr = curr.getSubtrie(c);
        } else {
          curr =
              null; // as soon as we encounter a empty node then set current to null indicating no
                    // further
          // auto-complete terms are available
        }
      }
      currSentence.append(c);
    }
    return result;
  }

  /** Class HotText to store the text and degree */
  private class HotText {
    private String text;
    private int degree;

    HotText(String text, int degree) {
      this.text = text;
      this.degree = degree;
    }

    private String getText() {
      return text;
    }

    private int getDegree() {
      return degree;
    }
  }

  /** Class Trie */
  private class Trie {
    private Map<Character, Trie> map = new HashMap<>();
    private TreeSet<HotText> hotText =
        new TreeSet<>(
            (HotText o1, HotText o2) -> {
              int cmp = Integer.compare(o2.getDegree(), o1.getDegree());
              return cmp == 0 ? o1.getText().compareTo(o2.getText()) : cmp;
            });

    /**
     * Get hot-text
     *
     * @return HotText
     */
    public TreeSet<HotText> getHotText() {
      return hotText;
    }

    /**
     * Return top 3 hottext
     *
     * @return hot text
     */
    private List<String> getTop3HotText() {
      List<String> hotText = new ArrayList<>();
      if (this.getHotText() != null) {
        this.getHotText().stream().limit(3).forEach((x) -> hotText.add(x.getText()));
      }
      return hotText;
    }

    /** Inserts a word into the trie. */
    private void insert(String word) {
      if (word != null) {
        add(0, word, word.length());
      }
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

    /**
     * Update hottex and degree
     *
     * @param word word or sentence
     */
    private void update(String word) {
      if (word != null) {
        update(0, word, word.length());
      }
    }

    /**
     * Update trie
     *
     * @param i curr position
     * @param word sentence
     * @param length length
     * @return HotText
     */
    private HotText update(int i, String word, int length) {
      if (i < length) {
        char c = word.charAt(i);
        Trie subTrie = map.get(c);
        HotText subTrieHotText = subTrie.update(i + 1, word, length);
        HotText currHotText =
            new HotText(
                c + (subTrieHotText == null ? "" : subTrieHotText.getText()), hotTextMap.get(word));
        updateHotText(subTrie, currHotText);
        return currHotText;
      }
      return null;
    }

    /**
     * Hot text update
     *
     * @param hotText hotText object
     */
    private void updateHotText(Trie trie, HotText hotText) {
      trie.getHotText()
          .remove(new HotText(hotText.getText(), hotText.getDegree() - 1)); // remove already
      // contained hot-text and add new
      trie.getHotText().add(hotText);
    }

    /**
     * Contains child
     *
     * @param c char
     * @return true if it contains child, false otherwise
     */
    private boolean containsChild(char c) {
      return this.map.containsKey(c);
    }

    /**
     * Return child tree
     *
     * @param c char
     * @return child subTrie
     */
    private Trie getSubtrie(char c) {
      return this.map.get(c);
    }
  }
}
