package errordeal;

//导入必需的 java 库
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//扩展 HttpServlet 类
public class ErrorHandler extends HttpServlet {

	// 处理 GET 方法请求的方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ErrorHandler------Get");
		System.out.println("被调用了错误处理代码");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "错误/异常 信息";

		String docType = "<!DOCTYPE html>\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		out.println("<h1>错误/异常信息</h1>");
		if (throwable == null && statusCode == null) {
			System.out.println("错误信息丢失");
			out.println("<h2>错误信息丢失</h2>");
			out.println("请返回 <a href=\"" + response.encodeURL("http://localhost:8080/SmallHomework2/index.html")
					+ "\">主页</a>。");
		} else if (statusCode != null && throwable != null) {
			System.out.println("存在错误， 错误代码为 " + statusCode);
			System.out.println("存在异常，异常类型为 " + throwable.getClass().getName());
			out.println("<h2>异常信息</h2>");
			out.println("错误代码 : " + statusCode);
			out.println("Servlet Name : " + servletName + "</br></br>");
			out.println("异常类型 : " + throwable.getClass().getName() + "</br></br>");
			out.println("请求 URI: " + requestUri + "<br><br>");
			out.println("异常信息: " + throwable.getMessage());
		} else {
			System.out.println("存在错误， 错误代码为 " + statusCode);
			out.println("<h2>异常信息</h2>");
			out.println("错误代码 : " + statusCode);
		}
		out.println("</body>");
		out.println("</html>");
	}

	// 处理 POST 方法请求的方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ErrorHandler------Post");
		doGet(request, response);
	}
}
