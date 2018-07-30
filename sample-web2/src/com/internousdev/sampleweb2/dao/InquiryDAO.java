package com.internousdev.sampleweb2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.InquiryDTO;
import com.internousdev.sampleweb2.util.DBConnector;

public class InquiryDAO {
	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public List<InquiryDTO>select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from inquiry";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				InquiryDTO dto = new InquiryDTO();
				dto.setUserId(rs.getString("userId"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}try{
		con.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return inquiryDTOList;
    }
	public int insert(String userId, String qtype, String body){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into inquiry values(?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, qtype);
			ps.setString(3, body);
			int i = ps.executeUpdate();
			if ( i > 0){
				System.out.println(i + "件送信しました。");
				ret = i;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
}
