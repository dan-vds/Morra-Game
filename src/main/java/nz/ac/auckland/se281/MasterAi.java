package nz.ac.auckland.se281;

import java.util.List;

public class MasterAi implements Ai {

  private Strategy strategy;
  private int roundNum;
  private List<Integer> previousFingers;

  public MasterAi(List<Integer> previousFingers, int roundnum) {
    this.roundNum = roundnum;
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    if (roundNum <= 3) {
      strategy = new RandomStrategy();
      return strategy.playHand();
    } else if (roundNum % 2 == 0) {
      strategy = new AverageStrategy(previousFingers);
      return strategy.playHand();
    } else if (roundNum % 2 != 0) {
      strategy = new TopStrategy(previousFingers);
      return strategy.playHand();
    }
    return null;
  }
}
