package Tree;

import java.util.*;

public class MaximumLevelSumofABinaryTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  Map<Integer, Integer> levelMap;

  public static void main(String[] args) {
    //
  }

  public int maxLevelSum(TreeNode root) {
    levelMap = new HashMap<>();
    inorder(root, 1);
    int max = Integer.MIN_VALUE;
    int ans = 0;
    for (int k : levelMap.keySet()) {
      if (levelMap.get(k) > max) {
        max = levelMap.get(k);
        ans = k;
      }
    }
    return ans;
  }

  private void inorder(TreeNode root, int level) {
    if (root != null) {
      levelMap.putIfAbsent(level, 0);
      levelMap.put(level, levelMap.get(level) + root.val);
      inorder(root.left, level + 1);
      inorder(root.right, level + 1);
    }
  }
}
