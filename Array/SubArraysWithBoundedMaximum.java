package Array;


public class SubArraysWithBoundedMaximum {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {2, 1, 4, 3};
    System.out.println(new SubArraysWithBoundedMaximum().numSubarrayBoundedMax(A, 2, 3));
  }

  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int[] DP = new int[A.length];
    int v = -1;
    for (int i = A.length - 1; i >= 0; i--) {
      if (A[i] >= L && A[i] <= R) {
        if (v != -1) {
          DP[i] = v - i + 1;
        } else {
          DP[i] = 1;
          v = i;
        }
      } else if (A[i] < L) {
        if (v == -1) {
          v = i;
        }
        if (i + 1 < A.length) {
          if (A[i + 1] < L || (A[i + 1] >= L && A[i + 1] <= R)) {
            DP[i] = DP[i + 1];
          } else {
            DP[i] = 0;
          }
        }
      } else {
        v = -1;
      }
    }
    int sum = 0;
    for (int i = 0; i < DP.length; i++) {
      sum += DP[i];
    }
    return sum;
  }
}
