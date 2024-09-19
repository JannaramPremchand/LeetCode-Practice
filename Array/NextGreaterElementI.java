package Array;


public class NextGreaterElementI {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {4, 1, 2};
    int[] B = {1, 3, 4, 2};
    int[] result = new NextGreaterElementI().nextGreaterElement(A, B);
    System.out.println(result);
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      int n = nums1[i];
      boolean found = false;
      int nF = 0;
      for (int j = 0; j < nums2.length; j++) {
        if (nums2[j] == n) {
          found = true;
        }
        if (found) {
          if (nums2[j] > n) {
            nF = nums2[j];
            break;
          }
        }
      }
      if (found) {
        result[i] = nF;
      } else {
        result[i] = -1;
      }
    }
    return result;
  }
}
