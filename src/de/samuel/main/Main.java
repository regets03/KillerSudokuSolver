package de.samuel.main;

import de.samuel.gui.Draw;
import de.samuel.gui.Gui;
import de.samuel.sudoku.Sudoku;

public class Main {

    public static void main(String[] args) {
        Sudoku.fillSudoku();
        new Test();
        new Gui();
        Sudoku.solve(0, 0);
        Draw.drawSolution = true;
    }

}
