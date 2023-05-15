package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundnum = 1;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnum));
    roundnum++;
    Boolean right = false;
    while (!right) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      String[] inputArray = input.split(" ");
      if (inputArray.length != 2) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      if (Integer.parseInt(inputArray[0]) < 1 || Integer.parseInt(inputArray[0]) > 5) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      try {
        Integer.parseInt(inputArray[0]);
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      try {
        Integer.parseInt(inputArray[1]);
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      right = true;
    }
  }

  public void playCheck() {}

  public void showStats() {}
}
