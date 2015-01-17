package com.epam.travelup.orm.model;


@DBTable(name = "portfolio")
public class Portfolio {

	@DBField(name = "id")
	private int id;

	@DBKey(name = "user_id")
	private User userId;

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

	public Portfolio(User userId, String description, boolean isPhotographer,
			boolean isCarrier, boolean isGuide) {
		super();
		this.userId = userId;
		this.description = description;
		this.isPhotographer = isPhotographer;
		this.isCarrier = isCarrier;
		this.isGuide = isGuide;
	}

	public Portfolio(int id, User userId, String description,
			boolean isPhotographer, boolean isCarrier, boolean isGuide) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.isPhotographer = isPhotographer;
		this.isCarrier = isCarrier;
		this.isGuide = isGuide;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
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

	public String toString() {
		return "User id: " + this.getUserId() + "\n" + "Description"
				+ this.getDescription() + "\n" + "Is photographer: "
				+ this.isPhotographer() + "\n" + "Is carrier: "
				+ this.isCarrier() + "\n" + "Is guide: " + this.isGuide();
	}
}
