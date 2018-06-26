package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ReviewCompleteDAO;
import com.internousdev.ecsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewCompleteAction extends ActionSupport implements SessionAware{
	private String handlename;
	private String title;
	private String star;
	private String comments;
	private String errorMessage;

	List<ReviewDTO> reviewDTOList =new ArrayList<ReviewDTO>();
	private Map<String, Object>session;

	public String execute(){
		String ret = ERROR;
		ReviewCompleteDAO dao=new ReviewCompleteDAO();
		int count=dao.insert(handlename, title, star,comments);
		if(count > 0){
			reviewDTOList =dao.select();
			session.put("reviewDTOList", reviewDTOList);
			ret = SUCCESS;
		}
		return ret;
	}
public String getHadlename(){
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
public Map<String, Object> getSession(){
	return session;
}
public void setSession(Map<String, Object> session){
	this.session = session;
}
public String getErrorMessage(){
	return errorMessage;
}
public void setErrorMessage(String errorMessage){
	this.errorMessage = errorMessage;
}
}