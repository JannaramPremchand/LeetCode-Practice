package Tree;


public class EqualTreePartition {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private long sum;
  private boolean possible = false;

  public static void main(String[] args) throws Exception {}

  public boolean checkEqualTree(TreeNode root) {
    sum = 0L;
    getSum(root);
    getDiff(root);
    return possible;
  }

  private void getSum(TreeNode node) {
    if (node != null) {
      sum += node.val;
      getSum(node.left);
      getSum(node.right);
    }
  }

  private Long getDiff(TreeNode node) {
    if (node == null) return null;
    Long left = getDiff(node.left);
    Long right = getDiff(node.right);
    if (left != null) {
      if ((sum - left) == left) {
        possible = true;
      }
    }
    if (right != null) {
      if ((sum - right) == right) {
        possible = true;
      }
    }
    Long curr = (long) node.val;
    if (left != null) {
      curr += left;
    }
    if (right != null) {
      curr += right;
    }
    return curr;
  }
}
