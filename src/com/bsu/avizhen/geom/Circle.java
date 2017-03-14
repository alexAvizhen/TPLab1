package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Roman
 * @version 1.0
 * @created 12-���-2017 12:23:49
 */
public class Circle extends Ellipse {

	public Circle(Point2D center, Point2D roundPoint) {
		setCenter(center);
		fillPoints(center, roundPoint);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	private void fillPoints(Point2D center, Point2D roundPoint) {
		double r = Point2D.distance(center.getX(), center.getY(), roundPoint.getX(), roundPoint.getY());
		int x1 = (int) (center.getX() - r);
		int y1 = (int) (center.getY() - r);
		int x2 = (int) (center.getX() + r);
		int y2 = (int) (center.getY() + r);
		setFirstPoint(new Point(x1, y1));
		setSecondPoint(new Point(x2, y2));
	}
}//end com.bsu.avizhen.geom.Circle