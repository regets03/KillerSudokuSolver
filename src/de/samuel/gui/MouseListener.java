package de.samuel.gui;

import de.samuel.sudoku.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class MouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        Point p = Gui.points_by_label.get((JLabel) e.getSource());

        if (!Draw.marked.isEmpty() && Sudoku.getCageByPoint(Draw.marked.get(0)) != null && !KeyListener.isValidValue()) {
            System.err.println("Not a valid value");
            return;
        }

        if (Sudoku.getCageByPoint(p) != null) {
            clickCage(p);
        } else {
            clickCell(p);
        }

    }

    private void clickCell(Point p) {
        if (Draw.marked.isEmpty() || Sudoku.getCageByPoint(Draw.marked.get(0)) == null) {
            if (Draw.marked.contains(p)) {
                Draw.marked.remove(p);
            } else {
                Draw.marked.add(p);
            }
        }
    }

    private void clickCage(Point p) {
        if (Draw.marked.isEmpty()) {
            Draw.marked.addAll(Objects.requireNonNull(Sudoku.getCageByPoint(p)).getPoints());
        } else if (Sudoku.getCageByPoint(Draw.marked.get(0)) == Sudoku.getCageByPoint(p)) {
            Draw.marked.clear();
        }
    }

}
