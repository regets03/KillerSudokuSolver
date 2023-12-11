package de.samuel.main;

import de.samuel.gui.Gui;
import de.samuel.sudoku.Sudoku;

public class Main {

    public static void main(String[] args) {
        new Gui();
        Sudoku.fillSudoku();
    }

}
