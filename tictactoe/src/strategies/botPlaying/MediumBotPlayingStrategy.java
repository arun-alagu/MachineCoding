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
        while(true) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            Cell cell = board.getBoard().get(row).get(col);
            if (cell.getCellState() == CellState.EMPTY)
                return cell;
        }
    }
}
