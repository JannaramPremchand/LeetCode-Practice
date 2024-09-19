package Array;


public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    //
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    boolean flag = false;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        if (!flag) {
          flag = true;
        }
        count++;
        max = Math.max(max, count);
      } else {
        count = 0;
        flag = false;
      }
    }
    return max;
  }
}
