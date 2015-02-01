package com.epam.travelup.orm.service;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Route;
import com.epam.travelup.orm.model.Tour;

public class RouteService {
	
	public static int insertRoute(Route obj){
		return new Dao<Route>(Route.class,"en").insert(obj);
	}
	
	public static List<Route> getRouteWhere(String attr, String value, String lang){		
		Dao<Route> dao = new Dao<Route>(Route.class, lang);
		return dao.selectWhere(attr, value, "=");
		
	}

}
