package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {
  // Defining list of previous fingers to be used in constructor
  private List<Integer> previousFingers;

  public AverageStrategy(List<Integer> previousFingers) {
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] playHand() {
    // Calculating average fingers from previous rounds
    int totalFingers = 0;
    for (int finger : previousFingers) {
      totalFingers += finger;
    }
    // Casting to double to get decimal value
    double averageFingers = (double) totalFingers / (double) previousFingers.size();
    averageFingers = Math.round(averageFingers);
    // Generating random number between 1 and 5
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = fingers + (int) averageFingers;
    // Returning array of fingers and sum
    int[] cpuHand = {fingers, sum};
    return cpuHand;
  }
}
