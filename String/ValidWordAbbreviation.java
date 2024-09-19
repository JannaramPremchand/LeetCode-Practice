package String;

public class ValidWordAbbreviation {

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new ValidWordAbbreviation().validWordAbbreviation("abbreviation", "a10n"));
  }

  public boolean validWordAbbreviation(String word, String abbr) {
    if (abbr.length() > word.length()) return false;
    StringBuilder num = new StringBuilder();
    int j = 0;
    for (int i = 0; i < abbr.length() && j < word.length(); i++) {
      char curr = abbr.charAt(i);
      if (curr == '0' && num.toString().isEmpty()) return false;
      if (curr >= '0' && curr <= '9') {
        num.append(curr);
      } else {
        if (num.toString().isEmpty()) {
          if (word.charAt(j) != abbr.charAt(i)) {
            return false;
          }
          j++;
        } else {
          int next = Integer.parseInt(num.toString());
          j += next;
          if (word.length() <= j) {
            return false;
          }
          if (word.charAt(j) != abbr.charAt(i)) {
            return false;
          }
          num = new StringBuilder();
          j++;
        }
      }
    }
    if (!num.toString().isEmpty()) {
      int next = Integer.parseInt(num.toString());
      j += next;
      if (j > word.length() || j < word.length()) {
        return false;
      }
    }
    return true;
  }
}
