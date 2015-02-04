package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceInfo;
import com.epam.travelup.orm.model.PlaceToRoute;
import com.epam.travelup.orm.model.Region;

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

	public static List<Place> getPlacesWhere(String attr, String value, String lang){
		Dao<Place> dao = new Dao<Place>(Place.class, lang);
		List<Place> places = dao.selectWhere(attr, value, "=");
		return fillTourInformation(places, lang);
	}

	public static Place getPlaceByName(String name){
		Dao<PlaceInfo> nameDao = new Dao<PlaceInfo>(PlaceInfo.class, "en");
		List<String> attrs = new ArrayList<String>();
		attrs.add("ua_place_name");
		attrs.add("en_place_name");
		List<String> values = new ArrayList<String>();
		values.add(name);
		values.add(name);
		PlaceInfo placeInfo = nameDao.selectWhereOr(attrs, values, "=").get(0);
		Dao<Place> dao = new Dao<Place>(Place.class, "en");
		Place place = dao.selectWhere("info_id", placeInfo.getId()+"", "=").get(0);
		return place;
	}

	private static List<Place> fillTourInformation(List<Place> places, String lang){
		for(Place curPlace: places){
			curPlace.setPhotos(PhotoService.getPhotosForPlace(curPlace.getId(), lang));
		}
		return places;
	}
	
	public static void updatePlaceInfo(String id, String attr, String value){
		Dao<Place> dao = new Dao<Place>(Place.class,"en");
		dao.update("id", id	, attr, value);
	}
	
	public static int countPlaces(){
		Dao<Place> dao = new Dao<Place>(Place.class,"en");
		return dao.count();
	}
	
	public static void insertPlace(Place place){
		System.out.println(place);
		new Dao<Place>(Place.class,"en").insert(place);
	}
	
	public static void insertPlaceInfo(PlaceInfo placeInfo){
		new Dao<PlaceInfo>(PlaceInfo.class,"en").insert(placeInfo);
	}
	
}
