package Array;

import java.util.TreeSet;


public class KEmptySlots {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 3, 2};
    System.out.println(new KEmptySlots().kEmptySlots(A, 2));
  }

  public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < flowers.length; i++) {
      Integer lowerBound = set.floor(flowers[i]);
      Integer upperBound = set.ceiling(flowers[i]);
      if (lowerBound != null) {
        if ((Math.abs(flowers[i] - lowerBound) + 1) == k) {
          return i + 1;
        }
      }
      if (upperBound != null) {
        if ((Math.abs(flowers[i] - upperBound) + 1) == k) {
          return i + 1;
        }
      }
      set.add(flowers[i]);
    }
    return -1;
  }
}
