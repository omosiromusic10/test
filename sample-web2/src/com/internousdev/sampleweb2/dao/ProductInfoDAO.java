package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.ProductInfoDTO;
import com.internousdev.sampleweb2.util.DBConnector;
import com.internousdev.sampleweb2.util.DateUtil;

public class ProductInfoDAO {

	private DateUtil dateUtil = new DateUtil();

	public List<ProductInfoDTO> getProductInfoList(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info" ;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDto = new ProductInfoDTO();
				productInfoDto.setId(resultSet.getInt("id"));
				productInfoDto.setProductId(resultSet.getInt("product_id"));
				productInfoDto.setProductName(resultSet.getString("product_name"));
				productInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDto.setProductDescription(resultSet.getString("product_description"));
				productInfoDto.setCategoryId(resultSet.getInt("category_id"));
				productInfoDto.setPrice(resultSet.getInt("price"));
				productInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDto.setStatus(resultSet.getInt("status"));
				productInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}


	public int getMaxProductId(){

		int maxProductId = -1;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT MAX(product_id) AS id FROM product_info";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				maxProductId = rs.getInt("id");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(con !=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return maxProductId;
	}

		public int createProduct( int productid  , String productName, String productNameKana, String productDescription,
				int categoryId, int price, String releaseCompany ,String releaseDate ,int Status , String imageFilePath , String imageFileName )throws SQLException{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			int count = 0;
			String sql = "insert into product_info(product_id,product_name, product_name_kana, product_description,"
					+ "category_id ,price ,release_company, release_date, status, image_file_path, image_file_name,  regist_date, update_date)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, productid);
				preparedStatement.setString(2, productName);
				preparedStatement.setString(3, productNameKana);
				preparedStatement.setString(4, productDescription);
				preparedStatement.setInt(5, categoryId);
				preparedStatement.setInt(6, price);
				preparedStatement.setString(7, releaseCompany);
				preparedStatement.setString(8, releaseDate);
				preparedStatement.setInt(9, Status);// これは何か。→特に意味はないが、チーム開発時の後々追加仕様時に
				preparedStatement.setString(10, imageFilePath);
				preparedStatement.setString(11, imageFileName);	//	纏めて9,10項目をuserImageで良いのか
				preparedStatement.setString(12, dateUtil.getDate());
				preparedStatement.setString(13, dateUtil.getDate());
				count = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				connection.close();
			}
			return count;
		}

	public ProductInfoDTO getProductInfo(int productId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql ="select * from product_info where product_id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTO;
	}

	public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId, int limitOffset,
			int limitRowCount){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOffset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where";
		boolean initializeFlag = true;
		for(String keyword : keywordsList) {
			if (initializeFlag){
				sql +=" (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql +=" and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, String categoryId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where ";
		boolean initializeFlag = true;
		for (String keyword : keywordsList){
			if (initializeFlag) {
				sql += " category_id=" + categoryId + " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			} else{
				 sql += " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}




	    public int updateProductInfo( int productid  , String productName, String productNameKana, String productDescription,
			int categoryId, int price, String releaseCompany ,String releaseDate ,String imageFilePath , String imageFileName )throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "update product_info set "
				+ "product_name= ? , "
				+ "product_name_kana = ? ,"
				+ "product_description= ? ,"
				+ "category_id = ? ,"
				+ "price = ? ,"
				+ "release_company = ? , "
				+ "release_date = ? ,"
				+ "image_file_path = ? ,"
				+ "image_file_name = ? ,"
				+ "regist_date = ? ,"
				+ "update_date = ?"
				+ "where product_id = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2, productNameKana);
			preparedStatement.setString(3, productDescription);
			preparedStatement.setInt(4, categoryId);
			preparedStatement.setInt(5, price);
			preparedStatement.setString(6, releaseCompany);
			preparedStatement.setString(7, releaseDate);
			preparedStatement.setString(8, imageFilePath);
			preparedStatement.setString(9, imageFileName);
			preparedStatement.setString(10, dateUtil.getDate());
			preparedStatement.setString(11, dateUtil.getDate());
			preparedStatement.setInt(12, productid);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return count;
	}

		public int delete(String id){
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			int count = 0;
			String sql = "delete from product_info where id=?";
			//ここはカートの情報を消す為だろうか？

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);

				count = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

	    public boolean checkProductInfo( String productName) throws SQLException{
	    	DBConnector db = new DBConnector();
	    	Connection con = db.getConnection();

	    	String sql = "select id from product_info where product_name = ?";
	    	boolean Result = false;
			try{
	    		PreparedStatement ps = con.prepareStatement(sql);
	    		ps.setString(1, productName);
	    		ResultSet rs = ps.executeQuery();
	    		Result= rs.next();
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}finally{
	    		con.close();
	    	}
	    	return Result;

	    }

	    public boolean checkProductInfo2(String productNameKana) throws SQLException{
	    	DBConnector db = new DBConnector();
	    	Connection con = db.getConnection();
	    	String sql = "select id from product_info where product_name_kana";
	    	boolean Result = false;
	    	try{
	    		PreparedStatement ps = con.prepareStatement(sql);
	    		ps.setString(1, productNameKana);
	    		ResultSet rs = ps.executeQuery();
	    		Result = rs.next();
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}finally{
	    		con.close();
	    	}
	    	return Result;
	    }



		public boolean checkProductInfo3(int productId, String productName) throws SQLException {
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			//こちらはProduct_idが同じ物ではない場合にProductNameで選択する同じ物があればConfirmのif文でエラーを出力する。
			String sql = "select id from product_info where product_id != ? and product_name = ?";
			boolean Result = false;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, productId);
				ps.setString(2, productName);
				ResultSet rs = ps.executeQuery();
				Result = rs.next();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				con.close();
			}
			return Result;
		}

		public boolean checkProductInfo4(int productId, String productNameKana) throws SQLException {
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			//こちらはProduct_idが同じ物ではない場合にProductNamekanaで選択する同じ物があればConfirmのif文でエラーを出力する。
			String sql = "select id from product_info where product_id != ? and product_name_kana = ?";
			boolean Result = false;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, productId);
				ps.setString(2, productNameKana);
				ResultSet rs = ps.executeQuery();
				Result = rs.next();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				con.close();
			}
			return Result;
		}

}
