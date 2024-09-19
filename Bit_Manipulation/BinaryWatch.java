package Bit_Manipulation;

import java.util.*;

public class BinaryWatch {
  public static void main(String[] args) {
    System.out.println(new BinaryWatch().readBinaryWatch(1));
  }

  public List<String> readBinaryWatch(int num) {
    int H = 11, M = 59;
    List<String> result = new ArrayList<>();
    if (num == 0) {
      result.add("0:00");
      return result;
    }
    for (int i = 0; i <= H; i++) {
      for (int j = 0; j <= M; j++) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
          if (((1 << k) & i) > 0) {
            count++;
          }
        }
        for (int k = 0; k < 6; k++) {
          if (((1 << k) & j) > 0) {
            count++;
          }
        }
        if (count == num) {
          result.add(i + ":" + ((String.valueOf(j).length() == 1) ? ("0" + j) : j));
        }
      }
    }
    return result;
  }
}
