package Dynamic_Programming;

public class DeleteColumnsToMakeSortedIII {
  public static void main(String[] args) {
    String[] A = {"ghi", "def", "abc"};
    System.out.println(new DeleteColumnsToMakeSortedIII().minDeletionSize(A));
  }

  int[] DP;

  public int minDeletionSize(String[] A) {
    DP = new int[A[0].length()];
    int max = 0;
    for (int i = 0; i < A[0].length(); i++) {
      max = Math.max(max, dp(A, i));
    }
    return A[0].length() - max;
  }

  private int dp(String[] A, int i) {
    if (i >= A[0].length()) return 0;
    else if (DP[i] != 0) return DP[i];
    DP[i] = 1;
    for (int j = i + 1; j < A[0].length(); j++) {
      boolean possible = true;
      for (String str : A) {
        if (str.charAt(j) < str.charAt(i)) {
          possible = false;
          break;
        }
      }
      if (possible) {
        DP[i] = Math.max(DP[i], dp(A, j) + 1);
      }
    }
    return DP[i];
  }
}
