package de.samuel.sudoku;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cage {

    private int value;

    private final int size;

    private List<List<Integer>> possibleCombinations = new ArrayList<>();

    private List<Integer> possibleNumbers = new ArrayList<>();

    private final ArrayList<Point> points;

    public Cage(int value, int size, ArrayList<Point> points) {
        this.value = value;
        this.size = size;
        this.points = points;

        possibleCombinations = searchPossibleCombinations(value, size);
        possibleNumbers = searchPossibleNumbers();
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public List<List<Integer>> getPossibleCombinations() {
        return possibleCombinations;
    }

    private List<Integer> searchPossibleNumbers() {
        return possibleCombinations
                .stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Point getTopLeftPoint(List<Point> points) {
        Point result = new Point(9, 9);

        for (Point p : points) {
            if (p.x < result.x || (p.x == result.x && p.y < result.y)) {
                result = p;
            }
        }

        return result;
    }

    private List<List<Integer>> searchPossibleCombinations(int value, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (n == 1) {
            return Stream.of(Stream.of(value).collect(Collectors.toList())).collect(Collectors.toList());
        }

        int min = Math.min(9, value - (n*(n-1))/2);
        int max = Math.max(1, value - 10*(n-1) + (n*(n-1))/2);

        for (int i = min; i >= max; i--) {
            List<List<Integer>> combinations = searchPossibleCombinations(value-i, n-1);

            for (List<Integer> list : combinations) {
                if (list.contains(i)) {
                    continue;
                }

                list.add(i);
                list.sort(Integer::compare);

                if (!result.contains(list)) {
                    result.add(list);
                }
            }
        }
        return result;
    }

    public ArrayList<Point> getPoints(){
        return points;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
