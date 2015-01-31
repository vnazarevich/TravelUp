package com.epam.travelup.orm.service;

import java.io.File;
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
			if(photo.getPlaceId()!=null&&photo.getPlaceId() == id){
				photosForPlace.add(photo);
			}
		}
		System.out.println(photosForPlace);
		return photosForPlace;
	}

	public static List<Photo> getPhotosForUser(String id){
		Dao<Photo> dao = new Dao<>(Photo.class, "en");
		List<Photo> photos = dao.selectWhere("photograph_id", id,"=");
		return photos;
	}

	public static void insertPhoto(Photo photo){
		Dao<Photo> dao = new Dao<>(Photo.class, "en");
		dao.insert(photo);
	}

	public static void deleteImageByLink(String fullPath){
		String[] hierarchy = fullPath.split(File.separator);
		String link = hierarchy[hierarchy.length-1];
		Dao<Photo> dao = new Dao<>(Photo.class, "en");
		dao.delete("photolink", link, "=");
	}
	public static void deleteImageById(String id){
		Dao<Photo> dao = new Dao<>(Photo.class, "en");
		dao.delete("id", id, "=");
	}

	public static void deleteImagesByUser(String id){
		Dao<Photo> dao = new Dao<>(Photo.class, "en");
		dao.delete("photograph_id", id,"=");
	}
}
