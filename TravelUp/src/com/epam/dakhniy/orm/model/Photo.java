package com.epam.dakhniy.orm.model;


@DBTable(name = "photo")
public class Photo {

	@DBKey(name = "tour_id")
	private Tour tourId;

	@DBField(name = "photograph_id")
	private int photographId;

	@DBField(name = "photolink")
	private String photolink;

	public Photo() {

	}

	public Photo(int photographId, String photolink) {
		super();
		this.photographId = photographId;
		this.photolink = photolink;
	}

	public Photo(Tour tourId, int photographId, String photolink) {
		super();
		this.tourId = tourId;
		this.photographId = photographId;
		this.photolink = photolink;
	}

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	public int getPhotographId() {
		return photographId;
	}

	public void setPhotographId(int photographId) {
		this.photographId = photographId;
	}

	public String getPhotolink() {
		return photolink;
	}

	public void setPhotolink(String photolink) {
		this.photolink = photolink;
	}

	@Override
	public String toString() {
		return "Tour id: " + this.getTourId() + "\n" + "Photograph id: "
				+ this.getPhotographId() + "\n" + "Photo link: "
				+ this.getPhotolink();
	}
}
