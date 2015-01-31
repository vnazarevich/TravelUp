package com.epam.travelup.orm.service;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.RequestToModel;

public class RequestToModelServices {
	
	public static void insertRequestToModel(RequestToModel obj){
		new Dao<RequestToModel>(RequestToModel.class,"en").insert(obj);
	}
}
