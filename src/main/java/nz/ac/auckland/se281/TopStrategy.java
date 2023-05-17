package nz.ac.auckland.se281;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopStrategy implements Strategy {

  private List<Integer> previousFingers;

  @Override
  public int[] playHand(Morra morra) {
    previousFingers = morra.getPreviousFingers();
    int oneFinger = Collections.frequency(previousFingers, 1);
    int twoFinger = Collections.frequency(previousFingers, 1);
    int threeFinger = Collections.frequency(previousFingers, 1);
    int fourFinger = Collections.frequency(previousFingers, 1);
    int fiveFinger = Collections.frequency(previousFingers, 1);

    List<Integer> fingersArray =
        Arrays.asList(oneFinger, twoFinger, threeFinger, fourFinger, fiveFinger);
    int maxFingers = Collections.max(fingersArray);
    System.out.println(maxFingers);
    // int[] cPUHand = {fingers, sum};
    return null;
  }
}
