package com.epam.dakhniy.orm.service;

import java.util.List;

import com.epam.dakhniy.orm.dao.Dao;
import com.epam.dakhniy.orm.model.User;

public class UserService {
	public static List<User> getUsersWhere(String attr, String value, String lang){
		Dao<User> dao = new Dao<User>(User.class,lang);
		List<User> users = dao.selectWhere(attr, value, "=");
		return users;
	}
}
