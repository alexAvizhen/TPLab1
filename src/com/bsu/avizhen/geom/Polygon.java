package com.bsu.avizhen.geom;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:50
 */
public class Polygon extends Figure2D {

	private List<Point2D> points;

	public Polygon(List<Point2D> points) {
		this.points = points;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void draw(Graphics g){
		if (points.isEmpty()) {
			return;
		}
		int x1 = (int) points.get(0).getX();
		int y1 = (int) points.get(0).getY();
		int x2 = (int) points.get(points.size() - 1).getX();
		int y2 = (int) points.get(points.size() - 1).getY();
		int[] xList = new int[points.size()];
		int[] yList = new int[points.size()];
		int k = 0;
		for (Point2D point : points) {
			xList[k] = (int) point.getX();
			yList[k++] = (int) point.getY();
		}
		g.setColor(getBgColor());
		g.fillPolygon(xList, yList, points.size());
		g.setColor(getLineColor());
		g.drawPolygon(xList, yList, points.size());
	}

	public List<Point2D> getPoints(){
		return points;
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
	public void setPoints(List<Point2D> newVal){
		points = newVal;
	}
}//end com.bsu.avizhen.geom.Polygon