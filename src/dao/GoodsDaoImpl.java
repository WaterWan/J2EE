package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Goods;

public class GoodsDaoImpl implements GoodsDao {
	@Override
	public List<Goods> findGoodsByUsername(String username) {
		List<Goods> goods = new ArrayList<>();
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/j2ee_shwk2");
			Connection conn = ds.getConnection();
			System.out.println("--------ShowGoods-----数据库连接成功！！！----------");
			String sql = "select * from goods where username = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet resultSet = pst.executeQuery();
			if (!resultSet.next()) {
				return goods;
			} else {
				resultSet.previous();
				while(resultSet.next()) {
					String goodsName = resultSet.getString(2);
					double price = resultSet.getDouble(3);
					int count = resultSet.getInt(4);
					Date date = resultSet.getDate(5);
					Goods good = new Goods(goodsName, price, count, date);
					goods.add(good);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}

}
