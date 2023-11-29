package de.samuel.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Gui {

    public static final int WIDTH = 800, HEIGHT = 700;

    public static final HashMap<JLabel, Point> labels = new HashMap<>();

    public static final HashMap<Point, JLabel> points = new HashMap<>();

    private final JFrame frame;
    public static final Draw draw = new Draw();

    public Gui() {
        frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        draw.setBounds(0,0, WIDTH, HEIGHT);
        frame.add(draw);
        draw.setVisible(true);

        addLabels();

        frame.addKeyListener(new KeyListener());
        
        frame.setVisible(true);
    }

    
    private void addLabels() {
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                JLabel label = new JLabel();

                label.setBounds(draw.pointToCoordinates(i, j).x, draw.pointToCoordinates(i, j).y, draw.CELL_SIZE, draw.CELL_SIZE);
                label.setVisible(true);
                label.addMouseListener(new MouseListener());

                frame.add(label);

                labels.put(label, new Point(i, j));
                points.put(new Point(i, j), label);
            }
        }
    }

}
