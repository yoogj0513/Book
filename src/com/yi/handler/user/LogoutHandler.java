package com.yi.handler.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yi.mvc.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		//logout처리 - session 없애면 됨
		HttpSession session = req.getSession();
		session.invalidate();
		
		res.sendRedirect(req.getContextPath() + "/product/list.do"); //홈 이동
		return null;
	}

}
