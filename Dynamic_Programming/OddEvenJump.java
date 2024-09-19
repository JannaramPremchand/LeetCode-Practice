package Dynamic_Programming;

import java.util.*;

public class OddEvenJump {

  private class Node {
    int num, pos;

    Node(int num, int pos) {
      this.num = num;
      this.pos = pos;
    }
  }

  TreeSet<Node> treeSet;
  int[][] next;
  int[][] possible;
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {10, 13, 12, 14, 15};
    System.out.println(new OddEvenJump().oddEvenJumps(A));
  }

  public int oddEvenJumps(int[] A) {
    treeSet = new TreeSet<>(Comparator.comparingInt(o -> o.num));
    next = new int[2][A.length];
    possible = new int[2][A.length];
    Arrays.fill(next[0], -1);
    Arrays.fill(next[1], -1);
    Arrays.fill(possible[0], -1);
    Arrays.fill(possible[1], -1);
    for (int i = A.length - 1; i >= 0; i--) {
      int num = A[i];
      // odd case
      Node curr = new Node(num, i);
      Node ceil = treeSet.ceiling(new Node(num, i));
      if (ceil != null) {
        next[0][i] = ceil.pos;
      }
      // even case
      Node floor = treeSet.floor(new Node(num, i));
      if (floor != null) {
        next[1][i] = floor.pos;
      }
      treeSet.remove(curr);
      treeSet.add(curr);
    }
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      count += dp(A, i, next, possible, 0) == 1 ? 1 : 0;
    }
    return count;
  }

  private int dp(int[] A, int i, int[][] next, int[][] possible, int oddOrEven) {
    if (i == A.length - 1) return 1;
    else if (possible[oddOrEven][i] == 1 || possible[oddOrEven][i] == 0) {
      return possible[oddOrEven][i];
    } else {
      int nextPos = oddOrEven == 0 ? next[0][i] : next[1][i];
      if (nextPos == -1) {
        possible[oddOrEven][i] = 0;
        return possible[oddOrEven][i];
      } else {
        possible[oddOrEven][i] = dp(A, nextPos, next, possible, ((oddOrEven + 1) % 2));
        return possible[oddOrEven][i];
      }
    }
  }
}
