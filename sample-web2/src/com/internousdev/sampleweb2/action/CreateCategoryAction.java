package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateCategoryAction extends ActionSupport implements SessionAware {
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	private Date insertDate;
	private Date updateDate;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		session.remove("categoryNameErrorMessageList");
		session.remove("categoryDescriptionErrorMessageList");

		session.put("categoryId", categoryId);
		session.put("categoryName", categoryName);
		session.put("categoryDescription", categoryDescription);
		session.put("insertDate", insertDate);
		session.put("updateDate", updateDate);


		result = SUCCESS;
		return result;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
