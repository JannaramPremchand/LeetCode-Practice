package Depth_First_Search;

import java.util.*;

public class ParallelCourses {
  public static void main(String[] args) {
    int[][] A = {{1, 3}, {2, 3}};
    System.out.println(new ParallelCourses().minimumSemesters(3, A));
  }

  Map<Integer, List<Integer>> graph;
  Set<Integer> done;
  Set<Integer> visited;

  public int minimumSemesters(int N, int[][] relations) {
    graph = new HashMap<>();
    for (int[] E : relations) {
      graph.putIfAbsent(E[0], new ArrayList<>());
      graph.get(E[0]).add(E[1]);
    }
    done = new HashSet<>();
    visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    for (int v : graph.keySet()) {
      if (!done.contains(v)) {
        boolean status = dfs(v, stack); // toposort and return false if a cycle is found
        if (!status) return -1;
      }
    }
    int[] DP = new int[N + 1];
    int max = 0;
    while (!stack.isEmpty()) {
      int v = stack.pop();
      List<Integer> children = graph.get(v);
      if (children != null) {
        for (int c : children) {
          DP[c] = Math.max(DP[c], DP[v] + 1);
          max = Math.max(max, DP[c]);
        }
      }
    }
    return max + 1;
  }

  private boolean dfs(int v, Stack<Integer> stack) {
    done.add(v);
    visited.add(v);
    List<Integer> children = graph.get(v);
    if (children != null) {
      for (int c : children) {
        if (!visited.contains(c)) {
          if (!done.contains(c)) {
            boolean status = dfs(c, stack);
            if (!status) return false;
          }
        } else {
          return false;
        }
      }
    }
    visited.remove(v);
    stack.push(v);
    return true;
  }
}
