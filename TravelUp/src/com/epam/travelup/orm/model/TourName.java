package com.epam.travelup.orm.model;
@DBTable(name="tour_name")
public class TourName {
	@DBField(name="id")
	private int id;
	@DBField(name="ua_tour_name")
	private String uaName;
	@DBField(name="en_tour_name")
	private String enName;
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
	
	public String getName(String lang){
		String name = null;
		if(lang.equals("ua")){
			name = this.getUaName();
		} else if(lang.equals("en")){
			name = this.getEnName();
		}
		return name;
	}
	
	@Override
	public String toString() {
		return "TourName [id=" + id + ", uaName=" + uaName + ", enName="
				+ enName + "]";
	}
	
}
