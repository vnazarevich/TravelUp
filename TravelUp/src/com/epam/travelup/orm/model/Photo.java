package com.epam.travelup.orm.model;


@DBTable(name = "photo")
public class Photo {

	@DBField(name = "place_id")
	private int placeId;

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

	public Photo(int placeId, int photographId, String photolink) {
		super();
		this.placeId = placeId;
		this.photographId = photographId;
		this.photolink = photolink;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setTourId(int placeId) {
		this.placeId = placeId;
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
		return "Tour id: " + this.getPlaceId() + "\n" + "Photograph id: "
				+ this.getPhotographId() + "\n" + "Photo link: "
				+ this.getPhotolink();
	}
}
