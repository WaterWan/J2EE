package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class ShowGoods extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------展示商品-------Post--------");
		HttpSession httpSession = req.getSession();
		String username = null;
		username = (String) httpSession.getAttribute("username");
		if (username == null) {
			resp.sendRedirect("http://localhost:8080/SmallHomework2/index.html");
			return;
		}
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/j2ee_shwk2");
			Connection conn = ds.getConnection();
			System.out.println("--------ShowGoods-----数据库连接成功！！！----------");
			String sql = "select * from goods where username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet resultSet = pst.executeQuery();
			PrintWriter out = resp.getWriter();
			String start = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<body>";
			String end = "</body>\r\n" + "</html>";
			out.println(start);
			if (!resultSet.next()) {
				out.println("No goods in this user!!!");
			} else {
				resultSet.previous();
				while(resultSet.next()) {
					String goodsName = resultSet.getString(2);
					double price = resultSet.getDouble(3);
					int count = resultSet.getInt(4);
					Date date = resultSet.getDate(5);
					out.println(goodsName + " " + price + " " + count + " " + date);
					if(count > 10) {
						out.print("(Not enough)");
					}
					out.println("<br>");
				}
			}
			int current = (Integer) getServletContext().getAttribute("current");
			int visitors = (Integer) getServletContext().getAttribute("visitors");
			getServletContext().setAttribute("visitors", visitors - 1);
			visitors = (Integer) getServletContext().getAttribute("visitors");
			int login = current - visitors;
			out.print("<br>当前用户数： " + current);
			out.print("<br>当前登录数： " + login);
			out.print("<br>当前游客数： " + visitors);
			out.println(end);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------展示商品-------Get--------");
		doPost(req, resp);
	}
}
