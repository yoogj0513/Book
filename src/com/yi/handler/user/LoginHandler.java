package com.yi.handler.user;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yi.dao.UserDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.User;
import com.yi.mvc.CommandHandler;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/user/loginForm.jsp";
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				UserDAO dao = UserDAO.getInstent();
				User user = dao.selectById(conn, id);
				if(user == null) { //id가 없음
					req.setAttribute("error", "notMathID");
					return "/WEB-INF/view/user/loginForm.jsp";
				}
				//else if()//비밀번호가 틀림
				
				HttpSession session = req.getSession();
				session.setAttribute("Auth", id);
				
				//home 이동
				// return "/product/list.do"
				// /Book//product/list.do -> req.getContextPath()+"/product/list.do"
				// req.getContextPath() : 프로젝트 이름을 가져옴 
				res.sendRedirect(req.getContextPath()+"/product/list.do");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
