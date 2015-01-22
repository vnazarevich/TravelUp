package com.epam.travelup.orm.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Photo;

public class PhotoService {

	public static List<Photo> getPhotos(){
		Dao<Photo> dao = new Dao<>(Photo.class, "en");
		List<Photo> photos = dao.selectAll();		
		return photos;
	}
	
	public static List<Photo> getPhotosForPlace(int id, String lang){
		List<Photo> photos = getPhotos();
		List<Photo> photosForPlace = new ArrayList<Photo>();
		
		for(Photo photo:photos){
			if(photo.getPlaceId() == id){
				photosForPlace.add(photo);
			}
		}
		
		return photosForPlace;
	}
}
