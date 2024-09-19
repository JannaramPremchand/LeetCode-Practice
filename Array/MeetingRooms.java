package Array;

import java.util.Arrays;


public class MeetingRooms {

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

  public static void main(String[] args) throws Exception {
    Interval i1 = new Interval(0, 30);
    Interval i2 = new Interval(5, 10);
    Interval i3 = new Interval(15, 20);
    Interval[] intervals = {i1, i2, i3};

    System.out.println(new MeetingRooms().canAttendMeetings(intervals));
  }

  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) return false;
    }
    return true;
  }
}
