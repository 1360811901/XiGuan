package com.fei.Entity;

import com.mongodb.ReflectionDBObject;

public class Position extends ReflectionDBObject{
	private double[] cordinates = new double[2];

	public Position(double[] cordinates) {
		super();
		this.cordinates = cordinates;
	}

	public double[] getCordinates() {
		return cordinates;
	}

	public void setCordinates(double[] cordinates) {
		this.cordinates = cordinates;
	}
	
	
	
}
