package service;

import model.Board;

public class SudokuValidator {

    public boolean isValidMove(Board board, int row, int col, int value) {
        // Não pode sobreescrever uma célula fixa
        if (((model.Cell) board.getCell(row, col)).isFixed()) {
            return false;
        }

        // Verifica linha
        for (int j = 0; j < 9; j++) {
            if (board.getValue(row, j) == value) {
                return false;
            }
        }

        // Verifica coluna
        for (int i = 0; i < 9; i++) {
            if (board.getValue(i, col) == value) {
                return false;
            }
        }

        // Verifica bloco 3x3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board.getValue(i, j) == value) {
                    return false;
                }
            }
        }

        return true; // passou em todas as regras
    }
}


