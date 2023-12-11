package de.samuel.sudoku;

public class Cell {

    private int value;
    private Cage cage;

    public int getValue() {
        return value;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
