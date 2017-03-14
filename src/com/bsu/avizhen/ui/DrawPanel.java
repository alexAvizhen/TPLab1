package com.bsu.avizhen.ui;

import com.bsu.avizhen.geom.Figure;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 12.03.2017.
 */
public class DrawPanel extends JPanel {
    private List<Figure> figures;

    public DrawPanel() {
        figures = new ArrayList<>();
        setBorder(new LineBorder(Color.BLACK, 3));
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (Figure figure : figures) {
            figure.draw(g);
        }
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void clear() {
        figures.clear();
    }
}
