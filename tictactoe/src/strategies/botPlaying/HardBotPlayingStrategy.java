package strategies.botPlaying;

import models.Board;
import models.Cell;

public enum HardBotPlayingStrategy implements BotPlayingStrategy{
    INSTANCE;
    @Override
    public Cell suggestMove(Board board) {
        return null;
    }
}
