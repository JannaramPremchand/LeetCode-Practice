package Tree;

public class BSTtoDoublyLinkedList {

  static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    Node root = new Node(4, new Node(2, null, null), new Node(5, null, null));
    Node result = new BSTtoDoublyLinkedList().treeToDoublyList(root);
    // print result
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;
    Node head = new Node();
    Node last = preorder(root, head);
    last.right = head.right;
    head.right.left = last;
    return head.right;
  }

  Node preorder(Node node, Node prev) {
    if (node == null) return prev;
    else {
      Node left = preorder(node.left, prev);
      left.right = node;
      node.left = left;
      return preorder(node.right, node);
    }
  }
}
