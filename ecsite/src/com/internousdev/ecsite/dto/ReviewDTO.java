package com.internousdev.ecsite.dto;

public class ReviewDTO {
	private String handlename;
	private String title;
	private String star;
	private String comments;

	public String getHandlename(){
		return handlename;
	}
	public void setHandlename(String handlename){
		this.handlename = handlename;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getStar(){
		return star;
	}
	public void setStar(String star){
		this.star = star;
	}
	public String getComments(){
		return comments;
	}
	public void setComments(String comments){
		this.comments = comments;
	}
}