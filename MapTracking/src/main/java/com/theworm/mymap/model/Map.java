package com.theworm.mymap.model;

public class Map {
	private int mapid;
	private String name;
	private String longitude;
	private String latitude;
	
	public Map() {
		super();
	}

	public Map(int mapid, String name, String longitude, String latitude) {
		super();
		this.mapid = mapid;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getMapid() {
		return mapid;
	}

	public void setMapid(int mapid) {
		this.mapid = mapid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Map [mapid=" + mapid + ", name=" + name + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}
	
	
}
