package com.epam.travelup.admin.util;

import java.util.List;

import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;

public class UserSearcher {
	public static List<User> search(String input, boolean isPhoto, boolean isTransport, boolean isGuide){
		List<User> users = UserService.getUsersLike(input);
		if(isGuide){
			users=filterGuide(users);
		}
		if(isPhoto){
			users=filterPhoto(users);
		}
		if(isTransport){
			users=filterTransport(users);
		}
		return users;
	}
	private static List<User> filterPhoto(List<User> users){
		for(int i=0;i<users.size();){
			if(users.get(i).getPortfolio()==null||!users.get(i).getPortfolio().isPhotographer()){
				users.remove(i);
			}else{
				i++;
			}
		}
		return users;
	}
	private static List<User> filterTransport(List<User> users){
		for(int i=0;i<users.size();){
			if(users.get(i).getPortfolio()==null||!users.get(i).getPortfolio().isCarrier()){
				users.remove(i);
			}else{
				i++;
			}
		}
		return users;
	}
	private static List<User> filterGuide(List<User> users){
		for(int i=0;i<users.size();){
			if(users.get(i).getPortfolio()==null||!users.get(i).getPortfolio().isGuide()){
				users.remove(i);
			}else{
				i++;
			}
		}
		return users;
	}

}
