package com.internousdev.sampleweb2.dto;

public class InquiryDTO {
	private String userId;
	private String qtype;
	private String body;
	public String getUserId() {
		return userId;
	}
	public void setUserId( String userId) {
		this.userId = userId;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
