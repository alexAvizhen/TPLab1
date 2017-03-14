package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Александр on 13.03.2017.
 */
public class Triangle extends SymmetricPolygon {

    public Triangle(Point2D firstPoint, Point2D secondPoint) {
        fillPoints(firstPoint, secondPoint);
    }

    private void fillPoints(Point2D firstPoint, Point2D secondPoint) {
        getPoints().add(firstPoint);
        getPoints().add(secondPoint);
        int x = (int) (firstPoint.getX() * 2 - secondPoint.getX());
        getPoints().add(new Point(x, (int) secondPoint.getY()));
    }
}
