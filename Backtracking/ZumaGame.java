package Backtracking;

import java.util.*;

public class ZumaGame {
  public static void main(String[] args) {
    System.out.println(new ZumaGame().findMinStep("BBWWRRYYRRWWBB", "Y"));
  }

  Map<Character, Integer> map;
  int min = Integer.MAX_VALUE;

  public int findMinStep(String board, String hand) {
    map = new HashMap<>();
    for (char c : hand.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }
    backtrack(board, 0);
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private void backtrack(String board, int total) {
    if (board.isEmpty()) {
      min = Math.min(min, total);
    } else {
      int i = 0, j = 0;
      for (int l = board.length(); i < l; ) {
        if (j < l && board.charAt(j) == board.charAt(i)) {
          j++;
        } else {
          if (j - i > 2) {
            backtrack(board.substring(0, i) + ((j < l) ? board.substring(j) : ""), total);
          } else {
            int a = j - i;
            char c = board.charAt(i);
            if (map.containsKey(c)) {
              int count = map.get(c);
              if (count >= (3 - a)) {
                if ((count - (3 - a)) == 0) {
                  map.remove(c);
                } else {
                  map.put(c, count - (3 - a));
                }
                backtrack(
                    board.substring(0, i) + ((j < l) ? board.substring(j) : ""), total + (3 - a));
                map.put(c, count);
              }
            }
          }
          i = j;
          j++;
        }
      }
    }
  }
}
