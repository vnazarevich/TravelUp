package com.epam.travelup.orm.model;


@DBTable(name = "photo")
public class Photo {

	@DBField(name = "id")
	private int id;

	@DBField(name = "place_id")
	private Integer placeId;

	@DBField(name = "photograph_id")
	private Integer photographId;

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



	@Override
	public String toString() {
		return "Tour id: " + this.getPlaceId() + "\n" + "Photograph id: "
				+ this.getPhotographId() + "\n" + "Photo link: "
				+ this.getPhotolink();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public void setPhotographId(Integer photographId) {
		this.photographId = photographId;
	}

	public String getPhotolink() {
		return photolink;
	}

	public void setPhotolink(String photolink) {
		this.photolink = photolink;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public Integer getPhotographId() {
		return photographId;
	}
}
