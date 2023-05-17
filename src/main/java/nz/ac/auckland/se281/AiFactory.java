package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty) {
    if (difficulty == Difficulty.EASY) {
      return new EasyAi();
    } else {
      return null;
    }
  }
}
