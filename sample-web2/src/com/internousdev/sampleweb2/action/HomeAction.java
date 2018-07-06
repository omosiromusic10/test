package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.MCategoryDAO;
import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>(); //ここでDAOに入れていた奴を使う用にコマンド
	private String categoryId;
	private Map<String, Object> session;
	public String execute(){

		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
			//session内のloginId と ゲストIDが存在しない場合に限り、CommonUtilityで使われている謎のﾊﾞﾘｭｰが使われる。
			//そしてsessionにはゲストＩＤと謎のバリューが残る。
		}
		if(!session.containsKey("logined")){
			session.put("logined", 0);
		//★ここではlogined？が存在しなければ起きる。でもloginedはいつ使われたのだろう？。
			//そしてsessionにloginedした物をputしている。
		}

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
			//ここではsessionの mCategoryListが存在しない場合？に起きる(そんな事があるのか)
			//★何故mCategoryDtoListとDaoを連結させているのか？
			//そして最後にsessionにmCategoryDtoListを記述させている。
		}
		return SUCCESS;
	}
	public String getCategiryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public List<MCategoryDTO> getCategoryDtoList(){
		return mCategoryDtoList;
	}
	public void setCategoryDtoList(List<MCategoryDTO> mCategoryDtoList){
		this.mCategoryDtoList = mCategoryDtoList;
	}
		public Map<String,Object>getSession(){
			return session;
		}
		public void setSession(Map<String, Object> session){
			this.session= session;
	}

}