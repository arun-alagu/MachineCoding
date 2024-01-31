package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

public class DiagnolWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Cell cell, Board board) {
        Player currentPlayer = cell.getPlayer();
        for(int i = 0; i < board.getSize(); i++){
            Cell currentCell = board.getBoard().get(i).get(i);
            if(currentCell.getCellState() != CellState.OCCUPIED ||
            currentCell.getPlayer() != currentPlayer)
                return false;
        }
        return true;
    }
}
