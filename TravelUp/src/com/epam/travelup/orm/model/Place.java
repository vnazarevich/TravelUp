package com.epam.travelup.orm.model;

import java.util.List;


@DBTable(name = "place")
public class Place {

	@DBField(name = "id")
	private int id;

	@DBKey(name="info_id")
	private PlaceInfo info;
	
	@DBField(name="type_id")
	private int type;

	@DBField(name="region_id")
	private int region;

	@DBField(name="x_coordinate")
	private String xCoordinate;
	
	@DBField(name="y_coordinate")
	private String yCoordinate;
	
	List<Photo> photos;

	public Place() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public PlaceInfo getInfo() {
		return info;
	}

	public void setInfo(PlaceInfo info) {
		this.info = info;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public String getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public String getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", info=" + info + ", type=" + type
				+ ", region=" + region + ", xCoordinate=" + xCoordinate
				+ ", yCoordinate=" + yCoordinate + ", photos=" + photos + "]";
	}

	
}
