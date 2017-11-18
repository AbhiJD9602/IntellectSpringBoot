package com.intellect.SpringBoot.beans;

import java.util.Date;

public class User {

	private String  id;
	
	private String fName;
	
	private String lName;
	
	private String email;
	
	private  Long pinCode;
	
	private Date bitryhDate;
    
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public Date getBitryhDate() {
		return bitryhDate;
	}

	public void setBitryhDate(Date bitryhDate) {
		this.bitryhDate = bitryhDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
		
	
}
