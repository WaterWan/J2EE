package dao;

import javax.servlet.ServletException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.User;
import utils.HibernateUtil;

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	@Override
	public String find(String username, String password) throws ServletException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from t_user where name = ? and pwd = ?";
		Query<User> query = session.createNativeQuery(sql, User.class);
		query.setParameter(1, username).setParameter(2, password);
		User user = query.getSingleResult();
		if(null == user) {
			throw new ServletException("Wrong password or no such user!");
		}
		System.out.println("----查询成功----用户名为： " + username);
		return username;
//		try {
//			Context initContext = new InitialContext();
//			Context envContext = (Context) initContext.lookup("java:comp/env");
//			DataSource ds = (DataSource) envContext.lookup("jdbc/j2ee_shwk2");
//			Connection conn = ds.getConnection();
//			System.out.println("--------Login-----数据库连接成功！！！----------");
//			String sql = "select * from users where username = ?";
//			PreparedStatement pst = conn.prepareStatement(sql);
//			pst.setString(1, username);
//			ResultSet resultSet = pst.executeQuery();
//			if (resultSet.next()) {
//				if (!resultSet.getString(2).equals(password)) {
//					throw new ServletException("Wrong password!");
//				} else {
//					return username;
//				}
//			} else {
//				throw new ServletException("No such user!");
//			}
//		} catch (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void save(User user) {
		super.save(user);
	}

}
