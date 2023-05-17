package nz.ac.auckland.se281;

import java.util.List;

public class HardAi implements Ai {
  private Strategy strategy;
  private int roundNum;
  private List<Integer> previousFingers;

  public HardAi(List<Integer> previousFingers, int roundNum) {
    this.roundNum = roundNum;
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      return strategy.playHand();
    } else {
      strategy = new TopStrategy(previousFingers);
      return strategy.playHand();
    }
  }
}
