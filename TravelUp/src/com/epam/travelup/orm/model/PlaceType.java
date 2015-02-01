package com.epam.travelup.orm.model;
@DBTable(name="place_type")
public class PlaceType {

	@DBField(name="id")
	private int id;
	@DBField(name="ua_type")
	private String uaType;
	@DBField(name="en_type")
	private String enType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUaType() {
		return uaType;
	}

	public void setUaType(String uaType) {
		this.uaType = uaType;
	}

	public String getEnType() {
		return enType;
	}

	public void setEnType(String enType) {
		this.enType = enType;
	}

	public String getType(String lang){
		String type = null;
		if(lang.equals("ua")){
			type = this.getUaType();
		} else if(lang.equals("en")){
			type = this.getEnType();
		}
		return type;
	}
	
	@Override
	public String toString() {
		return "";
//		return "PlaceType [id=" + id + ", uaType=" + uaType + ", enType="
//				+ enType + "]";
	}
}
