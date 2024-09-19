package Bit_Manipulation;

public class BinaryNumberWithAlternatingBits {
  public static void main(String[] args) {
    System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(18));
  }

  public boolean hasAlternatingBits(int n) {
    int curr = n & 1;
    int pos = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) > 0) {
        pos = i;
      }
    }

    for (int i = 1; i <= pos; i++) {
      int temp = (1 << i) & n;
      if ((temp > 0 && curr > 0) || (temp == 0 && curr == 0)) return false;
      curr = temp;
    }
    return true;
  }
}
