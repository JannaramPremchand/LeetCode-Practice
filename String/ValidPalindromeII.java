package String;


public class ValidPalindromeII {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new ValidPalindromeII().validPalindrome("aaaaaab"));
  }

  public boolean validPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; ) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return isPaliandrome(s.substring(i, j)) || isPaliandrome(s.substring(i + 1, j + 1));
      }
    }
    return true;
  }

  private boolean isPaliandrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; ) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else return false;
    }
    return true;
  }
}
