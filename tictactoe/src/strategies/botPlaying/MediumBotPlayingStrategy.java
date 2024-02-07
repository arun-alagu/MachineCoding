package strategies.botPlaying;

import models.Board;
import models.Cell;
import models.CellState;

import java.util.Random;
import java.util.random.RandomGenerator;

public enum MediumBotPlayingStrategy implements BotPlayingStrategy{
    INSTANCE;
    @Override
    public Cell suggestMove(Board board) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            Cell cell = board.getBoard().get(row).get(col);

            while(cell.getCellState() != CellState.EMPTY) {
                row = random.nextInt(board.getSize());
                col = random.nextInt(board.getSize());
                cell = board.getBoard().get(row).get(col);
            }

            return cell;
    }
}
