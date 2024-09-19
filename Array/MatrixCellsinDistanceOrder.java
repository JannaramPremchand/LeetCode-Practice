package Array;

import java.util.*;


public class MatrixCellsinDistanceOrder {
  public static void main(String[] args) {
    //
  }

  class Cell {
    int max, i, j;

    Cell(int max, int i, int j) {
      this.max = max;
      this.i = i;
      this.j = j;
    }
  }

  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    List<Cell> list = new ArrayList<>();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int sum = Math.abs(r0 - i) + Math.abs(c0 - j);
        list.add(new Cell(sum, i, j));
      }
    }
    list.sort(Comparator.comparingInt(o -> o.max));
    int[][] A = new int[list.size()][2];
    for (int i = 0; i < A.length; i++) {
      A[i][0] = list.get(i).i;
      A[i][1] = list.get(i).j;
    }
    return A;
  }
}
