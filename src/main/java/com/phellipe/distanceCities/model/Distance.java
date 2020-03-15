package com.phellipe.distanceCities.model;

public class Distance {
	private double distance;
	
	private String unit;

	public Distance(double distance, String unit) {
		super();
		this.distance = distance;
		this.unit = unit;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
