package Greedy;

import java.util.*;

public class BrokenCalculator {
  public static void main(String[] args) {
    //
  }

  public int brokenCalc(int X, int Y) {
    if (X == Y) return 0;
    else if (Y < X) return X - Y;
    else {
      int count = 0;
      while (Y > X) {
        if (Y % 2 == 0) {
          Y /= 2;
          count++;
        } else {
          Y += 1;
          Y /= 2;
          count += 2;
        }
      }
      if (X == Y) return count;
      else return count + (X - Y);
    }
  }
}
