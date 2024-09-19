package Array;

import java.util.ArrayDeque;
import java.util.Arrays;


public class RevealCardsInIncreasingOrder {
  public static void main(String[] args) {
    int[] A = {17, 13, 11, 2, 3, 5, 7};
    int[] R = new RevealCardsInIncreasingOrder().deckRevealedIncreasing(A);
  }

  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = deck.length - 1; i >= 0; i--) {
      queue.offer(deck[i]);
      if (i == 0) break;
      int temp = queue.pollFirst();
      queue.offer(temp);
    }
    int[] answer = new int[deck.length];
    int i = 0;
    while (!queue.isEmpty()) {
      answer[i++] = queue.pollLast();
    }
    return answer;
  }
}
