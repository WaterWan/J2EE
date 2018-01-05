package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class UserDaoImpl implements UserDao{

	@Override
	public String login(String username, String password) throws ServletException {
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
			if (resultSet.next()) {
				if (!resultSet.getString(2).equals(password)) {
					throw new ServletException("Wrong password!");
				} else {
					return username;
				}
			} else {
				throw new ServletException("No such user!");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
