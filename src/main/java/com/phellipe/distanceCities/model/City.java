package com.phellipe.distanceCities.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class City {
	
	private String id;
	private String name;
	private double longitude;
	private double latitude;
	
	

	public City() {
	}



	public City(String id, String name, double longitude, double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	
	

}
