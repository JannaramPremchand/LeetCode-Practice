package Tree;

public class RecoverBinarySearchTree {
  private boolean violation;
  private TreeNode left, right, prev;

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(5);
    new RecoverBinarySearchTree().recoverTree(root);
  }

  public void recoverTree(TreeNode root) {
    inorder(root);
    if (left != null && right != null) {
      int temp = left.val;
      left.val = right.val;
      right.val = temp;
    }
  }

  private void inorder(TreeNode root) {
    if (root != null) {
      inorder(root.left);
      if (prev != null) {
        if (!violation) {
          if (prev.val > root.val) {
            violation = true;
            left = prev;
            right = root;
          } else {
            prev = root;
          }
        } else {
          if (root.val <= right.val) {
            right = root;
          }
        }
      } else {
        prev = root;
      }
      inorder(root.right);
    }
  }
}
