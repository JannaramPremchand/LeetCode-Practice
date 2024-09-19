package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ZigZagTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {}

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    dfs(root, 0, result);
    return result;
  }

  @SuppressWarnings("unchecked")
  private void dfs(TreeNode root, int level, List<List<Integer>> result) {
    if (root != null) {
      LinkedList<Integer> subList;
      if (level >= result.size()) {
        subList = new LinkedList<>();
        result.add(subList);
      } else subList = (LinkedList) result.get(level);
      if (level % 2 == 0) subList.addFirst(root.val); // add to right
      else subList.add(root.val); // add to left
      dfs(root.right, level + 1, result);
      dfs(root.left, level + 1, result);
    }
  }
}
