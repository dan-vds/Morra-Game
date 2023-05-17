package nz.ac.auckland.se281;

public class MediumAi implements Ai {

  private Strategy strategy;
  Morra morra;
  private int round;

  @Override
  public int[] getHand() {
    round = morra.getRoundnum();
    if (round > 3) {
      strategy = new RandomStrategy();
      return strategy.playHand();
    } else {
      strategy = new AverageStrategy();
      return strategy.playHand();
    }
  }
}
