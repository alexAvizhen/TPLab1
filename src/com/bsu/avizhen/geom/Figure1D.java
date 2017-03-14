package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;
/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:49
 */
public abstract class Figure1D extends Figure {

	private Point2D secondPoint;

	public Figure1D(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void draw(Graphics g){
		g.setColor(getLineColor());
		g.drawLine(((int) getCenter().getX()), ((int) getCenter().getY()),
				((int) secondPoint.getX()), ((int) secondPoint.getY()));

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
	 * @param newVal
	 */
	public void setSecondPoint(Point2D newVal){
		secondPoint = newVal;
	}
}//end com.bsu.avizhen.geom.Figure1D