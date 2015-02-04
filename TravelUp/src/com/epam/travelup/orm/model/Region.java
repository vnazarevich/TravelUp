package com.epam.travelup.orm.model;
@DBTable(name="region")
public class Region {

	@DBField(name="id")
	private int id;
	@DBField(name="ua_region")
	private String uaRegion;
	@DBField(name="en_region")
	private String enRegion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUaRegion() {
		return uaRegion;
	}
	public void setUaRegion(String uaRegion) {
		this.uaRegion = uaRegion;
	}
	public String getEnRegion() {
		return enRegion;
	}
	public void setEnRegion(String enRegion) {
		this.enRegion = enRegion;
	}
	@Override
	public String toString() {
		return "Region [id=" + id + ", uaRegion=" + uaRegion + ", enRegion="
				+ enRegion + "]";
	}
	
	
}
