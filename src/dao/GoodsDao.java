package dao;

import java.util.List;

import model.Goods;

public interface GoodsDao {
	List<Goods> findGoodsByUsername(String username);
}
