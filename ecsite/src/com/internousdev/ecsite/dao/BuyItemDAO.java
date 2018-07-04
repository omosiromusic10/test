package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public ArrayList<BuyItemDTO> getBuyItemInfo ()throws SQLException{
		ArrayList<BuyItemDTO> buyItemDTOList =new ArrayList<BuyItemDTO>();
			String sql= "select * from item_info_transaction";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				BuyItemDTO dto= new BuyItemDTO();
				dto.setId(resultSet.getInt("id"));
			    dto.setItemName(resultSet.getString("item_name"));
			    dto.setItemPrice(resultSet.getString("item_price"));
			    buyItemDTOList.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		finally{
			connection.close();
		}
		return buyItemDTOList;
		}
		public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
}