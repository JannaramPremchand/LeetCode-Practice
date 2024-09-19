package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextRightPointer {
  private class LevelNode {
    int level;
    TreeLinkNode node;

    LevelNode(TreeLinkNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public static class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {
    TreeLinkNode node = new TreeLinkNode(2);
    node.left = new TreeLinkNode(1);
    node.right = new TreeLinkNode(3);
    new NextRightPointer().connect(node);
    System.out.println(node.next);
    System.out.println(node.left.next.val);
    System.out.println(node.right.next);
  }

  public void connect(TreeLinkNode root) {
    Queue<LevelNode> queue = new ArrayDeque<>();
    LevelNode zero = new LevelNode(root, 0);
    queue.offer(zero);
    LevelNode prev = null;
    while (!queue.isEmpty()) {
      LevelNode levelNode = queue.poll();
      if (levelNode.node == null) break;
      TreeLinkNode curr = levelNode.node;
      if (prev != null) {
        if (prev.level == levelNode.level) {
          prev.node.next = levelNode.node;
        }
      }
      prev = levelNode;
      queue.offer(new LevelNode(curr.left, levelNode.level + 1));
      queue.offer(new LevelNode(curr.right, levelNode.level + 1));
    }
  }
}
