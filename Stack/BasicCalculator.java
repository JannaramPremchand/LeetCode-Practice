package Stack;

import java.util.Stack;


public class BasicCalculator {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(
        new BasicCalculator().calculate("2-1 + (2 - 3) - ((2 - (2 - (3 - (4 - 5)))))"));
  }

  public int calculate(String s) {
    Stack<String> stack = new Stack<>();
    String num = "";
    s = "(" + s + ")";
    for (char c : s.toCharArray()) {
      switch (c) {
        case ' ':
        case '(':
        case '+':
        case '-':
          if (!num.equals("")) {
            stack.push(String.valueOf(num));
            num = "";
          }
          if (c != ' ') { // ignore blank
            stack.push(String.valueOf(c));
          }
          break;
        case ')':
          if (!num.equals("")) {
            stack.push(String.valueOf(num));
            num = "";
          }
          int sum = 0;
          int prev = 0; // maintain a prev value inorder to handle minus '-'
          while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("-")) {
              sum -= (prev * 2);
              prev = 0;
            } else if (top.equals("+")) {
              // ignore
            } else if (top.equals("(")) {
              stack.push(String.valueOf(sum));
              break;
            } else {
              sum += Integer.parseInt(top);
              prev = Integer.parseInt(top);
            }
          }
          break;
        default:
          num += String.valueOf(c);
          break;
      }
    }
    return Integer.parseInt(stack.peek());
  }
}
