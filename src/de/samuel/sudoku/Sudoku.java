package de.samuel.sudoku;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        return sudoku[point.x][point.y].getCage();
    }


    public static boolean solve(int row, int col) {
        print();
        if (row == 9) {
            row = 0;
            if (++col == 9) {
                return true;
            }
        }

        if (sudoku[row][col].getValue() != 0) {
            return solve(row + 1, col);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                sudoku[row][col].setValue(num);

                if (solve(row + 1, col)) {
                    return true;
                }

                sudoku[row][col].setValue(0);
            }
        }

        return false;
    }

    private static boolean isValid(int row, int column, int number) {
        Cell[][] board = sudoku;
        return !isNumberInRow(board, number, row, column)
                && !isNumberInColumn(board, number, column, row)
                && !isNumberInBox(board, number, row, column)
                && isNumberValidInCage(number, row, column);
    }

    private static boolean isNumberValidInCage(int number, int row, int column) {
        Cage cage = getCageByPoint(new Point(row, column));
        List<Integer> values = new ArrayList<>();
        for (Point p : cage.getPoints()) {
            if (sudoku[p.x][p.y].getValue() != 0) {
                values.add(sudoku[p.x][p.y].getValue());
            }
        }
        values.add(number);

        if (values.stream().distinct().count() != values.size()) {
            return false;
        }

        boolean possibleCombination = false;
        for (List<Integer> list : cage.getPossibleCombinations()) {
            if (new HashSet<>(list).containsAll(values)) {
                possibleCombination = true;
                break;
            }
        }

        return possibleCombination;
    }

    private static boolean isNumberInBox(Cell[][] board, int number, int row, int column) {
        int startRow = row - (row % 3);
        int startColumn = column - (column % 3);
        for (int r = startRow; r < startRow+3; r++) {
            for (int c = startColumn; c < startColumn+3; c++) {
                if (!(r == row && c == column)) {
                    if (board[r][c].getValue() == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(Cell[][] board, int number, int column, int row) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column].getValue() == number) {
                if (i != row) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isNumberInRow(Cell[][] board, int number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getValue() == number) {
                if (i != column) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[j][i].getValue() + " ");
            }
            System.out.println();
        }

    }

}
