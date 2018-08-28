package com.internousdev.sampleweb2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.CartInfoDAO;
import com.internousdev.sampleweb2.dao.DestinationInfoDAO;
import com.internousdev.sampleweb2.dao.MCategoryDAO;
import com.internousdev.sampleweb2.dao.UserInfoDAO;
import com.internousdev.sampleweb2.dto.CartInfoDTO;
import com.internousdev.sampleweb2.dto.DestinationInfoDTO;
import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAllSelectAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	//リストを情報化
	private List<MCategoryDTO> mCategoryAllDtoList = new ArrayList<MCategoryDTO>();
	private List<UserInfoDTO> UserInfoAllDtoList = new ArrayList<UserInfoDTO>();
	private List<DestinationInfoDTO> DestinationInfoAllDtoList = new ArrayList<DestinationInfoDTO>();
	private List<CartInfoDTO> CartInfoAllDtoList = new ArrayList<CartInfoDTO>();

	public String execute(){

		//最初にadminトークンが無い場合にエラーホームに飛ばす処理を行う。
		String result = "errorhome";
		String token = String.valueOf(session.get("token"));
		if ( token != "admin"){
			return result ;
		}

	    result = ERROR;

		try{
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryAllDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryAllDtoList", mCategoryAllDtoList);

			UserInfoDAO UserInfoDao = new UserInfoDAO();
			UserInfoAllDtoList = UserInfoDao.getUserInfoAllList();
			session.put("UserInfoAllDtoList",UserInfoAllDtoList);

			DestinationInfoDAO DestinationInfoDao = new DestinationInfoDAO();
			DestinationInfoAllDtoList = DestinationInfoDao.getDestinationInfoAllList();
			session.put("DestinationInfoAllDtoList",DestinationInfoAllDtoList);

			CartInfoDAO cartInfoDao = new CartInfoDAO();
			CartInfoAllDtoList = cartInfoDao.getCartInfoAllDtoList();
			session.put("CartInfoAllDtoList",CartInfoAllDtoList);

			result = SUCCESS;
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<MCategoryDTO> getmCategoryAllDtoList() {
		return mCategoryAllDtoList;
	}

	public void setmCategoryAllDtoList(List<MCategoryDTO> mCategoryAllDtoList) {
		this.mCategoryAllDtoList = mCategoryAllDtoList;
	}

	public List<UserInfoDTO> getUserInfoAllDtoList() {
		return UserInfoAllDtoList;
	}

	public void setUserInfoAllDtoList(List<UserInfoDTO> UserInfoAllDtoList) {
		this.UserInfoAllDtoList = UserInfoAllDtoList;
	}

	public List<DestinationInfoDTO> getDestinationInfoAllDtoList() {
		return DestinationInfoAllDtoList;
	}

	public void setDestinationInfoAllDtoList(List<DestinationInfoDTO> destinationInfoAllDtoList) {
		DestinationInfoAllDtoList = destinationInfoAllDtoList;
	}

	public List<CartInfoDTO> getCartInfoAllDtoList() {
		return CartInfoAllDtoList;
	}

	public void setCartInfoAllDtoList(List<CartInfoDTO> cartInfoAllDtoList) {
		CartInfoAllDtoList = cartInfoAllDtoList;
	}


}
