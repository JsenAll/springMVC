package com.jsen.demo01cookie;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
 *@author Jsen
 *@description 保存用户上一次使用时间
 */

public class CookieDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("lastTime".equals(cookies[i].getName())) {
                    writer.write("最后一次访问的时间是:" + cookies[i].getValue());
                }
            }
        } else {
            writer.write("你是第一次访问  欢迎光临");
        }
        Cookie lastTime = new Cookie("lastTime", System.currentTimeMillis() + "");

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
