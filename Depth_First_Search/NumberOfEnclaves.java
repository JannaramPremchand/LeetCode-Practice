package Depth_First_Search;

public class NumberOfEnclaves {

  final int[] R = {0, 0, -1, 1};
  final int[] C = {1, -1, 0, 0};

  boolean[][] done;
  int count = 0;
  int answer = 0;
  boolean possible = true;

  public static void main(String[] args) {
    int[][] A = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
    System.out.println(new NumberOfEnclaves().numEnclaves(A));
  }

  public int numEnclaves(int[][] A) {
    done = new boolean[A.length][A[0].length];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        if (!done[i][j] && A[i][j] == 1) {
          count = 0;
          possible = true;
          dfs(A, i, j);
          if (possible) {
            answer += count;
          }
        }
      }
    }
    return answer;
  }

  private void dfs(int[][] A, int r, int c) {
    done[r][c] = true;
    if (r == 0 || c == 0 || r == A.length - 1 || c == A[0].length - 1) {
      possible = false;
    }
    count++;
    for (int i = 0; i < 4; i++) {
      int newR = r + R[i];
      int newC = c + C[i];
      if (newR < A.length && newC < A[0].length && newR >= 0 && newC >= 0 && !done[newR][newC]) {
        if (A[newR][newC] == 1) {
          dfs(A, newR, newC);
        }
      }
    }
  }
}
