package com.bsu.avizhen.geom;

import java.awt.*;

/**
 * @author Alexander
 * @version 1.0
 * @created 12-���-2017 12:23:49
 */
public abstract class Figure2D extends Figure {

	private Color bgColor;

	public Figure2D(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public Color getBgColor(){
		return bgColor;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBgColor(Color newVal){
		bgColor = newVal;
	}
}//end com.bsu.avizhen.geom.Figure2D