package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int roundnum = 1;
  private String name;
  private Ai ai;
  private List<Integer> previousFingers = new ArrayList<>();

  public Morra() {}

  public int getRoundnum() {
    return roundnum;
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name = options[0];
    ai = AiFactory.createAi(difficulty);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnum));

    int[] aiHand = ai.getHand(this);
    int aiFingers = aiHand[0];
    int aiSum = aiHand[1];
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

    previousFingers.add(Integer.parseInt(inputArray[0]));
    MessageCli.PRINT_INFO_HAND.printMessage(name, inputArray[0], inputArray[1]);
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));
    int playerSum = Integer.parseInt(inputArray[1]);
    int playerFingers = Integer.parseInt(inputArray[0]);
    if (playerFingers + aiFingers == playerSum && playerFingers + aiFingers != aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (playerFingers + aiFingers != playerSum && playerFingers + aiFingers == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
    roundnum++;
  }

  public void playCheck() {}

  public void showStats() {}

  public List<Integer> getPreviousFingers() {
    return previousFingers;
  }
}
