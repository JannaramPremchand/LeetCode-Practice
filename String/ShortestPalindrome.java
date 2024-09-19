package String;


public class ShortestPalindrome {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new ShortestPalindrome().shortestPalindrome("aaaaaaaaaa"));
  }

  public String shortestPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return s;
    } else if (s.length() == 2) {
      if (s.charAt(0) == s.charAt(1)) {
        return s;
      } else {
        return (s.charAt(1) + s);
      }
    }
    if (isPaliandrome(s, 0, s.length() - 1)) return s;
    StringBuilder sb = new StringBuilder("");
    for (int i = 0, j = s.length() - 1; j >= i; j--) {
      if (!isPaliandrome(s, i, j)) {
        sb.append(s.charAt(j));
      } else {
        sb.append(s.substring(0, s.length()));
        break;
      }
    }
    return sb.toString();
  }

  boolean isPaliandrome(String s, int x, int y) {
    for (int i = x, j = y; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) return false;
    }
    return true;
  }
}
