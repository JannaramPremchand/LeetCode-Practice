package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationOfWords {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] words = {"word", "good", "best", "word"};
    System.out.println(
        new SubstringConcatenationOfWords().findSubstring("wordgoodgoodgoodbestword", words));
  }

  public List<Integer> findSubstring(String s, String[] words) {
    if (words.length == 0) return new ArrayList<>();
    int wLen = words[0].length();
    int sLen = wLen * words.length;
    List<Integer> result = new ArrayList<>();
    if (sLen > s.length()) return result;
    Map<String, Integer> countMap = new HashMap<>();
    for (String w : words) {
      countMap.putIfAbsent(w, 0);
      countMap.put(w, countMap.get(w) + 1);
    }
    for (int k = 0; (s.length() - k) >= sLen; k++) {
      Map<String, Integer> subSMap = new HashMap<>();
      int i = k;
      for (int j = i + wLen; (i - k) < sLen; i = j, j += wLen) {
        String subS = s.substring(i, j);
        subSMap.putIfAbsent(subS, 0);
        subSMap.put(subS, subSMap.get(subS) + 1);
        if (!countMap.containsKey(subS) || subSMap.get(subS) > countMap.get(subS)) {
          break;
        }
      }
      if ((i - k) >= sLen) {
        result.add(k);
      }
    }
    return result;
  }
}
