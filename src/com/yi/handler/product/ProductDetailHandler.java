package com.yi.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ProductDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Product;
import com.yi.mvc.CommandHandler;

public class ProductDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			String no = req.getParameter("no");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ProductDAO dao = ProductDAO.getInstent();
				Product item = dao.selectByNo(conn, Integer.parseInt(no));
				
				req.setAttribute("item", item);
				
				return "/WEB-INF/view/product/productDetail.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
