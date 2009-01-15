package org.light.portlets.addressbook;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class AddressBook extends Entity {

	private long userId;
	private String group;
	private String fullName;	
	private String homePhone;
	private String workPhone;
	private String mobilePhone;
	private int primaryPhone = 1; //0 no phone, 1 homePhone, 2 workPhone, 3 mobilePhone;
	private String workEmail;
	private String personalEmail;
	private int primaryEmail = 1; //0 no email, 1 personalEmail, 2 workEmail;
	private String homePage;
	private String address;
	private String city;
	private String province;
	private String country;
	private String postalCode;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());	
	public AddressBook(){
		super();
	}
    
	public AddressBook(String group,String fullName,String homePhone,
			String workPhone,String mobilePhone,String workEmail,String personalEmail,String homePage,
			String address,String city,String province,String country,String postalCode, long userId){
		this();
		this.group = group;
		this.fullName = fullName;		
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.mobilePhone = mobilePhone;
		this.personalEmail = personalEmail;
		this.workEmail = workEmail;
		this.homePage = homePage;
		this.address =address;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.userId = userId;
		
	}
	
	public String getPhone(){
		String phone = null;
		if(this.primaryPhone == 1) 
			phone = this.homePhone;
		else if(this.primaryPhone == 2) 
			phone = this.workPhone;
		else if(this.primaryPhone == 3) 
			phone = this.mobilePhone;
		return phone;
	}
	
	public String getEmail(){
		String email = null;
		if(this.primaryEmail == 1) 
			email = this.personalEmail;
		else if(this.primaryEmail == 2) 
			email = this.workEmail;
		
		return email;
	}
	
	public String getMap(){
		String map = this.address;
		if(this.city != null)map+=","+this.city;
		if(this.province != null)map+=","+this.province;
		if(this.country != null)map+=","+this.country;
		
		return map;
	}
	
	public String getDate(){
		 return DateFormatter.format(this.createDate,"EEE, MMM dd, yyyy");
	}
	
	public String getFullDate(){
		 return DateFormatter.format(this.createDate,"EEEE, MMMM dd, yyyy HH:mm aaa");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public int getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(int primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public int getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(int primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
