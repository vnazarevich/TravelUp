package com.epam.travelup.orm.model;

import java.util.List;


@DBTable(name = "place")
public class Place {

	@DBField(name = "id")
	private int id;

	@DBKey(name="info_id")
	private PlaceInfo info;
	
	@DBKey(name="type_id")
	private PlaceType type;

	@DBKey(name="region_id")
	private Region region;

	@DBField(name="x_coordinate")
	private String xCoordinate;
	
	@DBField(name="y_coordinate")
	private String yCoordinate;
	
	List<Photo> photos;

	public Place() {
	}

	public PlaceType getType() {
		return type;
	}

	public void setType(PlaceType type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public PlaceInfo getInfo() {
		return info;
	}

	public void setInfo(PlaceInfo info) {
		this.info = info;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
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
		return "";
//		return "Place [id=" + id + ", info=" + info + ", type=" + type
//				+ ", region=" + region + ", xCoordinate=" + xCoordinate
//				+ ", yCoordinate=" + yCoordinate + ", photos=" + photos + "]";
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
