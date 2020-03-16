package com.jsen.servlet; /*
 *@author Jsen
 *@description
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("username", "蒋厚森");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("调用 servletContext  中的 setAttribute 方法  ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
