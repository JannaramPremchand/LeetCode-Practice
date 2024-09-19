package Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
  public static void main(String[] args) throws Exception {
    String[] words = {""};
    System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Set<String> dictionary = new HashSet<>();
    for (String w : words) dictionary.add(w);
    List<String> result = new ArrayList<>();
    for (String w : words) {
      if (!w.isEmpty() && concatenatedWordsPossible(w, dictionary)) result.add(w);
    }
    return result;
  }

  private boolean concatenatedWordsPossible(String word, Set<String> dictionary) {
    boolean[] D = new boolean[word.length() + 1];
    D[word.length()] = true;
    dictionary.remove(word); // remove current word from dictionary temporarily
    for (int i = word.length() - 1; i >= 0; i--) {
      for (int j = i, l = word.length(); j < l; j++) {
        String subStr = word.substring(i, j + 1);
        if (dictionary.contains(subStr) && D[j + 1]) {
          D[i] = true;
          break;
        }
      }
    }
    dictionary.add(word); // restore deleted word
    return D[0];
  }
}
