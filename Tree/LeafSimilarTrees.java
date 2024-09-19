package Tree;

import java.util.*;

public class LeafSimilarTrees {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {}

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    inorder(root1, list1);
    inorder(root2, list2);
    if (list1.size() != list2.size()) return false;
    else {
      for (int i = 0, l = list1.size(); i < l; i++) {
        if (list1.get(i).intValue() != list2.get(i).intValue()) {
          return false;
        }
      }
    }
    return true;
  }

  private void inorder(TreeNode node, List<Integer> list) {
    if (node != null) {
      if (node.left == null && node.right == null) {
        list.add(node.val);
      }
      inorder(node.left, list);
      inorder(node.right, list);
    }
  }
}
