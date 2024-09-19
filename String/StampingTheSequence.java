package String;

import java.util.*;
import java.util.stream.Collectors;

public class StampingTheSequence {
  public static void main(String[] args) {
    int[] ans = new StampingTheSequence().movesToStamp("abca", "aaaaaaaaabcaaca");
    for (int a : ans) System.out.print(a + " ");
  }

  private class Window {
    Set<Integer> matched, unmatched;

    Window(Set<Integer> matched, Set<Integer> unmatched) {
      this.matched = matched;
      this.unmatched = unmatched;
    }
  }

  public int[] movesToStamp(String stamp, String target) {
    List<Window> windows = new ArrayList<>();
    Set<Integer> matchedTarget = new HashSet<>();
    Stack<Integer> answer = new Stack<>();
    for (int i = 0; i <= target.length() - stamp.length(); i++) {
      Window current = new Window(new HashSet<>(), new HashSet<>());
      for (int j = i, s = 0; j < (i + stamp.length()); j++, s++) {
        if (stamp.charAt(s) == target.charAt(j) || matchedTarget.contains(j)) {
          current.matched.add(j);
        } else current.unmatched.add(j);
      }
      if (current.unmatched.isEmpty()) {
        answer.push(i);
        matchedTarget.addAll(current.matched);
        for (int k = windows.size() - 1; k >= 0; k--) {
          if (!windows.get(k).unmatched.isEmpty()) {
            Set<Integer> newUnmatched =
                windows
                    .get(k)
                    .unmatched
                    .stream()
                    .filter(u -> !matchedTarget.contains(u))
                    .collect(Collectors.toSet());
            windows.get(k).unmatched = newUnmatched;
            if (newUnmatched.isEmpty()) {
              Set<Integer> newMatched =
                  windows
                      .get(k)
                      .matched
                      .stream()
                      .filter(m -> !matchedTarget.contains(m))
                      .collect(Collectors.toSet());
              if (!newMatched.isEmpty()) {
                answer.push(k);
                matchedTarget.addAll(newMatched);
              }
            }
          } else break;
        }
      }
      windows.add(current);
    }
    if (matchedTarget.size() == target.length()) {
      int[] finalAns = new int[answer.size()];
      int i = 0;
      while (!answer.isEmpty()) {
        finalAns[i++] = answer.pop();
      }
      return finalAns;
    }
    return new int[] {};
  }
}
