package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Александр on 13.03.2017.
 */
public class Rectangle extends SymmetricPolygon {

    public Rectangle(Point2D firstPoint, Point2D secondPoint) {
        fillPoints(firstPoint, secondPoint);
    }

    private void fillPoints(Point2D firstPoint, Point2D secondPoint) {
        getPoints().add(firstPoint);
        getPoints().add(new Point(((int) firstPoint.getX()), ((int) secondPoint.getY())));
        getPoints().add(secondPoint);
        getPoints().add(new Point(((int) secondPoint.getX()), ((int) firstPoint.getY())));
    }
}
