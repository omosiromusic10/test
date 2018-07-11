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

public class MCategoryDAO {
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

}
