package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Cell cell, Board board) {
        int col = cell.getCol();
        Player currentPlayer = cell.getPlayer();

        for (int i = 0; i < board.getSize(); i++) {
            Cell currentCell = board.getBoard().get(i).get(col);
            if (currentCell.getCellState().equals(CellState.EMPTY) ||
                    !currentCell.getPlayer().equals(currentPlayer)) {
                return false;
            }
        }
        return true;
    }
}
