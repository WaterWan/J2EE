package dao;

import javax.servlet.ServletException;

public interface UserDao {
	String login(String username, String password) throws ServletException;
}
