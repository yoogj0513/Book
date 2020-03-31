package com.yi.handler.cart;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.yi.dao.CartDAO;
import com.yi.dao.UserDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Cart;
import com.yi.model.User;
import com.yi.mvc.CommandHandler;

public class CartAddHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("post")) {
			String count = req.getParameter("count");
			String no = req.getParameter("no");
			String id = (String)req.getSession().getAttribute("Auth");
			
			// ajax으로 이동했을 경우 화면을 갱신할 수 없음.
			// 알림을 보낼 수 있음
			if(id == null) { //로그인 안되어 있을 경우, 로그인으로 이동한다.
				Map<String , String> map = new HashMap<String, String>();
				map.put("result", "notLogin");
				
				// map->json String
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(map);
				
				//브라우저로 보냄
				res.setContentType("application/json;charset=UTF-8");
				PrintWriter pw = res.getWriter();
				pw.print(json);
				pw.flush(); //브라우저로 보냄
				
				return null;
			}
			
			//사용자의 번호
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				UserDAO userDao = UserDAO.getInstent();
				CartDAO cartDao = CartDAO.getInstent();
				User user = userDao.selectById(conn, id);
				
				Cart cart = new Cart(0, Integer.parseInt(count), user.getuNo(), Integer.parseInt(no));
				cartDao.insert(conn, cart);
				
				Map<String, String> map = new HashMap<>();
				map.put("result", "success");
				
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(map);
				
				res.setContentType("application/json;charset=UTF-8");
				PrintWriter pw = res.getWriter();
				pw.print(json);
				pw.flush(); //브라우저로 보냄
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
