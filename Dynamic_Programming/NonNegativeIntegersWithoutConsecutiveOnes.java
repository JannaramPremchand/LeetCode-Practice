package Dynamic_Programming;

public class NonNegativeIntegersWithoutConsecutiveOnes {
  public static void main(String[] args) {
    System.out.println(new NonNegativeIntegersWithoutConsecutiveOnes().findIntegers(1000000000));
  }

  public int findIntegers(int num) {
    int msbIndex = 0;
    for (int i = 0; i < 31; i++) {
      if (((1 << i) & num) > 0) {
        msbIndex = i;
      }
    }
    int[][] DP1 = new int[2][msbIndex + 1]; // count from 0 until all possible value.
    int[][] DP2 = new int[2][msbIndex + 2]; // count from given N until max possible value
    for (int i = msbIndex; i >= 0; i--) {
      if (i == msbIndex) {
        DP1[0][msbIndex] = 1;
        DP1[1][msbIndex] = 1;
      } else {
        DP1[0][i] = DP1[0][i + 1] + DP1[1][i + 1];
        DP1[1][i] = DP1[0][i + 1];
      }
    }
    // find valid state just before given num
    int[] bits = new int[msbIndex + 1];
    boolean bitFlipped = false;
    for (int i = msbIndex, j = 0; i >= 0; i--, j++) {
      if (j == 0) {
        bits[j] = 1;
      } else {
        if (bitFlipped) {
          bits[j] = bits[j - 1] == 0 ? 1 : 0;
        } else {
          if (((1 << i) & num) > 0) {
            if (bits[j - 1] > 0) {
              bits[j] = 0;
              bitFlipped = true;
            } else bits[j] = 1;
          }
        }
      }
    }
    DP2[0][msbIndex + 1] = 1;
    for (int i = bits.length - 1; i >= 0; i--) {
      if (bits[i] == 0) {
        DP2[0][i] = DP2[0][i + 1] + DP2[1][i + 1];
        // if the curr bit is 0 then, we can make this 1 provided the previous bit was not 1
        if (bits[i - 1] == 0) {
          DP2[1][i] = (i == bits.length - 1) ? 1 : DP1[0][i + 1];
        }
      } else {
        DP2[1][i] = DP2[0][i + 1];
      }
    }
    return (DP1[0][0] + DP1[1][0]) - (DP2[0][0] + DP2[1][0]) + 1;
  }
}
