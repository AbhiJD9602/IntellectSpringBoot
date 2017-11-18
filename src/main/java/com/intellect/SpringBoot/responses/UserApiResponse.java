package com.intellect.SpringBoot.responses;

public class UserApiResponse <T> {
    
	private String message;
	
	private String  statusCode;
	
	private T resoponseBody;

	public String getMaessage() {
		return message;
	}

	public void setMessage(String maessage) {
		this.message = maessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public T getResoponseBody() {
		return resoponseBody;
	}

	public void setResoponseBody(T resoponseBody) {
		this.resoponseBody = resoponseBody;
	}
	
	
	
	
	
	
}
