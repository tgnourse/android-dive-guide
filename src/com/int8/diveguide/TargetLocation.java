package com.int8.diveguide;

import android.location.Location;

public class TargetLocation extends Location {
	private String name;
	private int color;
	
	public TargetLocation(String name, int color, double latitude, double longitude) {
		super("TargetLocation");
		
		this.name = name;
		this.color = color;
		super.setLatitude(latitude);
		super.setLongitude(longitude);
	}
	
	public String getName() {
		return name;
	}
	
	public int getColor() {
		return color;
	}
}
