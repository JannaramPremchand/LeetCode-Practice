package Hashing;

import java.util.*;

public class DistributeCandies {
  public static void main(String[] args) {}

  public int distributeCandies(int[] candies) {
    int N = candies.length;
    Set<Integer> set = new HashSet<>();
    for (int c : candies) {
      set.add(c);
    }
    int n = set.size();
    return Math.min(N / 2, set.size());
  }
}
