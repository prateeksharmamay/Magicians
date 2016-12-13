package server;

public interface IGameState {
  public void addPlayerOne(String playerName);

  public void addPlayerTwo(String playerName);

  public void submitPlayerOneScore(String playerName, int score);

  public void submitPlayerTwoScore(String playerName, int score);

  public void startGame();
}
