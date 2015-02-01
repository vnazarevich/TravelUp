package com.epam.travelup.orm.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


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

	@DBField(name = "is_admin")
	private boolean isAdmin;

	@DBField(name = "is_banned")
	private boolean isBanned;
	@DBKey(name="portfolio_id")
	private Portfolio portfolio;

	public Portfolio getPortfolio() {
		return portfolio;
	}



	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	public boolean isBanned() {
		return isBanned;
	}



	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
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
				+ isActive + ", isAdmin=" + isAdmin + ", isBanned=" + isBanned
				+ "]";
	}


	private static Comparator<User> dateComparator = new Comparator<User>() {

		@Override
		public int compare(User o1, User o2) {
			return (int) (o2.getDateOfRegistration().getTime()-o1.getDateOfRegistration().getTime());
		}
	};

	public static void sortByDate(List<User> users){
		Collections.sort(users, dateComparator);
	}

}
