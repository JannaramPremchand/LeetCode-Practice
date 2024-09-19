package Tree;


public class FindBottomLeftTreeValue {
  private int max = 0, result;

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.left.left = new TreeNode(7);
    root.right.right = new TreeNode(6);
    System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(root));
  }

  public int findBottomLeftValue(TreeNode root) {
    inorder(root, 1);
    return result;
  }

  private void inorder(TreeNode node, int level) {
    if (node != null) {
      if (level > max) {
        result = node.val;
        max = level;
      }
      inorder(node.left, level + 1);
      inorder(node.right, level + 1);
    }
  }
}
