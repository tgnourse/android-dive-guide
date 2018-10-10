package com.int8.diveguide;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "locations")
public class PersistentLocation {
	
    @Override
	public String toString() {
		return "PersistentLocation [id=" + id + ", name=" + name +
				", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	@DatabaseField(generatedId = true)
    public int id;
 
    @DatabaseField
    public String name;
    
    @DatabaseField
    public long longitude;
    
    @DatabaseField
    public long latitude;
    
    // TODO(tgnourse): Add a timestamp field.

	public PersistentLocation() {
		// ORMLite needs a no argument constructor.
	}
	
	public PersistentLocation(String name, long latitude, long longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
}
