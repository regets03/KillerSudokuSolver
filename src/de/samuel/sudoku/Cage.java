package de.samuel.sudoku;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cage {

    private final int value, size;

    private List<List<Integer>> possibleCombinations = new ArrayList<>();

    private final ArrayList<Point> points;

    public Cage(int value, int size, ArrayList<Point> points) {
        this.value = value;
        this.size = size;
        this.points = points;

        possibleCombinations = getPossibleCombinations(value, size);
    }

    private List<List<Integer>> getPossibleCombinations(int value, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (n == 1) {
            return Stream.of(Stream.of(value).collect(Collectors.toList())).collect(Collectors.toList());
        }

        int min = Math.min(9, value - (n*(n-1))/2);
        int max = Math.max(1, value - 10*(n-1) + (n*(n-1))/2);

        for (int i = min; i >= max; i--) {
            List<List<Integer>> combinations = getPossibleCombinations(value-i, n-1);

            for (List<Integer> list : combinations) {
                if (list.contains(i)){
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

}
