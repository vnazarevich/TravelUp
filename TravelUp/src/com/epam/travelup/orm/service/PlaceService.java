package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceToRoute;

public class PlaceService {

	public static List<Place> getPlacesForRoute(int id, String lang) {
		Dao<PlaceToRoute> dao = new Dao<PlaceToRoute>(PlaceToRoute.class, lang);
		Dao<Place> dao2 = new Dao<Place>(Place.class, lang);
		String routeId = new Integer(id).toString();
		List<Place> allPlaces = dao2.selectAll();

		List<PlaceToRoute> selectedPlaces = dao.selectWhere("route_id", routeId, "=");
		List<Place> placesForRoute = new ArrayList<Place>();
		for (PlaceToRoute selectedPlace : selectedPlaces) {
			placesForRoute.add(allPlaces.get(selectedPlace.getPlaceId().getId() - 1));
		}
		for(Place curPlace: placesForRoute){
			curPlace.setPhotos(PhotoService.getPhotosForPlace(curPlace.getId(), lang));
		}
		return placesForRoute;
	}

	public static List<Place> getAll(String lang){
		Dao<Place> dao = new Dao<Place>(Place.class, lang);
		List<Place> places = dao.selectAll();
		return places;
	}
}
