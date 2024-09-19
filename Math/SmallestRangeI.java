package Math;

import java.util.*;

public class SmallestRangeI {
  public static void main(String[] args) {
    //
  }

  public int smallestRangeI(int[] A, int K) {
    Arrays.sort(A);
    if (A.length == 0 || A.length == 1) return 0;
    else {
      int low = A[0];
      int high = A[A.length - 1];
      int l = low + (K);
      int r = high - (K);
      if (r > l) return r - l;
      else return 0;
    }
  }
}
