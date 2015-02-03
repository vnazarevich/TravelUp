package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Portfolio;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.transformer.Transformer;

public class UserService {
	public static List<User> getUsersWhere(String attr, String value){
		Dao<User> dao = new Dao<User>(User.class,"en");
		List<User> users = dao.selectWhere(attr, value, "=");
		return users;
	}
	public static List<User> getUsers(){
		Dao<User> dao = new Dao<User>(User.class,"en");
		List<User> users = dao.selectAll();
		return users;
	}
	public static void insertUser(User user){
		new Dao<User>(User.class,"en").insert(user);
	}
	public static List<User> getUsersLike(String input, int offset, int rowCount){
		List<String> attrs = new ArrayList<String>();
		Transformer<User> transformer = new Transformer<User>(User.class, "en");
		attrs.add(transformer.fieldToAttribute("login"));
		attrs.add(transformer.fieldToAttribute("firstName"));
		attrs.add(transformer.fieldToAttribute("lastName"));
		List<String> values = new ArrayList<String>();
		values.add("%"+input+"%");
		values.add("%"+input+"%");
		values.add("%"+input+"%");
		Dao<User> dao = new Dao<User>(User.class, "en");
		List<User> users = dao.selectWhereOr(attrs, values, "LIKE", offset, rowCount);
		return users;
	}

	public static void banUser(String id){
		Dao<User> dao = new Dao<User>(User.class,"en");
		dao.update("id", id	, "is_banned", "1");
	}

	public static int countUsers(){
		Dao<User> dao = new Dao<User>(User.class,"en");
		return dao.count();
	}

	public static void unbanUser(String id){
		Dao<User> dao = new Dao<User>(User.class,"en");
		dao.update("id", id	, "is_banned", "0");
	}

	public static void setAdmin(String id){
		Dao<User> dao = new Dao<User>(User.class,"en");
		dao.update("id", id	, "is_admin", "1");
	}

	public static void activateUser(String id){
		Dao<User> dao = new Dao<User>(User.class,"en");
		dao.update("id", id	, "is_active", "1");
	}

	public static void updateUserInfo(String id, String attr, String value){
		Dao<User> dao = new Dao<User>(User.class,"en");
		dao.update("id", id	, attr, value);
	}
	public static Map<String,List<User>> getSpecialists(){
		Dao<User> dao = new Dao<User>(User.class,"en");
		List<User> users = dao.selectAll();
		List<User> guides = new ArrayList<User>();
		List<User> photographers = new ArrayList<User>();
		List<User> transporters = new ArrayList<User>();
		for(User user:users){
			Portfolio portfolio = user.getPortfolio();
			if(portfolio!=null){
				if(portfolio.isGuide()){
					guides.add(user);
				}
				if(portfolio.isPhotographer()){
					photographers.add(user);
				}
				if(portfolio.isCarrier()){
					transporters.add(user);
				}
			}
		}
		Map<String,List<User>> specialists = new HashMap<String, List<User>>();
		specialists.put("photographers", photographers);
		specialists.put("guides", guides);
		specialists.put("transporters", transporters);
		return specialists;
	}


	public static void main(String[] args) {
		banUser("1");
	}

}
