package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Region;

public class RegionService {

	public static void insertRegion(Region region){
		new Dao<Region>(Region.class,"en").insert(region);
	}
	
	public static List<Region> getRegions(){
		List<Region> regions = new Dao<Region>(Region.class,"en").selectAll();
		return regions;
	}
	
	public static int countRegions(){
		Dao<Region> dao = new Dao<Region>(Region.class,"en");
		return dao.count();
	}
	
	public static List<Region> getRegionsWhereNameEquals(String value, String lang){
		Dao<Region> dao = new Dao<Region>(Region.class, lang);
		
		List<String> attrs = new ArrayList<>();
		List<String> values = new ArrayList<>();
	
		attrs.add("ua_region");
		attrs.add("en_region");
		values.add(value);
		values.add(value);
		
		List<Region> regions = dao.selectWhereOr(attrs, values, "=");
		return regions;
	}
	
}
