package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:49
 */
public class Ellipse extends Figure2D {

	private Point2D firstPoint;
	private Point2D secondPoint;

	public Ellipse(){

	}

	public Ellipse(Point2D firstPoint, Point2D secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void draw(Graphics g){
		int x = (int) Math.min(firstPoint.getX(), secondPoint.getX());
		int y = (int) Math.min(firstPoint.getY(), secondPoint.getY());
		int width = (int) Math.abs(secondPoint.getX() - firstPoint.getX());
		int height = (int) Math.abs(secondPoint.getY() - firstPoint.getY());
		g.setColor(getBgColor());
		g.fillOval(x, y, width, height);
		g.setColor(getLineColor());
		g.drawOval(x, y, width, height);
	}

	public Point2D getFirstPoint(){
		return firstPoint;
	}

	public Point2D getSecondPoint(){
		return secondPoint;
	}

	/**
	 * 
	 * @param point
	 */
	public void move(Point2D point){

	}

	/**
	 * 
	 * @param firstPoint
	 */
	public void setFirstPoint(Point2D firstPoint){
		this.firstPoint = firstPoint;
	}

	/**
	 * 
	 * @param secondPoint
	 */
	public void setSecondPoint(Point2D secondPoint){
		this.secondPoint = 	secondPoint;
	}
}//end com.bsu.avizhen.geom.Ellipse