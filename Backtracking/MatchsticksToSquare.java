package Backtracking;

import java.util.*;


public class MatchsticksToSquare {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 6, 10, 10};
    System.out.println(new MatchsticksToSquare().makesquare(A));
  }

  class Pair {
    int value, i;

    Pair(int value, int i) {
      this.value = value;
      this.i = i;
    }
  }

  public boolean makesquare(int[] nums) {
    if (nums.length == 0) return false;
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    int side = sum / 4;
    if ((sum % 4) != 0) return false;
    List<List<Pair>> list = powerSet(nums, side);
    Set<Integer> hashIndex = new HashSet<>();
    int cons = 0;
    for (int i = 0; i < nums.length; i++) {
      cons |= (1 << i);
    }
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        Set<Integer> indexList = new HashSet<>();
        List<Pair> list1 = list.get(i);
        List<Pair> list2 = list.get(j);
        int hash = 0;
        for (Pair l1 : list1) {
          indexList.add(l1.i);
          hash |= (1 << l1.i);
        }
        boolean allUnique = true;
        for (Pair l2 : list2) {
          if (indexList.contains(l2.i)) {
            allUnique = false;
            break;
          }
          indexList.add(l2.i);
          hash |= (1 << l2.i);
        }
        if (allUnique) {
          hashIndex.add(hash);
          int complement = ((~hash) & cons);
          if (hashIndex.contains(complement)) return true;
        }
      }
    }
    return false;
  }

  private List<List<Pair>> powerSet(int[] nums, int expectedSum) {
    List<List<Pair>> result = new ArrayList<>();
    generate(0, nums, new ArrayList<>(), result, 0, expectedSum);
    return result;
  }

  private void generate(
      int i, int[] nums, List<Pair> subList, List<List<Pair>> result, int sum, int expected) {
    if (i >= nums.length) {
      if (sum == expected) {
        List<Pair> pairs = new ArrayList<>(subList);
        result.add(pairs);
      }
    } else {
      if (sum + nums[i] <= expected) {
        subList.add(new Pair(nums[i], i));
        generate(i + 1, nums, subList, result, sum + nums[i], expected);
        subList.remove(subList.size() - 1);
      }
      generate(i + 1, nums, subList, result, sum, expected);
    }
  }
}
