<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="service.ShowGoodsServiceImpl"%>
<%@page import="service.ShowGoodsService"%>
<%@page import="dao.GoodsDao"%>
<%@page import="dao.GoodsDaoImpl"%>
<%@page import="model.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String username = request.getParameter("username"); %>
<%ShowGoodsService showGoodsService = new ShowGoodsServiceImpl(); %>
<%ServletContext context = getServletContext(); %>
<%showGoodsService.showGoods(request, response, username, context); %>

</body>
</html>