package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public String[] playHand() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    String[] cPUHand = {Integer.toString(fingers), Integer.toString(sum)};
    // TODO Auto-generated method stub
    return cPUHand;
  }
}
