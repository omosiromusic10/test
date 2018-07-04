package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.action.BuyItemAction;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	BuyItemAction number = new BuyItemAction();
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
			String sql= "select * from item_info_transaction where id=1";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
			    buyItemDTO.setItemName(resultSet.getString("item_name"));
			    buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			}

		return buyItemDTO;
		}
		public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}
}