package models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import strategies.botPlaying.BotPlayingStrategy;
import strategies.botPlaying.EasyBotPlayingStrategy;
@Getter
@Setter
@SuperBuilder
public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private static EasyBotPlayingStrategy botPlayingStrategy = new EasyBotPlayingStrategy();

    @Override
    public Cell nextMove(Board board) throws InterruptedException {
        System.out.println();cd
        Thread.sleep(2000);
        Cell cell = botPlayingStrategy.suggestMove(board);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
        return cell;
    }
}
