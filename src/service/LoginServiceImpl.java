package service;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;

public class LoginServiceImpl implements LoginService {
	private UserDao userDao;
	
	public LoginServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void login(String username, String password, HttpServletRequest req, HttpServletResponse resp, ServletContext context) throws ServletException, IOException {
		String newUsername = userDao.login(username, password);
		if(null == newUsername) {
			throw new ServletException("No such user!");
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			if (null == context.getAttribute("current")) {
				System.out.println("------------开始没有current这个属性-----------");
				session.setAttribute("current", 1);
			}
			resp.sendRedirect("http://localhost:8080/SmallHomework2/ShowGoods");
		}
	}

}
