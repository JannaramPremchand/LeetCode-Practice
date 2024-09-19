package Hashing;

import java.util.*;

public class ShortEncodingOfWords {
  class Node {
    String s;
    int l;

    Node(String s, int l) {
      this.s = s;
      this.l = l;
    }
  }

  public static void main(String[] args) {
    String[] A = {"memo", "me", "mo"};
    System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(A));
  }

  public int minimumLengthEncoding(String[] words) {
    List<Node> list = new ArrayList<>();
    for (String w : words) {
      list.add(new Node(w, w.length()));
    }
    Collections.sort(list, (o1, o2) -> Integer.compare(o2.l, o1.l));
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for (Node node : list) {
      String str = node.s;
      if (!map.containsKey(str)) {
        for (int i = 0, l = str.length(); i < l; i++) {
          map.put(str.substring(i, l), count + i);
        }
        count += (str.length() + 1);
      }
    }
    return count;
  }
}
