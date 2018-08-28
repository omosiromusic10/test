package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.sampleweb2.dto.MCategoryDTO;
import com.internousdev.sampleweb2.util.DBConnector;
import com.internousdev.sampleweb2.util.DateUtil;

public class MCategoryDAO {

	private DateUtil dateUtil = new DateUtil();
	//MCategoryは商品ごとの種類を示す情報内である。
	//例　本、おもちゃ、家電等
	public List<MCategoryDTO> getMCategoryList(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
		//ここでmCategoryListを作っておく。
		String sql = "select * from m_category";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				//ここで実行を回していく略を作った
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(resultSet.getInt("id"));
				mCategoryDTO.setCategoryId(resultSet.getInt("category_id"));
				mCategoryDTO.setCategoryName(resultSet.getString("category_name"));
				mCategoryDTO.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDTO.setInsertDate(resultSet.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(resultSet.getDate("update_date"));
				//ここでmCategoryDTOにresultSetでSQLから其々のデータを獲得し、mCategoryDTOにset=習得させている。
				mCategoryDtoList.add(mCategoryDTO);
				//最後にDtoの中に入っている物をList内にも入れた。
			}
			Iterator<MCategoryDTO> iterator = mCategoryDtoList.iterator();
			if(!(iterator.hasNext())){
				mCategoryDtoList = null; //念の為に入れている用の文
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return mCategoryDtoList;
	}

	public List<MCategoryDTO> getMCategoryList2(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
		//ここでmCategoryListを作っておく。
		String sql = "select * from m_category where id > 1";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				//ここで実行を回していく略を作った
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(resultSet.getInt("id"));
				mCategoryDTO.setCategoryId(resultSet.getInt("category_id"));
				mCategoryDTO.setCategoryName(resultSet.getString("category_name"));
				mCategoryDTO.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDTO.setInsertDate(resultSet.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(resultSet.getDate("update_date"));
				//ここでmCategoryDTOにresultSetでSQLから其々のデータを獲得し、mCategoryDTOにset=習得させている。
				mCategoryDtoList.add(mCategoryDTO);
				//最後にDtoの中に入っている物をList内にも入れた。
			}
			Iterator<MCategoryDTO> iterator = mCategoryDtoList.iterator();
			if(!(iterator.hasNext())){
				mCategoryDtoList = null; //念の為に入れている用の文
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return mCategoryDtoList;
	}


	public int getMaxCategoryId(){
		int maxCategoryId = -1;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="SELECT MAX(category_id) AS id FROM m_category";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				maxCategoryId = rs.getInt("id");
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
		return maxCategoryId;
	}
	public int createCategory(int categoryId ,String categoryName, String categoryDescription)throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql ="insert into m_category(category_id, category_name, category_description,"
				+ "insert_date, update_date)"
				+ "values(?, ?, ?, ?, ?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setString(2, categoryName);
			ps.setString(3, categoryDescription);
			ps.setString(4, dateUtil.getDate());
			ps.setString(5, dateUtil.getDate());
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;
}

	public MCategoryDTO getMCategory(int categoryId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		MCategoryDTO MCategoryDTO = new MCategoryDTO();

		/**
		 * ユーザーIDとパスワードを元にSelect分を用いて
		 * データを全てDTOに格納する。
		 */


	String sql = "SELECT * FROM m_category WHERE category_id = ?";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, categoryId);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			MCategoryDTO.setCategoryName(rs.getString("category_name"));
			MCategoryDTO.setCategoryId(rs.getInt("category_id"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return MCategoryDTO;
	}
}
