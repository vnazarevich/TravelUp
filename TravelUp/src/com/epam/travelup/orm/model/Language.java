package com.epam.travelup.orm.model;


@DBTable(name = "language")
public class Language {

	@DBField(name = "id")
	private int id;

	@DBField(name = "link")
	private String link;

	public Language() {

	}

	public Language(String link) {
		super();
		this.link = link;
	}

	public Language(int id, String link) {
		super();
		this.id = id;
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Link: " + this.getLink();
	}
}
