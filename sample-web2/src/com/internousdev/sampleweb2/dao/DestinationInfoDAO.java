package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.DestinationInfoDTO;
import com.internousdev.sampleweb2.util.DBConnector;

public class DestinationInfoDAO {

	public int insert(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana,
		String email, String telNumber, String userAddress){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "insert into destination_info(user_id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address, regist_date , update_date)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, now(), '0000-01-01')";
		//ここではユーザー登録の際に使う情報をinsertしてデーターベースに送る用に使われている？。
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, familyNameKana);
			preparedStatement.setString(5, firstNameKana);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, telNumber);
			preparedStatement.setString(8, userAddress);
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

	public List<DestinationInfoDTO> getDestinationInfo(String loginId) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name , first_name , family_name_kana, first_name_kana, user_address, tel_number , email FROM destination_info WHERE user_id = ?";
		//★ここでは先程の物を指定しているように見えるが...何をしているのだろう
		//★それにFROMとは何だろう。...結合？

		try{
			connection = dbConnector.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDtoList.add(destinationInfoDTO);
			}
			//★ここではログインの際に使われる物だろうか。
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return destinationInfoDtoList;
	}

	public List<DestinationInfoDTO> getDestinationInfoAllList() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT * FROM destination_info";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO destDTO = new DestinationInfoDTO();
				destDTO.setId(rs.getInt("id"));
				destDTO.setUserId(rs.getString("user_id"));
				destDTO.setFamilyName(rs.getString("family_name"));
				destDTO.setFirstName(rs.getString("first_name"));
				destDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destDTO.setUserAddress(rs.getString("user_address"));
				destDTO.setEmail(rs.getString("email"));
				destDTO.setTelNumber(rs.getString("tel_number"));
				destDTO.setRegistDate(rs.getDate("regist_date"));
				destDTO.setUpdateDate(rs.getDate("update_date"));

				destinationInfoDtoList.add(destDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return destinationInfoDtoList;
	}
}
