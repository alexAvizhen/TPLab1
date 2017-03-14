package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:49
 */
public class Line extends Ray {

	public Line(Point2D firstPoint, Point2D secondPoint){
		super(firstPoint, secondPoint);
		setPoints(firstPoint, secondPoint);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	private void setPoints(Point2D firstPoint, Point2D secondPoint){
		final int MAX_NUMBER_OF_PIXELS = 10000;
		int x1 = (int) firstPoint.getX();
		int y1 = (int) firstPoint.getY();
		int x2 = (int) secondPoint.getX();
		int y2 = (int) secondPoint.getY();
		int x = (int) Math.signum(x1 - x2) * MAX_NUMBER_OF_PIXELS;
		int y = (x2 * y1 - x1 * y2 - (y1 - y2) * x) / (x2 - x1);
		setCenter(new Point(x, y));
	}
}//end com.bsu.avizhen.geom.Line