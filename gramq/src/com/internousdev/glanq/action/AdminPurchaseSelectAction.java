package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dao.PurchaseHistoryInfoDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPurchaseSelectAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;
	public String execute(){

		//ここでもPurchaseHistoryのDAOから情報を取ってList情報をjspで表示させる為に用いている処理。
		PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();
		purchaseHistoryInfoDtoList = purchaseHistoryInfoDao.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
		Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			purchaseHistoryInfoDtoList = null;
		}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

		//ここでは検索機能にバグがおきないようにする為の処置
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return SUCCESS;
	}
	//以下ゲッタセッター
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
