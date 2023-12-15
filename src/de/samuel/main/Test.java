package de.samuel.main;

import de.samuel.sudoku.Sudoku;

import java.awt.*;
import java.util.ArrayList;;

public class Test {

    public Test() {

        //26674

        ArrayList<Point> l1 = new ArrayList<>();
        l1.add(new Point(0, 0));
        l1.add(new Point(1, 0));
        Sudoku.addCage(12, 2, l1);

        ArrayList<Point> l2 = new ArrayList<>();
        l2.add(new Point(2, 0));
        l2.add(new Point(3, 0));
        Sudoku.addCage(11, 2, l2);

        ArrayList<Point> l3 = new ArrayList<>();
        l3.add(new Point(4, 0));
        l3.add(new Point(5, 0));
        l3.add(new Point(4, 1));
        Sudoku.addCage(12, 3, l3);

        ArrayList<Point> l4 = new ArrayList<>();
        l4.add(new Point(6, 0));
        l4.add(new Point(7, 0));
        l4.add(new Point(8, 0));
        Sudoku.addCage(17, 3, l4);

        ArrayList<Point> l5 = new ArrayList<>();
        l5.add(new Point(0, 1));
        l5.add(new Point(0, 2));
        Sudoku.addCage(10, 2, l5);

        ArrayList<Point> l6 = new ArrayList<>();
        l6.add(new Point(1, 1));
        l6.add(new Point(1, 2));
        Sudoku.addCage(10, 2, l6);

        ArrayList<Point> l7 = new ArrayList<>();
        l7.add(new Point(2, 1));
        l7.add(new Point(2, 2));
        l7.add(new Point(2, 3));
        Sudoku.addCage(17, 3, l7);

        ArrayList<Point> l8 = new ArrayList<>();
        l8.add(new Point(3, 1));
        l8.add(new Point(3, 2));
        Sudoku.addCage(11, 2, l8);

        ArrayList<Point> l9 = new ArrayList<>();
        l9.add(new Point(4, 2));
        l9.add(new Point(5, 2));
        l9.add(new Point(5, 1));
        Sudoku.addCage(14, 3, l9);

        ArrayList<Point> l10 = new ArrayList<>();
        l10.add(new Point(6, 1));
        l10.add(new Point(7, 1));
        l10.add(new Point(8, 1));
        Sudoku.addCage(13, 3, l10);

        ArrayList<Point> l11 = new ArrayList<>();
        l11.add(new Point(6, 2));
        l11.add(new Point(7, 2));
        l11.add(new Point(8, 2));
        Sudoku.addCage(15, 3, l11);

        ArrayList<Point> l12 = new ArrayList<>();
        l12.add(new Point(0, 3));
        l12.add(new Point(1, 3));
        Sudoku.addCage(9, 2, l12);

        ArrayList<Point> l13 = new ArrayList<>();
        l13.add(new Point(0, 4));
        l13.add(new Point(0, 5));
        Sudoku.addCage(7, 2, l13);

        ArrayList<Point> l14 = new ArrayList<>();
        l14.add(new Point(1, 4));
        l14.add(new Point(2, 4));
        Sudoku.addCage(15, 2, l14);

        ArrayList<Point> l15 = new ArrayList<>();
        l15.add(new Point(1, 5));
        l15.add(new Point(2, 5));
        Sudoku.addCage(7, 2, l15);

        ArrayList<Point> l16 = new ArrayList<>();
        l16.add(new Point(3, 3));
        l16.add(new Point(3, 4));
        Sudoku.addCage(4, 2, l16);

        ArrayList<Point> l17 = new ArrayList<>();
        l17.add(new Point(4, 3));
        l17.add(new Point(5, 3));
        l17.add(new Point(5, 4));
        Sudoku.addCage(12, 3, l17);

        ArrayList<Point> l18 = new ArrayList<>();
        l18.add(new Point(3, 5));
        l18.add(new Point(3, 6));
        Sudoku.addCage(11, 2, l18);

        ArrayList<Point> l19 = new ArrayList<>();
        l19.add(new Point(4, 4));
        l19.add(new Point(4, 5));
        l19.add(new Point(4, 6));
        Sudoku.addCage(22, 3, l19);

        ArrayList<Point> l20 = new ArrayList<>();
        l20.add(new Point(5, 5));
        l20.add(new Point(5, 6));
        Sudoku.addCage(9, 2, l20);

        ArrayList<Point> l21 = new ArrayList<>();
        l21.add(new Point(6, 3));
        l21.add(new Point(6, 4));
        l21.add(new Point(6, 5));
        Sudoku.addCage(23, 3, l21);

        ArrayList<Point> l22 = new ArrayList<>();
        l22.add(new Point(7, 3));
        l22.add(new Point(7, 4));
        Sudoku.addCage(8, 2, l22);

        ArrayList<Point> l23 = new ArrayList<>();
        l23.add(new Point(8, 3));
        l23.add(new Point(8, 4));
        Sudoku.addCage(9, 2, l23);

        ArrayList<Point> l24 = new ArrayList<>();
        l24.add(new Point(8, 5));
        l24.add(new Point(7, 5));
        Sudoku.addCage(5, 2, l24);

        ArrayList<Point> l25 = new ArrayList<>();
        l25.add(new Point(0, 6));
        l25.add(new Point(1, 6));
        l25.add(new Point(2, 6));
        Sudoku.addCage(14, 3, l25);

        ArrayList<Point> l26 = new ArrayList<>();
        l26.add(new Point(0, 7));
        l26.add(new Point(1, 7));
        Sudoku.addCage(10, 2, l26);

        ArrayList<Point> l27 = new ArrayList<>();
        l27.add(new Point(0, 8));
        l27.add(new Point(1, 8));
        l27.add(new Point(2, 8));
        Sudoku.addCage(17, 3, l27);

        ArrayList<Point> l28 = new ArrayList<>();
        l28.add(new Point(2, 7));
        l28.add(new Point(3, 7));
        Sudoku.addCage(6, 2, l28);

        ArrayList<Point> l29 = new ArrayList<>();
        l29.add(new Point(4, 7));
        l29.add(new Point(3, 8));
        l29.add(new Point(4, 8));
        Sudoku.addCage(18, 3, l29);

        ArrayList<Point> l30 = new ArrayList<>();
        l30.add(new Point(5, 7));
        l30.add(new Point(5, 8));
        Sudoku.addCage(12, 2, l30);

        ArrayList<Point> l31 = new ArrayList<>();
        l31.add(new Point(6, 6));
        l31.add(new Point(7, 6));
        Sudoku.addCage(9, 2, l31);

        ArrayList<Point> l32 = new ArrayList<>();
        l32.add(new Point(6, 7));
        l32.add(new Point(6, 8));
        Sudoku.addCage(6, 2, l32);

        ArrayList<Point> l33 = new ArrayList<>();
        l33.add(new Point(7, 7));
        l33.add(new Point(7, 8));
        Sudoku.addCage(14, 2, l33);

        ArrayList<Point> l34 = new ArrayList<>();
        l34.add(new Point(8, 6));
        l34.add(new Point(8, 7));
        l34.add(new Point(8, 8));
        Sudoku.addCage(16, 3, l34);

    }

}
