package com.internousdev.sampleweb2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.UserInfoDAO;
import com.internousdev.sampleweb2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryAction extends ActionSupport implements SessionAware{

	private Map<String ,Object> session;

	public String execute(){
		String result = ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();


		if(session.containsKey("loginId")){
		userInfoDTO = userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));
			session.put("userId", userInfoDTO.getUserId());
			System.out.println(session.get("userId"));
			result = SUCCESS;
		}
		return result;

	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String ,Object> session){
		this.session = session;
	}

}
