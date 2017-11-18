package com.intellect.SpringBoot.responses;

public enum StatusCode  {

	SUCESS("200"),ERROR("400"), NOCONTENT("204"),ALLREADYEXIT("203");
	 private String errorcode;
	
	StatusCode(String errorcode ){
		this.errorcode= errorcode;
	}
	public String getErrorcode() {
		return errorcode;
	}
	
		
}

