package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import model.Goods;
import utils.HibernateUtil;

public class GoodsDaoImpl implements GoodsDao {
	@Override
	public List<Goods> findGoodsByUsername(String username) {
		List<Goods> goods = new ArrayList<>();
		String sql = "select * from goods where username = ?";
		Query<Goods> query = HibernateUtil.getSessionFactory().openSession().createNativeQuery(sql, Goods.class);
		query.setParameter(1, username);
		goods = query.getResultList();
		return goods;
	}

}
