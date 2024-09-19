package Tree;

import java.util.*;

public class ClosestLeafInABinaryTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static class Pair {
    int n, d;

    Pair(int n, int d) {
      this.n = n;
      this.d = d;
    }
  }

  private Map<Integer, Pair> map;
  private Pair minNode;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.left.left = new TreeNode(6);
    // root.right = new TreeNode(3);
    System.out.println(new ClosestLeafInABinaryTree().findClosestLeaf(root, 2));
  }

  public int findClosestLeaf(TreeNode root, int k) {
    map = new HashMap<>();
    minNode = new Pair(-1, Integer.MAX_VALUE);
    findDistanceToLeaf(root);
    findMin(root, k);
    return minNode.n;
  }

  private Pair findDistanceToLeaf(TreeNode node) {
    if (node != null) {
      if (node.left == null && node.right == null) {
        map.put(node.val, new Pair(node.val, 0));
        return new Pair(node.val, 1);
      } else {
        Pair left = findDistanceToLeaf(node.left);
        Pair right = findDistanceToLeaf(node.right);
        if (left.d < right.d) {
          map.put(node.val, left);
          return new Pair(left.n, left.d + 1);
        } else {
          map.put(node.val, right);
          return new Pair(right.n, right.d + 1);
        }
      }
    }
    return new Pair(-1, Integer.MAX_VALUE);
  }

  private int findMin(TreeNode node, int k) {
    if (node != null) {
      if (node.val == k) {
        if (map.get(node.val).d < minNode.d) {
          minNode = map.get(node.val);
        }
        return 1;
      } else {
        int left = findMin(node.left, k);
        int right = findMin(node.right, k);
        if (left != -1) {
          if ((left + map.get(node.val).d) < minNode.d) {
            minNode = new Pair(map.get(node.val).n, (left + map.get(node.val).d));
          }
          return left + 1;
        } else if (right != -1) {
          if ((right + map.get(node.val).d) < minNode.d) {
            minNode = new Pair(map.get(node.val).n, (right + map.get(node.val).d));
          }
          return right + 1;
        }
      }
    }
    return -1;
  }
}
