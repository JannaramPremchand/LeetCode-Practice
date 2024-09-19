package Two_Pointers;

public class SubarraysWithKDifferentIntegers {
  public static void main(String[] args) {
    int[] A = {1, 2, 1, 2, 3};
    SubarraysWithKDifferentIntegers task = new SubarraysWithKDifferentIntegers();
    System.out.println(task.subarraysWithKDistinct(A, 2));
  }

  public int subarraysWithKDistinct(int[] A, int K) {
    return calculate(A, K) - calculate(A, K - 1);
  }

  private int calculate(int[] A, int K) {
    int count = 0;
    int[] frequency = new int[A.length + 1];
    int currCount = 0;
    for (int i = 0, j = 0; i < A.length; i++) {
      frequency[A[i]]++;
      if (frequency[A[i]] == 1) {
        currCount++;
      }
      while (currCount > K) {
        frequency[A[j]]--;
        if (frequency[A[j]] == 0) {
          currCount--;
        }
        j++;
      }
      count += (i - j + 1);
    }
    return count;
  }
}
