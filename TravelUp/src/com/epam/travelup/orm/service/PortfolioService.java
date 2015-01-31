package com.epam.travelup.orm.service;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Portfolio;
import com.epam.travelup.orm.model.User;

public class PortfolioService {
	public static int insertPortfolio(Portfolio portfolio){
		Dao<Portfolio> dao = new Dao<Portfolio>(Portfolio.class, "en");
		return dao.insert(portfolio);
	}

	public static void updatePortfolio(String id, String attr, String value){
		Dao<Portfolio> dao = new Dao<Portfolio>(Portfolio.class, "en");
		dao.update("id", id, attr, value);
	}

	public static void removePortfolio(String userId){
		Dao<User> dao = new Dao<User>(User.class, "en");
		dao.update("id", userId, "portfolio_id", null);
	}
}
