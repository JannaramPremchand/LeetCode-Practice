package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

  class LevelNode {
    int level;
    TreeNode node;

    LevelNode(int level, TreeNode node) {
      this.level = level;
      this.node = node;
    }
  }

  public class TreeNode {
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
  public static void main(String[] args) throws Exception {}

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<LevelNode> queue = new ArrayDeque<>();
    LevelNode node = new LevelNode(0, root);
    queue.offer(node);
    int curLevel = 0, count = 0;
    long sum = 0L;
    List<Double> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      LevelNode first = queue.poll();
      if (first.level == curLevel) {
        sum += first.node.val;
        count++;
      } else {
        result.add((double) sum / count);
        sum = first.node.val;
        count = 1;
        curLevel++;
      }
      if (first.node.left != null) {
        queue.offer(new LevelNode(curLevel + 1, first.node.left));
      }
      if (first.node.right != null) {
        queue.offer(new LevelNode(curLevel + 1, first.node.right));
      }
    }
    result.add((double) sum / count);
    return result;
  }
}
