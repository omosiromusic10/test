package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ReviewDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ReviewCompleteDAO {
	List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();

	public List<ReviewDTO>select(){
		DBConnector db =new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from keijiban";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ReviewDTO dto=new ReviewDTO();
				dto.setHandlename(rs.getString("handlename"));
				dto.setTitle(rs.getString("title"));
				dto.setStar(rs.getString("star"));
				dto.setComments(rs.getString("comments"));
				reviewDTOList.add(dto);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
			try {
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return reviewDTOList;
			}
	public int insert(String handlename, String title, String star , String comments){
		int ret= 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into keijiban values(?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, handlename);
			ps.setString(2, title);
			ps.setString(3, star);
			ps.setString(4, comments);
			int i= ps.executeUpdate();
			if (i > 0){
				System.out.println(i + "件登録されました。");
				ret = i;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
			try {
			con.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return ret;
	}
}