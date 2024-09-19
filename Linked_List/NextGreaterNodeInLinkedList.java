package Linked_List;

import java.util.*;

public class NextGreaterNodeInLinkedList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private List<Integer> result;

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    new NextGreaterNodeInLinkedList().nextLargerNodes(node);
  }

  public int[] nextLargerNodes(ListNode head) {
    result = new ArrayList<>();
    find(head, result);
    Collections.reverse(result);
    int[] answer = new int[result.size()];
    for (int i = 0, l = result.size(); i < l; i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }

  private Stack<Integer> find(ListNode head, List<Integer> answer) {
    if (head == null) {
      return new Stack<>();
    }
    Stack<Integer> stack = find(head.next, answer);
    if (stack.isEmpty()) {
      answer.add(0);
      stack.push(head.val);
    } else {
      if (stack.peek() > head.val) {
        answer.add(stack.peek());
        stack.push(head.val);
      } else {
        while (!stack.isEmpty() && stack.peek() <= head.val) {
          stack.pop();
        }
        if (stack.isEmpty()) {
          stack.push(head.val);
          answer.add(0);
        } else {
          answer.add(stack.peek());
          stack.push(head.val);
        }
      }
    }
    return stack;
  }
}
