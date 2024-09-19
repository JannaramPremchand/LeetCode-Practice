package String;


public class ReverseStringII {
  public static void main(String[] args) {
    System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
  }

  public String reverseStr(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0, l = s.length(); i < l; i++) {
      if (i % (2 * k) == 0) {
        int count = 0;
        StringBuilder temp = new StringBuilder();
        while (count < k && i < l) {
          temp.append(s.charAt(i));
          count++;
          i++;
        }
        sb.append(temp.reverse());
      }
      if (i < l) {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
