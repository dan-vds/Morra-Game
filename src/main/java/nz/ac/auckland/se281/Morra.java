package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String name;
  private Ai ai;
  private List<Integer> previousFingers = new ArrayList<>();
  private int roundnum = 1;
  private int pointsToWin;
  private int aiPoints = 0;
  private int playerPoints = 0;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name = options[0];
    ai = AiFactory.createAi(difficulty, previousFingers);
    roundnum = 1;
    this.pointsToWin = pointsToWin;
  }

  public void play() {
    if (this.ai == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnum));
    int[] aiHand = ai.getHand();
    int aiFingers = aiHand[0];
    int aiSum = aiHand[1];
    Boolean right = false;
    String[] inputArray = new String[2];
    String fingers = "0";
    String sum = "0";

    while (!right) {
      right = true;
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      try {
        inputArray = input.split(" ");
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
        right = false;
        continue;
      }
      try {
        if (!inputArray[0].isEmpty() && !inputArray[1].isEmpty()) {
          fingers = inputArray[0];
          sum = inputArray[1];
        } else {
          MessageCli.INVALID_INPUT.printMessage();
          right = false;
        }
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
        right = false;
        continue;
      }
      if (!(Utils.isInteger(sum))
          || !(Utils.isInteger(fingers))
          || Integer.parseInt(fingers) < 1
          || Integer.parseInt(fingers) > 5
          || inputArray.length != 2
          || Integer.parseInt(sum) < 1
          || Integer.parseInt(sum) > 10) {
        MessageCli.INVALID_INPUT.printMessage();
        right = false;
      }
    }

    previousFingers.add(Integer.parseInt(inputArray[0]));
    MessageCli.PRINT_INFO_HAND.printMessage(name, inputArray[0], inputArray[1]);
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));
    int playerSum = Integer.parseInt(inputArray[1]);
    int playerFingers = Integer.parseInt(inputArray[0]);
    if (playerFingers + aiFingers == playerSum && playerFingers + aiFingers != aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerPoints++;
    } else if (playerFingers + aiFingers != playerSum && playerFingers + aiFingers == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      aiPoints++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    if (playerPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage(name, Integer.toString(roundnum));
      ai = null;
      return;
    } else if (aiPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(roundnum));
      ai = null;
      return;
    }
    roundnum++;
  }

  public void playCheck() {}

  public void showStats() {}
}
