package de.samuel.gui;

import de.samuel.sudoku.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()){
            case KeyEvent.VK_0 -> keyNumber(e, 0);
            case KeyEvent.VK_1 -> keyNumber(e, 1);
            case KeyEvent.VK_2 -> keyNumber(e, 2);
            case KeyEvent.VK_3 -> keyNumber(e, 3);
            case KeyEvent.VK_4 -> keyNumber(e, 4);
            case KeyEvent.VK_5 -> keyNumber(e, 5);
            case KeyEvent.VK_6 -> keyNumber(e, 6);
            case KeyEvent.VK_7 -> keyNumber(e, 7);
            case KeyEvent.VK_8 -> keyNumber(e, 8);
            case KeyEvent.VK_9 -> keyNumber(e, 9);
            case KeyEvent.VK_ENTER -> keyEnter(e);
            case KeyEvent.VK_BACK_SPACE -> keyDelete(e);
        }
    }

    private void keyDelete(KeyEvent e) {
        for (Point p : Draw.marked) {
            JLabel label = Gui.points.get(p);
            if (!label.getText().isEmpty()) {
                label.setText(label.getText().substring(0, label.getText().length() - 1));
            }
        }
    }

    private void keyNumber(KeyEvent e, int number) {
        for (Point p : Draw.marked) {
            JLabel label = Gui.points.get(p);
            label.setText(label.getText() + number);
        }
    }

    private void keyEnter(KeyEvent e){
        if(!Draw.marked.isEmpty()) {
            int value = Integer.parseInt(Gui.points.get(Draw.marked.get(0)).getText());
            ArrayList<Point> points = new ArrayList<>(Draw.marked);
            Sudoku.addCage(value, points.size(), points);
            Draw.marked.clear();
        }
    }

}
