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
	private List<String> loginErrorMessageList = new ArrayList<String>();

	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
//以前はloginIdpasswordがadminという文字列の場合adminが1になり、adminリターンが働くようにしていた。
/*		if(loginId.equals("admin") && password.equals("admin")){
			session.put("admin", 1);
			return  "admin";
	}*/
		//これは事前にadminだった場合resultでエラーを返す為に(adminで移動させない為)
		String token = String.valueOf(session.get("token"));
		if(token =="admin"){
			return result;
		}



//セッションに格納しているメッセージを外す。これがないと永遠とエラーが出続けてしまうので大事。
session.remove("loginIdErrorMessageList");
session.remove("passwordErrorMessageList");
session.remove("loginErrorMessageList");



        //「ログインID保存」のチェックボックスに使う
        // trueの場合にsessionに格納するようにしている。
		if(savedLoginId==true){
			session.put("savedLoginId",true);
			session.put("saveId", loginId);
		//逆にそれ以外はsessionからsaveIdを外している。
		}else{
			session.put("savedLoginId", false);
			session.remove("saveId", loginId);
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
		//ユーザーが存在していて、
		if(userInfoDao.isExistsUserInfo(loginId, password)){

			//ログインが成功していたら
			if(userInfoDao.login(loginId, password) > 0){

			//ユーザー情報を取得し、
			UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(loginId, password);

			//ユーザーID, statusをセッションに格納
			session.put("loginId", userInfoDTO.getUserId());
			session.put("status", userInfoDTO.getStatus());
			int count =0;

			//今回これをStatus型にし、それでadminかどうかを検証させる。
			//staという変数にsessionからstatusを取得させる
			String sta = String.valueOf(session.get("status"));

			if(sta.equals("1")){
				//そしてreturn でadminと返すようにし、tokenをsessionにputする。
				result = "admin";
				token = "admin";
				session.put("token", token);
				session.put("logined", 1);
				return result;
			}



			    //ここでもセッションを入れてログインした事にする。
			    session.put("logined", 1);

			CartInfoDAO cartInfoDao = new CartInfoDAO();

			count = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")),loginId);
			//仮のIDが発行されていたら、
			if(count > 0){
				DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
				try{
					List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
					//宛先情報を取得し、Listに格納。
					destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);
					Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
					//Listに格納した要素を順番に処理をし、要素がなくなったら、
					if(!(iterator.hasNext())){
					    //Listにnullを入れる。
						destinationInfoDtoList = null;
					}
					//セッションにはListを格納
					session.put("destinationInfoDtoList", destinationInfoDtoList);
				}catch (SQLException e) {
					e.printStackTrace();
				}
				//tryが走れば、場所の確認画面へ
				result = "settlement";
			}else
				//tryが走らなければ結果はSUCCESS;
			    result = SUCCESS;
		}
			//最後にセッションにログインフラグを格納
			session.put("logined", 1);
	}else{
		loginIdErrorMessageList.add("入力されたパスワードが異なります。");
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

public List<String> getLoginErrorMessageList() {
	return loginErrorMessageList;
}

public void setLoginErrorMessageList(List<String> loginErrorMessageList) {
	this.loginErrorMessageList = loginErrorMessageList;
}

}

