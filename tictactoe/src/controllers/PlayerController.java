package controllers;

import models.BotDifficultyLevel;
import models.BotPlayer;
import models.HumanPlayer;
import models.PlayerType;

public class PlayerController {

    public static HumanPlayer createHumanPlayer(String name, char symbol){
        return HumanPlayer.builder()
                .age(10)
                .name(name)
                .symbol(symbol)
                .playerType(PlayerType.HUMAN)
                .build();
    }

    public static BotPlayer createBotPlayer(String name, char symbol, BotDifficultyLevel botDifficultyLevel){
        return BotPlayer.builder()
                .playerType(PlayerType.BOT)
                .name(name)
                .symbol(symbol)
                .botDifficultyLevel(botDifficultyLevel)
                .build();
    }
}
