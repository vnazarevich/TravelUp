package com.epam.travelup.orm.service;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Portfolio;

public class PortfolioService {
	public static int insertPortfolio(Portfolio portfolio){
		Dao<Portfolio> dao = new Dao<Portfolio>(Portfolio.class, "en");
		return dao.insert(portfolio);
	}

}
