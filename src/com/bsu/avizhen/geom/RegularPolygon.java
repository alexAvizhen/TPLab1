package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:50
 */
public class RegularPolygon extends Polygon {

	private int amountOfSides;

	public RegularPolygon(Point2D center, Point2D firstPoint, int amountOfSides) {
		super(new ArrayList<>(Collections.singletonList(firstPoint)));
		setCenter(center);
		this.amountOfSides = amountOfSides;
		fillPoints(center, firstPoint, amountOfSides);

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	private void fillPoints(Point2D center, Point2D firstPoint, int amountOfSides){
		double radius = Point2D.distance(center.getX(), center.getY(), firstPoint.getX(), firstPoint.getY());
		double a = Point2D.distance(center.getX(), center.getY() - radius, firstPoint.getX(), firstPoint.getY());

		double deg = Math.acos((2 * radius * radius - a * a) / (2 * radius * radius));
		double deltaDeg = Math.PI * 2 / amountOfSides;

		deg = (firstPoint.getX() < center.getX()) ? -deg : deg;

		for (int i = 0; i < amountOfSides; i++) {
			int x = (int) (center.getX() +  radius * Math.sin(deg));
			int y = (int) (center.getY() -  radius * Math.cos(deg));
			getPoints().add(new Point(x, y));
			deg += deltaDeg;
		}

	}

	public int getAmountOfSides(){
		return amountOfSides;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmountOfSides(int newVal){
		amountOfSides = newVal;
	}
}//end com.bsu.avizhen.geom.RegularPolygon