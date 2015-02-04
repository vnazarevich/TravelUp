package com.epam.travelup.orm.service;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceToRoute;
import com.epam.travelup.orm.model.Route;

public class PlaceToRouteService {

	public static int insertPlaceToRoute(PlaceToRoute obj){
		return new Dao<PlaceToRoute>(PlaceToRoute.class,"en").insert(obj);
	}

	public static void insertListPlaceToRoute(Route route, List<Place> places) {
		for(Place place: places){
			PlaceToRoute ptr = new PlaceToRoute();
			ptr.setPlaceId(place);
			ptr.setRouteId(route);
			insertPlaceToRoute(ptr);
		}
		
	}
}
