package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.Tour;

public class ModelCreaterService {
	private final static double COEFFICIENT = 0.6;
	private final static Logger LOGGER = Logger.getLogger("ModelCreaterService ::");
	private List<Tour> models;
	private List<Tour> requestsTours;
	Dao<Tour> dao;

	private Map<String, Integer> newPlaces;

	public ModelCreaterService() {
		requestsTours = TourService.getTourRequests();
		models = new ArrayList<>();
		LOGGER.info(":: finish create object new ModelCreaterService()");
	}

//	 public static void main (String [] args){
//	 System.out.println("===================Start test CreaterModels============");
//	 ModelCreaterService mc = new ModelCreaterService ();
//	 mc.createModels();
//	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Requests count = " + TourService.getTourRequests().size());
//	 System.out.println();
//	 for (Tour t: TourService.getTourRequests()){
//		 System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		 System.out.println(t.toString());
//	 }
//	 System.out.println();
//	 for (Tour model : mc.models){
//	 System.out.println("=========================================================================");
//	 System.out.println("MODEL : " + model.toString() + ", countRequests = "
//	 + model.getCountRequests());
//	 }
//	 }

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
		List<Double> marks = new ArrayList<>();
		marks.add(comparissonByPlaces(curentTour, tour));
		marks.add(comparissonByPrice(curentTour, tour));
		marks.add(comparissonByDuration(curentTour, tour));
		marks.add(comparissonByData(curentTour, tour));
		marks.add(comparissonByCapacity(curentTour, tour));

		for (Double mark : marks) {
			result += mark;
		}

		if (result / marks.size() >= COEFFICIENT) {
			return true;
		} else {
			return false;
		}
	}

	private Double comparissonByCapacity(Tour curentTour, Tour tour) {
		return (curentTour.getMinCapacity()+curentTour.getMaxCapacity())*1.0
				/ (tour.getMinCapacity()+tour.getMaxCapacity()) ;
	}

	private Double comparissonByData(Tour t1, Tour t2) {
		
		long t1AverageDurationMiliSecunds = (t1.getMinDuration() + t1.getMaxDuration())/2*24*60*60*1000;
		long t2AverageDurationMiliSecunds = (t2.getMinDuration() + t2.getMaxDuration())/2*24*60*60*1000;
				
		if (t1.getStartDate().after(t2.getStartDate()) 
				&& (t1.getStartDate().getTime()+ t1AverageDurationMiliSecunds) <= t2.getStartDate().getTime()){			
			return 1.;
		}
		if (t2.getStartDate().after(t1.getStartDate()) 
				&& (t2.getStartDate().getTime()+ t2AverageDurationMiliSecunds) <= t1.getStartDate().getTime()){			
			return 1.;
		} else {
			return (t1.getStartDate().getTime()+t1.getEndDate().getTime())*1.0
					/(t2.getStartDate().getTime()+t2.getEndDate().getTime());
		}
		
	}

	private Double comparissonByDuration(Tour curentTour, Tour tour) {		
		return (curentTour.getMinDuration()+curentTour.getMaxDuration())*1.0
				/ (tour.getMinDuration()+tour.getMaxDuration()) ;
	}

	private Double comparissonByPrice(Tour curentTour, Tour tour) {
		return Math.abs(curentTour.getMaxPrice() - tour.getMaxPrice())/curentTour.getMaxPrice();
	}

	private Double comparissonByPlaces(Tour curentTour, Tour tour) {
		double match = 0;
		for (Place places : curentTour.getPlaces()) {
			if (tour.getPlaces().contains(places)) {
				match++;
			}
		}
		return match / curentTour.getPlaces().size();
	}

}
