package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.CartInfoDTO;
import com.internousdev.sampleweb2.util.DBConnector;
import com.internousdev.sampleweb2.util.DateUtil;

public class CartInfoDAO {
	private DateUtil dateUtil = new DateUtil();

	/*  カートの情報を取得するメソッド。*/
	public List<CartInfoDTO> getCartInfoDtoList(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

		String sql="select"
				+ " ci.id as id,"
				+ " ci.user_id as user_id,"
				+ " ci.temp_user_id as temp_user_id,"
				+ " ci.product_id as product_id,"
				+ " sum(ci.product_count) as product_count,"
				+ " pi.price as price,"
				+ " pi.regist_date as regist_date,"
				+ " pi.update_date as update_date,"
				+ " pi.product_name as product_name,"
				+ " pi.product_name_kana as product_name_kana,"
				+ " pi.product_description as product_description,"
				+ " pi.category_id as category_id,"
				+ " pi.image_file_path as image_file_path, "
				+ " pi.image_file_name as image_file_name, "
				+ " pi.release_date as release_date,"
				+ " pi.release_company as release_company,"
				+ " pi.status as status,"
				+ " (sum(ci.product_count) * pi.price) as subtotal"
				+ " FROM cart_info as ci"   //ここでci=Cart_infoの事を指している。
				+ " LEFT JOIN product_info as pi" //更にここでもproduct_info のテーブルをpiに略している。　左連結をしているこれによってCart内に情報を入れる為だ。
				+ " ON ci.product_id = pi.product_id" //ここでは...同期させている？
				+ " WHERE ci.user_id = ?" //ここでCartInfoのidを指定させるように
				+ " group by product_id"; //★group?　何だろう。
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println("cartinfodao-getcartinfodtolist:"+loginId);
			preparedStatement.setString(1,loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				CartInfoDTO cartInfoDTO = new CartInfoDTO();
				cartInfoDTO.setId(resultSet.getInt("id"));
				cartInfoDTO.setUserId(resultSet.getString("user_id"));
				cartInfoDTO.setTempUserId(resultSet.getString("temp_user_id"));
				cartInfoDTO.setProductId(resultSet.getInt("product_id"));
				cartInfoDTO.setProductCount(resultSet.getInt("product_count"));
				cartInfoDTO.setPrice(resultSet.getInt("price"));
				cartInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				cartInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				cartInfoDTO.setProductName(resultSet.getString("product_name"));
				cartInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				cartInfoDTO.setProductDescription(resultSet.getString("product_description"));
				cartInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				cartInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				cartInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				cartInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				cartInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				cartInfoDTO.setStatus(resultSet.getString("status"));
				cartInfoDTO.setSubtotal(resultSet.getInt("subtotal"));
				cartInfoDtoList.add(cartInfoDTO);
				//ここでcartInfoDtoListに全ての情報を入れている。
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartInfoDtoList;
	}

	public int getTotalPrice(String userId){
		int totalPrice = 0;
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "select sum(product_count * price) as total_price from cart_info where user_id=? group by user_id";
		//トータルプレイスの計算だ！
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				totalPrice = resultSet.getInt("total_price");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalPrice;
	}

	public int regist(String userId, String tempUserId, int productId, String productCount, int price){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		//★ここでもInsertでＩＤやらお金を入れているが、何をしているのだろう。
		int count = 0;
		String sql = "insert into cart_info(user_id, temp_user_id, product_id, product_count, price, regist_date)"
				+ "values(?, ?, ?, ?, ?, ?)";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, tempUserId);
			preparedStatement.setInt(3, productId);
			preparedStatement.setString(4, productCount);
			preparedStatement.setInt(5, price);
			preparedStatement.setString(6, dateUtil.getDate());
			count = preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int delete(String id){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "delete from cart_info where id=?";
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

	public int deleteAll(String userId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "delete from cart_info where user_id=?";
		//全てを消す為だろうか。

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

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

	public boolean isExistsCartInfo(){

		return false;
	}

	public int linkToLoginId(String tempUserId, String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0 ;
		String sql = "update cart_info set user_id=?, temp_user_id = null where temp_user_id=?";
		//★ユーザーＩＤとゲストＩＤをアップデートしている？

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, tempUserId);
			count = preparedStatement.executeUpdate();
         }catch (SQLException e) {
 			e.printStackTrace();
 		}
 		try {
 			connection.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return count;
	}


	public List<CartInfoDTO> getCartInfoAllDtoList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<CartInfoDTO> CartInfoDtoList = new ArrayList<CartInfoDTO>();

		String sql = "select * from cart_info";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO ciDTO = new CartInfoDTO();
				ciDTO.setId(rs.getInt("id"));
				ciDTO.setUserId(rs.getString("user_id"));
				ciDTO.setTempUserId(rs.getString("temp_user_id"));
				ciDTO.setProductId(rs.getInt("product_id"));
				ciDTO.setProductCount(rs.getInt("product_count"));
				ciDTO.setPrice(rs.getInt("price"));
				ciDTO.setRegistDate(rs.getDate("regist_date"));
				ciDTO.setUpdateDate(rs.getDate("update_date"));
				CartInfoDtoList.add(ciDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return CartInfoDtoList;
	}
}
