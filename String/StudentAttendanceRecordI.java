package String;

public class StudentAttendanceRecordI {
  public static void main(String[] args) {}

  public boolean checkRecord(String s) {
    int count = 0;
    for (int c : s.toCharArray()) {
      if (c == 'A') {
        count++;
      }
      if (count > 1) return false;
    }
    if (s.contains("LLL")) return false;
    return true;
  }
}
