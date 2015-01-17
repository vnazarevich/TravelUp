package com.epam.dakhniy.orm.model;
@DBTable(name="place_info")
public class PlaceInfo {
	@DBField(name="id")
	private int id;
	@DBField(name="ua_place_name")
	private String uaName;
	@DBField(name="en_place_name")
	private String enName;
	@DBField(name="en_place_description")
	private String enDescription;
	@DBField(name="ua_place_description")
	private String uaDescription;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUaName() {
		return uaName;
	}
	public void setUaName(String uaName) {
		this.uaName = uaName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getEnDescription() {
		return enDescription;
	}
	public void setEnDescription(String enDescription) {
		this.enDescription = enDescription;
	}
	public String getUaDescription() {
		return uaDescription;
	}
	public void setUaDescription(String uaDescription) {
		this.uaDescription = uaDescription;
	}
	@Override
	public String toString() {
		return "PlaceInfo [id=" + id + ", uaName=" + uaName + ", enName="
				+ enName + ", enDescription=" + enDescription
				+ ", uaDescription=" + uaDescription + "]";
	}

}
