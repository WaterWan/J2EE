package service;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;

public class Login extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO JNDI连接数据库
		try {
			Context ctx = new InitialContext();
			String dataSourceJNDIName = "";
			DataSource ods = (DataSource) ctx.lookup(dataSourceJNDIName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get.............");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post...........");
		String username = req.getParameter("username");
		if("".equals(username)) {
			throw new ServletException("Username is empty!");
		}
		String password = req.getParameter("password");
		if("".equals(password)) {
			throw new ServletException("Password is empty!");
		}
	}
}
