package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MaximumWidthOfBinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private Map<Integer, List<Integer>> map;

  public static void main(String[] args) {}

  public int widthOfBinaryTree(TreeNode root) {
    map = new HashMap<>();
    preorder(root, 1, 1);
    int max = 0;
    for (int k : map.keySet()) {
      List<Integer> list = map.get(k);
      if (list.size() == 1) {
        max = Math.max(max, 1);
      } else {
        max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
      }
    }
    return max;
  }

  private void preorder(TreeNode node, int level, int pos) {
    if (node != null) {
      preorder(node.left, level + 1, pos * 2);
      map.putIfAbsent(level, new ArrayList<>());
      map.get(level).add(pos);
      preorder(node.right, level + 1, pos * 2 + 1);
    }
  }
}
