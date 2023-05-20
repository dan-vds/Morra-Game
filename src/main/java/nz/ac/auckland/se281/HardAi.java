package nz.ac.auckland.se281;

import java.util.List;

public class HardAi implements Ai {
  private Strategy strategy;
  private List<Integer> previousFingers;
  private int roundNum = 1;

  public HardAi(List<Integer> previousFingers) {
    // get previous rounds fingers
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    // Check round number and return a hand using strategy based on the round number
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      roundNum++;
      // return a random hand
      return strategy.playHand();
    } else {
      strategy = new TopStrategy(previousFingers);
      roundNum++;
      // return a hand using the top strategy
      return strategy.playHand();
    }
  }
}
