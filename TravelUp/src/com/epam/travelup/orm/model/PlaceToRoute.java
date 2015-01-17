package com.epam.travelup.orm.model;


@DBTable(name = "place_to_route")
public class PlaceToRoute {

	@DBKey(name = "place_id")
	private Place placeId;

	@DBKey(name = "route_id")
	private Route routeId;

	public PlaceToRoute() {

	}

	public PlaceToRoute(Route routeId) {
		super();
		this.routeId = routeId;
	}

	public PlaceToRoute(Place placeId, Route routeId) {
		super();
		this.placeId = placeId;
		this.routeId = routeId;
	}

	public Place getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Place placeId) {
		this.placeId = placeId;
	}

	public Route getRouteId() {
		return routeId;
	}

	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "Place id: " + this.getPlaceId() + "\n" + "Route id: "
				+ this.getRouteId();
	}
}
