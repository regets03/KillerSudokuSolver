package de.samuel.sudoku;

import java.awt.*;
import java.util.ArrayList;

public class Sudoku {

    public static ArrayList<Cage> cages = new ArrayList<>();
    public static Cell[][] sudoku = new Cell[9][9];

    public static void fillSudoku() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                sudoku[i][j] = new Cell();
            }
        }
    }

    public static void addCage(int value, int size, ArrayList<Point> points) {
        Cage newCage = new Cage(value, size, points);
        cages.add(newCage);

        for (Point p : points) {
            sudoku[p.x][p.y].setCage(newCage);
        }
    }

    public static Cage getCageByPoint(Point point) {
        for (Cage cage : cages) {
            if (cage.getPoints().contains(point)) {
                return cage;
            }
        }
        return null;
    }

}
