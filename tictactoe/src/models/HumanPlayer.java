package models;

import exceptions.InvalidCellException;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends Player{
    private int rank;
    private int age;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Cell nextMove(Board board) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the row: ");
        int row = sc.nextInt();
        System.out.print("\nEnter the col: ");
        int col = sc.nextInt();

        if(row < 0 || row > board.getSize() ||
                col < 0 || col > board.getSize() ||
                !board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY))
            throw new InvalidCellException();

        Cell cell = board.getBoard().get(row).get(col);

        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);

        return cell;
    }
}
