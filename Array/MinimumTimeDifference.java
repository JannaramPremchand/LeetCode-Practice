package Array;

import java.util.*;
import java.util.stream.Collectors;


public class MinimumTimeDifference {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("23:59", "00:00");
    System.out.println(new MinimumTimeDifference().findMinDifference(list));
  }

  public int findMinDifference(List<String> timePoints) {
    List<Integer> timeInMinutes =
        timePoints
            .stream()
            .map(
                t -> {
                  String[] strings = t.split(":");
                  return Integer.parseInt(strings[0]) * 60 + Integer.parseInt(strings[1]);
                })
            .sorted(Integer::compareTo)
            .collect(Collectors.toList());
    int min = Integer.MAX_VALUE;
    for (int i = 1, l = timeInMinutes.size(); i < l; i++) {
      int prev = timeInMinutes.get(i - 1);
      int curr = timeInMinutes.get(i);
      min = Math.min(min, curr - prev);
      min = Math.min(min, ((24 * 60) - curr) + prev);
    }
    int prev = timeInMinutes.get(0);
    int curr = timeInMinutes.get(timeInMinutes.size() - 1);
    min = Math.min(min, curr - prev);
    min = Math.min(min, ((24 * 60) - curr) + prev);
    return min;
  }
}
