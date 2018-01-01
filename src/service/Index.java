package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {
	@Override
	public void init() throws ServletException {
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		String htmlContent = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<body>\r\n" + 
				"<form action=\"Login\" method=\"POST\">\r\n" + 
				"Username:<br>\r\n" + 
				"<input type=\"text\" name=\"username\" value=\"\">\r\n" + 
				"<br>\r\n" + 
				"Password:<br>\r\n" + 
				"<input type=\"password\" name=\"password\" value=\"\">\r\n" + 
				"<br><br>\r\n" + 
				"<input type=\"submit\" value=\"Login\">\r\n" + 
				"</form> \r\n" + 
				"</body>\r\n" + 
				"</html>";
		printWriter.println(htmlContent);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
