package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty, List<Integer> previousFingers) {
    // Checking what difficulty the user has chosen and creating the correct AI
    if (difficulty == Difficulty.EASY) {
      return new EasyAi();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new MediumAi(previousFingers);
    } else if (difficulty == Difficulty.HARD) {
      return new HardAi(previousFingers);
    } else if (difficulty == Difficulty.MASTER) {
      return new MasterAi(previousFingers);
    } else {
      return null;
    }
  }
}
