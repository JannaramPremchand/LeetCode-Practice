package Stack;

import java.util.Stack;


public class DecodeString {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new DecodeString().decodeString("100[leetcode]"));
  }

  public String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ']') {
        StringBuilder stackBuff = new StringBuilder();
        while (stack.peek() != '[') {
          stackBuff.append(stack.pop());
        }
        stack.pop(); // pop '['
        String num = "";
        while (!stack.isEmpty() && !Character.isAlphabetic(stack.peek()) && stack.peek() != '[') {
          num = stack.pop() + num;
        }
        String str = stackBuff.reverse().toString();
        StringBuilder stringMultiple = new StringBuilder();
        int N = Integer.parseInt(num);
        while (N-- > 0) {
          stringMultiple.append(str);
        }
        for (int j = 0; j < stringMultiple.length(); j++) {
          stack.push(stringMultiple.charAt(j));
        }
      } else stack.push(s.charAt(i));
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    return result.reverse().toString();
  }
}
