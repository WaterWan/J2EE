package dao;

import javax.servlet.ServletException;

import model.User;

public interface UserDao extends BaseDao{
	String find(String username, String password) throws ServletException;
	
	void save(User user);
}
