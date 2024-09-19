package Tree;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    new BinaryTreePaths().inorder(root, result, "");
    return result;
  }

  private void inorder(TreeNode node, List<String> list, String path) {
    if (node != null) {
      if (node.left == null && node.right == null) {
        list.add(path + node.val);
      } else {
        inorder(node.left, list, path + node.val + "->");
        inorder(node.right, list, path + node.val + "->");
      }
    }
  }
}
