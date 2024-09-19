package Array;

import java.util.Stack;

public class FruitIntoBaskets {

  private int count = 0;
  private int max = 0;
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] trees = {1, 0, 3, 4, 3};
    System.out.println(new FruitIntoBaskets().totalFruit(trees));
  }

  public int totalFruit(int[] tree) {
    int t1 = -1, t2 = -1;
    Stack<Integer> stack = new Stack<>();
    for (int i : tree) {
      if (i == t1 || i == t2) {
        countAndMax(stack, i);
      } else {
        if (t1 == -1) {
          t1 = i;
          countAndMax(stack, i);
        } else if (t2 == -1) {
          t2 = i;
          countAndMax(stack, i);
        } else {
          Stack<Integer> temp = new Stack<>();
          count = 0;
          t1 = stack.pop();
          countAndMax(temp, t1);
          while (!stack.isEmpty() && stack.peek() == t1) {
            countAndMax(temp, stack.pop());
          }
          t2 = i;
          stack = temp;
          countAndMax(stack, i);
        }
      }
    }
    return max;
  }

  private void countAndMax(Stack<Integer> stack, int i) {
    count++;
    stack.push(i);
    max = Math.max(max, count);
  }
}
