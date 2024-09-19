package Divide_And_Conquer;

import java.util.*;

public class MyCalendarII {
  public static void main(String[] args) {
    MyCalendarII t = new MyCalendarII();
    System.out.println(t.book(20, 27));
    System.out.println(t.book(27, 36));
    System.out.println(t.book(27, 36));
    System.out.println(t.book(24, 33));
  }

  private class Pair {
    int a, b, index;

    Pair(int a, int b, int index) {
      this.a = a;
      this.b = b;
      this.index = index;
    }
  }

  TreeSet<Pair> treeSet;
  int count;

  public MyCalendarII() {
    count = 0;
    treeSet =
        new TreeSet<>(
            (o1, o2) -> {
              int r = Integer.compare(o1.a, o2.a);
              if (r == 0) {
                int r2 = Integer.compare(o1.b, o2.b);
                if (r2 == 0) {
                  return Integer.compare(o1.index, o2.index);
                } else return r2;
              }
              return r;
            });
  }

  public boolean book(int start, int end) {
    Pair range = new Pair(start, end, count++);
    Iterator<Pair> ascending = treeSet.iterator();
    Pair prev = null;
    while (ascending.hasNext()) {
      Pair cur = ascending.next();
      if (prev != null) {
        if ((range.a >= prev.a && range.a < prev.b) && (range.a >= cur.a && range.a < cur.b)) {
          return false;
        } else if ((prev.a >= range.a && prev.a < range.b)
            && (cur.a >= prev.a && cur.a < Math.min(prev.b, range.b))) {
          return false;
        } else if ((range.a >= prev.a && range.a < range.b)
            && (cur.a >= range.a && cur.a < Math.min(prev.b, range.b))) {
          return false;
        }
      }
      if ((range.a >= cur.a && range.a < cur.b) || (cur.a >= range.a && cur.a < range.b)) {
        prev = cur;
      }
    }
    treeSet.add(range);
    return true;
  }
}
