package strategies.winning;

import models.Board;
import models.Cell;
import models.Player;

import java.util.HashMap;

public class RowWinningStrategy extends WinningStrategy{

    HashMap<Player,HashMap<Integer,Integer>> count = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Board board) {
        int row = cell.getRow();
        currentPlayer = cell.getPlayer();

//        for (int i = 0; i < board.getSize(); i++) {
//            Cell currentCell = board.getBoard().get(row).get(i);
//            if (currentCell.getCellState().equals(CellState.EMPTY) ||
//                    !currentCell.getPlayer().equals(currentPlayer)) {
//                return false;
//            }
//        }
        count.put(currentPlayer, count.getOrDefault(currentPlayer, new HashMap<>()));

        count.get(currentPlayer).put(row,
                count.get(currentPlayer).getOrDefault(row, 0)+1);

        int cnt = count.get(currentPlayer).get(row);
        return cnt == board.getSize();
    }
}
