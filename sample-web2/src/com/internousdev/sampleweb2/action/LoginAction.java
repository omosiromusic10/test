package com.internousdev.sampleweb2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.CartInfoDAO;
import com.internousdev.sampleweb2.dao.DestinationInfoDAO;
import com.internousdev.sampleweb2.dao.MCategoryDAO;
import com.internousdev.sampleweb2.dao.UserInfoDAO;
import com.internousdev.sampleweb2.dto.DestinationInfoDTO;
import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.dto.UserInfoDTO;
import com.internousdev.sampleweb2.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String loginId;
	private String password;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;

		if(loginId.equals("admin") && password.equals("admin")){
			return  "admin";
	}



		if(savedLoginId==true){
			session.put("savedLoginId",true);
			session.put("loginId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.put("loginId", loginId);
		}//ここでbooleanでif文でチェックする事により、ログインIDを残すか否かの処理をしている。

		InputChecker inputChecker = new InputChecker(); //★これに関してはInputCheckerを参照する。
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);


		if(loginIdErrorMessageList.size()!=0
		&& passwordErrorMessageList.size()!=0){
			session.put("loginIdErrorMessageList",loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("logined", 0);
		}//ここではLoginIdでエラーを表示させる物なのだろうが理解はまだ。

		if(!session.containsKey("mCategoryList")){
		    MCategoryDAO mCategoryDao = new MCategoryDAO();
		    mCategoryDtoList = mCategoryDao.getMCategoryList();
		    session.put("mCategoryDtoList", mCategoryDtoList);
	    } //ここではmCategoryListが存在しなければ Listをsessionに残すようにしている
		// MCategoryはカテゴリの種類を指している。

		UserInfoDAO userInfoDao = new UserInfoDAO();
		if(userInfoDao.isExistsUserInfo(loginId, password)){
			if(userInfoDao.login(loginId, password) > 0){
			UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(loginId, password);
			session.put("loginId", userInfoDTO.getUserId());
			int count =0;
			CartInfoDAO cartInfoDao = new CartInfoDAO();
			//★ここでもやっている事が全然わからない

			count = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")),loginId);
			if(count > 0){
				DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
				try{
					List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
					destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);
					Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
					if(!(iterator.hasNext())){
						destinationInfoDtoList = null;
					}
					session.put("destinationInfoDtoList", destinationInfoDtoList);
				}catch (SQLException e) {
					e.printStackTrace();
				}
				result = "settlement";
			}else
			    result = SUCCESS;
		}
			session.put("logined", 1);
	}
	return result;
    }

public String getCategoryId() {
	return categoryId;
}

public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}

public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public boolean isSavedLoginId() {
	return savedLoginId;
}

public void setSavedLoginId(boolean savedLoginId) {
	this.savedLoginId = savedLoginId;
}

public List<String> getLoginIdErrorMessageList() {
	return loginIdErrorMessageList;
}
public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
	this.loginIdErrorMessageList = loginIdErrorMessageList;
}
public List<String> getPasswordErrorMessageList() {
	return passwordErrorMessageList;
}
public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
	this.passwordErrorMessageList = passwordErrorMessageList;
}
public Map<String, Object> getSession() {
	return session;
}
public void setSession(Map<String, Object> session) {
	this.session = session;
}

}

