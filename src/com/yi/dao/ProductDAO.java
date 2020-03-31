package com.yi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yi.jdbc.JDBCUtil;
import com.yi.model.Product;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();
	
	public static ProductDAO getInstent() {
		return dao;
	}
	
	private ProductDAO() {};
	
	public void insert(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into product values (null, ?,?,?, now(),?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			pstmt.setInt(2, product.getpPrice());
			pstmt.setString(3, product.getpWriter());
			pstmt.setString(4, product.getpDetail());
			pstmt.setString(5, product.getpPublisher());
			pstmt.setString(6, product.getpType());
			pstmt.setString(7, product.getpFile());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<Product> list(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), 
										rs.getString(2),
										rs.getInt(3), 
										rs.getString(4), 
										rs.getTimestamp(5),
										rs.getString(6), 
										rs.getString(7),
										rs.getString(8), 
										rs.getString(9));
				list.add(p);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public Product selectByNo(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from product where p_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Product p = new Product(rs.getInt(1), 
										rs.getString(2),
										rs.getInt(3), 
										rs.getString(4), 
										rs.getTimestamp(5),
										rs.getString(6), 
										rs.getString(7),
										rs.getString(8), 
										rs.getString(9));
				return p;
			}
			
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
