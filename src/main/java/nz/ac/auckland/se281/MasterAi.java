package nz.ac.auckland.se281;

import java.util.List;

public class MasterAi implements Ai {

  private Strategy strategy;
  private List<Integer> previousFingers;
  private int roundNum = 1;

  public MasterAi(List<Integer> previousFingers) {
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      roundNum++;
      return strategy.playHand();
    } else if (roundNum % 2 == 0) {
      strategy = new AverageStrategy(previousFingers);
      roundNum++;
      return strategy.playHand();
    } else if (roundNum % 2 != 0) {
      strategy = new TopStrategy(previousFingers);
      roundNum++;
      return strategy.playHand();
    }
    return null;
  }
}
