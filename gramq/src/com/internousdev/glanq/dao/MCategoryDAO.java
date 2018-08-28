package com.internousdev.glanq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.util.DBConnector;



public class MCategoryDAO {
	//DBに接続するための準備

	public List<MCategoryDTO> getMCategoryList(){
	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();
	List<MCategoryDTO> mCategoryDTOList=new ArrayList<MCategoryDTO>();

	//sql文にてテーブルm_category内の全てのデータの取得
	String sql="SELECT * from m_category";
	try{
	PreparedStatement preparedStatement=connection.prepareStatement(sql);
	ResultSet resultSet=preparedStatement.executeQuery();

	//各変数にデータを追加
	while(resultSet.next()){
	MCategoryDTO mCategoryDTO=new MCategoryDTO();
	mCategoryDTO.setId(resultSet.getInt("Id"));
	mCategoryDTO.setCategoryId(resultSet.getInt("categoryId"));
	mCategoryDTO.setCategoryName(resultSet.getString("categoryName"));
	mCategoryDTO.setCategoryDescription(resultSet.getString("categoryDescription"));
	mCategoryDTO.setInsertDate(resultSet.getString("insertDate"));
	mCategoryDTO.setUpdateDate(resultSet.getString("updateDate"));

	//追加したデータをListに格納
	mCategoryDTOList.add(mCategoryDTO);
	}

//	iteratorメソッドを用いてリスト内のデータを順次参照し
//	次のデータがなくなったとき空データ"null"を挿入
//"データが空である"というデータを入れることで無用なエラーの防止
	Iterator<MCategoryDTO> iterator = mCategoryDTOList.iterator();
	if(!(iterator.hasNext())) {
	mCategoryDTOList = null;
	}
	}catch(SQLException e){
	e.printStackTrace();
	}try{
	connection.close();
	}catch(SQLException e){
	e.printStackTrace();
	}
	return mCategoryDTOList;
	}
	}


