package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private String loginUserId;
	private String loginPassword;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() throws SQLException{
		String result = "login";
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		if(session.containsKey("id")){
//			ArrayList<BuyItemDTO> buyItemDTO = buyItemDAO.getBuyItemInfo();			session.put("buyItemList", buyItemDTO);
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemDTO();
			buyItemList = buyItemDAO.getBuyItemInfo();
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			result = SUCCESS;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
	public Map <String,Object> getSession(){
		return this.session;
	}
	public ArrayList<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}
	public void setBuyItemList(ArrayList<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}
}
