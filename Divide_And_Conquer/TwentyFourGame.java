package Divide_And_Conquer;

import java.util.*;

public class TwentyFourGame {

  public static void main(String[] args) {
    int[] A = {4, 7, 7, 7};
    System.out.println(new TwentyFourGame().judgePoint24(A));
  }

  class Fraction {
    int n, d;

    Fraction(int n, int d) {
      this.n = n;
      this.d = d;
    }
  }

  public boolean judgePoint24(int[] nums) {
    List<int[]> result = new ArrayList<>();
    permute(0, nums, result);
    for (int[] A : result) {
      List<Fraction> list = generate(0, 3, A);
      for (Fraction f : list) {
        if ((f.d != 0) && (f.n / f.d) == 24 && (f.n % f.d) == 0) return true;
      }
    }
    return false;
  }

  private void permute(int i, int[] nums, List<int[]> result) {
    if (i >= nums.length) {
      result.add(Arrays.copyOf(nums, 4));
    } else {
      for (int j = i; j < nums.length; j++) {
        swap(i, j, nums);
        permute(i + 1, nums, result);
        swap(i, j, nums);
      }
    }
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private List<Fraction> generate(int l, int r, int[] nums) {
    if (l > r) {
      return new ArrayList<>();
    } else if (l == r) {
      return Arrays.asList(new Fraction(nums[l], 1));
    } else {
      List<Fraction> result = new ArrayList<>();
      for (int i = l; i < r; i++) {
        for (int j = l; j <= i; j++) {
          List<Fraction> left = generate(l, j, nums);
          List<Fraction> right = generate(j + 1, r, nums);
          if (right.isEmpty()) {
            result.addAll(left);
          } else if (left.isEmpty()) {
            result.addAll(right);
          } else {
            for (Fraction lF : left) {
              for (Fraction rF : right) {
                int n = (lF.n * rF.d + rF.n * lF.d);
                int d = (lF.d * rF.d);
                Fraction sum = new Fraction(n, d);

                n = (lF.n * rF.d - (rF.n * lF.d));
                d = (lF.d * rF.d);
                Fraction diff = new Fraction(n, d);

                n = (lF.n * rF.n);
                d = (lF.d * rF.d);
                Fraction prod = new Fraction(n, d);

                n = (lF.n * rF.d);
                d = (lF.d * rF.n);
                Fraction div = new Fraction(n, d);
                result.add(sum);
                result.add(diff);
                result.add(prod);
                result.add(div);
              }
            }
          }
        }
      }
      return result;
    }
  }
}
