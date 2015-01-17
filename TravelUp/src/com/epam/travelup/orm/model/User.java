package com.epam.travelup.orm.model;

import java.util.Date;

@DBTable(name = "user")
public class User {

	@DBField(name = "id")
	private int id;

	@DBField(name = "first_name")
	private String firstName;
	
	@DBField(name = "last_name")
	private String lastName;

	@DBField(name = "login")
	private String login;

	@DBField(name = "password")
	private String password;

	@DBField(name = "mail")
	private String mail;

	@DBField(name = "date_of_registration")
	private Date dateOfRegistration;

	@DBField(name = "picture")
	private String picture;

	@DBKey(name = "language_id")
	private Language languageId;

	@DBField(name = "paycard_no")
	private int paycardNo;
	
	@DBField(name = "is_active")
	private boolean isActive;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String login,
			String password, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}
	
	public User(String firstName, String lastName, String login,
			String password, String mail, Date dateOfRegistration,
			String picture, Language languageId, int paycardNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.dateOfRegistration = dateOfRegistration;
		this.picture = picture;
		this.languageId = languageId;
		this.paycardNo = paycardNo;
	}

	public User(int id, String firstName, String lastName, String login,
			String password, String mail, Date dateOfRegistration,
			String picture, Language languageId, int paycardNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.dateOfRegistration = dateOfRegistration;
		this.picture = picture;
		this.languageId = languageId;
		this.paycardNo = paycardNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Language getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Language languageId) {
		this.languageId = languageId;
	}

	public int getPaycardNo() {
		return paycardNo;
	}

	public void setPaycardNo(int paycardNo) {
		this.paycardNo = paycardNo;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return (((User) obj).getLogin().equals(this.getLogin()) && ((User) obj)
					.getPassword().equals(this.getPassword()));
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", login=" + login + ", password=" + password
				+ ", mail=" + mail + ", dateOfRegistration="
				+ dateOfRegistration + ", picture=" + picture + ", languageId="
				+ languageId + ", paycardNo=" + paycardNo + ", isActive="
				+ isActive + "]";
	}

	

}
