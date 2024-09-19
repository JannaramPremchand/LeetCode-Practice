package Tree;

import java.util.*;

public class AllPossibleFullBinaryTrees {

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
  public static void main(String[] args) {
    List<TreeNode> result = new AllPossibleFullBinaryTrees().allPossibleFBT(7);
    System.out.println(result.size());
  }

  public List<TreeNode> allPossibleFBT(int N) {
    if (N % 2 == 0) return new ArrayList<>();
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    map.put(1, Arrays.asList(new TreeNode(0)));
    for (int i = 3; i <= N; i += 2) {
      List<TreeNode> list = new ArrayList<>();
      for (int j = 1; j < i - 1; j += 2) {
        int l = j, r = i - 1 - j;
        List<TreeNode> leftList = map.get(l);
        List<TreeNode> rightList = map.get(r);
        for (TreeNode leftNode : leftList) {
          for (TreeNode rightNode : rightList) {
            TreeNode root = new TreeNode(0);
            root.left = leftNode;
            root.right = rightNode;
            list.add(root);
          }
        }
      }
      map.put(i, list);
    }
    return map.get(N);
  }
}
