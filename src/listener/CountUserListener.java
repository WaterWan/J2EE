package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountUserListener implements HttpSessionListener {
    ServletContext ctx = null;
    static int current = 0;
    static int visitors = 0;
    public void sessionCreated(HttpSessionEvent e) {
    	ctx = e.getSession().getServletContext();
    	if(null == ctx.getAttribute("current")) {
    		current = 0;
    		visitors = 0;
    	} else {
    		current = (Integer)ctx.getAttribute("current");
    		visitors = (Integer)ctx.getAttribute("visitors");
    	}
    	System.out.println("--------------新增加一个Session-----------------");
    	System.out.println("--------------之前的在线人数：" + current + "-----------");
    	System.out.println("--------------之前的游客人数：" + visitors + "-----------");
        current++;
        visitors++;
    	System.out.println("--------------之后的在线人数：" + current + "-----------");
    	System.out.println("--------------之后的游客人数：" + visitors + "-----------");
        
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