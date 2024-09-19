package Array;

import java.util.ArrayList;
import java.util.List;


public class RelativeRanks {

  class Position {
    int score, poisition;

    Position(int score, int position) {
      this.score = score;
      this.poisition = position;
    }
  }
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {5, 4, 3, 2, 1};
    String[] S = new RelativeRanks().findRelativeRanks(A);
    for (String i : S) {
      System.out.println(i);
    }
  }

  public String[] findRelativeRanks(int[] nums) {
    String[] S = new String[nums.length];
    List<Position> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      list.add(new Position(nums[i], i));
    }
    list.sort((o1, o2) -> Integer.compare(o2.score, o1.score));
    // Collections.reverse(list);
    for (int i = 0; i < list.size(); i++) {
      if (i == 0) {
        S[list.get(i).poisition] = "Gold Medal";
      } else if (i == 1) {
        S[list.get(i).poisition] = "Silver Medal";
      } else if (i == 2) {
        S[list.get(i).poisition] = "Bronze Medal";
      } else {
        S[list.get(i).poisition] = String.valueOf(i + 1);
      }
    }
    return S;
  }
}
