package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        createBoard(size);
    }

    private void createBoard(int size){
        this.board = new ArrayList<>();
        for(int i = 0; i < size; i++){
            board.add( new ArrayList<>());
            for(int j = 0; j < size; j++){
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void print(){
        int n = board.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    System.out.print(" ---");
                } else {
                    System.out.println(" ---");
                }
            }

            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    Cell cell = board.get(i).get(j);
                    if(cell.getCellState() == CellState.EMPTY)
                        System.out.print("|   ");
                    else
                        System.out.print("| "+cell.getPlayer().getSymbol()+" ");
                } else {
                    System.out.println("|");
                }
            }

            if(i == n - 1){
                for (int j = 0; j < n; j++) {
                    if (j < n - 1) {
                        System.out.print(" ---");
                    } else {
                        System.out.println(" ---");
                    }
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
