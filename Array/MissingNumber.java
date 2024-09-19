package Array;


public class MissingNumber {

  public static void main(String[] args) throws Exception {
    int[] nums = {0};
    System.out.println(new MissingNumber().missingNumber(nums));
  }

  public int missingNumber(int[] nums) {
    int sum = 0;
    int n = nums.length;
    for (int num : nums) {
      sum += num;
    }
    int arrSum = (((n + 1)) * n) / 2;
    if (arrSum == sum) return 0;
    else return arrSum - sum;
  }
}
