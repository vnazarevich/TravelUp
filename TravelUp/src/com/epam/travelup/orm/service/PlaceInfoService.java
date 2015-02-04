package com.epam.travelup.orm.service;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.PlaceInfo;

public class PlaceInfoService {
	
	public static List<PlaceInfo> getAll(String lang){
		Dao<PlaceInfo> dao = new Dao<PlaceInfo>(PlaceInfo.class, lang);
		List<PlaceInfo> places = dao.selectAll();
		return places;
	}

}
