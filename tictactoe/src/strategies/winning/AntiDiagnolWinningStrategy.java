package strategies.winning;

import models.Board;
import models.Cell;
import models.Player;

import java.util.HashMap;

public class AntiDiagnolWinningStrategy extends WinningStrategy{

    HashMap<Player, Integer> count  = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Board board) {
        currentPlayer = cell.getPlayer();
//        int n = board.getSize();
//        for(int i = 0, j = n-1; i < n;){
//            Cell currentCell = board.getBoard().get(i++).get(j--);
//            if(currentCell.getCellState() != CellState.OCCUPIED ||
//                    currentCell.getPlayer() != currentPlayer)
//                return false;
//        }
        if(cell.getRow()+cell.getCol() == board.getSize()-1)
            count.put(currentPlayer, count.getOrDefault(currentPlayer,0)+1);
        else
            count.put(currentPlayer, 0);

        int cnt = count.get(currentPlayer);

        return cnt == board.getSize();
    }
}
