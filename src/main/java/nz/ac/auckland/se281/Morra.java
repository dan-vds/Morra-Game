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
      right = true;
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      inputArray = input.split(" ");
      String fingers = inputArray[0];
      String sum = inputArray[1];
      if (Integer.parseInt(fingers) < 1
          || Integer.parseInt(fingers) > 5
          || inputArray.length != 2
          || Integer.parseInt(sum) < 1
          || Integer.parseInt(sum) > 10
          || !(Utils.isInteger(sum))
          || !(Utils.isInteger(fingers))) {
        MessageCli.INVALID_INPUT.printMessage();
        right = false;
      }
    }
    MessageCli.PRINT_INFO_HAND.printMessage(name, inputArray[0], inputArray[1]);
  }

  public void playCheck() {}

  public void showStats() {}
}
