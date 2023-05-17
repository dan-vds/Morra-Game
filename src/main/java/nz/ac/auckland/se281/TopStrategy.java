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
    int twoFinger = Collections.frequency(previousFingers, 2);
    int threeFinger = Collections.frequency(previousFingers, 3);
    int fourFinger = Collections.frequency(previousFingers, 4);
    int fiveFinger = Collections.frequency(previousFingers, 5);
    List<Integer> fingersArray =
        Arrays.asList(oneFinger, twoFinger, threeFinger, fourFinger, fiveFinger);
    int commonFingers = Collections.max(fingersArray);
    int index = fingersArray.indexOf(commonFingers);
    index += 1;
    int fingers = Utils.getRandomNumber(1, 5);
    int[] cPUHand = {fingers, fingers + index};
    return cPUHand;
  }
}
