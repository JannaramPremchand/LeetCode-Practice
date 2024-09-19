package Tree;

public class MinimumAbsoluteDifferenceInBST {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root);
  }

  public int getMinimumDifference(TreeNode root) {
    getMin(root, null);
    return min;
  }

  private Integer getMin(TreeNode node, Integer prev) {
    if (node == null) return prev;
    Integer left = getMin(node.left, prev);
    if (left != null) {
      min = Math.min(min, Math.abs(node.val - left));
    }
    return getMin(node.right, node.val);
  }
}
