package com.guinness.pub.api;

import java.util.Date;

public class Pub {
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty_province() {
		return county_province;
	}
	public void setCounty_province(String county_province) {
		this.county_province = county_province;
	}
	public String getZip_or_postcode() {
		return zip_or_postcode;
	}
	public void setZip_or_postcode(String zip_or_postcode) {
		this.zip_or_postcode = zip_or_postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Point getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	private int id;
    private int userId;
    private String name;
    private String description;
    private String line1;
    private String line2;
    private String region;
    private String city;
    private String county_province;
    private String zip_or_postcode;
    private String country;
    private String email;
    private String phone;
    private Point coordinate;
    private Date timestamp;

    
}
