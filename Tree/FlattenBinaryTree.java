package Tree;


public class FlattenBinaryTree {

  /** Class to keep track of head and tail */
  private class LinkNode {
    TreeNode head;
    TreeNode tail;

    LinkNode(TreeNode head, TreeNode tail) {
      this.head = head;
      this.tail = tail;
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(1);
    new FlattenBinaryTree().flatten(root);
    System.out.print(root.val + " ");
    System.out.print(root.right.val + " ");
    System.out.print(root.right.right.val);
  }

  public void flatten(TreeNode root) {
    preOrder(root);
  }

  private LinkNode preOrder(TreeNode node) {
    if (node == null) return null;
    LinkNode left = preOrder(node.left);
    LinkNode right = preOrder(node.right);
    LinkNode lNode;
    if (left == null && right == null) {
      lNode = new LinkNode(node, node);
    } else if (left == null) {
      node.right = right.head;
      lNode = new LinkNode(node, right.tail);
    } else if (right == null) {
      node.right = left.head;
      lNode = new LinkNode(node, left.tail);
    } else {
      node.right = left.head;
      left.tail.right = right.head;
      lNode = new LinkNode(node, right.tail);
    }
    node.left = null;
    return lNode;
  }
}
