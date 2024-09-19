package Tree;

public class DiameterOfBinaryTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private int max = 0;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
  }

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return max;
  }

  private int dfs(TreeNode node) {
    if (node != null) {
      int left = dfs(node.left);
      int right = dfs(node.right);
      max = Math.max(max, left + right);
      return left > right ? left + 1 : right + 1;
    }
    return 0;
  }
}
