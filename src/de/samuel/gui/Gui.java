package de.samuel.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Gui {

    public static final int WIDTH = 800, HEIGHT = 700;

    public static final HashMap<JLabel, Point> points_by_label = new HashMap<>();

    public static final HashMap<Point, JLabel> labels_by_point = new HashMap<>();

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
                label.addMouseListener(new MouseListener());
                label.setVerticalAlignment(SwingConstants.TOP);
                label.setHorizontalAlignment(SwingConstants.LEFT);
                label.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
                label.setVisible(true);

                frame.add(label);

                points_by_label.put(label, new Point(i, j));
                labels_by_point.put(new Point(i, j), label);
            }
        }
    }

}
