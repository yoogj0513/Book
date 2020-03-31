package com.yi.handler.product;

import java.io.File;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yi.dao.ProductDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Product;
import com.yi.mvc.CommandHandler;

public class ProductInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/product/productForm.jsp";
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			String uploadPath = req.getRealPath("upload"); //폴더명
			File dir = new File(uploadPath);
			if(dir.exists() == false) { //폴더가 없을 경우
				dir.mkdir(); //폴더 만듬
			}
			
			int size = 1024*1024*10; // -> 10M / 1024=1k / 1024*1024 = 1m
			
			MultipartRequest multi = new MultipartRequest(req, 
														uploadPath,
														size,
														"UTF-8",
														new DefaultFileRenamePolicy());
			System.out.println(uploadPath);
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				// ProductDAO 만들어서 add함
				ProductDAO dao = ProductDAO.getInstent();
				Product product = new Product(0, 
						multi.getParameter("pName"), 
						Integer.parseInt(multi.getParameter("pPrice")), 
						multi.getParameter("pWriter"), 
						null, 
						multi.getParameter("pDetail"), 
						multi.getParameter("pPublisher"), 
						multi.getParameter("pType"), 
						multi.getFilesystemName("pFile"));
				
				dao.insert(conn, product);
				
				res.sendRedirect(req.getContextPath()+"/product/list.do");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
