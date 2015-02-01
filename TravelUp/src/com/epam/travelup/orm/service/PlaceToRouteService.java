package com.epam.travelup.orm.service;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.PlaceToRoute;

public class PlaceToRouteService {

	public static int insertPlaceToRoute(PlaceToRoute obj){
		return new Dao<PlaceToRoute>(PlaceToRoute.class,"en").insert(obj);
	}
}
