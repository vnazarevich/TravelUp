package com.epam.dakhniy.orm.model;

import java.util.Date;

@DBTable(name = "comment")
public class Comment {

	@DBField(name = "id")
	private int id;

	@DBKey(name = "tour_id")
	private Tour tourId;

	@DBKey(name = "user_id")
	private User userId;

	@DBField(name = "text")
	private String text;

	@DBField(name = "date")
	private Date date;

	public Comment() {

	}

	public Comment(Tour tourId, User userId, String text, Date date) {
		super();
		this.tourId = tourId;
		this.userId = userId;
		this.text = text;
		this.date = date;
	}

	public Comment(int id, Tour tourId, User userId, String text, Date date) {
		super();
		this.id = id;
		this.tourId = tourId;
		this.userId = userId;
		this.text = text;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Tour id: " + this.getTourId() + "\n" + "User id: "
				+ this.getUserId() + "\n" + "Text: " + this.getText() + "\n"
				+ "Date: " + this.getDate();
	}
}
