package Array;


public class BattleshipsInABoard {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
    System.out.println(new BattleshipsInABoard().countBattleships(board));
  }

  public int countBattleships(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'X') {
          if (i - 1 >= 0) { // check for the boundary condition
            if (board[i - 1][j] == 'X') continue;
          }
          if (j - 1 >= 0) {
            if (board[i][j - 1] == 'X') {
              continue;
            }
          }
          count++;
        }
      }
    }
    return count;
  }
}
