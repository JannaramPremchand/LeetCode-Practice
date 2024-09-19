package Dynamic_Programming;

import java.util.Arrays;

public class MakeArrayStrictlyIncreasing {
  public static void main(String[] args) {
    int[] A = {1, 5, 3, 6, 7};
    int[] B = {4, 3, 1};
    System.out.println(new MakeArrayStrictlyIncreasing().makeArrayIncreasing(A, B));
  }

  private int[][] DP;

  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    DP = new int[arr1.length][arr2.length + 1];
    Arrays.sort(arr2);
    for (int i = 0; i < arr1.length; i++) {
      Arrays.fill(DP[i], -1);
    }
    int min = dp(1, 0, arr1, arr2);
    for (int i = 0; i < arr2.length; i++) {
      min = Math.min(min, dp(1, i + 1, arr1, arr2) + 1);
    }
    return min == 2000 ? -1 : min;
  }

  private int dp(int i, int j, int[] arr1, int[] arr2) {
    if (i >= arr1.length) return 0;
    else if (DP[i][j] != -1) return DP[i][j];
    else {
      int curr = (j == 0 ? arr1[i - 1] : arr2[j - 1]);
      int min = 2000;
      if (arr1[i] > curr) {
        min = dp(i + 1, 0, arr1, arr2);
      }
      int k = binarySearch(arr2, curr);
      if (k != -1) {
        min = Math.min(min, dp(i + 1, k + 1, arr1, arr2) + 1);
      }
      DP[i][j] = min;
      return min;
    }
  }

  private int binarySearch(int[] A, int k) {
    int l = 0, h = A.length;
    int ans = -1;
    while (l < h) {
      int m = l + (h - l) / 2;
      if (A[m] > k) {
        ans = m;
        h = m;
      } else l = m + 1;
    }
    return ans;
  }
}
