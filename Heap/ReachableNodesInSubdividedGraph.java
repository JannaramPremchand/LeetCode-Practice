package Heap;

import java.util.*;

public class ReachableNodesInSubdividedGraph {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] edges = {{0, 1, 1000}, {0, 2, 1}, {1, 2, 1}};
    System.out.println(new ReachableNodesInSubdividedGraph().reachableNodes(edges, 200, 3));
  }

  static class Node {
    int n, w;

    Node(int n, int w) {
      this.n = n;
      this.w = w;
    }
  }

  public int reachableNodes(int[][] edges, int M, int N) {
    Map<Integer, List<Node>> graph = new HashMap<>();
    for (int[] e : edges) {
      graph.putIfAbsent(e[0], new ArrayList<>());
      graph.get(e[0]).add(new Node(e[1], e[2] + 1));

      graph.putIfAbsent(e[1], new ArrayList<>());
      graph.get(e[1]).add(new Node(e[0], e[2] + 1));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
    Map<Integer, Integer> distance = new HashMap<>();
    int count = 0;
    pq.offer(new Node(0, 0));
    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      if (!distance.containsKey(curr.n)) {
        count += 1;
        distance.put(curr.n, curr.w);
        List<Node> children = graph.get(curr.n);
        if (children != null) {
          for (Node c : children) {
            if (!distance.containsKey(c.n)) {
              int availableMoves = M - curr.w;
              int nodesInBetween = c.w - 1;
              if (nodesInBetween >= availableMoves) {
                count += availableMoves;
              } else {
                count += nodesInBetween;
                if (availableMoves >= c.w) {
                  Node child = new Node(c.n, distance.get(curr.n) + c.w);
                  pq.offer(child);
                }
              }
            } else {
              int childAvailableMoves = M - distance.get(c.n);
              int nodesInBetween = c.w - 1;
              int unvisitedNodes = nodesInBetween - childAvailableMoves;
              if (unvisitedNodes > 0) {
                int availableMovesForCurr = M - distance.get(curr.n);
                count +=
                    (unvisitedNodes >= availableMovesForCurr
                        ? availableMovesForCurr
                        : unvisitedNodes);
              }
            }
          }
        }
      }
    }
    return count;
  }
}
