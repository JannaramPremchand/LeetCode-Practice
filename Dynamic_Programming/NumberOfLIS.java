package Dynamic_Programming;

public class NumberOfLIS {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 12, 11, 1, 1, 1, 12};
    System.out.println(new NumberOfLIS().findNumberOfLIS(A));
  }

  public int findNumberOfLIS(int[] nums) {
    if (nums.length == 0) return 0;
    int[] length = new int[nums.length];
    length[0] = 1;
    int maxVal = 1;
    for (int i = 1; i < nums.length; i++) {
      int max = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          max = Math.max(max, length[j] + 1);
          maxVal = Math.max(maxVal, max);
        }
      }
      length[i] = max;
    }
    int[] count = new int[nums.length];
    count[0] = 1;
    for (int i = 1; i < length.length; i++) {
      for (int j = 0; j < i; j++) {
        if ((length[j] + 1 == length[i]) && (nums[j] < nums[i])) {
          count[i] += count[j];
        }
      }
      if (count[i] == 0) {
        count[i] = 1; // default is just 1
      }
    }
    int ans = 0;
    for (int i = 0; i < length.length; i++) {
      if (length[i] == maxVal) {
        ans += count[i];
      }
    }
    return ans;
  }
}
