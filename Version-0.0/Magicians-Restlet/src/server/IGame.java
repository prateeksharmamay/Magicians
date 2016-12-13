package server;

public interface IGame {
  public void addPlayerOne(String playerName);

  public void addPlayerTwo(String playerName);

  public void submitPlayerOneScore(String playerName, int score);

  public void submitPlayerTwoScore(String playerName, int score);

  public IGameState getCurrentGameState();

  public void startGame();

  public String getGameScroreBoard();
}
