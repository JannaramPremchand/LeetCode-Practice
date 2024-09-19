package Tree;


public class ConstructStringFromBinaryTree {
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
    TreeNode t = new TreeNode(1);
    t.left = new TreeNode(2);
    t.left.left = new TreeNode(4);
    t.right = new TreeNode(3);
    System.out.println(new ConstructStringFromBinaryTree().tree2str(t));
  }

  public String tree2str(TreeNode t) {
    if (t == null) return "";
    String left = tree2str(t.left);
    String right = tree2str(t.right);
    if (left.equals("") && right.equals("")) return String.valueOf(t.val);
    if (left.equals("")) left = "()";
    else left = "(" + left + ")";
    if (!right.equals("")) right = "(" + right + ")";
    return t.val + left + right;
  }
}
