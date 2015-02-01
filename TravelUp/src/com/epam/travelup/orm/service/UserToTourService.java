package com.epam.travelup.orm.service;

import java.util.Iterator;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.UserToTour;

public class UserToTourService {
	public static int getUserCountByTour(String tourId){
		Dao<UserToTour> dao = new Dao<UserToTour>(UserToTour.class, "en");
		List<UserToTour> usersToTour = dao.selectWhere("tour_id", tourId, "=");
		return usersToTour.size();
	}
}
