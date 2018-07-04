package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute() throws SQLException{
		String result = "login";
		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			ArrayList<BuyItemDTO> buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("buyItemList", buyItemDTO);
			result = SUCCESS;
		}
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
	public Map <String,Object> getSession(){
		return this.session;
	}
}
