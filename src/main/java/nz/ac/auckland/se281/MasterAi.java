package nz.ac.auckland.se281;

public class MasterAi extends Morra implements Ai {

  private Strategy strategy;
  private int round;

  @Override
  public int[] getHand(Morra morra) {
    round = morra.getRoundnum();
    if (round <= 3) {
      strategy = new RandomStrategy();
      return strategy.playHand(morra);
    } else if (round % 2 == 0) {
      strategy = new AverageStrategy();
      return strategy.playHand(morra);
    } else if (round % 2 != 0) {
      strategy = new TopStrategy();
      return strategy.playHand(morra);
    }
    return null;
  }
}
