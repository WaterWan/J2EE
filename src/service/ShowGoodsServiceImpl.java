package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import dao.GoodsDaoImpl;
import model.Goods;

public class ShowGoodsServiceImpl implements ShowGoodsService{
	private GoodsDao goodsDao;
	public ShowGoodsServiceImpl() {
		goodsDao = new GoodsDaoImpl();
	}

	@Override
	public void showGoods(HttpServletRequest req, HttpServletResponse resp, String username, ServletContext context) throws IOException  {
		if(username == null || "".equals(username)) {
			resp.sendRedirect("http://localhost:8080/SmallHomework2/login.jsp");
		}
		try {
			PrintWriter out = resp.getWriter();
			String start = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<body>";
			String end = "</body>\r\n" + "</html>";
			out.println(start);
			
			List<Goods> goods = goodsDao.findGoodsByUsername(username);
			if(goods.size() == 0) {
				out.println("No goods in this user! <br>");
			} else {
				out.println("货物名    |    价格      |   数量      |   订单日期<br>");
				for(Goods good : goods) {
					out.println(good.getGoodsName() + "  |  " + good.getPrice() + "  |  " + good.getCount() + "  |  " + good.getDate());
					if(good.getCount() > 10) {
						out.println("(Not enough)");
					}
					out.println("<br>");
				}
			}
			
			
			int current = (Integer) context.getAttribute("current");
			int visitors = (Integer) context.getAttribute("visitors");
			if(null == context.getAttribute("counted")) {
				context.setAttribute("visitors", visitors - 1);
				context.setAttribute("counted", true);
			}
			visitors = (Integer) context.getAttribute("visitors");
			int login = current - visitors;
			out.print("<br>当前用户数： " + current);
			out.print("<br>当前登录数： " + login);
			out.print("<br>当前游客数： " + visitors);
			out.println(end);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
