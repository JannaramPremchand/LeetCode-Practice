package Dynamic_Programming;

public class MaxSum3SubArray {

  class Max {
    int i, j, k, max;

    Max(int i, int max) {
      this.i = i;
      this.max = max;
    }

    Max(int i, int j, int max) {
      this.i = i;
      this.j = j;
      this.max = max;
    }
  }

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 1, 2, 6};
    int[] result = new MaxSum3SubArray().maxSumOfThreeSubarrays(A, 1);
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + " ");
  }

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int[] fPrefix = new int[nums.length]; // forward prefix sum
    int[] rPrefix = new int[nums.length]; // reverse prefix sum

    // calculate forward prefix sum
    for (int i = 0; i < k; i++) {
      fPrefix[0] += nums[i];
    }
    for (int i = 1; i < nums.length; i++) {
      if (i + k - 1 < nums.length) {
        fPrefix[i] = fPrefix[i - 1] - nums[i - 1] + nums[i + k - 1];
      }
    }
    int sum = 0;
    for (int i = nums.length - 1; i >= nums.length - k; i--) {
      sum += nums[i];
    }
    Max[] max1 = new Max[nums.length];
    max1[nums.length - k] = new Max(nums.length - k, sum);

    // calculate reverse prefix sum
    rPrefix[nums.length - k] = sum;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + k >= nums.length) continue;
      rPrefix[i] = rPrefix[i + 1] - nums[i + k] + nums[i];
    }

    // calculate max for k index
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + k >= nums.length) continue;
      max1[i] = new Max(i, rPrefix[i]);
      if (max1[i + 1] != null) {
        if (max1[i].max < max1[i + 1].max) {
          max1[i] = new Max(max1[i + 1].i, max1[i + 1].max);
        }
      }
    }

    // calculate max for j and k index
    Max[] max2 = new Max[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + k < nums.length && max1[i + k] != null) {
        max2[i] = new Max(i, max1[i + k].i, fPrefix[i] + max1[i + k].max);
      }
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + 1 > nums.length - 1 || max2[i + 1] == null) continue;
      if (max2[i].max < max2[i + 1].max) {
        max2[i].max = max2[i + 1].max;
        max2[i].i = max2[i + 1].i;
        max2[i].j = max2[i + 1].j;
      }
    }

    // calculate max for i, j and k index
    int[] result = new int[3];
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((i + k) < nums.length - 1 && max2[i + k] != null) {
        int temp = fPrefix[i] + max2[i + k].max;
        if (temp > max) {
          max = temp;
          result[0] = i;
          result[1] = max2[i + k].i;
          result[2] = max2[i + k].j;
        }
      }
    }
    return result;
  }
}
