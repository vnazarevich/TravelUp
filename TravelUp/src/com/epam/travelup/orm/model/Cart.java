package com.epam.travelup.orm.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@DBTable(name = "cart")
public class Cart {
	@DBField(name = "id")
	private int id;
	@DBKey(name = "user_id")
	private User userId;
	@DBKey(name = "tour_id")
	private Tour tourId;
	@DBField(name = "date")
	private Date date;
	@DBField(name = "is_paid")
	private boolean isPaid;
	@DBField(name = "quantity")
	private int quantity;

	public Cart() {
	}

	private static Comparator<Cart> comparator = new Comparator<Cart>() {
		@Override
		public int compare(Cart o1, Cart o2) {
			if (o1.isPaid && !o2.isPaid) {
				return 1;
			} else if (!o1.isPaid && o2.isPaid) {
				return -1;
			} else {
				return (int) (o2.date.getTime() - o1.date.getTime());
			}
		}
	};

	public static void sortByDate(List<Cart> carts) {
		Collections.sort(carts, comparator);
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

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", tourId=" + tourId
				+ ", date=" + date + ", isPaid=" + isPaid + ", quantity="
				+ quantity + "]";
	}
}