package de.samuel.gui;

import de.samuel.sudoku.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()){
            case KeyEvent.VK_0 -> keyNumber(0);
            case KeyEvent.VK_1 -> keyNumber(1);
            case KeyEvent.VK_2 -> keyNumber(2);
            case KeyEvent.VK_3 -> keyNumber(3);
            case KeyEvent.VK_4 -> keyNumber(4);
            case KeyEvent.VK_5 -> keyNumber(5);
            case KeyEvent.VK_6 -> keyNumber(6);
            case KeyEvent.VK_7 -> keyNumber(7);
            case KeyEvent.VK_8 -> keyNumber(8);
            case KeyEvent.VK_9 -> keyNumber(9);
            case KeyEvent.VK_ENTER -> keyEnter();
            case KeyEvent.VK_BACK_SPACE -> keyDelete();
        }
    }

    private void keyDelete() {
        if (!Draw.marked.isEmpty() && Gui.labels_by_point.get(Draw.marked.get(0)).getText().isEmpty()) {
            if (Sudoku.getCageByPoint(Draw.marked.get(0)) != null) {
                Sudoku.cages.remove(Sudoku.getCageByPoint(Draw.marked.get(0)));
            }
        }

        for (Point p : Draw.marked) {
            JLabel label = Gui.labels_by_point.get(p);
            if (!label.getText().isEmpty()) {
                label.setText(label.getText().substring(0, label.getText().length() - 1));
            }
        }
    }

    private void keyNumber(int number) {
        for (Point p : Draw.marked) {
            JLabel label = Gui.labels_by_point.get(p);
            label.setText(label.getText() + number);
        }
    }

    private void keyEnter() {
        if (isValidValue()) {
            int value = Integer.parseInt(Gui.labels_by_point.get(Draw.marked.get(0)).getText());

            if (Sudoku.getCageByPoint(Draw.marked.get(0)) == null) {
                ArrayList<Point> points = new ArrayList<>(Draw.marked);
                Sudoku.addCage(value, points.size(), points);
                Draw.marked.clear();
            } else {
                Objects.requireNonNull(Sudoku.getCageByPoint(Draw.marked.get(0))).setValue(value);
            }

        } else if (!Draw.marked.isEmpty()) {
            System.err.println("Not a valid value");
        }
    }

    public static boolean isValidValue() {
        if (Draw.marked.isEmpty() || Gui.labels_by_point.get(Draw.marked.get(0)).getText().isEmpty()) {
            return false;
        }

        int value = Integer.parseInt(Gui.labels_by_point.get(Draw.marked.get(0)).getText());
        int n = Draw.marked.size();

        int min = (n * (n+1)) / 2;
        int max = (n * (n+1)) / 2 + n * (9-n);

        return value >= min && value <= max;
    }

}
