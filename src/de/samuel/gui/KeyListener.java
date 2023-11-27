package de.samuel.gui;

import de.samuel.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if(e.getKeyCode() >= KeyEvent.VK_0 && e.getKeyCode() <= KeyEvent.VK_9){
            int number = 0;
            switch (e.getKeyCode()){
                case KeyEvent.VK_1 -> number = 1;
                case KeyEvent.VK_2 -> number = 2;
                case KeyEvent.VK_3 -> number = 3;
                case KeyEvent.VK_4 -> number = 4;
                case KeyEvent.VK_5 -> number = 5;
                case KeyEvent.VK_6 -> number = 6;
                case KeyEvent.VK_7 -> number = 7;
                case KeyEvent.VK_8 -> number = 8;
                case KeyEvent.VK_9 -> number = 9;
            }
            for(Point p : Main.gui.getDraw().marked){
                JLabel label = Main.gui.points.get(p);
                label.setText(label.getText() + number);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DELETE){
            for(Point p : Main.gui.getDraw().marked){
                JLabel label = Main.gui.points.get(p);
                label.setText(label.getText().substring(0, label.getText().length()-2));
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            int value = 0;
            for(Point p : Main.gui.getDraw().marked){
                value = Integer.parseInt(Main.gui.points.get(p).getText());
                break;
            }
            int size = Main.gui.getDraw().marked.size();
            ArrayList<Point> points = Main.gui.getDraw().marked;
            Main.sudoku.addCage(value, size, points);
            Main.gui.getDraw().marked.clear();
        }
    }

}
