package com.internousdev.glanq.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminRegistConfirmAction extends ActionSupport implements SessionAware {

	//情報入力の為の情報記述
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String price;
	private String imageFileName;
	private String imageFilePath;
	private String releaseCompany;
	private String releaseDate;
	private File userImage;
	private String userImagePathContentType;
	private String userImageFileName;


	// ここではエラーリストの情報を記述
	private List<String>productNameErrorMessageList = new ArrayList<String>();
	private List<String>productNameKanaErrorMessageList = new ArrayList<String>();
	private List<String>productDescriptionErrorMessageList = new ArrayList<String>();
	private List<String>priceErrorMessageList = new ArrayList<String>();
	private List<String>imageFileNameErrorMessageList = new ArrayList<String>();
	private List<String>imageFilePathErrorMessageList = new ArrayList<String>();
	private List<String>releaseCompanyErrorMessageList = new ArrayList<String>();
	private List<String>releaseDateErrorMessageList = new ArrayList<String>();

	private int categoryId;
	private List<String> categoryIdList = new ArrayList<String>();
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();


		//sessionに情報をセットしている。
		session.put("productName", productName);
		session.put("productNameKana", productNameKana);
		session.put("productDescription",productDescription);
		session.put("price",price);
		session.put("imageFileName", imageFileName);
		session.put("imageFilePath", imageFilePath);
		session.put("releaseCompany", releaseCompany);
		session.put("releaseDate", releaseDate);
		session.put("categoryId", categoryId);
		session.put("Status", 0);

		//ここで画像アップロードを行うアクションなのだがImageLocationとfilePathを出力している。　ここで画像のコピーを行っている。
		String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");
		System.out.println("Image Location:"+filePath);
		File fileToCreate = new File(filePath,userImageFileName);


		//ここでエラーのチェックリストで、どれがいけないかの確認。
		//なお、ImageFilePathはjpgの画像ファイルになるのでここは検討中
		productNameErrorMessageList = inputChecker.docheck("商品名", productName, 1, 32, true, true, true, true, true, true, true);
		productNameKanaErrorMessageList = inputChecker.docheck("商品名ふりがな", productNameKana, 1, 32, false, false, true, false, false, false, false);
		productDescriptionErrorMessageList = inputChecker.docheck("商品名詳細", productDescription, 1, 320, true, true, true, true, true, true, true);
		priceErrorMessageList = inputChecker.docheck("価格", price, 1, 8, false, false, false, true, false, false, false);
	//  imageFilePathErrorMessageList = inputChecker.doCheck("画像ファイル", imageFilePath, 1, 64, true, true, true, true, true, true, true);
		imageFileNameErrorMessageList = inputChecker.docheck("画像ファイル名",imageFileName, 1, 16, true, true, true, true, true, true, true);
		releaseCompanyErrorMessageList = inputChecker.docheck("発売会社名", releaseCompany, 1, 16, true, true, true, true, false, true, false);
		releaseDateErrorMessageList = inputChecker.docheck("発売年月", releaseDate , 1, 16, false, true, false, true, true, false, false);

		if(productNameErrorMessageList.size()==0
		&& productNameKanaErrorMessageList.size()==0
		&& productDescriptionErrorMessageList.size()==0
		&& priceErrorMessageList.size()==0
	//  && imageFilePathErrorMessageList.size()==0
		&& imageFileNameErrorMessageList.size()==0
		&& releaseCompanyErrorMessageList.size()==0
		&& releaseDateErrorMessageList.size()==0
		){
			result = SUCCESS;
		}else{
			//これはサイズの中に値が入るとセッション内に情報が入り、エラーをセッション内に入れて表示させるようにputしている。
			session.put("productNameErrorMessageList", productNameErrorMessageList);
			session.put("productNameKanaErrorMessageList", productNameKanaErrorMessageList);
			session.put("productDescription", productDescriptionErrorMessageList);
			session.put("priceErrorMessageList", priceErrorMessageList);
			session.put("imageFileNameErrorMessageList", imageFileNameErrorMessageList);
		//  session.put("imageFilePathErrorMessageList", imageFilePathErrorMessageList);
			session.put("releaseCompanyErrorMessageList", releaseCompanyErrorMessageList);
			session.put("releaseDateErrorMessageList", releaseDateErrorMessageList);
			result = ERROR;
		}
		//ここで画像アップロードのcopyFileをしているがsession.putでUserImageFileName等にしている。
		//ここも相談予定
		try{
			FileUtils.copyFile(userImage ,  fileToCreate);
			    session.put("imageFileName",  userImageFileName);
			    session.put("imageFilePath", "images/"+userImageFileName);
			    session.put("image_flg", userImageFileName);
		}catch(IOException e){
			e.printStackTrace();
		}
		return result;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImagePathContentType() {
		return userImagePathContentType;
	}

	public void setUserImagePathContentType(String userImagePathContentType) {
		this.userImagePathContentType = userImagePathContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public List<String> getProductNameErrorMessageList() {
		return productNameErrorMessageList;
	}

	public void setProductNameErrorMessageList(List<String> productNameErrorMessageList) {
		this.productNameErrorMessageList = productNameErrorMessageList;
	}

	public List<String> getProductNameKanaErrorMessageList() {
		return productNameKanaErrorMessageList;
	}

	public void setProductNameKanaErrorMessageList(List<String> productNameKanaErrorMessageList) {
		this.productNameKanaErrorMessageList = productNameKanaErrorMessageList;
	}

	public List<String> getProductDescriptionErrorMessageList() {
		return productDescriptionErrorMessageList;
	}

	public void setProductDescriptionErrorMessageList(List<String> productDescriptionErrorMessageList) {
		this.productDescriptionErrorMessageList = productDescriptionErrorMessageList;
	}

	public List<String> getPriceErrorMessageList() {
		return priceErrorMessageList;
	}

	public void setPriceErrorMessageList(List<String> priceErrorMessageList) {
		this.priceErrorMessageList = priceErrorMessageList;
	}

	public List<String> getImageFileNameErrorMessageList() {
		return imageFileNameErrorMessageList;
	}

	public void setImageFileNameErrorMessageList(List<String> imageFileNameErrorMessageList) {
		this.imageFileNameErrorMessageList = imageFileNameErrorMessageList;
	}

	public List<String> getImageFilePathErrorMessageList() {
		return imageFilePathErrorMessageList;
	}

	public void setImageFilePathErrorMessageList(List<String> imageFilePathErrorMessageList) {
		this.imageFilePathErrorMessageList = imageFilePathErrorMessageList;
	}

	public List<String> getReleaseCompanyErrorMessageList() {
		return releaseCompanyErrorMessageList;
	}

	public void setReleaseCompanyErrorMessageList(List<String> releaseCompanyErrorMessageList) {
		this.releaseCompanyErrorMessageList = releaseCompanyErrorMessageList;
	}

	public List<String> getReleaseDateErrorMessageList() {
		return releaseDateErrorMessageList;
	}

	public void setReleaseDateErrorMessageList(List<String> releaseDateErrorMessageList) {
		this.releaseDateErrorMessageList = releaseDateErrorMessageList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<String> getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(List<String> categoryIdList) {
		this.categoryIdList = categoryIdList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
