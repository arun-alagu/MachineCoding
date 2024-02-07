package services;

import exceptions.InvalidCellException;
import models.*;
import strategies.botPlaying.HardBotPlayingStrategy;
import strategies.botPlaying.MediumBotPlayingStrategy;
import strategies.winning.WinningStrategy;

public class GameService {
    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    // While there is space on the board.
    // Print out which players move it is.
    // Get the player and call nextMove
    // Display the board.
    // Iterate over all the winning strategies to check if any player has won.
    // Update the next player index.

    public void executeNextMoves() throws Exception {
        while (checkEmptySpace()) {
            Player currentPlayer = game.getPlayerList().get(game.getNextPlayerIndex());
            System.out.printf("Now its %s's turn!", currentPlayer.getName());

            Cell currentCell = null;
            try {
                currentCell = currentPlayer.nextMove(game.getBoard());
            } catch (InvalidCellException e) {
                System.out.println("Please re-check the cell you entered!");
                System.out.println(e.getMessage()+"\n");
                continue;
            }
            game.getMoveList().add(new Move(currentCell, currentPlayer));
            game.board.print();

            for (WinningStrategy winningStrategy : game.getWinningStrategiesList()) {
                if (winningStrategy.checkWin(currentCell, game.board)) {
                    System.out.printf("%s Wins!!!", currentPlayer.getName());
                    return;
                }
            }

            this.game.setNextPlayerIndex(
                    (this.game.getNextPlayerIndex() + 1) % game.getPlayerList().size()
            );

        }
        System.out.print("\nIt's a Draw!!");
    }

        private boolean checkEmptySpace(){
        for(int i = 0; i < game.board.getSize(); i++){
            for(int j = 0; j < game.board.getSize(); j++){
                if(game.board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY))
                    return true;
            }
        }
        return false;
        }

    }
