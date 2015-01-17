package com.epam.travelup.orm.model;

import java.util.Date;

@DBTable(name = "message")
public class Message {

	@DBField(name = "id")
	private int id;

	@DBDictionaryField(name = "type")
	@DBField(name="type_id")
	private String type;

	@DBKey(name = "sender_id")
	private User senderId;

	@DBKey(name = "receiver_id")
	private User receiverId;

	@DBKey(name = "tour_id")
	private Tour tourId;

	@DBField(name = "message_text")
	private String messageText;

	@DBField(name = "date")
	private Date date;

	public Message() {

	}

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setTypeId(String type) {
		this.type = type;
	}

	public User getSenderId() {
		return senderId;
	}

	public void setSenderId(User senderId) {
		this.senderId = senderId;
	}

	public User getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(User receiverId) {
		this.receiverId = receiverId;
	}

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Type id: " + this.getType() + "\n" + "Sender id: "
				+ this.getSenderId() + "\n" + "Receiver id: "
				+ this.getReceiverId() + "\n" + "Tour id: " + this.getTourId()
				+ "\n" + "Message: " + this.getMessageText() + "\n" + "Date: "
				+ this.getDate();
	}
}
