package Array;

import java.util.ArrayList;
import java.util.List;


public class EmployeeFreeTime {

  public static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    List<List<Interval>> schedule = new ArrayList<>();
    List<Interval> ints1 = new ArrayList<>();
    ints1.add(new Interval(45, 56));
    ints1.add(new Interval(89, 96));

    List<Interval> ints3 = new ArrayList<>();
    ints3.add(new Interval(5, 21));
    ints3.add(new Interval(57, 74));

    schedule.add(ints1);
    schedule.add(ints3);

    List<Interval> result = new EmployeeFreeTime().employeeFreeTime(schedule);
    for (Interval i : result) {
      System.out.println(i.start + " " + i.end);
    }
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    if (schedule.isEmpty()) return new ArrayList<>();
    List<Interval> merged = schedule.get(0);
    for (int i = 1, l = schedule.size(); i < l; i++) {
      List<Interval> employeeInt = schedule.get(i);
      for (Interval in : employeeInt) {
        merged = merge(merged, in);
      }
    }
    List<Interval> result = new ArrayList<>();
    for (int i = 0, l = merged.size(); i + 1 < l; i++) {
      if (merged.get(i).end != merged.get(i + 1).start) {
        result.add(new Interval(merged.get(i).end, merged.get(i + 1).start));
      }
    }
    return result;
  }

  private List<Interval> merge(List<Interval> list, Interval interval) {
    List<Interval> result = new ArrayList<>();
    for (int i = 0, l = list.size(); i < l; i++) {
      Interval curr = list.get(i);
      if (interval.start >= curr.start && interval.end <= curr.end) {
        return list;
      } else if (interval.start >= curr.start && interval.start <= curr.end) {
        interval = new Interval(curr.start, interval.end);
      } else if (interval.end >= curr.start && interval.end <= curr.end) {
        interval = new Interval(interval.start, curr.end);
      } else if (interval.end < curr.start) {
        result.add(interval);
        for (int j = i; j < l; j++) {
          result.add(list.get(j));
        }
        return result;
      } else if (interval.start > curr.end) {
        result.add(curr);
      }
    }
    result.add(interval);
    return result;
  }
}
