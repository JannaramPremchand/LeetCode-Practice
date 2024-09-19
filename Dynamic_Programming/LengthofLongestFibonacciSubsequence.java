package Dynamic_Programming;

import java.util.*;

public class LengthofLongestFibonacciSubsequence {
  public static void main(String[] args) {
    int[] A = {1, 2, 4, 7, 12, 20};
    System.out.println(new LengthofLongestFibonacciSubsequence().lenLongestFibSubseq(A));
  }

  public int lenLongestFibSubseq(int[] A) {
    if (A.length < 3) return 0;
    Map<Integer, Map<Integer, Integer>> indexMap = new HashMap<>();
    int max = 0;
    for (int i = A.length - 1; i >= 0; i--) {
      Map<Integer, Integer> subHashMap = new HashMap<>();
      for (int j = 0; j < i; j++) {
        int sum = A[i] + A[j];
        if (indexMap.containsKey(sum)) {
          if (indexMap.get(sum).containsKey(A[i])) {
            int value = 1 + indexMap.get(sum).get(A[i]);
            subHashMap.put(A[j], value);
            max = Math.max(max, value);
          } else {
            subHashMap.put(A[j], 1);
            max = Math.max(max, 1);
          }
        }
      }
      indexMap.put(A[i], subHashMap);
    }
    return max == 0 ? 0 : max + 2;
  }
}
