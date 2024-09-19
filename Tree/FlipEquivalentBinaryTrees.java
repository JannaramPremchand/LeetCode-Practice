package Tree;


public class FlipEquivalentBinaryTrees {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.left.left = new TreeNode(4);
    node.left.right = new TreeNode(5);
    node.left.right.left = new TreeNode(7);
    node.left.right.right = new TreeNode(8);
    node.right = new TreeNode(3);
    node.right.left = new TreeNode(6);

    TreeNode node1 = new TreeNode(1);
    node1.left = new TreeNode(3);
    node1.left.right = new TreeNode(6);
    node1.right = new TreeNode(2);
    node1.right.left = new TreeNode(4);
    node1.right.right = new TreeNode(5);
    node1.right.right.left = new TreeNode(8);
    node1.right.right.right = new TreeNode(7);
    System.out.println(new FlipEquivalentBinaryTrees().flipEquiv(node, node1));
  }

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    flip(root1, root2);
    return checkIfBothAreSame(root1, root2);
  }

  private boolean checkIfBothAreSame(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    else if (root1 == null) return false;
    else if (root2 == null) return false;
    else {
      if (root1.val != root2.val) return false;
      if (!checkIfBothAreSame(root1.left, root2.left)) return false;
      return checkIfBothAreSame(root1.right, root2.right);
    }
  }

  private void flip(TreeNode root1, TreeNode root2) {
    if (root1 != null) {
      TreeNode result = find(root2, root1.val);
      boolean valid = true;
      if (result != null) {
        if (root1.left == null) {
          if (result.right != null) {
            valid = false;
          }
        }
        if (root1.right == null) {
          if (result.left != null) {
            valid = false;
          }
        }
        if (root1.left != null) {
          if (result.right == null) {
            valid = false;
          } else {
            if (root1.left.val != result.right.val) {
              valid = false;
            }
          }
        }
        if (root1.right != null) {
          if (result.left == null) {
            valid = false;
          } else {
            if (root1.right.val != result.left.val) {
              valid = false;
            }
          }
        }
        if (valid) {
          TreeNode temp = result.left;
          result.left = result.right;
          result.right = temp;
        }
      }
      flip(root1.left, root2);
      flip(root1.right, root2);
    }
  }

  private TreeNode find(TreeNode node, int value) {
    if (node != null) {
      if (node.val == value) return node;
      TreeNode left = find(node.left, value);
      if (left != null) return left;
      TreeNode right = find(node.right, value);
      if (right != null) return right;
    }
    return null;
  }
}
