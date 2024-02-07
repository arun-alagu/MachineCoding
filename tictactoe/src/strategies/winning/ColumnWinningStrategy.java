package strategies.winning;

import models.Board;
import models.Cell;
import models.Player;

import java.util.HashMap;

public class ColumnWinningStrategy extends WinningStrategy{
    HashMap<Player, HashMap<Integer, Integer>> count  = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Board board) {
        int col = cell.getCol();
        currentPlayer = cell.getPlayer();

//        for (int i = 0; i < board.getSize(); i++) {
//            Cell currentCell = board.getBoard().get(i).get(col);
//            if (currentCell.getCellState().equals(CellState.EMPTY) ||
//                    !currentCell.getPlayer().equals(currentPlayer)) {
//                return false;
//            }
//        }
        count.put(currentPlayer, count.getOrDefault(currentPlayer, new HashMap<>()));

        count.get(currentPlayer).put(col,
                count.get(currentPlayer).getOrDefault(col, 0)+1);

        int cnt = count.get(currentPlayer).get(col);

        return cnt == board.getSize();
    }
}
