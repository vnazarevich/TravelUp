package com.epam.travelup.orm.model;


@DBTable(name = "place")
public class Place {

	@DBField(name = "id")
	private int id;

	@DBKey(name="name_id")
	private PlaceInfo name;

	@DBKey(name="info_id")
	private PlaceInfo info;

	@DBField(name = "wiki")
	private String wiki;

	@DBField(name = "picture")
	private String picture;

	@DBField(name="x_coordinate")
	private String xCoordinate;
	@DBField(name="y_coordinates")
	private String yCoordinate;

	public Place() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlaceInfo getDescription() {
		return info;
	}

	public void setDescription(PlaceInfo description) {
		this.info = description;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public PlaceInfo getName() {
		return name;
	}

	public void setName(PlaceInfo name) {
		this.name = name;
	}

	public PlaceInfo getInfo() {
		return info;
	}


	public void setInfo(PlaceInfo info) {
		this.info = info;
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


	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", info=" + info
				+ ", wiki=" + wiki + ", picture=" + picture + ", xCoordinate="
				+ xCoordinate + ", yCoordinate=" + yCoordinate + "]";
	}


}
