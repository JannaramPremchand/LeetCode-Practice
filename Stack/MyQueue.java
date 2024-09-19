package Stack;

import java.util.Stack;

public class MyQueue {

  private Stack<Integer> stack;

  public static void main(String[] args) throws Exception {
    MyQueue myQueue = new MyQueue();
    myQueue.push(5);
    myQueue.push(12);
    myQueue.push(7);
    myQueue.push(9);
    System.out.println(myQueue.peek());
    System.out.println(myQueue.pop());
    myQueue.push(56);
    myQueue.push(53);
    System.out.println(myQueue.pop());
  }

  /** Initialize your data structure here. */
  public MyQueue() {
    stack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    Stack<Integer> auxStack = new Stack<>();
    while (!stack.isEmpty()) {
      auxStack.push(stack.pop());
    }
    int result = auxStack.pop();
    while (!auxStack.isEmpty()) {
      stack.push(auxStack.pop());
    }
    return result;
  }

  /** Get the front element. */
  public int peek() {
    Stack<Integer> auxStack = new Stack<>();
    while (!stack.isEmpty()) {
      auxStack.push(stack.pop());
    }
    int result = auxStack.peek();
    while (!auxStack.isEmpty()) {
      stack.push(auxStack.pop());
    }
    return result;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.isEmpty();
  }
}
