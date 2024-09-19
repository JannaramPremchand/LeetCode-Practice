package Array;

import java.util.*;


public class MinimumSwapsToGroupAll1Together {
  public static void main(String[] args) {
    //
  }

  public int minSwaps(int[] data) {
    int one = 0;
    int zero = 0;
    for (int i = 0; i < data.length; i++) {
      if (data[i] == 1) {
        one++;
      } else zero++;
    }
    if (one == 0) return 0;
    int window = one;
    one = 0;
    zero = 0;
    int i = 0, j = window - 1;
    for (int k = i; k <= j; k++) {
      if (data[k] == 1) {
        one++;
      } else zero++;
    }
    i++;
    j++;
    int min = zero;
    for (; j < data.length; i++, j++) {
      if (data[j] == 0) {
        zero++;
      } else one++;

      if (data[i - 1] == 0) {
        zero--;
      } else one--;
      min = Math.min(min, zero);
    }
    return min;
  }
}
