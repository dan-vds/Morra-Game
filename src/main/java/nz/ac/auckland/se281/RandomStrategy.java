package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int[] playHand() {
    // Pick random number of fingers and sum
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    int[] cpuHand = {fingers, sum};
    return cpuHand;
  }
}
