package de.samuel.sudoku;

import java.awt.*;
import java.util.ArrayList;

public class Sudoku {

    public static ArrayList<Cage> cages = new ArrayList<>();

    public static void addCage(int value, int size, ArrayList<Point> points){
        cages.add(new Cage(value, size, points));
    }

    public static Cage getCageByPoint(Point point){
        for(Cage cage : cages){
            if(cage.getPoints().contains(point)){
                return cage;
            }
        }
        return null;
    }

}
