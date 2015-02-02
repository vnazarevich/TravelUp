package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;
import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Cart;
import com.epam.travelup.orm.model.Tour;

public class CartService {
	public static List<Cart> getCart(String userId, String language) {
		Dao<Cart> dao = new Dao<Cart>(Cart.class, language);
		List<Cart> orders = dao.selectWhere("user_id", userId, "=");
		for (Cart order : orders) {
			Tour tour = order.getTourId();
			order.setTourId(TourService.fillTourInformation(tour, language));
		}
		return orders;
	}

	public static void payForTour(String userId, String tourId) {
		Dao<Cart> dao = new Dao<Cart>(Cart.class, "en");
		List<String> conditionAttrs = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();
		conditionAttrs.add("user_id");
		conditionAttrs.add("tour_id");
		conditionValues.add(userId);
		conditionValues.add(tourId);
		dao.update(conditionAttrs, conditionValues, "is_paid", "1", "AND");
	}

	public static void deleteOrder(String orderId) {
		Dao<Cart> dao = new Dao<Cart>(Cart.class, "en");
		dao.delete("id", orderId, "=");
	}
}
