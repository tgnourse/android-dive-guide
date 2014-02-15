package com.int8.diveguide;

import android.graphics.Color;
import android.location.Location;

public class PersistentTargetLocation extends Location {
	// The persistent location that's being used to store the information about this physical location.
	private PersistentLocation persistentLocation;

	public PersistentTargetLocation(PersistentLocation location) {
		super("PersistentTargetLocation");
		this.persistentLocation = location;
		// Need to also set the longitude and latitude for the parent location.
		super.setLatitude(PersistentTargetLocation.convertToDouble(location.latitude));
		super.setLongitude(PersistentTargetLocation.convertToDouble(location.longitude));
	}
	
	public PersistentTargetLocation(String name, double latitude, double longitude) {
		super("PersistentTargetLocation");
		super.setLatitude(latitude);
		super.setLongitude(longitude);
		// Create a new persistent location.
		this.persistentLocation = new PersistentLocation(name, PersistentTargetLocation.convertToLong(latitude),
				PersistentTargetLocation.convertToLong(longitude));
	}

	private static long convertToLong(double coordinate) {
		return Double.doubleToLongBits(coordinate);
	}
	
	private static double convertToDouble(long coordinate) {
		return Double.longBitsToDouble(coordinate);
	}

	public void setLatitude(long latitude) {
		super.setLatitude(latitude);
		// Set the location in the ORM object too.
		persistentLocation.setLatitude(PersistentTargetLocation.convertToLong(latitude));
	}
	
	public void setLongitude(double longitude) {
		super.setLatitude(longitude);
		// Set the location in the ORM object too.
		persistentLocation.setLongitude(PersistentTargetLocation.convertToLong(longitude));
	}
	
	public PersistentLocation getPersistentLocation() {
		return persistentLocation;
	}
	
	public int getColor() {
		// TODO(tgnourse): Calculate color somehow consistently with a reasonable set of mostly non repeating colors.
		// right now this just defaults to white.
		return Color.rgb(255, 255, 255);
	}
}
