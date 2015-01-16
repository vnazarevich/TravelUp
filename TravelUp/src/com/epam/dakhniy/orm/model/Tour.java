package com.epam.dakhniy.orm.model;

import java.util.Date;

@DBTable(name = "tour")
public class Tour {

	@DBField(name = "id")
	private int id;

	@DBKey(name = "guide_id")
	private User guideId;

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
	private double minDuration;

	@DBField(name = "max_duration")
	private double maxDuration;

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

	public Tour() {

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(double minDuration) {
		this.minDuration = minDuration;
	}

	public double getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(double maxDuration) {
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
		return "Guide id: " + this.getGuideId() + "\n" + "Photograph id: "
				+ this.getPhotographId() + "\n" + "Route id: "
				+ this.getRoute_id() + "\n" + "Status id: "
				+ this.getStatus() + "\n" + "Transport id: "
				+ this.getTransport() + "\n" + "Name: " + this.getName()
				+ "\n" + "Photographer required" + this.isPhotographRequired()
				+ "\n" + "Min age: " + this.getMinAge() + "\n" + "Max age: "
				+ this.getMaxAge() + "\n" + "Min capacity: "
				+ this.getMinCapacity() + "\n" + "Max capacity: "
				+ this.getMaxCapacity() + "\n" + "Min duration: "
				+ this.getMinDuration() + "\n" + "Max duration: "
				+ this.getMaxDuration();
	}
}
