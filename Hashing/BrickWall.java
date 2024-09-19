package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    List<List<Integer>> wall = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>();
    List<Integer> row2 = new ArrayList<>();
    List<Integer> row3 = new ArrayList<>();
    List<Integer> row4 = new ArrayList<>();
    List<Integer> row5 = new ArrayList<>();
    List<Integer> row6 = new ArrayList<>();
    row1.add(1);
    row1.add(2);
    row1.add(2);
    row1.add(1);
    row2.add(3);
    row2.add(1);
    row2.add(2);
    row3.add(1);
    row3.add(3);
    row3.add(2);
    row4.add(2);
    row4.add(4);
    row5.add(3);
    row5.add(1);
    row5.add(2);
    row6.add(1);
    row6.add(3);
    row6.add(1);
    row6.add(1);
    wall.add(row1);
    wall.add(row2);
    wall.add(row3);
    wall.add(row4);
    wall.add(row5);
    wall.add(row6);
    System.out.println(new BrickWall().leastBricks(wall));
  }

  public int leastBricks(List<List<Integer>> wall) {
    for (List<Integer> row : wall) {
      int prefix = 0;
      for (int i = 0, l = row.size(); i < l; i++) {
        prefix += row.get(i);
        row.set(i, prefix);
      }
    }
    int result = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    for (List<Integer> row : wall) {
      for (int i = 0, l = row.size(); i < l - 1; i++) {
        int prefix = row.get(i);
        if (map.containsKey(prefix)) {
          int plusOne = map.get(prefix) + 1;
          map.put(prefix, plusOne);
          result = Math.max(result, plusOne);
        } else {
          map.put(prefix, 1);
          result = Math.max(result, 1);
        }
      }
    }
    return (result == Integer.MIN_VALUE) ? wall.size() : wall.size() - result;
  }
}
