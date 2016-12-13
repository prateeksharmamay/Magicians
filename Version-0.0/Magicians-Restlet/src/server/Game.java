package server;


public class Game implements IGame {
  IGameState noPlayerState;
  IGameState onePlayerState;
  IGameState twoPlayerState;
  IGameState gameStartedState;
  IGameState playerOneSubmittedScoreState;
  IGameState playerTwoSubmittedScoreState;
  IGameState gameFinishedState;
  IGameState state;
  String playerOne;
  String playerTwo;

  int playerOneScore;
  int playerTwoScore;

  
  public Game() {
    noPlayerState = new NoPlayerState(this);
    onePlayerState = new OnePlayerState(this);
    twoPlayerState = new TwoPlayerState(this);
    gameStartedState = new GameStartedState(this);
    playerOneSubmittedScoreState = new PlayerOneSubmittedScoreState(this);
    gameFinishedState = new GameFinishedState(this);
    state = noPlayerState;
    
  }

  void setState(IGameState state) {
    this.state = state;
  }

  public void addPlayerOne(String playerName) {
    state.addPlayerOne(playerName);
  }

  public void updatePlayerOne(String playerName) {
    playerOne = playerName;
  }

  public void addPlayerTwo(String playerName) {
    playerTwo = playerName;
    state.addPlayerTwo(playerName);
  }

  public void updatePlayerTwo(String playerName) {
    playerTwo = playerName;
  }

  public IGameState getOnePlayerState() {
    return onePlayerState;
  }

  public IGameState getTwoPlayerState() {
    return twoPlayerState;
  }

  public IGameState getGameStartedState() {
    return gameStartedState;
  }

  public IGameState getPlayerOneSubmittedScoreState() {
    return playerOneSubmittedScoreState;
  }

  public IGameState getPlayerTwoSubmittedScoreState() {
    return playerTwoSubmittedScoreState;
  }

  public void submitPlayerOneScore(String playerName, int score) {
    state.submitPlayerOneScore(playerName, score);
  }

  public void updatePlayerOneScore(String playerName, int score) {
    playerOne = playerName;
    playerOneScore = score;
  }

  @Override
  public void submitPlayerTwoScore(String playerName, int score) {
    state.submitPlayerTwoScore(playerName, score);
  }

  public void updatePlayerTwoScore(String playerName, int score) {
    playerTwo = playerName;
    playerTwoScore = score;
  }

  public IGameState getCurrentGameState() {
    return state;
  }

  public void startGame() {
    state.startGame();
    //System.out.println("Game Started");
  }

  public void startingGame(){

  }

  @Override
  public String getGameScroreBoard() {

    String scoreBoard = playerOne + " - " + playerOneScore;
    scoreBoard += "  |  " + playerTwo + " - " + playerTwoScore;
    return scoreBoard;
  }

  public IGameState getGameFinishedState() {
    return gameFinishedState;
  }
}