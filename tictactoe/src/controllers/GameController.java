package controllers;

import models.Game;
import models.GameState;
import models.Player;
import services.GameService;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {
    Game game;
    GameService gameService;
    public GameController(Game game){
        this.game = game;
        this.gameService = new GameService(game);
    }
    public static Game initiateGame(int dimension,
                                    List<Player> playerList,
                                    List<WinningStrategy> winningStrategiesList){
        return new Game(dimension, playerList, winningStrategiesList);
    }

    public void startGame() throws Exception {
        game.setGameState(GameState.INPROGRESS);
        gameService.executeNextMoves();
    }
}
