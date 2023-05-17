package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty) {
    if (difficulty == Difficulty.EASY) {
      return new EasyAi();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new MediumAi();
    } else if (difficulty == Difficulty.HARD) {
      return new HardAi();
    } else if (difficulty == Difficulty.MASTER) {
      return new MasterAi();
    } else {
      return null;
    }
  }
}
