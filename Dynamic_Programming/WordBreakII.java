package Dynamic_Programming;

import java.util.*;

public class WordBreakII {
  private Map<Integer, List<String>> map;

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    List<String> wordList = new ArrayList<>();
    wordList.add("cat");
    wordList.add("cats");
    wordList.add("and");
    wordList.add("sand");
    wordList.add("dog");
    System.out.println(new WordBreakII().wordBreak("catsanddog", wordList));
  }

  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null) return new ArrayList<>();
    map = new HashMap<>();
    Set<String> dictionary = new HashSet<>();
    dictionary.addAll(wordDict);
    return dp(0, s, s.length(), dictionary);
  }

  private List<String> dp(int p, String s, int l, Set<String> dictionary) {
    List<String> result = new ArrayList<>();
    if (p >= s.length()) {
      result.add("");
      return result;
    } else if (map.containsKey(p)) {
      return map.get(p);
    }
    for (int i = p; i < l; i++) {
      String subStr = s.substring(p, i + 1);
      if (dictionary.contains(subStr)) {
        List<String> subList = dp(i + 1, s, l, dictionary);
        for (String se : subList) result.add((subStr + " " + se).trim());
      }
    }
    map.put(p, result);
    return result;
  }
}
