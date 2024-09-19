package Math;

import java.util.Arrays;

public class SuperWashingMachines {
  public static void main(String[] args) {
    //
  }

  public int findMinMoves(int[] machines) {
    long sum = Arrays.stream(machines).asLongStream().sum();
    if (((sum / machines.length) < 0) || ((sum % machines.length) != 0)) return -1;
    int n = (int) (sum / machines.length);
    int count = 0, moves = Integer.MIN_VALUE;
    for (int i = 0; i < machines.length; i++) {
      count += (machines[i] - n);
      moves = Math.max(moves, Math.max(Math.abs(count), (machines[i] - n)));
    }
    return moves;
  }
}
