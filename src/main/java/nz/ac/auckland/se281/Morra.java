package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundnum = 1;
  private String name;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name = options[0];
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnum));
    roundnum++;
    Boolean right = false;
    String[] inputArray = new String[2];
    while (!right) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      inputArray = input.split(" ");
      if (inputArray.length != 2) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      if (Integer.parseInt(inputArray[0]) < 1 || Integer.parseInt(inputArray[0]) > 5) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      if (Integer.parseInt(inputArray[1]) < 1 || Integer.parseInt(inputArray[1]) > 10) {
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
    MessageCli.PRINT_INFO_HAND.printMessage(name, inputArray[0], inputArray[1]);
  }

  public void playCheck() {}

  public void showStats() {}
}
