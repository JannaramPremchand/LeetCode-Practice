package Tree;

public class InorderSuccessorInBST {
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
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(6);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(13);
    root.right.left.left = new TreeNode(12);
    root.right.left.right = new TreeNode(14);
    root.right.right = new TreeNode(17);
    TreeNode ans = new InorderSuccessorInBST().inorderSuccessor(root, root.right.left.right);
    if (ans != null) System.out.println(ans.val);
    else System.out.println(ans);
  }

  /**
   * Find successor
   *
   * @param root root node
   * @param p target
   * @return successor
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    return inOrder(root, p, null);
  }

  /**
   * Inorder traversal
   *
   * @param curr current node
   * @param target target node
   * @param successor successor
   * @return successor node
   */
  private TreeNode inOrder(TreeNode curr, TreeNode target, TreeNode successor) {
    if (curr == null) return successor;
    if (curr.val <= target.val) return inOrder(curr.right, target, successor);
    return inOrder(curr.left, target, curr); // make the current node as successor
  }
}
