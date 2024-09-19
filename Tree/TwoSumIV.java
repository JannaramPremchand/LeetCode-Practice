package Tree;

import java.util.HashSet;


public class TwoSumIV {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {}

  public boolean findTarget(TreeNode root, int k) {
    return inorder(root, new HashSet<>(), k);
  }

  private boolean inorder(TreeNode node, HashSet<Integer> set, int k) {
    if (node != null) {
      int req = k - (node.val);
      if (set.contains(req)) {
        return true;
      }
      set.add(node.val);
      if (inorder(node.left, set, k)) {
        return true;
      } else {
        if (inorder(node.right, set, k)) {
          return true;
        }
      }
    }
    return false;
  }
}
