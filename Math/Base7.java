package Math;

import java.util.*;


public class Base7 {
  public static void main(String[] args) {
    //
  }

  public String convertToBase7(int num) {
    Integer.toString(7, 7);
    if (num == 0) return "0";
    int q = Math.abs(num), r;
    StringBuilder sb = new StringBuilder();
    while (q != 0) {
      r = q % 7;
      sb.append(r);
      q /= 7;
    }
    if (num < 0) {
      return "-" + sb.reverse().toString();
    } else return sb.reverse().toString();
  }
}
