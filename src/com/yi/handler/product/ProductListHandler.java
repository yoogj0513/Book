package com.yi.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ProductDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Product;
import com.yi.mvc.CommandHandler;

public class ProductListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		//db에 들어있는 책 리스트 가지고 와야됨
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ProductDAO dao = ProductDAO.getInstent();
			List<Product> list = dao.list(conn);
			
			req.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		
		return "/WEB-INF/view/product/list.jsp";
	}

}
