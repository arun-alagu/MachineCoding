package models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import strategies.botPlaying.BotPlayingStrategy;
import strategies.botPlaying.EasyBotPlayingStrategy;
import strategies.botPlaying.HardBotPlayingStrategy;
import strategies.botPlaying.MediumBotPlayingStrategy;

@SuperBuilder
public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    @Override
    public Cell nextMove(Board board) throws InterruptedException {
        System.out.println();
        Thread.sleep(2000);
        botDifficultyLevel = this.getBotDifficultyLevel();
        switch (botDifficultyLevel){
            case MEDIUM -> botPlayingStrategy = MediumBotPlayingStrategy.INSTANCE;
            case HARD -> botPlayingStrategy = HardBotPlayingStrategy.INSTANCE;
            default -> botPlayingStrategy = EasyBotPlayingStrategy.INSTANCE;
        }
        Cell cell = botPlayingStrategy.suggestMove(board);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
        return cell;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
