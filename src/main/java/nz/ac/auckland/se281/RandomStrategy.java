package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int[] playHand() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    int[] cPUHand = {fingers, sum};
    // TODO Auto-generated method stub
    return cPUHand;
  }
}
