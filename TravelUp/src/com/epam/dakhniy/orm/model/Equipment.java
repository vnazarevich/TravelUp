package com.epam.dakhniy.orm.model;


@DBTable(name = "equipment")
public class Equipment {

	@DBKey(name = "tour_id")
	private Tour tourId;

	@DBField(name = "sleepbag")
	private int sleepingBag;

	@DBField(name = "tent")
	private int tent;

	@DBField(name = "karemat")
	private int karemat;

	@DBField(name = "backpack")
	private int backpack;

	public Equipment() {

	}

	public Equipment(int sleepingBag, int tent, int karemat, int backpack) {
		super();
		this.sleepingBag = sleepingBag;
		this.tent = tent;
		this.karemat = karemat;
		this.backpack = backpack;
	}

	public Equipment(Tour tourId, int sleepingBag, int tent, int karemat,
			int backpack) {
		super();
		this.tourId = tourId;
		this.sleepingBag = sleepingBag;
		this.tent = tent;
		this.karemat = karemat;
		this.backpack = backpack;
	}

	public Tour getTourId() {
		return tourId;
	}

	public void setTourId(Tour tourId) {
		this.tourId = tourId;
	}

	public int getSleepingBag() {
		return sleepingBag;
	}

	public void setSleepingBag(int sleepingBag) {
		this.sleepingBag = sleepingBag;
	}

	public int getTent() {
		return tent;
	}

	public void setTent(int tent) {
		this.tent = tent;
	}

	public int getKaremat() {
		return karemat;
	}

	public void setKaremat(int karemat) {
		this.karemat = karemat;
	}

	public int getBackpack() {
		return backpack;
	}

	public void setBackpack(int backpack) {
		this.backpack = backpack;
	}

	@Override
	public String toString() {
		return "Equipment: " + "\n" + "Sleeping bags: " + this.getSleepingBag()
				+ "\n" + "Tents: " + this.getTent() + "\n" + "Karemats: "
				+ this.getKaremat() + "\n" + "Backpacks: " + this.getBackpack();
	}
}
