package com.bsu.avizhen.geom;

import java.awt.geom.Point2D;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:50
 */
public class Segment extends Figure1D {

	public Segment(Point2D firstPoint, Point2D secondPoint) {
		setPoints(firstPoint, secondPoint);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	private void setPoints(Point2D firstPoint, Point2D secondPoint){
		this.setCenter(firstPoint);
		this.setSecondPoint(secondPoint);
	}
}//end com.bsu.avizhen.geom.Segment