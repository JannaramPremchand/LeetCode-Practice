package Array;


public class FirstMissingPositive {
  private int L;

  public static void main(String[] args) throws Exception {
    int[] nums = {1, 3, 5, 9};
    System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
  }

  public int firstMissingPositive(int[] nums) {
    L = nums.length;
    for (int i = 0; i < L; i++) {
      if (nums[i] > 0 && nums[i] <= L && nums[i] != i + 1) {
        int v = nums[i];
        nums[i] = -1;
        replace(v, nums);
      }
    }

    for (int i = 0; i < L; i++) {
      if (nums[i] != i + 1) return i + 1;
    }

    return L + 1;
  }

  private void replace(int i, int[] nums) {
    if (i > 0 && i <= L && i != nums[i - 1]) {
      int v = nums[i - 1];
      nums[i - 1] = i;
      replace(v, nums);
    }
  }
}
