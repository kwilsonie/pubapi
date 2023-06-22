package com.guinness.pub.api;

public class Point {
    public Point(double lat, double lon) {
    	
    	this.lat = lat;
    	this.lon = lon;
		// TODO Auto-generated constructor stub
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	private double lat;
    private double lon;
    
}
