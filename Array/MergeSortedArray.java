package Array;


public class MergeSortedArray {
  public static void main(String[] args) throws Exception {
    int[] A = {0};
    int[] B = {1};
    new MergeSortedArray().merge(A, 0, B, 1);
    for (int i : A) System.out.println(i);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m + n - 1, j = m - 1, k = n - 1;
    while (j >= 0 && k >= 0) nums1[i--] = (nums1[j] > nums2[k]) ? nums1[j--] : nums2[k--];
    while (k >= 0) nums1[i--] = nums2[k--];
  }
}
