package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Comment;
import com.epam.travelup.orm.model.Tour;

public class TourService {

	private static List<Tour> fillTourInformation(List<Tour> tours, String lang){
		for(Tour tour: tours){
			tour.setPlaces(PlaceService.getPlacesForRoute(tour.getRoute_id().getId(), lang));
			tour.setUserCount(UserToTourService.getUserCountByTour(tour.getId()+""));
			if(tour.getMinCapacity()<tour.getUserCount()){
				System.err.println("tour overflow!!!");
			}
		}
		return tours;
	}

	public static Tour fillTourInformation(Tour tour, String lang){
		tour.setPlaces(PlaceService.getPlacesForRoute(tour.getRoute_id().getId(), lang));
		tour.setUserCount(UserToTourService.getUserCountByTour(tour.getId()+""));
		if(tour.getMinCapacity()<tour.getUserCount()){
		System.err.println("tour overflow!!!");
		}
		return tour;
	}

	public static List<Tour> getAllTours(String lang){
		Dao<Tour> dao = new Dao<Tour>(Tour.class, lang);
		List<Tour> tours = dao.selectAll();

		return fillTourInformation(tours, lang);
	}

	public static List<Tour> getTourRequests(){
		Dao<Tour> dao = new Dao<>(Tour.class, "en");
		List<Tour> tours = dao.selectWhere("status_id", "4", "=");

		return fillTourInformation(tours, "en");
	}
	
	public static List<Tour> getTourMackets(){
		Dao<Tour> dao = new Dao<>(Tour.class, "en");
		List<Tour> tours = dao.selectWhere("status_id", "1", "=");

		return fillTourInformation(tours, "en");
	}
	public static List<Tour> getSimpleTours(String lang){
		List<String> attrs = new ArrayList<String>();
		attrs.add("status_id");
		attrs.add("status_id");
		List<String> values = new ArrayList<String>();
		values.add("2");
		values.add("3");
		Dao<Tour> dao = new Dao<Tour>(Tour.class, lang);
		List<Tour> tours = dao.selectWhereOr(attrs, values, "=");


		return fillTourInformation(tours, lang);
	}

	public static List<Tour> getToursWhere(String attr, String value, String lang){
		Dao<Tour> dao = new Dao<Tour>(Tour.class, lang);
		List<Tour> tours = dao.selectWhere(attr, value, "=");
		return fillTourInformation(tours, lang);
	}

	public static int insertTour(Tour tour){
		return new Dao<Tour>(Tour.class,"en").insert(tour);
	}
	
	public static List<Comment> getCommentsForTour(String id, String lang){
				Dao<Comment> dao = new Dao<>(Comment.class, lang);
				List<Comment> comments = dao.selectWhere("tour_id", id, "=");
				System.out.println(comments);
				return comments;
			}
	
	public static void deleteToursWhere(String attr, String value, String lang){
		Dao<Tour> dao = new Dao<Tour>(Tour.class, lang);
		dao.delete(attr, value, "=");
	}

}
