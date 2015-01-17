package com.epam.travelup.orm.model;


@DBTable(name = "detail")
public class Detail {

	@DBKey(name = "cart_id")
	private Cart cartId;

	@DBKey(name = "tour_id")
	private Tour tourId;

	@DBField(name = "quantity")
	private int quantity;

	public Detail() {

	}

	public Detail(Tour tourId, int quantity) {
		super();
		this.tourId = tourId;
		this.quantity = quantity;
	}

	public Detail(Cart cartId, Tour tourId, int quantity) {
		super();
		this.cartId = cartId;
		this.tourId = tourId;
		this.quantity = quantity;
	}

	public Cart getCartId() {
		return cartId;
	}

	public void setCartId(Cart cartId) {
		this.cartId = cartId;
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
		return "Cart Id: " + this.getCartId() + "\n" + "Tour Id: "
				+ this.getTourId() + "\n" + "Quantity: " + this.getQuantity();
	}
}
