import controllers.GameController;
import controllers.PlayerController;
import exceptions.InvalidCellException;
import exceptions.InvalidSymbolException;
import models.BotDifficultyLevel;
import models.Game;
import models.Player;
import strategies.winning.AntiDiagnolWinningStrategy;
import strategies.winning.ColumnWinningStrategy;
import strategies.winning.DiagnolWinningStrategy;
import strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        Thread.sleep(1000);
        System.out.println("Welcome to tictactoe game!!");
        Thread.sleep(1000);
        System.out.println("Let's start the game...\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the dimension: ");
        int dimension = sc.nextInt();

        System.out.print("Enter the number of players: ");
        int n = sc.nextInt();

        List<Player> playerList = new ArrayList<>();

        for(int i = 0; i < n ; i++) {
            System.out.print("Enter player" +(i+1)+" name: ");
            String name = sc.next();

            char symbol = 'X';
            boolean sym = true;
            Symbol:
            while(sym) {
                try {
                    System.out.print("Symbol: ");
                    symbol = sc.next().charAt(0);
                    for (Player player : playerList) {
                        if (player.getSymbol() == symbol)
                            throw new InvalidSymbolException();
                    }
                    sym = false;
                } catch (InvalidSymbolException e) {
                    System.out.println(e.getMessage());
                    continue Symbol;
                }
            }

            System.out.print("Are you a bot (Y/N): ");
            char isBot = sc.next().toLowerCase().charAt(0);

            BotDifficultyLevel botDifficultyLevel;
            if (isBot == 'y') {
                System.out.print("Bot difficulty level (E/M/H): ");
                char difficulty = sc.next().toLowerCase().charAt(0);
                botDifficultyLevel = switch (difficulty) {
                    case 'm' -> BotDifficultyLevel.MEDIUM;
                    case 'h' -> BotDifficultyLevel.HARD;
                    default -> BotDifficultyLevel.EASY;
                };
                playerList.add(PlayerController.createBotPlayer(name, symbol, botDifficultyLevel));
            } else
                playerList.add(PlayerController.createHumanPlayer(name, symbol));

            System.out.println();

        }

        Game game = GameController.initiateGame(dimension, playerList,
                List.of(new ColumnWinningStrategy(), new RowWinningStrategy(),
                new DiagnolWinningStrategy(), new AntiDiagnolWinningStrategy()));

        System.out.println("Are you ready to start the game?");

        if (sc.next().toLowerCase().charAt(0) == 'y') {
            GameController gc = new GameController(game);
            gc.startGame();
        }

        System.out.println("\nGame ended.");



    }
}
