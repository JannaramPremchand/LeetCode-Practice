package String;


public class PushDominoes {
  public static void main(String[] args) {
    System.out.println(new PushDominoes().pushDominoes("RR.L"));
  }

  public String pushDominoes(String dominoes) {
    int R = -1, L = -1;
    char[] A = dominoes.toCharArray();
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 'L') {
        if (R > L) {
          int d = (i - R);
          int st;
          st = R + d / 2;
          if ((d % 2) == 0) {
            A[st] = '.';
          }
          for (int j = st + 1; j < i; j++) {
            A[j] = 'L';
          }
        } else {
          for (int j = (L == -1 ? 0 : L); j < i; j++) {
            A[j] = 'L';
          }
        }
        L = i;
      } else {
        if (A[i] == 'R') {
          R = i;
        } else {
          if (R > L) {
            A[i] = 'R';
          }
        }
      }
    }
    return String.valueOf(A);
  }
}
