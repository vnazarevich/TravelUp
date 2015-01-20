package com.epam.travelup.orm.model;
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
	
	public String getName(String lang){
		String name = null;
		if(lang.equals("ua")){
			name = this.getUaName();
		} else if(lang.equals("en")){
			name = this.getEnName();
		}
		return name;
	}
	
	public String getDescription(String lang){
		String desc = null;
		if(lang.equals("ua")){
			desc = this.getUaDescription();
		} else if(lang.equals("en")){
			desc = this.getEnDescription();
		}
		return desc;
	}
	
	@Override
	public String toString() {
		return "PlaceInfo [id=" + id + ", uaName=" + uaName + ", enName="
				+ enName + ", enDescription=" + enDescription
				+ ", uaDescription=" + uaDescription + "]";
	}

}
