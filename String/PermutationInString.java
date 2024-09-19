package String;


public class PermutationInString {
  private int[] S1 = new int[256];
  private int[] S2 = new int[256];

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new PermutationInString().checkInclusion("ab", "eidboaoo"));
  }

  public boolean checkInclusion(String s1, String s2) {
    if (s2.length() < s1.length()) return false;
    for (int i = 0, l = s1.length(); i < l; i++) {
      S1[s1.charAt(i)]++;
      S2[s2.charAt(i)]++;
    }
    if (isEqual()) return true;
    for (int i = 1, j = s1.length(), l = s2.length(); j < l; i++, j++) {
      S2[s2.charAt(i - 1)]--;
      S2[s2.charAt(j)]++;
      if (isEqual()) return true;
    }
    return false;
  }

  private boolean isEqual() {
    boolean equal = true;
    for (int i = 0; i < 256; i++) {
      if (S1[i] != S2[i]) {
        equal = false;
        break;
      }
    }
    return equal;
  }
}
