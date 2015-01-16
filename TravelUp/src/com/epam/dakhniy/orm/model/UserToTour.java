package com.epam.dakhniy.orm.model;


@DBTable(name = "user_to_tour")
public class UserToTour {

	@DBField(name = "id")
	private int id;

	@DBKey(name = "user_id")
	private User userId;

	@DBDictionaryField(name = "role")
	@DBField(name = "role_id")
	private String role;

	@DBKey(name = "tour_id")
	private Tour tourId;

	public UserToTour() {

	}
	
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRoleId(String role) {
		this.role = role;
	}

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	@Override
	public String toString() {
		return "User id: " + this.getUserId() + "\n" + "Role id: "
				+ this.getRole() + "\n" + "Tour id: " + this.getTourId();
	}
}
