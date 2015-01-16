package com.epam.dakhniy.orm.model;


@DBTable(name = "place")
public class Place {

	@DBField(name = "id")
	private int id;
	
	@DBKey(name="name_id")
	private PlaceName name;

	@DBKey(name="description_id")
	private PlaceDescripion description;

	@DBField(name = "wiki")
	private String wiki;

	@DBField(name = "picture")
	private String picture;

	public Place() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlaceDescripion getDescription() {
		return description;
	}

	public void setDescription(PlaceDescripion description) {
		this.description = description;
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

	public PlaceName getName() {
		return name;
	}

	public void setName(PlaceName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Description: " + this.getDescription() + "\n" + "Wiki: "
				+ this.getWiki() + "\n" + "Picture: " + this.getPicture();
	}
}
