package Math;

import java.math.BigInteger;

public class WaterAndJugProblem {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new WaterAndJugProblem().canMeasureWater(0, 0, 1));
  }

  public boolean canMeasureWater(int x, int y, int z) {
    if (x == y && y == z) return true;
    if (z > (x + y)) return false;
    BigInteger b1 = new BigInteger(String.valueOf(x));
    BigInteger b2 = new BigInteger(String.valueOf(y));
    BigInteger b3 = b1.gcd(b2);
    return b3.intValue() != 0 && (z % b3.intValue()) == 0;
  }
}
