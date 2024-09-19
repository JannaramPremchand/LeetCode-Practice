package Stack;

public class StudentAttendanceRecordII {
  public static void main(String[] args) {
    System.out.println(new StudentAttendanceRecordII().checkRecord(5));
  }

  int mod = 1000000007;

  public int checkRecord(int n) {
    if (n == 0) return 1;
    int P = 1;
    int A = 1;
    int LA = 0, LX = 1, LLA = 0, LLX = 0;
    for (int i = n - 1; i > 0; i--) {
      int temP = (((P + LX) % mod) + LLX) % mod;
      int tempLX = P;
      int tempLA = A;
      int tempLLX = LX;
      int tempLLA = LA;
      int tempA =
          ((((((((((P + LX) % mod) + LLX) % mod) + A) % mod) + LA) % mod) + LLA)
              % mod); // A + LA + LLA
      // is because we can add P to each of these forming PA, PLA and PLLA
      P = temP;
      LX = tempLX;
      LA = tempLA;
      LLX = tempLLX;
      LLA = tempLLA;
      A = tempA;
    }
    return ((((((((((P + LX) % mod) + LA) % mod) + LLX) % mod) + LLA) % mod) + A) % mod);
  }
}
