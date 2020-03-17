package com.jsen.servlet04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Jsen
 * @description 读取资源文件 要根据 打包文件来写路径 尽量写相对路径
 */
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/aa.properties");
        Properties prop = new Properties();
        prop.load(resourceAsStream);
        String user = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.getWriter().println("名字为:" + user);
        resp.getWriter().println("密码:" + pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
