package String;


public class SplitConcatenatedStrings {
  public static void main(String[] args) {
    String[] A = {"abc"};
    System.out.println(new SplitConcatenatedStrings().splitLoopedString(A));
  }

  public String splitLoopedString(String[] strs) {
    String max = "";
    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      String result = findMax(strs, (i + 1) % strs.length);

      String ans;
      for (int k = 0, l = s.length(); k < l; k++) {
        StringBuilder sb = new StringBuilder();
        String start = s.substring(k);
        String end = s.substring(0, k);
        ans = sb.append(start).append(result).append(end).toString();
        max = max.compareTo(ans) > 0 ? max : ans;
      }

      s = new StringBuilder(s).reverse().toString();
      for (int k = 0, l = s.length(); k < l; k++) {
        StringBuilder sb = new StringBuilder();
        String start = s.substring(k);
        String end = s.substring(0, k);
        ans = sb.append(start).append(result).append(end).toString();
        max = max.compareTo(ans) > 0 ? max : ans;
      }
    }
    return max;
  }

  private String findMax(String[] strs, int i) {
    int c = 1;
    StringBuilder sb = new StringBuilder();
    for (int j = i, l = strs.length; c < l; j = (j + 1) % l, c++) {
      String nextStr = strs[j];
      String reverse = new StringBuilder(nextStr).reverse().toString();
      String result = nextStr.compareTo(reverse) > 0 ? nextStr : reverse;
      sb.append(result);
    }
    return sb.toString();
  }
}
