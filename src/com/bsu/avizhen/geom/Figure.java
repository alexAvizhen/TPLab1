package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:49
 */
public abstract class Figure {

	private Point2D center;
	private Color lineColor;

	public Figure(){

	}

	public void finalize() throws Throwable {

	}
	public abstract void draw(Graphics g);

	public Point2D getCenter(){
		return center;
	}

	public Color getLineColor(){
		return lineColor;
	}

	public Point2D location(){
		return null;
	}

	/**
	 * 
	 * @param point
	 */
	public abstract void move(Point2D point);

	/**
	 * 
	 * @param newVal
	 */
	public void setCenter(Point2D newVal){
		center = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineColor(Color newVal){
		lineColor = newVal;
	}
}//end com.bsu.avizhen.geom.Figure