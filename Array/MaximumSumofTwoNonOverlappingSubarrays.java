package Array;

import java.util.*;


public class MaximumSumofTwoNonOverlappingSubarrays {
  public static void main(String[] args) {
    int[] A = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
    System.out.println(new MaximumSumofTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(A, 4, 3));
  }

  class MaxWithIndex {
    int max, i, j;

    MaxWithIndex(int max, int i, int j) {
      this.max = max;
      this.i = i;
      this.j = j;
    }
  }

  public int maxSumTwoNoOverlap(int[] A, int L, int M) {
    List<MaxWithIndex> first = getMax(A, L);
    List<MaxWithIndex> second = getMax(A, M);
    int max = 0;
    for (MaxWithIndex f : first) {
      for (MaxWithIndex s : second) {
        if (f.j < s.i || s.j < f.i) {
          max = Math.max(max, f.max + s.max);
        }
      }
    }
    return max;
  }

  private List<MaxWithIndex> getMax(int[] A, int L) {
    List<MaxWithIndex> list = new ArrayList<>();
    int i = 0, j = L;
    int sum = 0;
    for (; i < L; i++) {
      sum += A[i];
    }
    list.add(new MaxWithIndex(sum, 0, j - 1));
    for (i = 1; j < A.length; i++, j++) {
      sum -= A[i - 1];
      sum += A[j];
      list.add(new MaxWithIndex(sum, i, j));
    }
    return list;
  }
}
