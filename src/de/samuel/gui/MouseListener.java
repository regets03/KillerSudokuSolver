package de.samuel.gui;

import de.samuel.sudoku.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        Point p = Gui.labels.get((JLabel) e.getSource());

        if (!isValidCell(e, p)) {
            return;
        }

        if (Draw.marked.contains(p)) {
            Draw.marked.remove(p);
        } else {
            Draw.marked.add(p);
        }

    }

    private boolean isValidCell(MouseEvent e, Point p){
        if (Sudoku.getCageByPoint(p) != null) {
            if (!Draw.marked.isEmpty()) {
                return Sudoku.getCageByPoint(Draw.marked.get(0)) == Sudoku.getCageByPoint(p);
            }
        } else {
            if (!Draw.marked.isEmpty()) {
                return Sudoku.getCageByPoint(Draw.marked.get(0)) == null;
            }
        }
        return true;
    }


}
