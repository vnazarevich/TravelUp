package com.epam.travelup.orm.model;

@DBTable(name="request_to_model")
public class RequestToModel {
	
	@DBField(name="id")
	private int id;

	@DBKey(name = "request_id")
	private Tour request;

	@DBKey(name = "model_id")
	private Tour model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tour getRequest() {
		return request;
	}

	public void setRequest(Tour request) {
		this.request = request;
	}

	public Tour getModel() {
		return model;
	}

	public void setModel(Tour model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "RequestToModel [id=" + id + ", request=" + request + ", model="
				+ model + "]";
	}
}
