package org.light.portal.model;


public class UserProfile  extends Entity{
	private long userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String occupation;
	private int ethnicity;
	private int bodyType;
	private int height;
	private int registerPurpose;
	//background & lifestyle
	private int maritalStatus;
	private int sexualOrientation;
	private String religion;
	private String hometown;
	private int smoker;
	private int drinker;
	private int childrenStatus;
	private int education;
	private String income;
	
	//interests and personality
	private String headline;
	private String aboutMe;
	private String likeToMeet;
	private String interests;
	private String music;
	private String movies;
	private String television;
	private String books;
	private String heroes;
	
//	 read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	private int userCurrentStatusId;

	public UserProfile(){
	super();
	}

	public UserProfile(long userId){
	this();
	this.userId = userId;
	}

	public UserProfile(long userId,String photoUrl,int photoWidth,int	photoHeight,String assignedUri,String chosedUri,String displayName,int userCurrentStatusId){
	this();
	this.userId = userId;
	this.photoUrl = photoUrl;
	this.photoWidth = photoWidth;
	this.photoHeight= photoHeight;
	this.assignedUri = assignedUri;
	this.chosedUri = chosedUri;
	this.displayName = displayName;
	this.userCurrentStatusId = userCurrentStatusId;
	}
	
	public String getName(){
		String name= (this.firstName != null) ? this.firstName : "";
		name+= (this.middleName!= null) ? " "+this.middleName : " ";
		name+= (this.lastName != null) ? " "+this.lastName : "";
		return name.trim();
	}
	
	public String getUri() {
		String uri = this.assignedUri;
		if(this.chosedUri != null)
			uri = this.chosedUri;
		return uri;
	}
	
	public int getPhotoSmallWidth(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.photoWidth * rate / 10;
			newHeight= this.photoHeight * rate / 10;
			rate--;
		}
		return newWidth;
	}
	public int getPhotoSmallHeight(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.photoWidth * rate / 10;
			newHeight= this.photoHeight * rate / 10;
			rate--;
		}
		return newHeight;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}
	

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	

	public int getBodyType() {
		return bodyType;
	}
	

	public void setBodyType(int bodyType) {
		this.bodyType = bodyType;
	}
	

	public String getBooks() {
		return books;
	}
	

	public void setBooks(String books) {
		this.books = books;
	}
	

	public int getChildrenStatus() {
		return childrenStatus;
	}
	

	public void setChildrenStatus(int childrenStatus) {
		this.childrenStatus = childrenStatus;
	}
	

	public int getDrinker() {
		return drinker;
	}
	

	public void setDrinker(int drinker) {
		this.drinker = drinker;
	}
	

	public int getEducation() {
		return education;
	}
	

	public void setEducation(int education) {
		this.education = education;
	}
	

	public int getEthnicity() {
		return ethnicity;
	}
	

	public void setEthnicity(int ethnicity) {
		this.ethnicity = ethnicity;
	}
	

	public String getFirstName() {
		return firstName;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public String getHeadline() {
		return headline;
	}
	

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	

	public int getHeight() {
		return height;
	}
	

	public void setHeight(int height) {
		this.height = height;
	}
	

	public String getHeroes() {
		return heroes;
	}
	

	public void setHeroes(String heroes) {
		this.heroes = heroes;
	}
	

	public String getHometown() {
		return hometown;
	}
	

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	

	public String getIncome() {
		return income;
	}
	

	public void setIncome(String income) {
		this.income = income;
	}
	

	public String getInterests() {
		return interests;
	}
	

	public void setInterests(String interests) {
		this.interests = interests;
	}
	

	public String getLastName() {
		return lastName;
	}
	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getLikeToMeet() {
		return likeToMeet;
	}
	

	public void setLikeToMeet(String likeToMeet) {
		this.likeToMeet = likeToMeet;
	}
	

	public int getMaritalStatus() {
		return maritalStatus;
	}
	

	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	

	public String getMiddleName() {
		return middleName;
	}
	

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	

	public String getMovies() {
		return movies;
	}
	

	public void setMovies(String movies) {
		this.movies = movies;
	}
	

	public String getMusic() {
		return music;
	}
	

	public void setMusic(String music) {
		this.music = music;
	}
	

	public String getOccupation() {
		return occupation;
	}
	

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	

	public int getRegisterPurpose() {
		return registerPurpose;
	}
	

	public void setRegisterPurpose(int registerPurpose) {
		this.registerPurpose = registerPurpose;
	}
	

	public String getReligion() {
		return religion;
	}
	

	public void setReligion(String religion) {
		this.religion = religion;
	}
	

	public int getSexualOrientation() {
		return sexualOrientation;
	}
	

	public void setSexualOrientation(int sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}
	

	public int getSmoker() {
		return smoker;
	}
	

	public void setSmoker(int smoker) {
		this.smoker = smoker;
	}
	

	public String getTelevision() {
		return television;
	}
	

	public void setTelevision(String television) {
		this.television = television;
	}
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAssignedUri() {
		return assignedUri;
	}

	public void setAssignedUri(String assignedUri) {
		this.assignedUri = assignedUri;
	}

	public String getChosedUri() {
		return chosedUri;
	}

	public void setChosedUri(String chosedUri) {
		this.chosedUri = chosedUri;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getPhotoHeight() {
		return photoHeight;
	}

	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getPhotoWidth() {
		return photoWidth;
	}

	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}

	public int getUserCurrentStatusId() {
		return userCurrentStatusId;
	}

	public void setUserCurrentStatusId(int userCurrentStatusId) {
		this.userCurrentStatusId = userCurrentStatusId;
	}
	
}
