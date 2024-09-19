package Two_Pointers;

public class LastSubstringInLexicographicalOrder {
  public static void main(String[] args) {
    System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("babcbd"));
  }

  public String lastSubstring(String s) {
    int currAns = 0;
    int candidate = -1;
    int prevIndex = 1;
    for (int i = 1, l = s.length(); i < l; i++) {
      if (candidate != -1) {
        if (s.charAt(i) == s.charAt(prevIndex)) {
          prevIndex++;
        } else if (s.charAt(i) > s.charAt(prevIndex)) {
          if (s.charAt(i) > s.charAt(candidate)) {
            currAns = i;
            candidate = -1;
            prevIndex = currAns + 1;
          } else if (s.charAt(i) == s.charAt(candidate)) {
            currAns = candidate;
            candidate = i;
            prevIndex = currAns + 1;
          } else {
            currAns = candidate;
            candidate = -1;
            prevIndex = currAns + 1;
          }
        } else {
          candidate = -1;
          prevIndex = currAns + 1;
        }
      } else {
        if (s.charAt(i) > s.charAt(currAns)) {
          currAns = i;
          candidate = -1;
          prevIndex = currAns + 1;
        } else if (s.charAt(i) == s.charAt(currAns)) {
          candidate = i;
        }
      }
    }
    return s.substring(currAns);
  }
}
