package Dynamic_Programming;

import java.util.*;

public class StoneGame {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {5, 3, 4, 5};
    System.out.println(new StoneGame().stoneGame(A));
  }

  public boolean stoneGame(int[] piles) {
    int sum = 0;
    for (int i = 0; i < piles.length; i++) {
      sum += piles[i];
    }
    int[][] A = new int[2][sum + 1];
    Arrays.fill(A[0], -1);
    Arrays.fill(A[1], -1);
    int result = dp(A, piles, 0, piles.length - 1, sum, 0, 0, 0);
    return result == 1;
  }

  private int dp(int[][] A, int[] piles, int i, int j, int sum, int p, int sumA, int sumB) {
    if (A[p][sum] != -1) return A[p][sum];
    else {
      if (p == 0) {
        if (i <= j) {
          int result = dp(A, piles, i + 1, j, sum - piles[i], (p + 1) % 2, sumA + piles[i], sumB);
          if (result == 0) {
            A[p][sum] = 1;
            return 1;
          } else {
            result = dp(A, piles, i, j - 1, sum - piles[j], (p + 1) % 2, sumA + piles[j], sumB);
            A[p][sum] = result;
            return result;
          }
        } else {
          if (sumA > sumB) return 1;
          else return 0;
        }
      } else {
        if (i <= j) {
          int result = dp(A, piles, i + 1, j, sum - piles[i], (p + 1) % 2, sumA, sumB + piles[i]);
          if (result == 0) {
            A[p][sum] = 1;
            return 1;
          } else {
            result = dp(A, piles, i, j - 1, sum - piles[j], (p + 1) % 2, sumA, sumB + piles[j]);
            A[p][sum] = result;
            return result;
          }
        } else {
          if (sumB > sumA) return 1;
          else return 0;
        }
      }
    }
  }
}
