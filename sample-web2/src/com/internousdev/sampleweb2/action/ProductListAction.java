package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.MCategoryDAO;
import com.internousdev.sampleweb2.dao.ProductInfoDAO;
import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.dto.PaginationDTO;
import com.internousdev.sampleweb2.dto.ProductInfoDTO;
import com.internousdev.sampleweb2.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware{
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;

	private String categoryId;
	private String keywords;
	private String pageNo = "1"; //年の為
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private Map<String, Object> session;
	private Pagination pagination = new Pagination();
	public String execute(){
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			return result;
		}


		int pageSize = 9;
		ProductInfoDAO productInfoDao = new ProductInfoDAO();
		List<ProductInfoDTO> productInfoListAll = productInfoDao.getProductInfoList();
		session.put("productInfoListAll", productInfoListAll);
		PaginationDTO paginationDTO = pagination.initialize(productInfoListAll, pageSize);
		session.put("totalPageSize", paginationDTO.getTotalPageSize());
		session.put("currentPageNo", paginationDTO.getCurrentPageNo());
		session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
		session.put("startRecordNo", paginationDTO.getStartRecordNo());
		session.put("endRecordNo", paginationDTO.getEndRecordNo());
		session.put("pageNumberList", paginationDTO.getPageNumberList());
		session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
		session.put("hasNextPage", paginationDTO.isHasNextPage());
		session.put("hasPreviousPage", paginationDTO.isHasPreviousPage());
		session.put("nextPageNo", paginationDTO.getNextPageNo());
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());

		if(!session.containsKey("mCategoryDtoList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		// セッションlogined はヘッダーにて用いているので、無い場合は非ログイン状態として0を入れる。
		if (!session.containsKey("logined")) {
			session.put("logined", 0);
		}

		result = SUCCESS;
		return result;
	}
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

}
