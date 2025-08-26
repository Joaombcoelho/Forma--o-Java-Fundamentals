package model;

public class Board {
    private final Cell[][] grid;

    public Board() {
        grid = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void setValue(int row, int col, int value, boolean fixed) {
        grid[row][col] = new Cell(value, fixed);
    }

    public int getValue(int row, int col) {
        return grid[row][col].getValue();
    }
public Cell getCell(int row, int col) {
    return grid[row][col];
}

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    }


