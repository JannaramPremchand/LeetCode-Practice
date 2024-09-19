package Depth_First_Search;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RobotRoomCleaner {

  // direction
  // UP 0, LEFT = 1, DOWN = 2, RIGHT = 3

  private final int[] R = {-1, 0, 1, 0};
  private final int[] C = {0, -1, 0, 1};

  interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
  }

  static class Position {
    int r, c;

    Position(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
      int r = ((Position) obj).r;
      int c = ((Position) obj).c;
      return (this.r == r && this.c == c);
    }

    @Override
    public int hashCode() {
      return Objects.hash(r, c);
    }
  }

  private static Set<Position> done;

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {}

  public void cleanRoom(Robot robot) {
    done = new HashSet<>();
    dfs(1, 3, done, robot, 0);
  }

  private void dfs(int r, int c, Set<Position> done, Robot robot, int direction) {
    done.add(new Position(r, c));
    robot.clean();
    for (int i = 0; i < 4; i++) {
      int newR = r + R[direction];
      int newC = c + C[direction];
      if (!done.contains(new Position(newR, newC))) {
        boolean possible = robot.move();
        if (possible) {
          dfs(newR, newC, done, robot, direction);
        }
      }
      robot.turnLeft();
      direction = (direction + 1) % 4;
    }
    robot.turnLeft();
    robot.turnLeft();
    robot.move();
    robot.turnLeft();
    robot.turnLeft();
  }
}
