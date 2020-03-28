package listener; /*
 *@author Jsen
 *@description
 */

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {

    //创建session监听:一旦有session的创建 就会触发
    //HttpSessionEvent : 相当于监听session的实体类对象
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null) onlineCount = new Integer(1);
        else onlineCount++;
        servletContext.setAttribute("OnlineCount", onlineCount);
    }

    //创建session销毁监听:一旦有session销毁,就会触发
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null) onlineCount = new Integer(0);
        else onlineCount--;
        servletContext.setAttribute("OnlineCount", onlineCount);
    }
}
