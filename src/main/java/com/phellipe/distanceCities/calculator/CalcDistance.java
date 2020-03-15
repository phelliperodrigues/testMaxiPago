package com.phellipe.distanceCities.calculator;

import com.phellipe.distanceCities.model.City;

public class CalcDistance {

	public double getDistance(City cityA, City cityB, String unit) {
				
		double latA = cityA.getLatitude();
		double latB = cityB.getLatitude();
		double lngA = cityA.getLongitude();
		double lngB = cityB.getLongitude();
		
		double distance = haversine(latA, latB, lngA, lngB);	
		
		if(unit != null && "mi".equalsIgnoreCase(unit)){
			distance = distance * 0.621;		
		}
		
		return (double) Math.round(distance * 100) / 100;	
	}
	
	
	private double haversine(double latA, double latB, double lngA, double lngB) {

		double earthradius = 6371000;
		double dlat = Math.toRadians(latB - latA);
		double dLong = Math.toRadians(lngB - lngA);
		double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) + Math.cos(Math.toRadians(latA))
				* Math.cos(Math.toRadians(latB)) * Math.sin(dLong / 2) * Math.sin(dLong / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return (earthradius * c) / 1000;
		
	}

}
