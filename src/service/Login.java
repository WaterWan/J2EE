package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


public class Login extends HttpServlet {

	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get.............");
		String username = null;
		HttpSession httpSession = req.getSession();
		username = (String) httpSession.getAttribute("username");
		if(username == null) {
			resp.sendRedirect("http://localhost:8080/SmallHomework2/index.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post...........");
		String username = req.getParameter("username");
		if ("".equals(username)) {
			throw new ServletException("Username is empty!");
		}
		String password = req.getParameter("password");
		if ("".equals(password)) {
			throw new ServletException("Password is empty!");
		}
		PrintWriter writer = resp.getWriter();
		// TODO JNDI连接数据库
		try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/j2ee_shwk2");
            Connection conn = ds.getConnection();
			System.out.println("--------Login-----数据库连接成功！！！----------");
			String sql = "select * from users where username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet resultSet = pst.executeQuery();
			if(resultSet.next()) {
				if(!resultSet.getString(2).equals(password)) {
					throw new ServletException("Wrong password!");
				} else {
					HttpSession session = req.getSession(true);
					session.setAttribute("username", username);
					resp.sendRedirect("http://localhost:8080/SmallHomework2/ShowGoods");
				}
			} else {
				throw new ServletException("No such user!");
			}
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
