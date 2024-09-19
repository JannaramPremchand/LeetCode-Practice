package Tree;

public class SubtreeOfAnotherTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {}

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s != null) {
      if (s.val == t.val) {
        if (equal(s, t)) return true;
        else return (isSubtree(s.left, t) || isSubtree(s.right, t));
      } else return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    return false;
  }

  private boolean equal(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    else if (s == null || t == null) return false;
    else if (s.val != t.val) return false;
    else return equal(s.left, t.left) && equal(s.right, t.right);
  }
}
