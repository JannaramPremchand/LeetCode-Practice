package Dynamic_Programming;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfPathsWithMaxScore {
  public static void main(String[] args) {
    String[] board = {"E11", "XXX", "11S"};
    List<String> input = Arrays.stream(board).collect(Collectors.toList());
    int[] r = new NumberOfPathsWithMaxScore().pathsWithMaxScore(input);
    System.out.println(r[0] + " " + r[1]);
  }

  long[][] M, N;
  final int[] R = {0, 1, 1};
  final int[] C = {1, 1, 0};
  int MOD = (int) 1e9 + 7;

  public int[] pathsWithMaxScore(List<String> board) {
    M = new long[board.size()][board.get(0).length()];
    N = new long[board.size()][board.get(0).length()];
    N[board.size() - 1][board.get(0).length() - 1] = 1;
    for (int i = board.size() - 1; i >= 0; i--) {
      for (int j = board.get(i).length() - 1; j >= 0; j--) {
        char curr = board.get(i).charAt(j);
        if (curr != 'X') {
          int currInt = 0;
          if (curr != 'S' && curr != 'E') {
            currInt = Integer.parseInt(String.valueOf(curr));
          }
          long currMax = -1;
          for (int k = 0; k < 3; k++) {
            int newR = i + R[k];
            int newC = j + C[k];
            if (newR < board.size()
                && newC < board.get(0).length()
                && board.get(newR).charAt(newC) != 'X'
                && N[newR][newC] != 0) {
              M[i][j] = Math.max(M[i][j], ((currInt + M[newR][newC]) % MOD));
              long newMax = ((currInt + M[newR][newC]) % MOD);
              if (newMax > currMax) {
                currMax = newMax;
                N[i][j] = N[newR][newC];
              } else if (newMax == currMax) {
                N[i][j] = ((N[newR][newC] + N[i][j]) % MOD);
              }
            }
          }
        }
      }
    }
    int[] res = new int[2];
    res[0] = (int) M[0][0];
    res[1] = (int) N[0][0];
    return res;
  }
}
