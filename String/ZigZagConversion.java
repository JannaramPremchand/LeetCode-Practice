package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ZigZagConversion {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 5));
  }

  /**
   * Convert and return the result
   *
   * @param s input string
   * @param numRows max rows
   * @return Result string
   */
  public String convert(String s, int numRows) {
    if (s == null || s.length() <= numRows || numRows == 1) return s;
    List<String> list = new ArrayList<>();
    char[] A = new char[numRows];
    int direction = 1; // 1 indicates forward, 0 indicates backwards
    int n = 1;
    A[0] = s.charAt(0);
    for (int j = 1; j < numRows; ) {
      if (n >= s.length()) break;
      A[j] = s.charAt(n++);
      if (j == numRows - 1) {
        list.add(String.valueOf(A));
        A = new char[numRows];
        Arrays.fill(A, ' ');
        direction = 0;
      } else if (j == 0) {
        list.add(String.valueOf(A));
        A = new char[numRows];
        Arrays.fill(A, ' ');
        direction = 1;
      }
      j = direction == 1 ? j + 1 : j - 1;
    }
    if (!String.valueOf(A).trim().isEmpty()) list.add(String.valueOf(A));
    char[] arr = new char[s.length()];
    int k = 0;
    for (int j = 0; j < numRows; j++) {
      for (String aList : list) {
        if (aList.charAt(j) != ' ') arr[k++] = aList.charAt(j);
      }
    }
    return new String(arr).trim();
  }
}
