package nz.ac.auckland.se281;

import java.util.List;

public class MediumAi implements Ai {

  private Strategy strategy;
  private int roundNum;
  private List<Integer> previousFingers;

  public MediumAi(List<Integer> previousFingers, int roundNum) {
    this.roundNum = roundNum;
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      return strategy.playHand();
    } else {
      strategy = new AverageStrategy(previousFingers);
      return strategy.playHand();
    }
  }
}
