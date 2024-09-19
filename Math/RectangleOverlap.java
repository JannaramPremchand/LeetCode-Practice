package Math;

public class RectangleOverlap {
  public static void main(String[] args) {
    int[] A = {0, 0, 2, 2};
    int[] B = {1, 1, 3, 3};
    System.out.println(new RectangleOverlap().isRectangleOverlap(A, B));
  }

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    boolean x =
        ((rec1[0] >= rec2[0] && rec1[0] < rec2[2]) || (rec2[0] >= rec1[0] && rec2[0] < rec1[2]));
    boolean y =
        ((rec1[1] >= rec2[1] && rec1[1] < rec2[3]) || (rec2[1] >= rec1[1] && rec2[1] < rec1[3]));
    return x && y;
  }
}
