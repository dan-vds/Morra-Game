package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty, List<Integer> previousFingers, int roundnum) {
    if (difficulty == Difficulty.EASY) {
      return new EasyAi();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new MediumAi(previousFingers, roundnum);
    } else if (difficulty == Difficulty.HARD) {
      return new HardAi(previousFingers, roundnum);
    } else if (difficulty == Difficulty.MASTER) {
      return new MasterAi(previousFingers, roundnum);
    } else {
      return null;
    }
  }
}
