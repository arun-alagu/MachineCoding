package strategies.winning;

import models.Board;
import models.Cell;
import models.Player;

public abstract class WinningStrategy {
    Player currentPlayer;

    public boolean checkWin(Cell cell, Board board) {
        return false;
    }
}
