package models;

import lombok.Getter;
import lombok.Setter;
import strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    public Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategiesList;
    private GameState gameState;

    public Game(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategiesList) {
        this.playerList = playerList;
        this.winningStrategiesList = winningStrategiesList;
        this.board = new Board(dimension);
        this.moveList = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameState = GameState.INITIAL;
    }

}
