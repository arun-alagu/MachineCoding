package strategies.botPlaying;

import lombok.Singular;
import models.Board;
import models.Cell;
import models.CellState;
import models.GameState;

public enum EasyBotPlayingStrategy implements BotPlayingStrategy{
    INSTANCE;
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
