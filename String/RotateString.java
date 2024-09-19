package String;

public class RotateString {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new RotateString().rotateString("abcde", "cdeab"));
  }

  public boolean rotateString(String A, String B) {
    if (A.length() == 1 || A.isEmpty() || B.length() == 1 || B.isEmpty()) {
      return A.equals(B);
    } else if (A.length() != B.length()) {
      return false;
    }
    for (int i = 0, l = A.length(); i < l; i++) {
      char s = A.charAt(0);
      A = A.substring(1) + s;
      if (A.equals(B)) return true;
    }
    return false;
  }
}
