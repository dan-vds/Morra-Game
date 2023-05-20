package nz.ac.auckland.se281;

import java.util.List;

public class MediumAi implements Ai {

  private Strategy strategy;
  private List<Integer> previousFingers;
  private int roundNum = 1;

  public MediumAi(List<Integer> previousFingers) {
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    // Check round number and return a hand using strategy based on the round number
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      roundNum++;
      return strategy.playHand();
    } else {
      strategy = new AverageStrategy(previousFingers);
      roundNum++;
      return strategy.playHand();
    }
  }
}
