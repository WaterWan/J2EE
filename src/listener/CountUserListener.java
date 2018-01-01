package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountUserListener implements HttpSessionListener {
    ServletContext ctx = null;
    static int current = 0;
    static int visitors = 0;
    public void sessionCreated(HttpSessionEvent e) {
    	System.out.println("--------------新增加一个Session-----------------");
        current++;
        visitors++;
        ctx = e.getSession().getServletContext();
        ctx.setAttribute("current", current);
        ctx.setAttribute("visitors", visitors);
    }

    public void sessionDestroyed(HttpSessionEvent e) {
    	if(null == e.getSession().getAttribute("username")) {
    		visitors--;
    	}
        current--;
        ctx.setAttribute("currentusers", current);
    }

}