package server;

/**
 * Created by Jayam on 11/15/2016.
 */
public class PlayerOneSubmittedScoreState implements IGameState {

  private Game game;

  public PlayerOneSubmittedScoreState(Game _game) {
    this.game = _game;
  }

  @Override
  public void addPlayerOne(String playerName) {
    System.out.println("Cannot add player one, PlayerOneSubmittedScore");
  }

  @Override
  public void addPlayerTwo(String playerName) {
    System.out.println("Cannot add player two, PlayerOneSubmittedScore");
  }

  @Override
  public void submitPlayerOneScore(String playerName, int score) {
    System.out.println("Cannot add player one, PlayerOne Submitted Score");

  }

  @Override
  public void submitPlayerTwoScore(String playerName, int score) {
    System.out.println("Submitting Player two score");
    game.updatePlayerTwoScore(playerName, score);
    game.setState(game.getGameFinishedState());
  }

  @Override
  public void startGame() {
    System.out.println("Cannot start game, PlayerOne Submitted Score");
  }

  @Override
  public String toString() {
    return "PlayerOneSubmiitedState";
  }
}