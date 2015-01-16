package com.epam.dakhniy.orm.model;
@DBTable(name="place_description")
public class PlaceDescripion {
	@DBField(name="id")
	private int id;
	@DBField(name="ua_place_description")
	private String uaDescription;
	@DBField(name="en_place_description")
	private String enDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUaDescription() {
		return uaDescription;
	}
	public void setUaDescription(String uaDescription) {
		this.uaDescription = uaDescription;
	}
	public String getEnDescription() {
		return enDescription;
	}
	public void setEnDescription(String enDescription) {
		this.enDescription = enDescription;
	}
	@Override
	public String toString() {
		return "PlaceDescripion [id=" + id + ", uaDescription=" + uaDescription
				+ ", enDescription=" + enDescription + "]";
	}
}
