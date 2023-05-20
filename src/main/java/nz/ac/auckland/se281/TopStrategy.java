package nz.ac.auckland.se281;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopStrategy implements Strategy {
  // Get the previous fingers of the AI
  private List<Integer> previousFingers;

  public TopStrategy(List<Integer> previousFingers) {
    this.previousFingers = previousFingers;
  }

  @Override
  public int[] playHand() {
    // Get the most common fingers of the player
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
    // Generate random number between 1 and 5
    int fingers = Utils.getRandomNumber(1, 5);
    // Return array of fingers and sum
    int[] cPUHand = {fingers, fingers + index};
    return cPUHand;
  }
}
