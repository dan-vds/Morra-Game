package nz.ac.auckland.se281;

public class EasyAi extends Morra implements Ai {

  private Strategy strategy = new RandomStrategy();

  @Override
  public int[] getHand(Morra morra) {
    return strategy.playHand(morra);
  }
}
