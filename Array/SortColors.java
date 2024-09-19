package Array;


public class SortColors {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] nums = {2, 1, 0, 0, 1};
    new SortColors().sortColors(nums);
    for (int i : nums) System.out.println(i);
  }

  public void sortColors(int[] nums) {
    int s = nums[0]; // save the first index value
    nums[0] = 1; // overwrite with 1
    int l = 0, r = 0; // left and right index indicating the start and end index of 1s
    for (int i = 1; i < nums.length; i++) {
      switch (nums[i]) {
        case 0:
          nums[l] = 0;
          nums[r + 1] = 1;
          if (r + 1 != i) {
            nums[i] = 2;
          }
          l++;
          r++;
          break;

        case 1:
          nums[r + 1] = 1;
          if (r + 1 != i) {
            nums[i] = 2;
          }
          r++;
          break;
      }
    }
    // replace the initial overwritten value with the original value
    if (s == 0) nums[l] = 0;
    else if (s == 2) nums[r] = 2;
  }
}
