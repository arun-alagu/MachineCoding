package strategies.botPlaying;

import models.Board;
import models.Cell;

import java.util.Random;

public interface BotPlayingStrategy {
    Random random = new Random();
    Cell suggestMove(Board board);
}
