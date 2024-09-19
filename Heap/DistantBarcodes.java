package Heap;

import java.util.*;

public class DistantBarcodes {
  public static void main(String[] args) {
    int[] barcode = {1, 1, 1, 2, 2, 2};
    int[] result = new DistantBarcodes().rearrangeBarcodes(barcode);
    for (int i : result) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  class Node {
    int value, count, rank;

    Node(int value, int count, int rank) {
      this.value = value;
      this.count = count;
      this.rank = rank;
    }
  }

  public int[] rearrangeBarcodes(int[] barcodes) {
    PriorityQueue<Node> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              int r = Integer.compare(o2.count, o1.count);
              return r == 0 ? Integer.compare(o1.rank, o2.rank) : r;
            });
    Map<Integer, Integer> map = new HashMap<>();
    for (int b : barcodes) {
      map.putIfAbsent(b, 0);
      map.put(b, map.get(b) + 1);
    }
    for (int k : map.keySet()) {
      pq.offer(new Node(k, map.get(k), -1));
    }
    int[] result = new int[barcodes.length];
    int i = 0;
    int rank = 0;
    while (!pq.isEmpty()) {
      Node node = pq.poll();
      result[i++] = node.value;
      node.count -= 1;
      node.rank = rank++;
      if (!pq.isEmpty()) {
        Node next = pq.poll();
        result[i++] = next.value;
        next.count -= 1;
        next.rank = rank++;
        if (next.count > 0) {
          pq.offer(next);
        }
      }
      if (node.count > 0) {
        pq.offer(node);
      }
    }
    return result;
  }
}
