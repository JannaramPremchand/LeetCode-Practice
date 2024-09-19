package String;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReverseWordsInAString {
  public static void main(String[] args) throws Exception {
    System.out.println(new ReverseWordsInAString().reverseWords("  the     sky is blue"));
  }

  public String reverseWords(String s) {
    if (s == null || s.isEmpty()) return "";
    StringBuilder sb = new StringBuilder(s.trim());
    String reverse = sb.reverse().toString();
    StringTokenizer st = new StringTokenizer(reverse, " ");
    List<String> list = new ArrayList<>();
    while (st.hasMoreTokens()) {
      list.add(st.nextToken());
    }
    for (int i = 0, l = list.size(); i < l; i++) {
      String str = list.get(i);
      String newStr = new StringBuilder(str).reverse().toString();
      list.set(i, newStr);
    }
    StringBuilder result = new StringBuilder();
    for (String str : list) {
      result.append(str).append(" ");
    }
    return result.toString().trim();
  }
}
