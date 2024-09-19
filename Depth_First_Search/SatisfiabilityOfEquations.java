package Depth_First_Search;

import java.util.*;

public class SatisfiabilityOfEquations {
  public static void main(String[] args) {
    String[] input = {"c==c", "f!=a", "f==b", "b==c"};
    System.out.println(new SatisfiabilityOfEquations().equationsPossible(input));
  }

  private Set<Character> done;
  private Map<Character, Integer> valueMap;
  private int count = 0;

  public boolean equationsPossible(String[] equations) {
    Map<Character, List<Character>> graph = new HashMap<>();
    done = new HashSet<>();
    valueMap = new HashMap<>();
    for (String eq : equations) {
      if (eq.charAt(1) == '=') {
        graph.putIfAbsent(eq.charAt(0), new ArrayList<>());
        graph.get(eq.charAt(0)).add(eq.charAt(3));
        graph.putIfAbsent(eq.charAt(3), new ArrayList<>());
        graph.get(eq.charAt(3)).add(eq.charAt(0));
      }
    }
    for (char c : graph.keySet()) {
      if (!done.contains(c)) {
        dfs(c, graph, ++count);
      }
    }

    for (String eq : equations) {
      if (eq.charAt(1) == '!') {
        char a = eq.charAt(0);
        char b = eq.charAt(3);
        if (a == b) return false;
        if (valueMap.containsKey(a) && valueMap.containsKey(b)) {
          if (valueMap.get(a).intValue() == valueMap.get(b).intValue()) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean dfs(char node, Map<Character, List<Character>> graph, int value) {
    done.add(node);
    valueMap.put(node, value);
    List<Character> children = graph.get(node);
    if (!children.isEmpty()) {
      for (char c : children) {
        if (!done.contains(c)) {
          boolean status = dfs(c, graph, value);
          if (!status) {
            return status;
          }
        } else {
          if (valueMap.get(c) != value) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
