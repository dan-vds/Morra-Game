package nz.ac.auckland.se281;

public class HardAi implements Ai {
  private Strategy strategy;
  private int round;

  @Override
  public int[] getHand(Morra morra) {
    round = morra.getRoundnum();
    if (round <= 3) {
      strategy = new RandomStrategy();
      return strategy.playHand(morra);
    } else {
      strategy = new TopStrategy();
      return strategy.playHand(morra);
    }
  }
}
