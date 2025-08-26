package service;

import java.util.Random;
import model.Board;
import model.Difficulty;

public class SudokuGenerator {
    private final Random random = new Random();

    // Gera um tabuleiro inicial
    public Board generate(Difficulty difficulty) {
        Board board = new Board();

        // 🔹 Passo 1: começar de uma grade completa válida (mock por enquanto)
        int[][] solution = getPredefinedSolution();

        // 🔹 Passo 2: copiar para o tabuleiro
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board.setValue(i, j, solution[i][j], true);
            }
        }

        // 🔹 Passo 3: remover alguns números dependendo da dificuldade
        int cellsToRemove = 81 - difficulty.getFilledCells();
        while (cellsToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);

            if (board.getValue(row, col) != 0) {
                board.setValue(row, col, 0, false);
                cellsToRemove--;
            }
        }

        return board;
    }

    // Uma solução completa de Sudoku (pode fixar essa por enquanto)
    private int[][] getPredefinedSolution() {
        return new int[][] {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };
    }
}
