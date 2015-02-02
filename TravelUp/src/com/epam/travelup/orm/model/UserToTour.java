package com.epam.travelup.orm.model;

@DBTable(name = "user_to_tour")
public class UserToTour {
	@DBField(name = "id")
	private int id;
	@DBField(name = "quantity")
	private int quantity;
	@DBKey(name = "user_id")
	private User userId;
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

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "User id: " + this.getUserId() + "Tour id: " + this.getTourId();
	}
}