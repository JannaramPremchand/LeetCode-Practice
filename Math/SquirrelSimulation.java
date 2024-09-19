package Math;

public class SquirrelSimulation {
  public static void main(String[] args) {
    int height = 5;
    int width = 7;
    int[] tree = {2, 2};
    int[] squirrel = {4, 4};
    int[][] nuts = {{3, 0}, {2, 5}};
    System.out.println(new SquirrelSimulation().minDistance(height, width, tree, squirrel, nuts));
  }

  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int dist = 0;
    for (int[] n : nuts) {
      dist += Math.abs(n[0] - tree[0]) + Math.abs(n[1] - tree[1]);
    }
    dist *= 2;
    int ans = Integer.MAX_VALUE;
    for (int[] n : nuts) {
      int nutDist = Math.abs(n[0] - squirrel[0]) + Math.abs(n[1] - squirrel[1]);
      ans = Math.min(ans, dist - (Math.abs(n[0] - tree[0]) + Math.abs(n[1] - tree[1])) + nutDist);
    }
    return ans;
  }
}
