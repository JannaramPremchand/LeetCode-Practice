package Array;

import java.util.*;


public class MyCalendarThree {

  private List<Node> events;
  private int max;

  private class Node {
    int n, index;

    Node(int n, int index) {
      this.n = n;
      this.index = index;
    }

    public int getN() {
      return n;
    }

    public int getIndex() {
      return index;
    }
  }

  public MyCalendarThree() {
    events = new ArrayList<>();
    max = 0;
  }

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    MyCalendarThree calendar = new MyCalendarThree();
    System.out.println(calendar.book(10, 20));
    System.out.println(calendar.book(50, 60));
    System.out.println(calendar.book(10, 40));
    System.out.println(calendar.book(5, 15));
    System.out.println(calendar.book(5, 10));
    System.out.println(calendar.book(25, 55));
  }

  public int book(int start, int end) {
    events.add(new Node(start, 1));
    events.add(new Node(end, 0));
    events.sort((Comparator.comparing(Node::getN).thenComparing(Node::getIndex)));
    int count = 0;
    for (Node node : events) {
      if (node.index == 1 && node.n >= end) {
        break;
      }
      count += node.index == 1 ? 1 : -1;
      if (node.getN() >= start) {
        max = Math.max(max, count);
      }
    }
    return max;
  }
}
