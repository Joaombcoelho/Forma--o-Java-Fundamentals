package model;

public class Cell {
    private int value;       // 0 se vazio
    private boolean fixed;   // true se faz parte do puzzle inicial

    public Cell() {
        this.value = 0;
        this.fixed = false;
    }

    public Cell(int value, boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!fixed) {
            this.value = value;
        } else {
            System.out.println("Essa célula é fixa e não pode ser alterada!");
        }
    }

    public boolean isFixed() {
        return fixed;
    }

    @Override
    public String toString() {
        return value == 0 ? "." : String.valueOf(value);
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    
}
