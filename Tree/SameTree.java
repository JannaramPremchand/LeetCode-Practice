package Tree;

public class SameTree {

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

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if ((p == null && q != null) || (p != null && q == null)) return false;
    if (p == null && q == null) return true;
    else {
      boolean status = isSameTree(p.left, q.left);
      if (!status || p.val != q.val) {
        return false;
      }
      return isSameTree(p.right, q.right);
    }
  }
}
