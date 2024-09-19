package Dynamic_Programming;

public class StickersToSpellWord {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] stickers = {"bright", "neighbor", "capital"};

    System.out.println(new StickersToSpellWord().minStickers(stickers, "originalchair"));
  }

  private int destination = 0;
  private int min = Integer.MAX_VALUE;
  private int[][] DP;

  public int minStickers(String[] stickers, String target) {
    for (int i = 0; i < target.length(); i++) {
      destination |= (1 << i);
    }
    DP = new int[destination][target.length() + 1];
    int answer = dp(stickers, target, 0, 0);
    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  private int dp(String[] stickers, String target, int curr, int count) {
    if (curr == destination) {
      return count;
    } else {
      if (count > min) return Integer.MAX_VALUE;
      if (DP[curr][count] != 0) return DP[curr][count];
      DP[curr][count] = Integer.MAX_VALUE;
      for (String s : stickers) {
        int temp = 0;
        char[] arr = s.toCharArray();
        for (int i = 0, l = target.length(); i < l; i++) {
          if ((curr & (1 << i)) == 0) {
            char targetChar = target.charAt(i);
            for (int j = 0; j < arr.length; j++) {
              if (arr[j] == targetChar) {
                arr[j] = '0';
                temp |= (1 << i);
                break;
              }
            }
          }
        }
        if (temp > 0) {
          int child = (curr | temp);
          int retValue = dp(stickers, target, child, count + 1);
          DP[curr][count] = Math.min(DP[curr][count], retValue);
          min = Math.min(min, DP[curr][count]);
        }
      }
      return DP[curr][count];
    }
  }
}
