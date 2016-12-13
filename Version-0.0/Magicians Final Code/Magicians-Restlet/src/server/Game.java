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
  
  String playerOneResult;
  String playerTwoResult;

  
  public Game() {
    noPlayerState = new NoPlayerState(this);
    onePlayerState = new OnePlayerState(this);
    twoPlayerState = new TwoPlayerState(this);
    gameStartedState = new GameStartedState(this);
    playerOneSubmittedScoreState = new PlayerOneSubmittedScoreState(this);
    gameFinishedState = new GameFinishedState(this);
    state = noPlayerState;
    
  }
  
  void restart(){
	  this.state = noPlayerState;
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

  public void submitPlayerOneScore(String playerName, int score, String result) {
    state.submitPlayerOneScore(playerName, score, result);
  }

  public void updatePlayerOneScore(String playerName, int score,String result) {
    playerOne = playerName;
    playerOneScore = score;
    playerOneResult = result;
  }

  @Override
  public void submitPlayerTwoScore(String playerName, int score , String result) {
    state.submitPlayerTwoScore(playerName, score, result);
  }

  public void updatePlayerTwoScore(String playerName, int score, String result) {
    playerTwo = playerName;
    playerTwoScore = score;
    playerTwoResult = result;
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
	if(playerOneResult.equals("correct") && playerTwoResult.equals("correct") ){
		if(playerOneScore > playerTwoScore){
			playerTwoResult = "Winner!!";
			playerOneResult = "You Lost...";
		}
		else{
			playerTwoResult = "You Lost...";
			playerOneResult = "Winner!!";
		}
	}
	else {
		if(playerOneResult.equals("correct")){
			playerTwoResult = "You Lost...";
			playerOneResult = "Winner!!";
		}
		else{
			playerTwoResult = "Winner!!";
			playerOneResult = "You Lost...";
		}
	}
		
    String scoreBoard = playerOne + " - " + playerOneScore + " - "+ playerOneResult;
    scoreBoard += "  |  " + playerTwo + " - " + playerTwoScore + " - "+ playerTwoResult;
    return scoreBoard;
  }

  public IGameState getGameFinishedState() {
    return gameFinishedState;
  }
}