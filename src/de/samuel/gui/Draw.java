package de.samuel.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JLabel {

    public final int CELL_SIZE = 60;

    public final int MARGIN_TOP = 50, MARGIN_LEFT = 50, FIELD_LENGTH = 9 * CELL_SIZE + 8 + 6, BOX_LENGTH = 3* CELL_SIZE + 4;

    ArrayList<Point> marked = new ArrayList<>();

    protected void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        for(int i = 0; i < 4; i++){

            // vertical box lines
            g2.drawLine(MARGIN_LEFT, MARGIN_TOP + i*BOX_LENGTH, MARGIN_LEFT + FIELD_LENGTH - 2, MARGIN_TOP + i*BOX_LENGTH);

            //horizontal box lines
            g2.drawLine(MARGIN_LEFT + i*BOX_LENGTH, MARGIN_TOP, MARGIN_LEFT + i*BOX_LENGTH, MARGIN_TOP + FIELD_LENGTH - 2);

        }

        //horizontal outlines
        g2.drawLine(MARGIN_LEFT - 2, MARGIN_TOP - 2, MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP - 2);
        g2.drawLine(MARGIN_LEFT - 2, MARGIN_TOP + FIELD_LENGTH, MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP + FIELD_LENGTH);

        //vertical outlines
        g2.drawLine(MARGIN_LEFT - 2, MARGIN_TOP - 2, MARGIN_LEFT - 2, MARGIN_TOP + FIELD_LENGTH);
        g2.drawLine(MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP - 2, MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP + FIELD_LENGTH);


        g2.setStroke(new BasicStroke(1));

        for (int i = 1; i < 10; i++) {

            int y = MARGIN_TOP + i * (BOX_LENGTH / 3) + (i / 3);
            g2.drawLine(MARGIN_LEFT, y, MARGIN_LEFT + FIELD_LENGTH, y);

            int x = MARGIN_LEFT + i * (BOX_LENGTH / 3) + (i / 3);
            g2.drawLine(x, MARGIN_TOP, x, MARGIN_TOP + FIELD_LENGTH);

        }

        g2.setColor(new Color(0, 255, 255, 50));
        for(Point point : marked){
            Point p = pointToCoordinates(point.x, point.y);
            g2.fillRect(p.x, p.y, CELL_SIZE, CELL_SIZE);
        }

        repaint();
    }


    public Point pointToCoordinates(int x, int y){
        Point point = new Point();
        point.x = MARGIN_LEFT + x * (CELL_SIZE + 1) + 1 + (x/3);
        point.y = MARGIN_TOP + y * (CELL_SIZE + 1) + 1 + (y/3);
        return point;
    }

}
