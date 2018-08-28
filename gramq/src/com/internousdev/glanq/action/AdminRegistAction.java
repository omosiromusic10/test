package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminRegistAction extends ActionSupport implements SessionAware{

	/* ProductInfoの情報 */
	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int price;
	private int categoryId;
	private String imageFilePath;
	private String imageFileName;
	private String releaseDate;
	private String releaseCompany;
	private String status;
	private String registDate;
	private String updateDate;
	private Map<String ,Object> session;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();



	public String execute(){
		String result = ERROR;
		/* セッションの一時的に保持されていたエラーリストを一旦削除する為のremove */
		session.remove("productNameErrorMessageList");
		session.remove("productNameKanaErrormessageList");
		session.remove("productDescriptionErrorMeesageList");
		session.remove("priceErrorMessageList");
		session.remove("imageFilePathErrorMessageList");
		session.remove("imageFileNameErrorMessageList");
		session.remove("releaseCompanyErrorMessageList");
		session.remove("releaseDateErrorMessageList");

		// セッションにProduct情報を入れる為のput
		session.put("productName", productName);
		session.put("productNameKana", productNameKana);
		session.put("productDescription",productDescription);
		session.put("price", price);
		session.put("imageFilePath", imageFilePath);
		session.put("imageFileName", imageFileName);
		session.put("releaseCompany", releaseCompany);
		session.put("releaseDate",releaseDate);

		// ここではセッション内にカテゴリリストが存在していない場合に起きる
		//ここではDAOの挿入文をDtoListに纏めている。
		//これはヘッダー部分で検索機能として置いているのでエラーを出さないようにする為の処置
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		//ここでmCategoryDtoListが取れているかの確認出力を出している。
		System.out.println(session.get("mCategoryDtoList").toString());

		result = SUCCESS;
		return result;
	}


// product情報のゲッターセッター(取得や設定に必要な事項)
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
}
