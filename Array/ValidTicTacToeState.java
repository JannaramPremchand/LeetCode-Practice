package Array;

public class ValidTicTacToeState {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] board = {"XXX", "XOO", "OO "};
    System.out.println(new ValidTicTacToeState().validTicTacToe(board));
  }

  public boolean validTicTacToe(String[] board) {
    boolean xWon = hasWon(board, 'X');
    boolean oWon = hasWon(board, 'O');
    int xcount = 0, ocount = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'X') {
          xcount++;
        } else if (board[i].charAt(j) == 'O') {
          ocount++;
        }
      }
    }
    if (xWon && oWon) return false;
    if (xWon) {
      return ((xcount - 1 == ocount));
    } else if (oWon) {
      return ((xcount == ocount));
    } else {
      return (xcount == ocount || xcount - 1 == ocount);
    }
  }

  private boolean hasWon(String[] board, char c) {
    boolean diagnol =
        ((board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            || (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c));
    if (diagnol) return true;
    for (int i = 0; i < 3; i++) {
      if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
        return true;
    }
    for (int i = 0; i < 3; i++) {
      if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c)
        return true;
    }
    return false;
  }
}
