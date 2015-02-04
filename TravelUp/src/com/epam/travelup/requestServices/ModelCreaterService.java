package com.epam.travelup.requestServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceToRoute;
import com.epam.travelup.orm.model.RequestToModel;
import com.epam.travelup.orm.model.Route;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.service.PlaceToRouteService;
import com.epam.travelup.orm.service.RequestToModelServices;
import com.epam.travelup.orm.service.RouteService;
import com.epam.travelup.orm.service.TourService;

public class ModelCreaterService {
	private final static double COEFFICIENT = 0.6;
	private final static Logger LOGGER = Logger.getLogger("ModelCreaterService ::");
	private final String TOUR_TYPE = "maket";
	private final String TRANSPORT = "undefined";
	private List<Tour> models;
	private List<Tour> requestsTours;

	private Map<String, Integer> newPlaces;

	public ModelCreaterService() {
		requestsTours = TourService.getTourRequests();
		models = new ArrayList<>();
		LOGGER.info(":: finish create object new ModelCreaterService()");
	}

//	public static void main(String[] args) {
//		System.out.println("===================Start test CreaterModels============");
//		ModelCreaterService mc = new ModelCreaterService();
//		System.out.println("===================After creating CreaterModels============");
//		mc.createModels();
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Requests count = "+ mc.requestsTours.size());
//		System.out.println();
//		for (Tour t : mc.requestsTours) {
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//			System.out.println(t.toString());
//		}
//		System.out.println();
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Models count = " + mc.models.size());
//		System.out.println();
//		List<Tour> list = TourService.getToursWhere("status_id", "1", "en");
//		for (Tour model : list) {
//			System.out.println("=========================================================================");
//			System.out.println("MODEL : " + model.toString()+ ", countRequests = " + model.getCountRequests());
//		}
//	}

	public void createModels() {
		LOGGER.info("start createModels()");
		// include tours like curentTour -> create 1 model
		List<Tour> simpleTours = new ArrayList<Tour>();
		Tour curentTour;
		for (int i = 0; i < requestsTours.size(); i++) {
			curentTour = requestsTours.get(i);
			simpleTours.clear();
			simpleTours.add(curentTour);

			for (Tour tour : requestsTours) {
				if (isCurentTourlikeTour(curentTour, tour)) {
					simpleTours.add(tour);
				}
			}
			System.out.println("SimpleTour size = " + simpleTours.size());
			models.add(createModel(simpleTours));
		}
			saveModels();	
	}

	private void saveModels() {
		LOGGER.info("start saveModels()");
		int i = 1;
		Integer modelId;
		for (Tour model : models) {
			System.out.println("********************************** Insert in DB model number " + i++);
			modelId = TourService.insertTour(model);
			
			// set in DB requestToModel
			RequestToModel requestToModel = new RequestToModel();			
			
			for (Tour request: model.getRequests()){
				requestToModel.setRequest(request);
//				requestToModel.setModel(model);
 
				requestToModel.setModel((TourService.getToursWhere("id", modelId+"", "en")).get(0));
				RequestToModelServices.insertRequestToModel(requestToModel);
			}			
		}
	}

	private Tour createModel(List<Tour> simpleTours) {
		LOGGER.info("start createModel by simpleTours");
		Tour model = new Tour();
		Set<Tour> requests = new HashSet<>();
		
		// Key - Place, V - count 
		Map<Place, Integer> places = new HashMap<>();
		// contain places which have more than one tour
		Map<Place, Integer> placesPopular = new HashMap<>();
		
		int minCapacity = 0;
		int maxCapacity = 0;
		int minDuration = 0;
		int maxDuration = 0;
		int maxPricePerDay = 0;
		long startDataLong = 0;
		long endDateLong = 0;
		Date startData = new Date();
		Date endDate = new Date();
		int tripId = 0;

		for (Tour tour : simpleTours) {
			requests.add(tour);
			minCapacity += tour.getMinCapacity();
			maxCapacity += tour.getMaxCapacity();
			minDuration += tour.getMinDuration();
			maxDuration += tour.getMaxDuration();
			maxPricePerDay += tour.getMaxPrice() / maxDuration;
			tripId += tour.getTripId();
			startDataLong += tour.getStartDate().getTime();
			endDateLong += tour.getEndDate().getTime();
			for (Place place : tour.getPlaces()) {
				if (places.containsKey(place)) {
					places.put(place, places.get(place) + 1);
				} else {
					places.put(place, 0);
				}
			}
		}
		 
		// remove unique places
         
		Iterator iterator = places.keySet().iterator();
		while (iterator.hasNext()){
			if(places.get(iterator.next()) == 1){
				iterator.remove();
			}
		}
		Route route = new Route();
		route.setRegion("Carpathians");
		Integer routeId = RouteService.insertRoute(route);
		
		//get this route, with id
		System.out.println("******************** " + "RouteService.getRouteWhere(id, routeId.toString(), en) == null" + RouteService.getRouteWhere("id", routeId.toString(), "en") == null);
		route = RouteService.getRouteWhere("id", routeId.toString(), "en").get(0);
		
		PlaceToRoute placeToRoute = new PlaceToRoute();
		for (Place place: places.keySet()){
			placeToRoute.setPlaceId(place);
			placeToRoute.setRouteId(route);
			PlaceToRouteService.insertPlaceToRoute(placeToRoute);
		}
		
		model.setRoute_id(route);
		model.setMinCapacity(minCapacity / simpleTours.size());
		model.setMaxCapacity(maxCapacity / simpleTours.size());
		model.setMinDuration(minDuration / simpleTours.size());
		model.setMaxDuration(maxDuration / simpleTours.size());
		model.setMaxPrice(maxPricePerDay * maxDuration / simpleTours.size());
		model.setTripId(tripId / simpleTours.size());
		model.setCountRequests(simpleTours.size());
		model.setStartDate(new java.sql.Date(startDataLong / simpleTours.size()));
		model.setEndDate(new java.sql.Date(endDateLong / simpleTours.size()));
		model.setStatusId(TOUR_TYPE);
		model.setTransport(TRANSPORT);
		model.setRequests(requests);
		return model;
	}

	private boolean isCurentTourlikeTour(Tour curentTour, Tour tour) {
		double result = 0;
		List<Double> marks = new ArrayList<>();
		if (comparissonByPlaces(curentTour, tour) < COEFFICIENT){
			return false;
		}
		
		marks.add(comparissonByPlaces(curentTour, tour));
		marks.add(comparissonByPrice(curentTour, tour));
		marks.add(comparissonByDuration(curentTour, tour));
		marks.add(comparissonByData(curentTour, tour));
		marks.add(comparissonByCapacity(curentTour, tour));
		System.out.println("**********  MARKS  ****************");
		System.out.println("tour id = " + curentTour.getId());
		for (Double mark : marks) {
			result += mark;
			System.out.println("mark = " + mark);
		}
		System.out.println("RESULT = " + result / marks.size());
		if (result / marks.size() >= COEFFICIENT) {
			return true;
		} else {
			return false;
		}
	}

	private Double comparissonByCapacity(Tour curentTour, Tour tour) {
		return (curentTour.getMinCapacity() + curentTour.getMaxCapacity())
				* 1.0 / (tour.getMinCapacity() + tour.getMaxCapacity());
	}

	private Double comparissonByData(Tour t1, Tour t2) {

		long t1AverageDurationMiliSecunds = (t1.getMinDuration() + t1
				.getMaxDuration()) / 2 * 24 * 60 * 60 * 1000;
		long t2AverageDurationMiliSecunds = (t2.getMinDuration() + t2
				.getMaxDuration()) / 2 * 24 * 60 * 60 * 1000;

		if (t1.getStartDate().after(t2.getStartDate())
				&& (t1.getStartDate().getTime() + t1AverageDurationMiliSecunds) <= t2
						.getStartDate().getTime()) {
			return 1.;
		}
		if (t2.getStartDate().after(t1.getStartDate())
				&& (t2.getStartDate().getTime() + t2AverageDurationMiliSecunds) <= t1
						.getStartDate().getTime()) {
			return 1.;
		} else {
			return (t1.getStartDate().getTime() + t1.getEndDate().getTime())
					* 1.0
					/ (t2.getStartDate().getTime() + t2.getEndDate().getTime());
		}

	}

	private Double comparissonByDuration(Tour curentTour, Tour tour) {
		return (curentTour.getMinDuration() + curentTour.getMaxDuration())
				* 1.0 / (tour.getMinDuration() + tour.getMaxDuration());
	}

	private Double comparissonByPrice(Tour curentTour, Tour tour) {
		return Math.abs(curentTour.getMaxPrice() - tour.getMaxPrice())
				/ curentTour.getMaxPrice();
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
