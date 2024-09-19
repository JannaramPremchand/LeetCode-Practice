package Two_Pointers;

public class NumberOfMatchingSubsequences {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] A = {"a", "bb", "acd", "ace"};
    System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq("abcde", A));
  }

  public int numMatchingSubseq(String S, String[] words) {
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      String w = words[i];
      if (isSubsequence(S, w)) {
        count++;
      }
    }
    return count;
  }

  private boolean isSubsequence(String S, String P) {
    int i = 0, j = 0;
    if (P.length() > S.length()) return false;
    for (; ; ) {
      if (j >= P.length()) return true;
      else if (i >= S.length()) return false;
      else {
        if (S.charAt(i) == P.charAt(j)) {
          i++;
          j++;
        } else {
          i++;
        }
      }
    }
  }
}
