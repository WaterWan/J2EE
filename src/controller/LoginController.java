package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class LoginController extends HttpServlet{
	private LoginService loginService;
	
	@Override
	public void init() throws ServletException {
		loginService = new LoginServiceImpl();
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
		ServletContext context = getServletContext();
		loginService.login(username, password, req, resp, context);
	}
}
