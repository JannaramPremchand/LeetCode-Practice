package Array;


public class HIndex {

  public static void main(String[] args) throws Exception {
    int[] A = {3, 0, 6, 1, 5};
    System.out.println(new HIndex().hIndex(A));
  }

  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];
    int[] S = new int[n + 1];
    for (int i = 0; i < citations.length; i++) {
      if (citations[i] > n) {
        citations[i] = n;
      }
    }
    for (int citation : citations) {
      count[citation]++;
    }
    S[n] = count[n];
    for (int i = n - 1; i >= 0; i--) {
      S[i] = count[i] + S[i + 1];
    }
    for (int i = n; i >= 0; i--) {
      if (i <= S[i]) {
        return i;
      }
    }
    return 0;
  }
}
