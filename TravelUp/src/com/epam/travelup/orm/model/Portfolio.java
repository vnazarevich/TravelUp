package com.epam.travelup.orm.model;


@DBTable(name = "portfolio")
public class Portfolio {

	@DBField(name = "id")
	private int id;


	@DBField(name = "description")
	private String description;

	@DBField(name = "is_photographer")
	private boolean isPhotographer;

	@DBField(name = "is_carrier")
	private boolean isCarrier;

	@DBField(name = "is_guide")
	private boolean isGuide;

	public Portfolio() {

	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPhotographer() {
		return isPhotographer;
	}

	public void setPhotographer(boolean isPhotographer) {
		this.isPhotographer = isPhotographer;
	}

	public boolean isCarrier() {
		return isCarrier;
	}

	public void setCarrier(boolean isCarrier) {
		this.isCarrier = isCarrier;
	}

	public boolean isGuide() {
		return isGuide;
	}

	public void setGuide(boolean isGuide) {
		this.isGuide = isGuide;
	}





	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", description=" + description
				+ ", isPhotographer=" + isPhotographer + ", isCarrier="
				+ isCarrier + ", isGuide=" + isGuide + "]";
	}


}
