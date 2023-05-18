package nz.ac.auckland.se281;

import java.util.List;

public class HardAi implements Ai {
  private Strategy strategy;
  private List<Integer> previousFingers;
  private int roundNum = 1;

  public HardAi(List<Integer> previousFingers) {

    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      roundNum++;
      return strategy.playHand();
    } else {
      strategy = new TopStrategy(previousFingers);
      roundNum++;
      return strategy.playHand();
    }
  }
}
