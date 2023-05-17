package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategy {
  private List<Integer> previousFingers;

  @Override
  public int[] playHand(Morra morra) {
    previousFingers = morra.getPreviousFingers();
    int totalFingers = 0;
    for (int finger : previousFingers) {
      totalFingers += finger;
    }
    int averageFingers = totalFingers / previousFingers.size();
    int fingers = Utils.getRandomNumber(1, 5);
    int sum = fingers + averageFingers;
    int[] cPUHand = {fingers, sum};
    return cPUHand;
  }
}
