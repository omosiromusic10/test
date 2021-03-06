package com.internousdev.sampleweb2.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.MCategoryDAO;
import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class CreateCategoryCompleteAction extends ActionSupport implements SessionAware {
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	private Date insertDate;
	private Date updateDate;

	private List<String>categoryNameErrorMessageList = new ArrayList<String>();
	private List<String>categoryDescriptionErrorMessageList = new ArrayList<String>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException{
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		session.put("categoryId", categoryId);
		session.put("categoryName", categoryName);
		session.put("categoryDescription", categoryDescription);
		session.put("insertDate", insertDate);
		session.put("updateDate", updateDate);

		categoryNameErrorMessageList = inputChecker.doCheck("カテゴリ名", categoryName, 1, 16, false, true, true, true, false, true, false);
		categoryDescriptionErrorMessageList = inputChecker.doCheck("カテゴリ名詳細", categoryDescription, 1, 64, false, true, true, true, false, true, false);

		if(categoryNameErrorMessageList.size()>0
		&& categoryDescriptionErrorMessageList.size()>0){
			session.put("categoryNameErrorMessageList", categoryNameErrorMessageList);
			session.put("categoryDescriptionErrorMessageList", categoryDescriptionErrorMessageList);
		}

		MCategoryDAO mCategoryDao = new MCategoryDAO();

		int categoryId = mCategoryDao.getMaxCategoryId() + 1;

		int count = mCategoryDao.createCategory(categoryId,
				session.get("categoryName").toString(),
				session.get("categoryDescription").toString());
		if (count > 0){
		    session.remove("categoryName");
		    session.remove("categoryDescription");
		    System.out.println("カテゴリの追加を行いました");
		    result = SUCCESS;
		    session.remove("categoryId");
		}
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

	public List<String> getCategoryNameErrorMessageList() {
		return categoryNameErrorMessageList;
	}

	public void setCategoryNameErrorMessageList(List<String> categoryNameErrorMessageList) {
		this.categoryNameErrorMessageList = categoryNameErrorMessageList;
	}

	public List<String> getCategoryDescriptionErrorMessageList() {
		return categoryDescriptionErrorMessageList;
	}

	public void setCategoryDescriptionErrorMessageList(List<String> categoryDescriptionErrorMessageList) {
		this.categoryDescriptionErrorMessageList = categoryDescriptionErrorMessageList;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
