package Math;

public class ReachingPoints {

  class Pair {
    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new ReachingPoints().reachingPoints(1, 1, 153, 10));
  }

  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    Pair target = new Pair(tx, ty);
    Pair start = new Pair(sx, sy);
    while (true) {
      if (start.x == target.x && start.y == target.y) {
        return true;
      } else if (start.x > target.x || start.y > target.y || target.x == target.y) {
        return false;
      } else if (start.x == target.x) {
        int t = target.y - start.y;
        return (t % target.x) == 0;
      } else if (start.y == target.y) {
        int t = target.x - start.x;
        return (t % target.y) == 0;
      } else {
        if (target.x > target.y) {
          int[] R = reduce(target.x, target.y);
          target.x = R[0];
          target.y = R[1];
        } else {
          int[] R = reduce(target.y, target.x);
          target.x = R[1];
          target.y = R[0];
        }
      }
    }
  }

  private int[] reduce(int x, int y) {
    int t = x - y;
    int q = t / y;
    x -= (y * q);
    if ((t % y) != 0) {
      x -= y;
    }
    return new int[] {x, y};
  }
}
