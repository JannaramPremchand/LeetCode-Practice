package Math;

import java.util.*;
import java.util.stream.Collectors;

public class LargestComponentSizebyCommonFactor {
  private static class UnionFind {
    private int[] p;
    private int[] rank;
    private int[] size;

    UnionFind(int s) {
      this.p = new int[s];
      this.rank = new int[s];
      this.size = new int[s];
      init();
    }
    /** Initialize with its same index as its parent */
    private void init() {
      for (int i = 0; i < p.length; i++) {
        p[i] = i;
        size[i] = 1;
      }
    }
    /**
     * Find the representative vertex
     *
     * @param i
     * @return
     */
    private int findSet(int i) {
      if (p[i] != i) {
        p[i] = findSet(p[i]);
      }
      return p[i];
    }

    /**
     * Perform union of two vertex
     *
     * @param i
     * @param j
     * @return true if union is performed successfully, false otherwise
     */
    public boolean union(int i, int j) {
      int x = findSet(i);
      int y = findSet(j);
      if (x != y) {
        if (rank[x] > rank[y]) {
          p[y] = p[x];
          size[x] = size[x] + size[y];
        } else {
          p[x] = p[y];
          size[y] = size[x] + size[y];
          if (rank[x] == rank[y]) {
            rank[y]++; // increment the rank
          }
        }
        return true;
      }
      return false;
    }

    /**
     * is attached to roof
     *
     * @param i
     * @return
     */
    public int size(int i) {
      return size[findSet(i)];
    }
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(new LargestComponentSizebyCommonFactor().largestComponentSize(A));
  }

  public int largestComponentSize(int[] A) {
    int max = 0;
    for (int a : A) {
      max = Math.max(max, a);
    }
    UnionFind unionFind = new UnionFind(max + 1);
    List<Integer> primeNums = primes(max, A);
    int answer = 1;
    for (int p : primeNums) {
      int curr = -1;
      for (int a : A) {
        if ((a % p) == 0) {
          if (curr != -1) {
            unionFind.union(curr, a);
          } else curr = a;
        }
      }
      answer = Math.max(answer, unionFind.size(curr));
    }
    return answer;
  }

  private List<Integer> primes(int N, int[] A) {
    boolean[] P = new boolean[N + 1];
    int[] pF = new int[N + 1];
    int sqRt = (int) Math.sqrt(N);
    for (int i = 2; i <= sqRt; i++) {
      if (!P[i]) {
        for (int j = 2; ; j++) {
          if (i * j > N) break;
          P[i * j] = true;
          if (pF[i * j] == 0) {
            pF[i * j] = i;
          }
        }
      }
    }
    Map<Integer, Integer> result = new HashMap<>();
    for (int a : A) {
      if (a == 1) continue;
      int n = pF[a];
      while (n != 0) {
        result.putIfAbsent(n, 0);
        result.put(n, result.get(n) + 1);
        a /= n;
        n = pF[a];
      }
      result.putIfAbsent(a, 0);
      result.put(a, result.get(a) + 1);
    }
    return result.keySet().stream().filter(x -> result.get(x) > 1).collect(Collectors.toList());
  }
}
