package String;


public class ValidPalindrome {
  public static void main(String[] args) throws Exception {
    System.out.println(new ValidPalindrome().isPalindrome("989 "));
  }

  public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) return true;
    s = s.toLowerCase();
    for (int i = 0, j = s.length() - 1; i < j; ) {
      char f = s.charAt(i);
      char l = s.charAt(j);
      if (!(f >= 'a' && f <= 'z') && !(f >= '0' && f <= '9')) {
        i++;
        continue;
      }
      if (!(l >= 'a' && l <= 'z') && !(l >= '0' && l <= '9')) {
        j--;
        continue;
      }
      if (f != l) return false;
      i++;
      j--;
    }
    return true;
  }
}
