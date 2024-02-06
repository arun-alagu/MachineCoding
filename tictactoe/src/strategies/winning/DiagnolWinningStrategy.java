package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

import java.util.HashMap;

public class DiagnolWinningStrategy extends WinningStrategy{

    HashMap<Player, Integer> count = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Board board) {
        currentPlayer = cell.getPlayer();
//        for(int i = 0; i < board.getSize(); i++){
//            Cell currentCell = board.getBoard().get(i).get(i);
//            if(currentCell.getCellState() != CellState.OCCUPIED ||
//            currentCell.getPlayer() != currentPlayer)
//                return false;
//        }
        if(cell.getRow() == cell.getCol())
            count.put(currentPlayer,
                    count.getOrDefault(currentPlayer,0)+1);
        else
            count.put(currentPlayer, 0);

        int cnt = count.get(currentPlayer);

        return cnt == board.getSize();
    }
}
