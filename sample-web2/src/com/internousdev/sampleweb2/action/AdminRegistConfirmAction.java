package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminRegistConfirmAction extends ActionSupport implements SessionAware{

	private String productName;
	private String productNameKana;
	private String productDescription;
	private String price;
	private String imageFileName;
	private String imageFilePath;
	private String releaseCompany;
	private String releaseDate;

	private List<String>productNameErrorMessageList = new ArrayList<String>();
	private List<String>productNameKanaErrorMessageList = new ArrayList<String>();
	private List<String>productDescriptionErrorMessageList  = new ArrayList<String>();
	private List<String>priceErrorMessageList = new ArrayList<String>();
	private List<String>imageFileNameErrorMessageList = new ArrayList<String>();
	private List<String>imageFilePathErrorMessageList = new ArrayList<String>();
	private List<String>releaseCompanyErrorMessageList = new ArrayList<String>();
	private List<String>releaseDateErrorMessageList = new ArrayList<String>();

	private String categoryId;
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		session.put("productName", productName);
		session.put("productNameKana", productNameKana);
		session.put("productDescription", productDescription);
		session.put("price", price);
		session.put("imageFileName", imageFileName);
		session.put("imageFilePath", imageFilePath);
		session.put("releaseCompany", releaseCompany);
		session.put("releaseDate", releaseDate);

		productNameErrorMessageList = inputChecker.doCheck("商品名", productName, 1, 32, true, true, true, false, false, false, false);
		productNameKanaErrorMessageList = inputChecker.doCheck("商品名ふりがな", productNameKana, 1, 32, false, false, true, false, false, false, false);
		productDescriptionErrorMessageList = inputChecker.doCheck("商品名詳細", productDescription, 1, 320, true, true, true, true, true, true, true);
		priceErrorMessageList  = inputChecker.doCheck("価格", price, 1, 8, false, false, false, true, false, false, false);
		imageFilePathErrorMessageList = inputChecker.doCheck("画像ファイル", imageFilePath, 1, 64, true, true, true, true, true, true, true);
		imageFileNameErrorMessageList = inputChecker.doCheck("画像ファイル名", imageFileName, 1, 16, true, true, true, true, true, true, true);
		releaseCompanyErrorMessageList  = inputChecker.doCheck("発売会社名", releaseCompany, 1, 16, true, true, true, true, false, true, false);
		releaseDateErrorMessageList  = inputChecker.doCheck("発売年月", releaseDate, 1, 16, false, true, false, true, true, false, false);

		if(productNameErrorMessageList.size()==0
		&& productNameKanaErrorMessageList.size()==0
		&& productDescriptionErrorMessageList.size()==0
		&& priceErrorMessageList.size()==0
		&& imageFilePathErrorMessageList.size()==0
		&& imageFileNameErrorMessageList.size()==0
		&& releaseCompanyErrorMessageList.size()==0
		&& releaseDateErrorMessageList.size()==0 ){
			result = SUCCESS;
		}else{
			session.put("productNameErrorMessageList", productNameErrorMessageList);
			session.put("productNameKanaErrorMessageList", productNameKanaErrorMessageList);
			session.put("productDescriptionErrorMessageList", productDescriptionErrorMessageList);
			session.put("priceErrorMessageList", priceErrorMessageList);
			session.put("imageFileNameErrorMessageList", imageFileNameErrorMessageList);
			session.put("imageFilePathErrorMessageList", imageFilePathErrorMessageList);
			session.put("releaseCompanyErrorMessageList", releaseCompanyErrorMessageList);
			session.put("releaseDateErrorMessageList", releaseDateErrorMessageList);
			result = ERROR;
		}
		return result;
	}
	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductNameKana(){
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}
	public String getProductDescription(){
		return productDescription;
	}
	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}
	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getImageFilePath(){
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName(){
		return imageFileName;
	}
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}
	public String getReleaseCompany(){
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}


	public List<String> getProductNameErrorMessageList(){
		return productNameErrorMessageList;
	}
	public void setProductNameErrorMessageList(List<String> productNameErrorMessageList){
		this.productNameErrorMessageList = productNameErrorMessageList;
	}
	public List<String> getProductNameKanaErrorMessageList(){
		return productNameKanaErrorMessageList;
	}
	public void setProductNameKanaErrorMessageList(List<String> productNameKanaErrorMessageList){
		this.productNameKanaErrorMessageList = productNameKanaErrorMessageList;
	}
	public List<String> getProductDescriptionErrorMessageList(){
		return productDescriptionErrorMessageList;
	}
	public void setProductDescriptionErrorMessageList(List<String> productDescriptionErrorMessageList){
		this.productDescriptionErrorMessageList = productDescriptionErrorMessageList;
	}
	public List<String> getPriceErrorMessageList(){
		return priceErrorMessageList;
	}
	public void setPriceErrorMessageList(List<String> priceErrorMessageList){
		this.priceErrorMessageList = priceErrorMessageList;
	}
	public List<String> getImageFilePathErrorMessageList(){
		return imageFilePathErrorMessageList;
	}
	public void setImageFilePathErrorMessageList(List<String> imageFilePathErrorMessageList){
		this.imageFilePathErrorMessageList = imageFilePathErrorMessageList;
	}
	public List<String> getImageFileNameErrorMessageList(){
		return imageFileNameErrorMessageList;
	}
	public void setImageFileNameErrorMessageList(List<String> imageFileNameErrorMessageList){
		this.imageFileNameErrorMessageList = imageFileNameErrorMessageList;
	}
	public List<String> getReleaseCompanyErrorMessageList(){
		return releaseCompanyErrorMessageList;
	}
	public void setReleaseCompanyErrorMessageList(List<String> releaseCompanyErrorMessageList){
		this.releaseCompanyErrorMessageList = releaseCompanyErrorMessageList;
	}
	public List<String> getReleaseDateErrorMessageList(){
		return releaseDateErrorMessageList;
	}
	public void setReleaseDateErrorMessageList(List<String> releaseDateErrorMessageList){
		this.releaseDateErrorMessageList = releaseDateErrorMessageList;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
