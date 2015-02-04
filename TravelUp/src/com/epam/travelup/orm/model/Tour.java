package com.epam.travelup.orm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@DBTable(name = "tour")
public class Tour {

	@DBField(name = "id")
	private Integer id;

	@DBKey(name = "guide_id")
	private User guideId;

	@DBKey(name = "carrier_id")
	private User transporter;

	@DBKey(name = "photograph_id")
	private User photographer;

	@DBKey(name = "route_id")
	private Route route;

	@DBDictionaryField(name = "status")
	@DBField(name = "status_id")
	private String status;

	@DBDictionaryField(name = "transport")
	@DBField(name = "transport_id")
	private String transport;

	@DBKey(name = "name_id")
	private TourName name;

	@DBField(name = "photograph_required")
	private boolean photographRequired;

	@DBField(name = "min_age")
	private int minAge;

	@DBField(name = "max_age")
	private int maxAge;

	@DBField(name = "min_capacity")
	private int minCapacity;

	@DBField(name = "max_capacity")
	private int maxCapacity;

	@DBField(name = "min_duration")
	private int minDuration;

	@DBField(name = "max_duration")
	private int maxDuration;

	@DBDictionaryField(name = "trip_days")
	@DBField(name = "trip_days_id")
	private String tripDays;

	@DBField(name = "start_date")
	private Date startDate;

	@DBField(name = "end_date")
	private Date endDate;

	@DBField(name = "min_price")
	private double minPrice;

	@DBField(name = "max_price")
	private double maxPrice;

	@DBField(name = "trip_days_id")
	private int tripId;
	
	@DBField(name = "creater_tour_id")
	private int createrTourId;

	private List<Place> places;

	//count of similar users requests, which used for creating model
	private int countRequests;

	// include requests, from which model was created
	private Set <Tour> requests;

	//count of users, that bought this tour
	private int userCount;

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public Tour() {

	}

	public int getCountRequests() {
		return countRequests;
	}



	public void setCountRequests(int countRequests) {
		this.countRequests = countRequests;
	}



	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getCreaterTourId() {
		return createrTourId;
	}

	public void setCreaterTourId(int createrTourId) {
		this.createrTourId = createrTourId;
	}

	public List<Place> getPlaces() {
		return places;
	}


	public void setPlaces(List<Place> places) {
		this.places = places;
	}



	public User getGuideId() {
		return guideId;
	}

	public void setGuideId(User guideId) {
		this.guideId = guideId;
	}

	public User getPhotographId() {
		return photographer;
	}

	public void setPhotographId(User photographer) {
		this.photographer = photographer;
	}

	public Route getRoute_id() {
		return route;
	}

	public void setRoute_id(Route route_id) {
		this.route = route_id;
	}

	public Set<Tour> getRequests() {
		return requests;
	}

	public void setRequests(Set<Tour> requests) {
		this.requests = requests;
	}

	public String getStatus() {
		return status;
	}

	public void setStatusId(String status) {
		this.status = status;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public TourName getName() {
		return name;
	}

	public void setName(TourName name) {
		this.name = name;
	}

	public boolean isPhotographRequired() {
		return photographRequired;
	}

	public void setPhotographRequired(boolean photographRequired) {
		this.photographRequired = photographRequired;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getMinCapacity() {
		return minCapacity;
	}

	public void setMinCapacity(int minCapacity) {
		this.minCapacity = minCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(int minDuration) {
		this.minDuration = minDuration;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public User getTransporter() {
		return transporter;
	}

	public void setTransporter(User transporter) {
		this.transporter = transporter;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public String getTripDays() {
		return tripDays;
	}

	public void setTripDays(String tripDays) {
		this.tripDays = tripDays;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public String toString() {
		return "Tour id:" + this.getId() +
				 "Guide id: " + this.getGuideId() +
				"\n" + "Photograph id: "
				+ this.getPhotographId() + "\n" + "Route id: "
				+ this.getRoute_id() + "\n" + "Status id: "
				+ this.getStatus() + "\n" + "Transport id: "
				+ this.getTransport() + "\n" + "Name: " + this.getName()
				+ "\n" + "Photographer required" + this.isPhotographRequired()
				+ "\n" + "Min age: " + this.getMinAge() + "\n" + "Max age: "
				+ this.getMaxAge() +
				"\n" + "Min capacity: "
				+ this.getMinCapacity() + "\n" + "Max capacity: "
				+ this.getMaxCapacity() + "\n" + "Min duration: "
				+ this.getMinDuration() + "\n" + "Max duration: "
				+ this.getMaxDuration() + "\n" + "Places: "

			//	+ getPlacesId(this.getPlaces());

				+ this.getPlaces();
	}

	private String getPlacesId (List<Place> list){
		StringBuilder sb = new StringBuilder();
		for (Place p: list){
			sb.append(p.getId() + "\n");
		}
		return sb.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public static List<Integer> getToursId(List<Tour> tours){
		List<Integer> result = new ArrayList<>();
		for (Tour tour: tours){
			result.add(tour.getId());
		}
		return result;
	}





}
