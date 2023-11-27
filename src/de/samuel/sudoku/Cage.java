package de.samuel.sudoku;

import java.awt.*;
import java.util.ArrayList;

public class Cage {

    int value, size;
    int[] possibleNumbers;

    private final ArrayList<Point> points;

    public Cage(int value, int size, ArrayList<Point> points){
        this.value = value;
        this.size = size;
        this.points = points;
        possibleNumbers = getPossibleNumbers(value, size);
    }

    private int[] getPossibleNumbers(int value, int size) {
        System.out.println(value + " " + size);
        return null;
    }

    public ArrayList<Point> getPoints(){
        return points;
    }

}
