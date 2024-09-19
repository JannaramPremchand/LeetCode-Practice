package Divide_And_Conquer;

public class ReversePairsII {
  public static void main(String[] args) {
    int[] A = {2, 4, 3, 5, 1};
    System.out.println(new ReversePairsII().reversePairs(A));
  }

  int answer = 0;

  public int reversePairs(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return answer;
  }

  private int[] mergeSort(int[] num, int l, int h) {
    if (l < h) {
      int m = l + (h - l) / 2;
      int[] left = mergeSort(num, l, m);
      int[] right = mergeSort(num, m + 1, h);
      return merge(left, right);
    } else if (l == h) {
      return new int[] {num[l]};
    } else {
      return new int[] {};
    }
  }

  private int[] merge(int[] A, int[] B) {
    for (int i = 0; i < B.length; i++) {
      int num = B[i];
      int l = 0, h = A.length;
      int index = -1;
      while (l < h) {
        int m = l + (h - l) / 2;
        if ((long) A[m] > (2 * (long) num)) {
          index = m;
          h = m;
        } else {
          l = m + 1;
        }
      }
      if (index > -1) {
        answer += ((A.length - index));
      }
    }
    int[] C = new int[A.length + B.length];
    int k = 0;
    int i = 0, j = 0;
    for (; i < A.length && j < B.length; ) {
      if (A[i] < B[j]) {
        C[k++] = A[i];
        i++;
      } else {
        C[k++] = B[j];
        j++;
      }
    }
    while (i < A.length) {
      C[k++] = A[i++];
    }
    while (j < B.length) {
      C[k++] = B[j++];
    }
    return C;
  }
}
