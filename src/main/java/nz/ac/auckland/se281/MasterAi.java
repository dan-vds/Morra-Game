package nz.ac.auckland.se281;

import java.util.List;

public class MasterAi implements Ai {

  private Strategy strategy;
  private List<Integer> previousFingers;
  private int roundNum = 1;

  public MasterAi(List<Integer> previousFingers) {
    // get previous rounds fingers
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] getHand() {
    if (roundNum <= 3) {
      // return a random hand if round less than 3
      strategy = new RandomStrategy();
      roundNum++;
      return strategy.playHand();
    } else if (roundNum % 2 == 0) {
      // if even round number return average strategy
      strategy = new AverageStrategy(previousFingers);
      roundNum++;
      return strategy.playHand();
    } else if (roundNum % 2 != 0) {
      // if odd round number return top strategy
      strategy = new TopStrategy(previousFingers);
      roundNum++;
      return strategy.playHand();
    }
    return null;
  }
}
