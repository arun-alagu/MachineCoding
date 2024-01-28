package strategies.botPlaying;

import models.Board;
import models.Cell;
import models.CellState;
import models.GameState;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell suggestMove(Board board) {
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                Cell cell = board.getBoard().get(i).get(j);
                if(cell.getCellState() == CellState.EMPTY)
                    return cell;
            }
        }

        return null;
    }
}
