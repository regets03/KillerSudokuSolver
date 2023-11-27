package de.samuel.gui;

import de.samuel.main.Main;
import de.samuel.sudoku.Cage;
import de.samuel.sudoku.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        Point p = Main.gui.labels.get((JLabel) e.getSource());

        if(Sudoku.getCageByPoint(p) != null){
            if(!Main.gui.getDraw().marked.isEmpty()){
                // TODO
            }
        }

        if(Main.gui.getDraw().marked.contains(p)) {
            Main.gui.getDraw().marked.remove(p);
        }else{
            Main.gui.getDraw().marked.add(p);
        }
    }


}
