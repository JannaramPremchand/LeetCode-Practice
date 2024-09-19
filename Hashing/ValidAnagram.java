package Hashing;

public class ValidAnagram {
  private int[] S = new int[256];
  private int[] T = new int[256];

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    for (int i = 0, l = s.length(); i < l; i++) {
      S[s.charAt(i)]++;
    }

    for (int i = 0, l = t.length(); i < l; i++) {
      T[t.charAt(i)]++;
    }

    for (int i = 0; i < 256; i++) {
      if (S[i] != T[i]) return false;
    }

    return true;
  }
}
