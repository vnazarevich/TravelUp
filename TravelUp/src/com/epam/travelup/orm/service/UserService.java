package com.epam.travelup.orm.service;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.User;

public class UserService {
	public static List<User> getUsersWhere(String attr, String value, String lang){
		Dao<User> dao = new Dao<User>(User.class,lang);
		List<User> users = dao.selectWhere(attr, value, "=");
		return users;
	}
	public static void insertUser(User user){
		new Dao<User>(User.class,"en").insert(user);
	}
}
