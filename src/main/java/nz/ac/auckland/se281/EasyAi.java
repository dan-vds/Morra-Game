package nz.ac.auckland.se281;

public class EasyAi implements Ai {

  private Strategy strategy = new RandomStrategy();

  @Override
  public int[] getHand(Morra morra) {
    return strategy.playHand();
  }
}
