package com.epam.travelup.orm.model;


@DBTable(name = "question")
public class Question {

	@DBField(name = "id")
	private int id;

	@DBKey(name = "user_id")
	private User userId;

	@DBDictionaryField(name = "character_type")
	@DBField(name = "character_type_id")
	private String characterType;

	@DBDictionaryField(name = "temper_type")
	@DBField(name = "temper_type_id")
	private String temperType;

	@DBDictionaryField(name = "sleep_chronotype")
	@DBField(name = "sleep_chronotype_id")
	private String sleepChronotype;

	@DBField(name = "age")
	private int age;

	@DBDictionaryField(name = "living_place")
	@DBField(name = "living_place_id")
	private String livingPlace;

	@DBField(name = "is_vegeterian")
	private boolean isVegeterian;

	@DBField(name = "is_religious")
	private boolean isReligious;

	@DBField(name = "is_extremal")
	private boolean isExtremal;

	@DBDictionaryField(name = "people_to_spend_time_with")
	@DBField(name = "people_to_spend_time_with_id")
	private String peopleToSpendTimeWith;

	@DBDictionaryField(name = "place_to_spend_time")
	@DBField(name = "place_to_spend_time_id")
	private String placeToSpendTime;

	@DBDictionaryField(name = "working_area")
	@DBField(name = "working_area_id")
	private String workingArea;

	@DBField(name = "is_office_worker")
	private boolean isOfficeWorker;

	@DBField(name = "like_to_swim")
	private boolean likeToSwim;

	@DBField(name = "like_to_pick_berries")
	private boolean likeToPickBerries;

	@DBField(name = "like_to_pick_mushrooms")
	private boolean likeToPickMushrooms;

	@DBField(name = "like_to_fish")
	private boolean likeToFish;

	@DBField(name = "like_guitar_singing")
	private boolean likeGuitarSinging;

	@DBField(name = "like_sitting_near_fire")
	private boolean likeSittingNearFire;

	@DBField(name = "is_traveller")
	private boolean isTraveller;

	@DBDictionaryField(name = "walk_type")
	@DBField(name = "walk_type_id")
	private String walkType;

	@DBField(name = "like_being_photographed")
	private boolean likeBeingPhotographed;

	@DBKey(name = "selected_tour")
	private Tour selectedTour;
	
	@DBDictionaryField(name="gender")
	@DBField(name="gender_id")
	private String gender;
	
	public Question() {

	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getCharacterType() {
		return characterType;
	}

	public void setCharacterType(String characterType) {
		this.characterType = characterType;
	}

	public String getTemperType() {
		return temperType;
	}

	public void setTemperType(String temperType) {
		this.temperType = temperType;
	}

	public String getSleepChronotype() {
		return sleepChronotype;
	}

	public void setSleepChronotype(String sleepChronotype) {
		this.sleepChronotype = sleepChronotype;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLivingPlace() {
		return livingPlace;
	}

	public void setLivingPlace(String livingPlace) {
		this.livingPlace = livingPlace;
	}

	public boolean isVegeterian() {
		return isVegeterian;
	}

	public void setVegeterian(boolean isVegeterian) {
		this.isVegeterian = isVegeterian;
	}

	public boolean isReligious() {
		return isReligious;
	}

	public void setReligious(boolean isReligious) {
		this.isReligious = isReligious;
	}

	public boolean isExtremal() {
		return isExtremal;
	}

	public void setExtremal(boolean isExtremal) {
		this.isExtremal = isExtremal;
	}

	public String getPeopleToSpendTimeWith() {
		return peopleToSpendTimeWith;
	}

	public void setPeopleToSpendTimeWith(String peopleToSpendTimeWith) {
		this.peopleToSpendTimeWith = peopleToSpendTimeWith;
	}

	public String getPlaceToSpendTime() {
		return placeToSpendTime;
	}

	public void setPlaceToSpendTime(String placeToSpendTime) {
		this.placeToSpendTime = placeToSpendTime;
	}

	public String getWorkingArea() {
		return workingArea;
	}

	public void setWorkingArea(String workingArea) {
		this.workingArea = workingArea;
	}

	public boolean isOfficeWorker() {
		return isOfficeWorker;
	}

	public void setOfficeWorker(boolean isOfficeWorker) {
		this.isOfficeWorker = isOfficeWorker;
	}

	public boolean isLikeToSwim() {
		return likeToSwim;
	}

	public void setLikeToSwim(boolean likeToSwim) {
		this.likeToSwim = likeToSwim;
	}

	public boolean isLikeToPickBerries() {
		return likeToPickBerries;
	}

	public void setLikeToPickBerries(boolean likeToPickBerries) {
		this.likeToPickBerries = likeToPickBerries;
	}

	public boolean isLikeToPickMushrooms() {
		return likeToPickMushrooms;
	}

	public void setLikeToPickMushrooms(boolean likeToPickMushrooms) {
		this.likeToPickMushrooms = likeToPickMushrooms;
	}

	public boolean isLikeToFish() {
		return likeToFish;
	}

	public void setLikeToFish(boolean likeToFish) {
		this.likeToFish = likeToFish;
	}

	public boolean isLikeGuitarSinging() {
		return likeGuitarSinging;
	}

	public void setLikeGuitarSinging(boolean likeGuitarSinging) {
		this.likeGuitarSinging = likeGuitarSinging;
	}

	public boolean isLikeSittingNearFire() {
		return likeSittingNearFire;
	}

	public void setLikeSittingNearFire(boolean likeSittingNearFire) {
		this.likeSittingNearFire = likeSittingNearFire;
	}

	public boolean isTraveller() {
		return isTraveller;
	}

	public void setTraveller(boolean isTraveller) {
		this.isTraveller = isTraveller;
	}

	public String getWalkType() {
		return walkType;
	}

	public void setWalkType(String walkType) {
		this.walkType = walkType;
	}

	public boolean isLikeBeingPhotographed() {
		return likeBeingPhotographed;
	}

	public void setLikeBeingPhotographed(boolean likeBeingPhotographed) {
		this.likeBeingPhotographed = likeBeingPhotographed;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSelectedTour(Tour selectedTour) {
		this.selectedTour = selectedTour;
	}

	public Tour getSelectedTour() {
		return selectedTour;
	}

	@Override
	public String toString() {
		return "User id: " + this.getUserId() + "\n" + "Character type: "
				+ this.getCharacterType() + "\n" + "Temper type: "
				+ this.getTemperType() + "\n" + "Sleep Chronotype: "
				+ this.getSleepChronotype() + "\n" + "Age: " + this.getAge()
				+ "\n" + "Place of living: " + this.getLivingPlace() + "\n"
				+ "Is vegetarian: " + this.isVegeterian() + "\n"
				+ "Is religious: " + this.isReligious() + "\n"
				+ "Is extremal: " + this.isExtremal() + "\n"
				+ "People to spend time with: "
				+ this.getPeopleToSpendTimeWith() + "\n"
				+ "Places to spend time: " + this.getPlaceToSpendTime() + "\n"
				+ "Working Area: " + this.getWorkingArea() + "\n"
				+ "Is office worker: " + this.isOfficeWorker() + "\n"
				+ "Like swimming: " + this.isLikeToSwim() + "\n"
				+ "Like picking berries: " + this.isLikeToPickBerries() + "\n"
				+ "Like picking mushrooms: " + this.isLikeToPickMushrooms()
				+ "\n" + "Like fishing: " + this.isLikeToFish() + "\n"
				+ "Like guitar singing: " + this.isLikeGuitarSinging() + "\n"
				+ "Like sitting near fire: " + this.isLikeSittingNearFire()
				+ "\n" + "Is a traveller: " + this.isTraveller() + "\n"
				+ "Walk type: " + this.getWalkType() + "\n"
				+ "Like being photographed: " + this.isLikeBeingPhotographed()
				+ "\n" + "Selected tour: " + this.getSelectedTour();
	}
}
