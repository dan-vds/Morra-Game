package nz.ac.auckland.se281;

public class AiFactory {
  public static Ai createAi(String type) {
    if (type.equals("Easy")) {
      return new EasyAi();
    } else {
      return null;
    }
  }
}
