package Tree;

import java.util.*;
 
public class AllNodesDistanceKInBinaryTree {

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
   */
  public static void main(String[] args) {}

  class Node {
    int v, d;

    Node(int v, int d) {
      this.d = d;
      this.v = v;
    }
  }

  private Set<Integer> done;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    done = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    findAndProcess(root, result, K, target);
    return result;
  }

  private int findAndProcess(TreeNode node, List<Integer> result, int K, TreeNode target) {
    if (node != null) {
      if (target == node) {
        fillResult(node, result, 0, K);
        return 1;
      } else {
        int status = findAndProcess(node.left, result, K, target);
        if (status > 0) {
          if (K - status >= 0) {
            fillResult(node, result, 0, K - status);
          }
          return status + 1;
        } else {
          status = findAndProcess(node.right, result, K, target);
          if (status > 0) {
            if (K - status >= 0) {
              fillResult(node, result, 0, K - status);
            }
            return status + 1;
          }
        }
        return -1;
      }
    } else return -1;
  }

  private void fillResult(TreeNode node, List<Integer> result, int d, int K) {
    done.add(node.val);
    if (d == K) {
      result.add(node.val);
      return;
    }
    if (node.left != null && !done.contains(node.left.val)) {
      fillResult(node.left, result, d + 1, K);
    }
    if (node.right != null && !done.contains(node.right.val)) {
      fillResult(node.right, result, d + 1, K);
    }
  }
}
