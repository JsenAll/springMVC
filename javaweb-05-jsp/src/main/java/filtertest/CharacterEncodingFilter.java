package filtertest; /*
 *@author Jsen
 *@description
 */

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("Content-type; text/html;charset=UTF-8");//防止页面乱码
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("销毁");
    }
}
