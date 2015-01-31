package com.epam.travelup.orm.model;


@DBTable(name = "route")
public class Route {

	@DBField(name = "id")
	private int id;

	@DBDictionaryField(name = "region")
	@DBField(name = "region_id")
	private String region;	

	@DBField(name = "min_duration")
	private double minDuration;

	@DBField(name = "max_duration")
	private double maxDuration;

	public Route() {

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}	

	public double getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(double minDuration) {
		this.minDuration = minDuration;
	}

	public double getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(double maxDuration) {
		this.maxDuration = maxDuration;
	}


	@Override
	public String toString() {
		return "Route [id=" + id + ", region=" + region + ", minDuration="
				+ minDuration + ", maxDuration=" + maxDuration + "]";
	}

	
}
