package String;

import java.util.*;

public class ValidWordSquare {
  public static void main(String[] args) {
    List<String> arr = Arrays.asList("abcd", "bnrt", "crmy", "dtye");
    System.out.println(new ValidWordSquare().validWordSquare(arr));
  }

  public boolean validWordSquare(List<String> words) {
    List<String> newList = new ArrayList<>();
    int max = 0;
    for (int i = 0; i < words.size(); i++) {
      max = Math.max(max, words.get(i).length());
    }

    for (int i = 0; i < max; i++) {
      StringBuilder sb = new StringBuilder();
      for (String w : words) {
        if (i < w.length()) {
          sb.append(w.charAt(i));
        } else break;
      }
      newList.add(sb.toString());
    }

    if (words.size() != newList.size()) return false;

    for (int i = 0, l = words.size(); i < l; i++) {
      if (!words.get(i).equals(newList.get(i))) return false;
    }
    return true;
  }
}
