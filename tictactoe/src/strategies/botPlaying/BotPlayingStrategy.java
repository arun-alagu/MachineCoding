package strategies.botPlaying;

import models.Board;
import models.Cell;

public interface BotPlayingStrategy {
    Cell suggestMove(Board board);
}
