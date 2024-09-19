package String;

public class MinimumAddtoMakeParenthesesValid {
  public static void main(String[] args) {
    System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid("()))(("));
  }

  public int minAddToMakeValid(String S) {
    int result = 0;
    int open = 0;
    for (char c : S.toCharArray()) {
      if (c == '(') {
        open++;
      } else if (c == ')') {
        if (open > 0) {
          open--;
        } else result++;
      }
    }
    return result + open;
  }
}
