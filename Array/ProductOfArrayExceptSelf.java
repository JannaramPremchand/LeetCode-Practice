package Array;


public class ProductOfArrayExceptSelf {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
    for (int r : result) System.out.print(r + " ");
  }

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0, temp = 1, l = nums.length; i < l; i++) {
      result[i] = temp;
      temp *= nums[i];
    }
    for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
      result[i] = result[i] * temp;
      temp *= nums[i];
    }
    return result;
  }
}
