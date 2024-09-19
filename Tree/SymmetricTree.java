package Tree;

public class SymmetricTree {

  static class TreeNode {
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
  public static void main(String[] args) throws Exception {
    TreeNode node = new TreeNode(3);
    node.left = new TreeNode(4);
    node.right = new TreeNode(5);
    System.out.println(new SymmetricTree().isSymmetric(node));
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return dfs(root.left, root.right);
  }

  private boolean dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    else if (left == null || right == null) return false;
    return dfs(left.left, right.right) && left.val == right.val && dfs(left.right, right.left);
  }
}
