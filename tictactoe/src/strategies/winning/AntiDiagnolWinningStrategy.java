package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

public class AntiDiagnolWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Cell cell, Board board) {
        Player currentPlayer = cell.getPlayer();
        int n = board.getSize();
        for(int i = 0, j = n-1; i < n;){
            Cell currentCell = board.getBoard().get(i++).get(j--);
            if(currentCell.getCellState() != CellState.OCCUPIED ||
                    currentCell.getPlayer() != currentPlayer)
                return false;
        }
        return true;
    }
}
