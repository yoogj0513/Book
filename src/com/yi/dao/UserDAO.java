package com.yi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yi.jdbc.JDBCUtil;
import com.yi.model.User;

public class UserDAO {
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstent() {
		return dao;
	}
	
	private UserDAO() {};
	
	public User selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User(rs.getInt(1), 
									rs.getString(2), 
									rs.getString(3), 
									rs.getString(4), 
									rs.getString(5), 
									rs.getTimestamp(6), 
									rs.getBoolean(7));
				
				return user;
			}
			
			return null;
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
}
