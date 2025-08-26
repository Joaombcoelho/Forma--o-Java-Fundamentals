package model;

public enum Difficulty {
    EASY(40),    // 40 células preenchidas
    MEDIUM(30),  // 30 preenchidas
    HARD(20);    // 20 preenchidas

    private final int filledCells;

    Difficulty(int filledCells) {
        this.filledCells = filledCells;
    }

    public int getFilledCells() {
        return filledCells;
    }
}
