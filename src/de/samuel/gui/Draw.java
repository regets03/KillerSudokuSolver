package de.samuel.gui;

import de.samuel.sudoku.Cage;
import de.samuel.sudoku.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JLabel {

    public final int CELL_SIZE = 60;

    public final int MARGIN_TOP = 50, MARGIN_LEFT = 50, FIELD_LENGTH = 9 * CELL_SIZE + 8 + 6, BOX_LENGTH = 3 * CELL_SIZE + 4;

    public static final ArrayList<Point> marked = new ArrayList<>();

    public static boolean drawSolution = false;

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        drawBoxes(g2);
        drawOutline(g2);
        drawCells(g2);
        drawMarks(g2);
        drawCages(g2);

        if (drawSolution) {
            drawSolution(g2);
        }

        repaint();
    }

    private void drawSolution(Graphics2D g2) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                g2.drawString(Sudoku.sudoku[i][j].getValue() + "", pointToCoordinates(i, j).x, pointToCoordinates(i, j).y);
            }
        }
    }

    private void drawCages(Graphics2D g2) {
        for (Cage c : Sudoku.cages) {
            drawCage(g2, c);
        }
    }

    private void drawCage(Graphics2D g2, Cage c) {
        int margin = 5;

        g2.setColor(Color.BLACK);

        for (Point p : c.getPoints()) {
            Point coordinates = pointToCoordinates(p.x, p.y);

            boolean left = c.getPoints().contains(new Point(p.x - 1, p.y));
            boolean top = c.getPoints().contains(new Point(p.x, p.y - 1));
            boolean right = c.getPoints().contains(new Point(p.x + 1, p.y));
            boolean bottom = c.getPoints().contains(new Point(p.x, p.y + 1));

            if (p == Cage.getTopLeftPoint(c.getPoints())) {
                drawTopLeftOutline(g2, coordinates, margin, Gui.labels_by_point.get(p).getText().length());
            } else {
                drawCageOutlineLeft(g2, coordinates, left, margin);
                drawCageOutlineTop(g2, coordinates, top, margin);
            }

            drawCageOutlineRight(g2, coordinates, right, margin);
            drawCageOutlineBottom(g2, coordinates, bottom, margin);
        }
    }

    private void drawTopLeftOutline(Graphics2D g2, Point coordinates, int margin, int textLength) {
        //top
        int adjustment = textLength == 1 ? 5 : 0;
        g2.drawLine(coordinates.x + margin + 15 - adjustment, coordinates.y + margin, coordinates.x + CELL_SIZE - margin, coordinates.y + margin);

        //left
        g2.drawLine(coordinates.x + margin, coordinates.y + margin + 15, coordinates.x + margin, coordinates.y + CELL_SIZE - margin);
    }

    private void drawCageOutlineTop(Graphics2D g2, Point coordinates, boolean hasAdjacentFieldTop, int margin) {
        if (hasAdjacentFieldTop) {
            g2.drawLine(coordinates.x + margin, coordinates.y, coordinates.x + margin, coordinates.y + margin);
            g2.drawLine(coordinates.x + CELL_SIZE - margin, coordinates.y, coordinates.x + CELL_SIZE - margin, coordinates.y + margin);
        } else {
            g2.drawLine(coordinates.x + margin, coordinates.y + margin, coordinates.x + CELL_SIZE - margin, coordinates.y + margin);
        }
    }

    private void drawCageOutlineRight(Graphics2D g2, Point coordinates, boolean hasAdjacentFieldRight, int margin) {
        if (hasAdjacentFieldRight) {
            g2.drawLine(coordinates.x + CELL_SIZE - margin, coordinates.y + margin, coordinates.x + CELL_SIZE, coordinates.y + margin);
            g2.drawLine(coordinates.x + CELL_SIZE - margin, coordinates.y + CELL_SIZE - margin, coordinates.x + CELL_SIZE, coordinates.y + CELL_SIZE - margin);
        } else {
            g2.drawLine(coordinates.x + CELL_SIZE - margin, coordinates.y + margin, coordinates.x + CELL_SIZE - margin, coordinates.y + CELL_SIZE - margin);
        }
    }

    private void drawCageOutlineBottom(Graphics2D g2, Point coordinates, boolean hasAdjacentFieldBottom, int margin) {
        if (hasAdjacentFieldBottom) {
            g2.drawLine(coordinates.x + margin, coordinates.y + CELL_SIZE - margin, coordinates.x + margin, coordinates.y + CELL_SIZE);
            g2.drawLine(coordinates.x + CELL_SIZE - margin, coordinates.y + CELL_SIZE - margin, coordinates.x + CELL_SIZE - margin, coordinates.y + CELL_SIZE);
        } else {
            g2.drawLine(coordinates.x + margin, coordinates.y + CELL_SIZE - margin, coordinates.x + CELL_SIZE - margin, coordinates.y + CELL_SIZE - margin);
        }
    }

    private void drawCageOutlineLeft(Graphics2D g2, Point coordinates, boolean hasAdjacentFieldLeft, int margin) {
        if (hasAdjacentFieldLeft) {
            g2.drawLine(coordinates.x, coordinates.y + margin, coordinates.x + margin, coordinates.y + margin);
            g2.drawLine(coordinates.x, coordinates.y + CELL_SIZE - margin, coordinates.x + margin, coordinates.y + CELL_SIZE - margin);
        } else {
            g2.drawLine(coordinates.x + margin, coordinates.y + margin, coordinates.x + margin, coordinates.y + CELL_SIZE - margin);
        }
    }

    private void drawBoxes(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        for (int i = 0; i < 4; i++){
            // vertical box lines
            g2.drawLine(MARGIN_LEFT, MARGIN_TOP + i*BOX_LENGTH, MARGIN_LEFT + FIELD_LENGTH - 2, MARGIN_TOP + i*BOX_LENGTH);

            //horizontal box lines
            g2.drawLine(MARGIN_LEFT + i*BOX_LENGTH, MARGIN_TOP, MARGIN_LEFT + i*BOX_LENGTH, MARGIN_TOP + FIELD_LENGTH - 2);
        }

        g2.setStroke(new BasicStroke(1));
    }

    private void drawOutline(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        //horizontal outlines
        g2.drawLine(MARGIN_LEFT - 2, MARGIN_TOP - 2, MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP - 2);
        g2.drawLine(MARGIN_LEFT - 2, MARGIN_TOP + FIELD_LENGTH, MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP + FIELD_LENGTH);

        //vertical outlines
        g2.drawLine(MARGIN_LEFT - 2, MARGIN_TOP - 2, MARGIN_LEFT - 2, MARGIN_TOP + FIELD_LENGTH);
        g2.drawLine(MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP - 2, MARGIN_LEFT + FIELD_LENGTH, MARGIN_TOP + FIELD_LENGTH);

        g2.setStroke(new BasicStroke(1));
    }


    public Point pointToCoordinates(int x, int y) {
        Point point = new Point();

        point.x = MARGIN_LEFT + x * (CELL_SIZE + 1) + 1 + (x/3);
        point.y = MARGIN_TOP + y * (CELL_SIZE + 1) + 1 + (y/3);

        return point;
    }

    private void drawMarks(Graphics2D g2) {
        g2.setColor(new Color(0, 255, 255, 50));

        for (Point point : marked) {
            Point p = pointToCoordinates(point.x, point.y);
            g2.fillRect(p.x, p.y, CELL_SIZE, CELL_SIZE);
        }
    }

    private void drawCells(Graphics2D g2) {
        g2.setColor(Color.BLACK);

        for (int i = 1; i < 10; i++) {
            // vertical lines
            int y = MARGIN_TOP + i * (BOX_LENGTH / 3) + (i / 3);
            g2.drawLine(MARGIN_LEFT, y, MARGIN_LEFT + FIELD_LENGTH, y);

            // horizontal lines
            int x = MARGIN_LEFT + i * (BOX_LENGTH / 3) + (i / 3);
            g2.drawLine(x, MARGIN_TOP, x, MARGIN_TOP + FIELD_LENGTH);
        }
    }
}
