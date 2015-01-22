package com.epam.travelup.orm.service;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Tour;

public class TourService {

	public static List<Tour> getTours(String lang){
		Dao<Tour> dao = new Dao<Tour>(Tour.class, lang);
		List<Tour> tours = dao.selectAll();
		
		for(Tour tour: tours){
			tour.setPlaces(PlaceService.getPlacesForRoute(tour.getRoute_id().getId(), lang));
		}
		return tours;
	}
	
	public static List<Tour> getToursWhere(String attr, String value, String lang){
		Dao<Tour> dao = new Dao<Tour>(Tour.class, lang);
		List<Tour> tours = dao.selectWhere(attr, value, "=");
		return tours;
	}
	public static void insertTour(Tour tour){
		new Dao<Tour>(Tour.class,"en").insert(tour);
	}
}
