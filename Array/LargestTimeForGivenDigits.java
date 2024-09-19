package Array;


public class LargestTimeForGivenDigits {
  public static void main(String[] args) {
    int[] A = {2, 0, 6, 6};
    System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(A));
  }

  public String largestTimeFromDigits(int[] A) {
    int max = -1;
    String result = "";
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 2) continue;
      for (int j = 0; j < A.length; j++) {
        if (j == i) continue;
        if (A[i] == 2 && A[j] > 3) continue;
        for (int k = 0; k < A.length; k++) {
          if (k == i || k == j) continue;
          if (A[k] > 5) continue;
          for (int l = 0; l < A.length; l++) {
            if (l == i || l == j || l == k) continue;
            int value = ((A[i] * 10 + A[j]) * 60) + A[k] * 10 + A[l];
            if (value > max) {
              max = value;
              result = A[i] + "" + A[j] + ":" + A[k] + "" + A[l];
            }
          }
        }
      }
    }
    return result;
  }
}
