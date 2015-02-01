package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Cart;
import com.epam.travelup.orm.model.Tour;

public class CartService {
	public static List<Cart> getCart(String userId, String language){
		Dao<Cart> dao = new Dao<Cart>(Cart.class, language);
		List<Cart> orders = dao.selectWhere("user_id", userId, "=");
		for(Cart order:orders){
			Tour tour = order.getTourId();
			tour.setPlaces(PlaceService.getPlacesForRoute(tour.getRoute_id().getId(), language));
		}
		return orders;
	}
}
