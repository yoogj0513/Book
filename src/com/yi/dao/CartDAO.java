package com.yi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yi.jdbc.JDBCUtil;
import com.yi.model.Cart;

public class CartDAO {
	private static CartDAO dao = new CartDAO();
	
	public static CartDAO getInstent() {
		return dao;
	}
	
	private CartDAO() {}
	
	public void insert(Connection conn, Cart cart) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into cart values (null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getcCount());
			pstmt.setInt(2, cart.getuNo());
			pstmt.setInt(3, cart.getpNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
}
