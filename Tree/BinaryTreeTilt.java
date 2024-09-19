package Tree;

public class BinaryTreeTilt {

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
    node.right = new TreeNode(3);
    System.out.println(new BinaryTreeTilt().findTilt(node));
  }

  int sum = 0;

  public int findTilt(TreeNode root) {
    if (root == null) return 0;
    tilt(root);
    return sum;
  }

  private int tilt(TreeNode node) {
    if (node == null) return 0;
    int left = tilt(node.left);
    int right = tilt(node.right);
    sum += Math.abs(left - right);
    return left + right + node.val;
  }
}
