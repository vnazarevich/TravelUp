package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.Tour;

public class ModelCreaterService {
	private final static double COEFFICIENT = 0.6;
	private List<Tour> models;
	private List<Tour> requestsTours;
	Dao<Tour> dao;

	private Map<String, Integer> newPlaces;

	public ModelCreaterService() {
		requestsTours = TourService.getTourRequests();
		models = new ArrayList<>();
	}

	// public static void main (String [] args){
	// System.out.println("===================Start test============");
	// ModelCreater mc = new ModelCreater ();
	// mc.createModels();
	// for (Tour model : mc.models){
	// System.out.println("=========================================================================");
	// System.out.println("MODEL : " + model.getPlaces() + ", countRequests = "
	// + model.getCountRequests());
	// }
	// }

	public void createModels() {
		List<Tour> simpleTours = new ArrayList<Tour>();

		for (int i = 0; i < requestsTours.size(); i++) {
			Tour curentTour = requestsTours.get(i);
			simpleTours.clear();
			simpleTours.add(curentTour);

			for (Tour tour : requestsTours) {
				if (isCurentTourlikeTour(curentTour, tour)) {
					simpleTours.add(tour);
				}
			}
			models.add(createModel(simpleTours));
		}
		saveModels();
	}

	private void saveModels() {
		dao = new Dao<Tour>(Tour.class, "en");
		for (Tour model : models) {
			dao.insert(model);
		}
	}

	private Tour createModel(List<Tour> simpleTours) {
		Tour model = new Tour();
		Map<Place, Integer> places = new HashMap<>();
		int minCapacity = 0;
		int maxCapacity = 0;
		int minDuration = 0;
		int maxDuration = 0;
		int maxPricePerDay = 0;
		int tripId = 0;

		for (Tour tour : simpleTours) {
			minCapacity += tour.getMinCapacity();
			maxCapacity += tour.getMaxCapacity();
			minDuration += tour.getMinDuration();
			maxDuration += tour.getMaxDuration();
			maxPricePerDay += tour.getMaxPrice() / maxDuration;
			tripId += tour.getTripId();

			for (Place place : tour.getPlaces()) {
				if (places.containsKey(place)) {
					places.put(place, places.get(place) + 1);
				} else {
					places.put(place, 0);
				}
			}
		}
		for (Place place : places.keySet()) {
			if (places.get(place) == 1) {
				places.remove(place);
			}
		}
		model.setPlaces(new ArrayList(places.keySet()));
		model.setMinCapacity(minCapacity / simpleTours.size());
		model.setMaxCapacity(maxCapacity / simpleTours.size());
		model.setMinDuration(minDuration / simpleTours.size());
		model.setMaxDuration(maxDuration / simpleTours.size());
		model.setMaxPrice(maxPricePerDay * maxDuration / simpleTours.size());
		model.setTripId(tripId / simpleTours.size());
		model.setCountRequests(simpleTours.size());

		return model;
	}

	private boolean isCurentTourlikeTour(Tour curentTour, Tour tour) {
		int result = 0;
		List<Integer> marks = new ArrayList<>();
		marks.add(comparissonByPlaces(curentTour, tour));
		marks.add(comparissonByPrice(curentTour, tour));
		// marks.add(comparissonByPlaces(curentTour, tour));
		// marks.add(comparissonByPlaces(curentTour, tour));
		// marks.add(comparissonByPlaces(curentTour, tour));

		for (Integer mark : marks) {
			result += mark;
		}

		if (result / marks.size() >= COEFFICIENT) {
			return true;
		} else {
			return false;
		}
	}

	private Integer comparissonByPrice(Tour curentTour, Tour tour) {
		int delta;
		if (curentTour.getMinPrice() < tour.getMaxPrice()
				|| tour.getMinPrice() < curentTour.getMaxPrice()) {
			// delta = curentTour.getMinPrice() < tour.getMaxPrice()
			return (int) COEFFICIENT;
		}
		return 0;
	}

	private Integer comparissonByPlaces(Tour curentTour, Tour tour) {
		int match = 0;
		for (Place places : curentTour.getPlaces()) {
			if (tour.getPlaces().contains(places)) {
				match++;
			}
		}
		if (match == 0) {
			return 0;
		}
		return match / curentTour.getPlaces().size();
	}

}
