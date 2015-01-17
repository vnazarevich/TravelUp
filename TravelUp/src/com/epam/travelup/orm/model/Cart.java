package com.epam.travelup.orm.model;

import java.util.Date;

@DBTable(name = "cart")
public class Cart {

	@DBField(name = "id")
	private int id;

	@DBKey(name = "user_id")
	private User userId;

	@DBKey(name = "admin_id")
	private User adminId;

	@DBField(name = "date")
	private Date date;

	@DBField(name = "is_paid")
	private boolean isPaid;

	@DBField(name = "is_confirmed")
	private boolean isConfirmed;

	public Cart() {

	}

	public Cart(User userId, User adminId, Date date, boolean isPaid,
			boolean isConfirmed) {
		super();
		this.userId = userId;
		this.adminId = adminId;
		this.date = date;
		this.isPaid = isPaid;
		this.isConfirmed = isConfirmed;
	}

	public Cart(int id, User userId, User adminId, Date date, boolean isPaid,
			boolean isConfirmed) {
		super();
		this.id = id;
		this.userId = userId;
		this.adminId = adminId;
		this.date = date;
		this.isPaid = isPaid;
		this.isConfirmed = isConfirmed;
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

	public User getAdminId() {
		return adminId;
	}

	public void setAdminId(User adminId) {
		this.adminId = adminId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	@Override
	public String toString() {
		return "User Id: " + this.getUserId() + "\n" + "Admin Id: "
				+ this.getAdminId() + "\n" + "Date: " + this.getDate() + "\n"
				+ "Is Paid: " + this.isPaid() + "\n" + "Is Confirmed: "
				+ this.isConfirmed();
	}
}
