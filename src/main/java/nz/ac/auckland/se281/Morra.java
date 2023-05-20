package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Declaring instance variables
  private String name;
  private Ai ai;
  private List<Integer> previousFingers = new ArrayList<>();
  private int roundnum = 1;
  private int pointsToWin;
  private int aiPoints = 0;
  private int playerPoints = 0;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // Print welcome messge and set name
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name = options[0];
    // Create new AI and set roundnum to 1, read pointsToWin
    ai = AiFactory.createAi(difficulty, previousFingers);
    roundnum = 1;
    this.pointsToWin = pointsToWin;
  }

  public void play() {
    if (this.ai == null) {
      // If ai is null, game has not been started
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnum));
    // Get ai hand and split into fingers and sum
    int[] aiHand = ai.getHand();
    int aiFingers = aiHand[0];
    int aiSum = aiHand[1];
    Boolean inputValid = false;

    while (!inputValid) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      inputValid = playCheck(input);
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

  public Boolean playCheck(String input) {
    String[] inputArray = new String[2];
    String fingers = "0";
    String sum = "0";
    try {
      inputArray = input.split(" ");
      fingers = inputArray[0];
      sum = inputArray[1];
    } catch (Exception e) {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }

    if (!(Utils.isInteger(sum))
        || !(Utils.isInteger(fingers))
        || Integer.parseInt(fingers) < 1
        || Integer.parseInt(fingers) > 5
        || inputArray.length != 2
        || Integer.parseInt(sum) < 1
        || Integer.parseInt(sum) > 10) {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }
    return true;
  }

  public void showStats() {
    if (ai != null) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          name, Integer.toString(playerPoints), Integer.toString(pointsToWin - playerPoints));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(aiPoints), Integer.toString(pointsToWin - aiPoints));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}
