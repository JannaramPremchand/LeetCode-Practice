package Array;


public class MaxConsecutiveOnesII {
  public static void main(String[] args) {
    //
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    int[] L = new int[nums.length];
    int[] R = new int[nums.length];
    boolean flag = false;
    int count = 0;
    int max = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == 1) {
        if (!flag) {
          flag = true;
        }
        count++;
        L[j] = count;
      } else {
        count = 0;
        flag = false;
        L[j] = count;
      }
      max = Math.max(max, count);
    }

    flag = false;
    count = 0;
    for (int j = nums.length - 1; j >= 0; j--) {
      if (nums[j] == 1) {
        if (!flag) {
          flag = true;
        }
        count++;
        R[j] = count;
      } else {
        count = 0;
        flag = false;
        R[j] = count;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int l = i == 0 ? 0 : L[i - 1];
        int r = i == nums.length - 1 ? 0 : R[i + 1];
        max = Math.max(max, l + r + 1);
      }
    }
    return max;
  }
}
