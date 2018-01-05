package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import service.ShowGoodsService;
import service.ShowGoodsServiceImpl;

public class ShowGoodsController extends HttpServlet{
	private ShowGoodsService showGoodsService;
	@Override
	public void init() throws ServletException {
		showGoodsService = new ShowGoodsServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------展示商品-------Post--------");
		HttpSession httpSession = req.getSession();
		String username = null;
		username = (String) httpSession.getAttribute("username");
		if (username == null) {
			resp.sendRedirect("http://localhost:8080/SmallHomework2/index.jsp");
			return;
		}
		ServletContext context = getServletContext();
		resp.sendRedirect("http://localhost:8080/SmallHomework2/goods.jsp?username=" + username);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------展示商品-------Get--------");
		doPost(req, resp);
	}
}
