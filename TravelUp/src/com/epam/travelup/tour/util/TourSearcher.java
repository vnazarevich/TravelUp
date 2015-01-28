package com.epam.travelup.tour.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.service.TourService;

public class TourSearcher {

	public static List<Tour> search(String input, Date startDate, Date endDate,
			int minPrice, int maxPrice, int minDuration, int maxDuration,
			String dayType, boolean isRegion1, boolean isRegion2) {

		List<Tour> tours = TourService.getSimpleTours(LanguageContainer
				.getBundle().getLocale().getLanguage());
		List<Tour> filteredTours = new ArrayList<Tour>();

		for (Tour tour : tours) {
			Pattern p = Pattern.compile(input.toLowerCase());
			Matcher m1 = p.matcher(tour.getName().getEnName().toLowerCase());
			Matcher m2 = p.matcher(tour.getName().getUaName().toLowerCase());
			for (Place place : tour.getPlaces()) {
				Matcher m3 = p.matcher(place.getInfo().getEnName()
						.toLowerCase());
				Matcher m4 = p.matcher(place.getInfo().getUaName()
						.toLowerCase());
				if (m1.find() || m2.find() || m3.find() || m4.find()) {
					filteredTours.add(tour);
					break;
				}
			}
		}

		if (startDate != null || endDate != null) {
			filteredTours = fiterByDates(filteredTours, startDate, endDate);
		}

		filteredTours = filterByPrice(filteredTours, minPrice, maxPrice);

		if (minDuration != 0) {
			filteredTours = filterByDuration(filteredTours, minDuration,
					maxDuration);
		}
		
		if(!dayType.equals("")){
			filteredTours = filterByDayType(filteredTours, dayType);
		}

		// if(isRegion1){
		// filteredTours = filterRegion1(filteredTours);
		// }

		return filteredTours;
	}

	private static List<Tour> filterByDayType(List<Tour> tours,
			String dayType) {
		for (int i = 0; i < tours.size();) {
			if (tours.get(i).getTripDays().equals(dayType)) {
				i++;
			} else {
				tours.remove(i);
			}
		}
		
		return tours;
	}

	private static List<Tour> filterByDuration(List<Tour> tours,
			int minDuration, int maxDuration) {
		if (minDuration == maxDuration) {
			for (int i = 0; i < tours.size();) {
				if (tours.get(i).getMinDuration() != minDuration) {
					tours.remove(i);
				} else {
					i++;
				}
			}
		} else {
			for (int i = 0; i < tours.size();) {
				if (tours.get(i).getMinDuration() >= minDuration && tours.get(i).getMinDuration() <= maxDuration) {
					i++;
				} else {
					tours.remove(i);
				}
			}
		}

		return tours;
	}

	private static List<Tour> filterByPrice(List<Tour> tours, int minPrice,
			int maxPrice) {
		for (int i = 0; i < tours.size();) {
			if (tours.get(i).getMinPrice() >= minPrice
					&& tours.get(i).getMinPrice() <= maxPrice) {
				i++;
			} else {
				tours.remove(i);
			}
		}

		return tours;
	}

	private static List<Tour> fiterByDates(List<Tour> tours, Date startDate,
			Date endDate) {
		System.out.println(startDate + ", " + tours.get(0).getEndDate());
		if (startDate == null) {
			for (int i = 0; i < tours.size();) {
				if (tours.get(i).getEndDate().after(endDate)) {
					tours.remove(i);
				} else {
					i++;
				}
			}
		} else if (endDate == null) {
			for (int i = 0; i < tours.size();) {
				if (tours.get(i).getStartDate().before(startDate)) {
					tours.remove(i);
				} else {
					i++;
				}
			}
		} else {
			for (int i = 0; i < tours.size();) {
				if (tours.get(i).getStartDate().after(startDate)
						&& tours.get(i).getStartDate().before(endDate)
						&& tours.get(i).getEndDate().after(startDate)) {
					i++;
				} else {
					tours.remove(i);
				}
			}
		}
		return tours;
	}

	// private static List<Tour> filterRegion1(List<Tour> tours) {
	//
	// for(int i=0;i<tours.size();){
	// if(tours.get(i).getRoute_id().getRegion().equals(region)){
	// tours.remove(i);
	// }else{
	// i++;
	// }
	// }
	// return tours;
	// }
}
