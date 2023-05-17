package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {
  private List<Integer> previousFingers;

  public AverageStrategy(List<Integer> previousFingers) {
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] playHand() {
    int totalFingers = 0;
    for (int finger : previousFingers) {
      totalFingers += finger;
    }
    double averageFingers = (double) totalFingers / (double) previousFingers.size();
    averageFingers = Math.round(averageFingers);
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = fingers + (int) averageFingers;
    int[] cPUHand = {fingers, sum};
    return cPUHand;
  }
}
