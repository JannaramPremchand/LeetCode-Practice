package Tree;

import java.util.*;


public class FindLargestValueInEachTreeRow {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  Map<Integer, Integer> maxRow = new HashMap<>();

  class Node {
    int row;
    TreeNode val;

    Node(int row, TreeNode val) {
      this.row = row;
      this.val = val;
    }
  }

  public List<Integer> largestValues(TreeNode root) {
    if (root == null) return new ArrayList<>();
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(new Node(0, root));
    while (!queue.isEmpty()) {
      Node top = queue.poll();
      maxRow.putIfAbsent(top.row, top.val.val);
      maxRow.put(top.row, Math.max(maxRow.get(top.row), top.val.val));
      if (top.val.left != null) {
        queue.offer(new Node(top.row + 1, top.val.left));
      }
      if (top.val.right != null) {
        queue.offer(new Node(top.row + 1, top.val.right));
      }
    }
    List<Integer> answer = new ArrayList<>();
    List<Integer> keyList = new ArrayList<>(maxRow.keySet());
    keyList.sort(Integer::compareTo);
    for (int k : keyList) {
      answer.add(maxRow.get(k));
    }
    return answer;
  }

  public static void main(String[] args) {
    //
  }
}
