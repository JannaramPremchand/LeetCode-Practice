package Tree;

import java.util.*;
import java.util.stream.Collectors;
public class SerializeAndDeserializeNAryTree {

  static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    Node n1 = new Node(5, new ArrayList<>());
    Node n2 = new Node(6, Arrays.asList(n1));
    Node n3 = new Node(2, Arrays.asList(n2));
    Node n4 = new Node(4, Arrays.asList(n3));
    Node n5 = new Node(3, Arrays.asList(n4));
    Node root = new Node(1, Arrays.asList(n5));
    SerializeAndDeserializeNAryTree serializer = new SerializeAndDeserializeNAryTree();
    String result = serializer.serialize(root);
    Node rootNode = serializer.deserialize(result);
    System.out.println(result);
    System.out.println(rootNode);
  }

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    if (root != null) {
      String curr = String.valueOf(root.val);
      List<Node> children = root.children;
      return children != null
          ? curr
              + "["
              + children.stream().map(this::serialize).collect(Collectors.joining(","))
              + "]"
          : curr + "[]";
    } else {
      return "";
    }
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    char[] arr = data.toCharArray();
    StringBuilder num = new StringBuilder();
    Queue<String> queue = new ArrayDeque<>();
    for (char c : arr) {
      if (c >= '0' && c <= '9') {
        num.append(c);
      } else if (c == '[') {
        if (num.length() != 0) {
          queue.offer(num.toString());
          num = new StringBuilder();
        }
        queue.offer("[");
      } else {
        queue.offer(String.valueOf(c));
      }
    }
    if (queue.isEmpty()) return null;
    return decode(queue).get(0);
  }

  private List<Node> decode(Queue<String> elements) {
    List<Node> children = new ArrayList<>();
    while (!elements.isEmpty()) {
      String curr = elements.poll();
      if (curr.equals("[") || curr.equals(",")) {
      } else if (curr.equals("]")) {
        return children;
      } else {
        int num = Integer.parseInt(curr);
        Node currNode = new Node(num, decode(elements));
        children.add(currNode);
      }
    }
    return children;
  }
}
