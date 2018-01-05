package service;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShowGoodsService {

	void showGoods(HttpServletRequest req, HttpServletResponse resp, String username, ServletContext context) throws IOException;

}
