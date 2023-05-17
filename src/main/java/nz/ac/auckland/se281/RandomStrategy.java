package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public void play() {
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'play'");
  }
}
