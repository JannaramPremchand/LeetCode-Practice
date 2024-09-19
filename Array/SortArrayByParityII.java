package Array;

import java.util.*;


public class SortArrayByParityII {
  public static void main(String[] args) {
    //
  }

  public int[] sortArrayByParityII(int[] A) {
    int[] R = new int[A.length];
    int i = 0, j = 1;
    for (int a : A) {
      if (a % 2 == 0) {
        R[i] = a;
        i += 2;
      } else {
        R[j] = a;
        j += 2;
      }
    }
    return R;
  }
}
