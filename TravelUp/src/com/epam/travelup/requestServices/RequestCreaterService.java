package com.epam.travelup.requestServices;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceInfo;
import com.epam.travelup.orm.model.Route;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.service.PlaceInfoService;
import com.epam.travelup.orm.service.PlaceToRouteService;
import com.epam.travelup.orm.service.RouteService;
import com.epam.travelup.orm.service.TourService;
import java.util.logging.Logger;

public class RequestCreaterService {
	private final static Logger LOGGER = Logger.getLogger("RequestCreaterService ::");
	private final static String TOUR_TYPE = "maket";
	private final static String TRANSPORT = "undefined";
	private final static String TRIP_DAY = "no matter";
	private final static String STATUS = "request";

	public static void createRequest(Tour requestTour, String[] places) {
		LOGGER.info("start createRequest");
		Route route = createRoute();
		RouteService.insertRoute(route);
		TourService.insertTour(fillingTour(requestTour, route));
		PlaceToRouteService.insertListPlaceToRoute(route, createPlaceToRout(places));
		
		
	}

	private static Route createRoute() {
		Route route = new Route();
		route.setRegion("Carpathians");
		return route;
	}

	private static Tour fillingTour(Tour requestTour, Route route) {
		requestTour.setRoute(route);
		requestTour.setStatusId(TOUR_TYPE);
		requestTour.setTripDays(TRIP_DAY);
		requestTour.setStatusId(STATUS);
		requestTour.setTransport(TRANSPORT);
		return requestTour;
	}
	
	private static List<Place> createPlaceToRout(String[] places){
		List<Place> result = new ArrayList<>();
		List<String> nameEnUa = new ArrayList<>();;
		PlaceInfo placeInfo;
		List<Place> allPlaces = new ArrayList<>();
		
		for (String placeName: places){
			
			for (Place temp: allPlaces){
				nameEnUa.add(temp.getInfo().getEnName());
				nameEnUa.add(temp.getInfo().getUaName());
				
				if(nameEnUa.contains(placeName)){
					result.add(temp);
					nameEnUa.clear();
					break;
				}
			}
		}		
		return allPlaces;		
	}

}
