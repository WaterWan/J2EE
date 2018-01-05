package service;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
	void login(String username, String password, HttpServletRequest req, HttpServletResponse resp, ServletContext context) throws ServletException, IOException;
}
