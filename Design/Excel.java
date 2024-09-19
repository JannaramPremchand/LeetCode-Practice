package Design;

import java.util.*;

public class Excel {

  private Map<String, Set<String>> fwdEdges; // Forward links from cell
  private Map<String, List<String>> backEdge; // All backward links from cell
  private Map<String, Integer> count; // Keep track of number of times the cell is linked
  private int[][] grid; // excel grid

  /**
   * Initialize datastructure
   *
   * @param H row
   * @param W column
   */
  public Excel(int H, char W) {
    grid = new int[H][(Character.toUpperCase(W) - 'A') + 1];
    fwdEdges = new HashMap<>();
    backEdge = new HashMap<>();
    count = new HashMap<>();
  }

  public static void main(String[] args) throws Exception {
    Excel excel = new Excel(26, 'Z');
    excel.set(1, 'A', 1);
    excel.set(1, 'I', 1);
    String[] arr = {"A1:D6", "A1:G3", "A1:C12"};
    String[] arr1 = {"A1:D7", "D1:F10", "D3:I8", "I1:I9"};
    System.out.println(excel.get(1, 'A'));
    System.out.println(excel.sum(7, 'D', arr));
    System.out.println(excel.get(1, 'A'));
    System.out.println(excel.sum(10, 'G', arr1));
    System.out.println(excel.get(1, 'A'));
  }

  /**
   * Set value to the grid
   *
   * @param r row
   * @param c column
   * @param v value
   */
  public void set(int r, char c, int v) {
    setValue(r, c, v);
    removeForwardEdges(String.valueOf(c) + r);
  }

  private void setValue(int r, char c, int v) {
    int curr = grid[r - 1][Character.toUpperCase(c) - 'A'];
    grid[r - 1][Character.toUpperCase(c) - 'A'] = v;
    broadcast(v - curr, String.valueOf(c) + r);
  }

  /**
   * Remove all the links
   *
   * @param node node
   */
  private void removeForwardEdges(String node) {
    List<String> parents = backEdge.get(node);
    if (parents != null) {
      for (String p : parents) {
        Set<String> children = fwdEdges.get(p);
        if (children != null) {
          count.remove(p + ":" + node);
          children.remove(node);
        }
      }
    }
  }

  /**
   * Broadcast to all the links
   *
   * @param v current node
   * @param node node
   */
  private void broadcast(int v, String node) {
    Set<String> children = fwdEdges.get(node);
    if (children != null) {
      for (String c : children) {
        int order = count.get(node + ":" + c);
        grid[Integer.parseInt(c.substring(1)) - 1][c.charAt(0) - 'A'] += (v * order);
        broadcast(v, c);
      }
    }
  }

  public int get(int r, char c) {
    return grid[r - 1][c - 'A'];
  }

  /**
   * Sum range of cells
   *
   * @param r row
   * @param c column
   * @param strs Strings
   * @return integer sum
   */
  public int sum(int r, char c, String[] strs) {
    int sum = 0;
    // Remove all the forward and backward edges or links
    removeForwardEdges(c + String.valueOf(r));
    backEdge.remove(c + String.valueOf(r));
    Set<String> nodes = new HashSet<>();
    for (String s : strs) {
      String[] range = s.split(":");
      if (range.length > 1) {
        int startRow = Integer.parseInt(range[0].substring(1)) - 1;
        int startColumn = range[0].charAt(0) - 'A';

        int endRow = Integer.parseInt(range[1].substring(1)) - 1;
        int endColumn = range[1].charAt(0) - 'A';

        for (int i = startRow; i <= endRow; i++) {
          for (int j = startColumn; j <= endColumn; j++) {
            char newC = (char) ('A' + j);
            nodes.add(newC + String.valueOf(i + 1));
            sum += grid[i][j];
            String key = newC + String.valueOf(i + 1) + ":" + (c + String.valueOf(r));
            if (count.putIfAbsent(key, 1) != null) {
              count.put(key, (count.get(key) + 1));
            }
          }
        }
      } else {
        sum += grid[Integer.parseInt(range[0].substring(1)) - 1][range[0].charAt(0) - 'A'];
        nodes.add(range[0]);
        String key = range[0] + ":" + (c + String.valueOf(r));
        if (count.putIfAbsent(key, 1) != null) {
          count.put(key, count.get(key) + 1);
        }
      }
    }
    // set value
    setValue(r, c, sum);

    // make new forward-edges
    for (String n : nodes) {
      Set<String> children = fwdEdges.get(n);
      if (children == null) {
        children = new HashSet<>();
        fwdEdges.put(n, children);
      }
      children.add(c + String.valueOf(r));
    }

    // make new back-edges
    List<String> backEdges = new ArrayList<>();
    backEdges.addAll(nodes);
    backEdge.put(c + String.valueOf(r), backEdges);
    return sum;
  }
}
