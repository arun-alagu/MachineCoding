package strategies.winning;

import models.Board;
import models.Cell;

public interface WinningStrategy {

    public boolean checkWin(Cell cell, Board board);
}
