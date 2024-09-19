package Linked_List;

import java.util.*;

public class SplitLinkedListInParts {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    ListNode[] result = new SplitLinkedListInParts().splitListToParts(root, 5);
    System.out.println(result);
  }

  public ListNode[] splitListToParts(ListNode root, int k) {
    List<Integer> list = new ArrayList<>();
    while (root != null) {
      list.add(root.val);
      root = root.next;
    }
    int tempK = k;
    int N = list.size();
    List<ListNode> result = new ArrayList<>();
    ListNode head = new ListNode(-1);
    ListNode prev = head;
    int i = 0, j = 0;
    int count = 0;
    int P = N / tempK;
    if ((N % tempK) > 0) {
      P++;
    }
    for (; j < N; ) {
      if (j - i < P) {
        prev.next = new ListNode(list.get(j));
        prev = prev.next;
        j++;
        count++;
      } else {
        result.add(head.next);
        i = j;
        head = new ListNode(-1);
        prev = head;
        tempK--;
        P = (N - count) / tempK;
        if (((N - count) % tempK) > 0) {
          P++;
        }
      }
    }
    result.add(head.next);
    while (result.size() < k) {
      result.add(null);
    }
    ListNode[] nodes = new ListNode[result.size()];
    for (int l = 0; l < result.size(); l++) {
      nodes[l] = result.get(l);
    }
    return nodes;
  }
}
