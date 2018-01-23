package model;

import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserTest {
	private UserDao userDao;
	@Before
	public void setUp() {
		userDao = new UserDaoImpl();
	}

	@Test//我们使用junit进行测试
	public void test1(){
		for(int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("user" + i);
			user.setPwd("pwd" + i);
			userDao.save(user);
		}
	}
}
