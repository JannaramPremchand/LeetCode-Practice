package Array;

import java.util.Arrays;


public class IncreasingTripletSubsequence {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 3, 4, 5};
    System.out.println(new IncreasingTripletSubsequence().increasingTriplet(A));
  }

  public boolean increasingTriplet(int[] nums) {
    int[] A = new int[3];
    Arrays.fill(A, Integer.MAX_VALUE);
    for (int num : nums) {
      if (num < A[0]) {
        A[0] = num;
      } else if (num < A[1] && num > A[0]) {
        A[1] = num;
      } else if (num < A[2] && num > A[1]) {
        return true;
      }
    }
    return false;
  }
}
