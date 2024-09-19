package Tree;

public class SplitBST {

  public static class TreeNode {
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
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    TreeNode[] result = new SplitBST().splitBST(root, 3);
  }

  public TreeNode[] splitBST(TreeNode root, int V) {
    if (root == null) {
      return new TreeNode[] {null, null};
    } else {
      TreeNode[] result = new TreeNode[2];
      if (root.val <= V) {
        result[0] = root;
        TreeNode[] right = splitBST(root.right, V);
        root.right = right[0];
        result[1] = right[1];
        return result;
      } else {
        TreeNode[] left = splitBST(root.left, V);
        root.left = left[1];
        result[0] = left[0];
        result[1] = root;
        return result;
      }
    }
  }
}
