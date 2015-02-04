package com.epam.travelup.orm.service;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.RequestToModel;

public class RequestToModelService {
	
	public static int insertRequestToModel(RequestToModel obj){
		return new Dao<RequestToModel>(RequestToModel.class,"en").insert(obj);
	}
	
	public static List<RequestToModel> getRequestToModelWhere (String attr, String value, String lang){
		Dao<RequestToModel> dao = new Dao<RequestToModel>(RequestToModel.class, lang);
		return dao.selectWhere(attr, value, "=");
	}
	
	public static void deleteRequestToModelWhere(String attr, String value, String lang){
		Dao<RequestToModel> dao = new Dao<RequestToModel>(RequestToModel.class, lang);
		dao.delete(attr, value, "=");
	}
}

